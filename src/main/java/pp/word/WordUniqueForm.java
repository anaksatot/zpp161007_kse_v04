package pp.word;

import pp.linguisticCategories.Language;
import pp.linguisticCategories.LinguisticCategoryForms;

public class WordUniqueForm {

	private String formOfWord;
	private int quantiySymbols;
	private long uniqueIndex;
	private Language language;
	private LinguisticCategoryForms linguisticCategoryForms;
	private static int accountOfWords;

	public WordUniqueForm(String formOfWord,Language language) {
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

	public Language getLanguage() {
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

	@Override
	public String toString() {
		return "WordUniqueForm{" +
				"formOfWord='" + formOfWord + '\'' +
				", quantiySymbols=" + quantiySymbols +
				", uniqueIndex=" + uniqueIndex +
				", language=" + language +
				", linguisticCategoryForms=" + linguisticCategoryForms +
				'}';
	}
}
