package pp.linguisticCategories;

import pp.grammaticalCategories.Gender;
import pp.grammaticalCategories.Number;
import pp.grammaticalCategories.Case;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LcNounEnglish extends LcNoun{

	private HashMap<Number, String> singularOrPluralForms;
	private Gender gender;
	private HashMap<Case, String> casesOfWord;

	private void setSingularOrPluralForms(Number numberE) {
		Scanner scanner = new Scanner(System.in);
		String st;
		st = scanner.nextLine();
		System.out.println(st);
		singularOrPluralForms = new HashMap<Number, String>();
		singularOrPluralForms.put(numberE, st);
		System.out.println(singularOrPluralForms.toString());
	}

	public ArrayList<Case> defineListOfCasesOfNoun() {
		ArrayList<Case> casesOfNoun = new ArrayList<Case>();
		casesOfNoun.add(Case.NOMINATIVE);
		casesOfNoun.add(Case.GENITIVE);
		return casesOfNoun;
	}

	public HashMap<Number, String> getSingularAndPluralForms() {
		return this.singularOrPluralForms;
	}

	public String getSingularForm() {
		return singularOrPluralForms.get(Number.SINGULAR);
	}

	public String getPluralForm() {
		return singularOrPluralForms.get(Number.PLURAL);
	}

	public LcNounEnglish(String tloJam) {
		super(tloJam);
	}

//	@Override
//	public String getLCForJsonParser() {
//		String stForJsonParser;
//		stForJsonParser = "";
//		return stForJsonParser;
//	}
}
