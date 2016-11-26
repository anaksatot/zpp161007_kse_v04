package pp.entity;

public class WordUniqueForm {

	private String formOfWord;
	private int quantiySymbols;
	private long uniqueIndex;
	private LANGUAGE language;
	private LinguisticCategoryForms linguisticCategoryForms;
	private static int accountOfWords;

	public WordUniqueForm(String formOfWord,LANGUAGE language) {
		this.formOfWord = formOfWord;
		this.language = language;
		++accountOfWords;
	}

	public String getFormOfWord() {
		return formOfWord;
	}

	public int getQuantiySymbols() {
		return quantiySymbols;
	}

	public long getUniqueIndex() {
		return uniqueIndex;
	}

	public LANGUAGE getLanguage() {
		return language;
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

}
