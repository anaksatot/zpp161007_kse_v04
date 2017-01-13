package pp.word;

import pp.linguisticCategories.Language;
import pp.linguisticCategories.LinguisticCategoryForms;

import java.io.Serializable;

public class WordUniqueForm implements Serializable {

	private String formOfWord;
	private String formOfWordFirstLetterCapital;
	private String formOfWordInLowerCase;
	private String formOfWordInUpperCase;
	private String formOfWordStrangeCaseOrder;
	private int quantiySymbols;
	private long uniqueIndex;
	private Language language;
	private LinguisticCategoryForms linguisticCategoryForms;
	private static int accountOfWords;

	public WordUniqueForm(String formOfWord,Language language) {
		this.formOfWord = formOfWord.toLowerCase();
		this.language = language;
		this.quantiySymbols = formOfWord.length();
		setFormOfWordFirstLetterCapital(formOfWord);
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
				", formOfWordFirstLetterCapital='" + formOfWordFirstLetterCapital + '\'' +
				", formOfWordInLowerCase='" + formOfWordInLowerCase + '\'' +
				", formOfWordInUpperCase='" + formOfWordInUpperCase + '\'' +
				", formOfWordStrangeCaseOrder='" + formOfWordStrangeCaseOrder + '\'' +
				", quantiySymbols=" + quantiySymbols +
				", uniqueIndex=" + uniqueIndex +
				", language=" + language +
				", linguisticCategoryForms=" + linguisticCategoryForms +
				'}';
	}

	public void setFormOfWordFirstLetterCapital(String word) {
		System.out.println("U-------------U");
		System.out.println(word.substring(0,1));
		System.out.println(word.substring(0,1).matches("^[А-Я]"));
		String ws = word.substring(1);
		System.out.println((word.substring(1).length()));
		System.out.println((ws.matches("^[а-я]")));
		System.out.println((word.substring(0,1).matches("^[А-Я]")&&word.substring(1).matches("^[а-я]$")));
		if (word.substring(0,1).matches("^[А-Я]")&&word.substring(1).matches("^[а-я]$")) {
			this.formOfWordFirstLetterCapital = word;
		}

	}

	public void setFormOfWordInLowerCase(String word) {
		this.formOfWordInLowerCase = word;
	}

	public void setFormOfWordInUpperCase(String word) {
		this.formOfWordInUpperCase = word;
	}

	public boolean isEmptyFormOfWordFirstLetterCapital() {
		return this.formOfWordFirstLetterCapital == null || this.formOfWordFirstLetterCapital.isEmpty();
	}

	public boolean isEmptyFormOfWordInLowerCase() {
		return this.formOfWordInLowerCase == null || this.formOfWordInLowerCase.isEmpty();
	}

	public boolean isEmptyFormOfWordInUpperCase() {
		return this.formOfWordInUpperCase == null || this.formOfWordInUpperCase.isEmpty();
	}

	public boolean isEmptyFormOfWordStrangeCaseOrder() {
		return this.formOfWordStrangeCaseOrder == null || this.formOfWordStrangeCaseOrder.isEmpty();
	}

	public boolean checkAndWriteFormsWithCapitalAndLowerLetters(String word) {
		System.out.println(word);
		System.out.println(word.substring(1));
		System.out.println(word.substring(1).matches("[а-я]+"));
		//System.out.println((int)"і");
	//	System.out.println((char)179);
		System.out.println(word.substring(1).matches("[char[179]]+"));
//		if (wordUniqueForm.isEmptyFormOfWordFirstLetterCapital() && (word.matches("[а-я ]*"))) {
//			wordUniqueForm.setFormOfWordInLowerCase(word);word.matches("[а-я]+")||word.matches("[і]+")
//			return true;char
//		}
		if (this.isEmptyFormOfWordInLowerCase() && (word.matches("[а-я]+")||word.matches("[і]+"))) {
			this.setFormOfWordInLowerCase(word);
			return true;
		}
		if (this.isEmptyFormOfWordInUpperCase() && (word.matches("[А-Я]+"))) {
			this.setFormOfWordInLowerCase(word);
			return true;
		}
//		if (wordUniqueForm.isEmptyFormOfWordStrangeCaseOrder() && (word.matches("[а-я ]*"))) {
//			wordUniqueForm.setFormOfWordInLowerCase(word);
//			return true;
//		}
		return false;
	}

}
