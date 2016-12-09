package pp.linguisticCategories;

import pp.grammaticalCategories.GENDER;
import pp.grammaticalCategories.NUMBER;
import pp.grammaticalCategories.CASE;
import java.util.HashMap;

public class LcNounUkrainian extends LcNoun{

	private HashMap<NUMBER, String> singularOrPluralForms;
	private GENDER gender;
	private HashMap<CASE, String> casesOfWord;
	private static int accountOfWords;


	public String getSingularForm(){
		return singularOrPluralForms.get(NUMBER.SINGULAR);
	}

	public String getPluralForm(){
		return singularOrPluralForms.get(NUMBER.PLURAL);
	}

	public LcNounUkrainian(String formOfWord) {
		super(formOfWord);
		accountOfWords = accountOfWords+1;
	}

	public LcNounUkrainian(String formOfWord,boolean forUniqueForm) {
		super(formOfWord);
		accountOfWords = accountOfWords+1;
	}

	public static int getAccountOfWords() {
		return accountOfWords;
	}

	public HashMap<NUMBER, String> getSingularOrPluralForms() {
		return singularOrPluralForms;
	}

	public GENDER getGender() {
		return gender;
	}

	public HashMap<CASE, String> getCasesOfWord() {
		return casesOfWord;
	}

	public void setSingularOrPluralForms(HashMap<NUMBER, String> singularOrPluralForms) {
		this.singularOrPluralForms = singularOrPluralForms;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	public void setCasesOfWord(HashMap<CASE, String> casesOfWord) {
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
