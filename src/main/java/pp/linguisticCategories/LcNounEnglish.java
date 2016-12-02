package pp.linguisticCategories;

import pp.grammaticalCategories.GENDER;
import pp.grammaticalCategories.NUMBER;
import pp.grammaticalCategories.CASE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LcNounEnglish extends LcNoun{

	private HashMap<NUMBER, String> singularOrPluralForms;
	private GENDER gender;
	private HashMap<CASE, String> casesOfWord;

	private void setSingularOrPluralForms(NUMBER numberE) {
		Scanner scanner = new Scanner(System.in);
		String st;
		st = scanner.nextLine();
		System.out.println(st);
		singularOrPluralForms = new HashMap<NUMBER, String>();
		singularOrPluralForms.put(numberE, st);
		System.out.println(singularOrPluralForms.toString());
	}
	public ArrayList<CASE> defineListOfCasesOfNoun(){
		ArrayList<CASE> CasesOfNoun = new ArrayList<CASE>();
		CasesOfNoun.add(CASE.NOMINATIVE);
		CasesOfNoun.add(CASE.GENITIVE);
		return CasesOfNoun;
	}
	public HashMap<NUMBER, String> getSingularAndPluralForms(){
		return this.singularOrPluralForms;
	}
	public String getSingularForm(){
		return singularOrPluralForms.get(NUMBER.SINGULAR);
	}
	public String getPluralForm(){
		return singularOrPluralForms.get(NUMBER.PLURAL);
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
