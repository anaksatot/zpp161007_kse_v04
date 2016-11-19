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

	public String getFormOfWord() {
		return formOfWord;
	}

	public int getQuantiySymbols() {
		return quantiySymbols;
	}

	public long getUniqueIndex() {
		return uniqueIndex;
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
