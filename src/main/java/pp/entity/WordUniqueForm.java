package pp.entity;

public class WordUniqueForm {

	private String formOfWord;
	private int quantiySymbols;
	private long uniqueIndex;
	private LinguisticCategoryForms linguisticCategoryForms;
	private static int accountOfWords;

	public WordUniqueForm(String formOfWord) {
		this.formOfWord = formOfWord;
		++accountOfWords;
	}

	public String getTloJam() {
		return formOfWord;
	}

	public void setLinguisticCategoryForms(LinguisticCategoryForms linguisticCategoryForms) {
		this.linguisticCategoryForms = linguisticCategoryForms;
	}

	public static int getAccountOfWords() {
		return accountOfWords;
	}

	public LinguisticCategoryForms getLinguisticCategoryForms() {
		return linguisticCategoryForms;
	}

//	public String stringForJsonParser(){
//		String stForJsonParser;
//		stForJsonParser = "{"+"\""+"tloJam"+"\""+":"+"\""+formOfWord+"\""+","+"\""+"quantiyBor"+"\""+":"+quantiySymbols+","+"\""+"ovnKixc"+"\""+":"+uniqueIndex+linguisticCategoryForms.getLinguisticCategoriesForJsonParser()+"}";
//		System.out.print(stForJsonParser);
//		return 	stForJsonParser;
//	}
}
