package pp.linguisticCategories;

import pp.grammaticalCategories.Gender;
import pp.grammaticalCategories.Number;
import pp.grammaticalCategories.Case;
import java.util.HashMap;

public class LcNounUkrainian extends LcNoun{

	private HashMap<Number, String> singularOrPluralForms;
	private Gender gender;
	private HashMap<Case, String> casesOfWord;
	private static int accountOfWordsLC;


	public String getSingularForm(){
		return singularOrPluralForms.get(Number.SINGULAR);
	}

	public String getPluralForm(){
		return singularOrPluralForms.get(Number.PLURAL);
	}

	public LcNounUkrainian(String formOfWord) {
		super(formOfWord);
		++accountOfWordsLC;
	}

	public LcNounUkrainian(String formOfWord,boolean forUniqueForm) {
		super(formOfWord);
		++accountOfWordsLC;
	}

	public static int getAccountOfWords() {
		return accountOfWordsLC;
	}

	public HashMap<Number, String> getSingularOrPluralForms() {
		return singularOrPluralForms;
	}

	public Gender getGender() {
		return gender;
	}

	public HashMap<Case, String> getCasesOfWord() {
		return casesOfWord;
	}

	public void setSingularOrPluralForms(HashMap<Number, String> singularOrPluralForms) {
		this.singularOrPluralForms = singularOrPluralForms;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setCasesOfWord(HashMap<Case, String> casesOfWord) {
		this.casesOfWord = casesOfWord;
	}

	@Override
	public String toString() {
		return "LcNounUkrainian{" +
				"singularOrPluralForms=" + singularOrPluralForms +
				", gender=" + gender +
				", casesOfWord=" + casesOfWord +
				'}';
	}
}
