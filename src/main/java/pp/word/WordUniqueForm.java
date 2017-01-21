package pp.word;

import pp.linguisticCategories.Language;
import pp.linguisticCategories.LinguisticCategoryForms;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class WordUniqueForm implements Serializable {

	private String formOfWord;
	private String formOfWordFirstLetterCapital;
	private String formOfWordInLowerCase;
	private String formOfWordInCapitalCase;
	private String formOfWordStrangeCaseOrder;
	private int quantiySymbols;
	private String uniqueIndex;
	private Language language;
	private LinguisticCategoryForms linguisticCategoryForms;
	private static int accountOfWordsCurrentText;

	public WordUniqueForm(String formOfWord,Language language) {
		this.formOfWord = formOfWord.toLowerCase();
		this.language = language;
		this.quantiySymbols = formOfWord.length();
		this.uniqueIndex = defineRandomUniqueIndex(10);
		checkAndWriteFormsWithCapitalAndLowerLetters(formOfWord);
		++accountOfWordsCurrentText;
	}

	public String getFormOfWord() {
		return formOfWord;
	}

	public int getQuantiySymbols() {
		return quantiySymbols;
	}

	public String getUniqueIndex() {
		return uniqueIndex;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLinguisticCategoryForms(LinguisticCategoryForms linguisticCategoryForms) {
		this.linguisticCategoryForms = linguisticCategoryForms;
	}

	private String defineRandomUniqueIndex(int numberOfWords) {
		String index = "";
		int n;
		Random rand = new Random();
		for (int i=0; i<16;i++) {
			n = rand.nextInt(16);
			String n16 = Integer.toHexString(n);
			index = index + n16;
		}
		String numberOfWords16 = Integer.toHexString(numberOfWords);
		System.out.println(numberOfWords16);
		for (int i=0; i<16-numberOfWords16.length();i++) {
			index = index + "0";
		}
		index = index + numberOfWords16;
		System.out.println(index);
		return index;
	}

	public static int getAccountOfWords() {
		return accountOfWordsCurrentText;
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
				", formOfWordInUpperCase='" + formOfWordInCapitalCase + '\'' +
				", formOfWordStrangeCaseOrder='" + formOfWordStrangeCaseOrder + '\'' +
				", quantiySymbols=" + quantiySymbols +
				", uniqueIndex=" + uniqueIndex +
				", language=" + language +
				", linguisticCategoryForms=" + linguisticCategoryForms +
				'}';
	}

	public void setFormOfWordFirstLetterCapital(String word) {
		this.formOfWordFirstLetterCapital= word;

	}

	public void setFormOfWordInLowerCase(String word) {
		this.formOfWordInLowerCase = word;
	}

	public void setFormOfWordInCapitalCase(String word) {
		this.formOfWordInCapitalCase = word;
	}

	public void setFormOfWordStrangeCaseOrder(String word) {
		this.formOfWordStrangeCaseOrder = word;
	}

	public boolean isEmptyFormOfWordFirstLetterCapital() {
		return this.formOfWordFirstLetterCapital == null || this.formOfWordFirstLetterCapital.isEmpty();
	}

	public boolean isEmptyFormOfWordInLowerCase() {
		return this.formOfWordInLowerCase == null || this.formOfWordInLowerCase.isEmpty();
	}

	public boolean isEmptyFormOfWordInCapitalCase() {
		return this.formOfWordInCapitalCase == null || this.formOfWordInCapitalCase.isEmpty();
	}

	public boolean isEmptyFormOfWordStrangeCaseOrder() {
		return this.formOfWordStrangeCaseOrder == null || this.formOfWordStrangeCaseOrder.isEmpty();
	}

	public boolean checkAndWriteFormsWithCapitalAndLowerLetters_test(String word) {

		System.out.println(word);
		// char charI = (char) 1110;
		char charJi = 't';
		char charJ = "t".toCharArray()[0];
		char charJi16 = '\u0074'; // t
		char charJi17 = (char) 116; // t

		// System.out.println(charI);
		System.out.println(charJi);
		System.out.println((int) charJ);
		System.out.println((int) charJi16);
		System.out.println(charJi17);
		System.out.println(word.substring(0,1).toCharArray()[0]);
		System.out.println((int) word.substring(0,1).toCharArray()[0]);
		//System.out.println((int) c.charValue());
//		for (int i=1100; i<1135;i++ ) {
//			System.out.println((char) i);
//		}
		System.out.println((int) "t".toCharArray()[0]);
		System.out.println( word.charAt(0));
		System.out.println("-------------");
		if (this.isEmptyFormOfWordInLowerCase() && (word.substring(0,1).matches("[А-Я\\u0406\\u0407\\u0490\\u0404]")&&word.substring(1).matches("[а-я-\\u0456\\u0457\\u0491\\u0454]+"))) {
			this.setFormOfWordInLowerCase(word);
			return true;
		}
		return false;
	}

	public boolean checkAndWriteFormsWithCapitalAndLowerLetters(String word) {

		if (this.isEmptyFormOfWordFirstLetterCapital() && (word.substring(0,1).matches("[А-Я\\u0406\\u0407\\u0490\\u0404]")&&word.substring(1).matches("[а-я-\\u0456\\u0457\\u0491\\u0454]+"))) {
			this.setFormOfWordFirstLetterCapital(word);
			return true;
		}
		if (this.isEmptyFormOfWordInLowerCase() && (word.matches("[а-я-\\u0456\\u0457\\u0491\\u0454]+"))) {
			this.setFormOfWordInLowerCase(word);
			return true;
		}

		if (this.isEmptyFormOfWordInCapitalCase() && (word.matches("[А-Я\\u0406\\u0407\\u0490\\u0404]+"))) {
			this.setFormOfWordInCapitalCase(word);
			return true;
		}
		if (this.isEmptyFormOfWordStrangeCaseOrder() && (word.matches("[А-Я\\u0406\\u0407\\u0490\\u0404а-я-\\u0456\\u0457\\u0491\\u0454]+"))) {
			this.setFormOfWordStrangeCaseOrder(word);
			return true;
		}
		return false;
	}
}
