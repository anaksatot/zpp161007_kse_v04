package pp.linguisticCategories.linguisticCategoriesService;

import pp.grammaticalCategories.GENDER;
import pp.grammaticalCategories.NUMBER;
import pp.grammaticalCategories.CASE;
import pp.linguisticCategories.LcNoun;
import pp.linguisticCategories.LcNounUkrainian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Admin on 07.11.2016.
 */
public class LcNounUkrainianServiceImpl implements LcNounUkranianService {

    public HashMap<NUMBER,String> defineSingularAndPluralForms(LcNounUkrainian lcNounUkrainian){
        new LinguisticCategoriesServiceImpl().listNumeralCasesOfNounInUkrainianOut();
        HashMap<NUMBER,String>  singularOrPluralForms = new HashMap<NUMBER, String>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        switch (n) {
            case 1:
                singularOrPluralForms.put(NUMBER.SINGULAR, lcNounUkrainian.getFormOfWord());
                System.out.println(lcNounUkrainian.getFormOfWord());
                return singularOrPluralForms;
            case 2:
                 singularOrPluralForms.put(NUMBER.PLURAL, lcNounUkrainian.getFormOfWord());
                return singularOrPluralForms;
            case 3:
                 singularOrPluralForms.put(NUMBER.SINGULAR, lcNounUkrainian.getFormOfWord());
                singularOrPluralForms.put(NUMBER.PLURAL, lcNounUkrainian.getFormOfWord());
                return singularOrPluralForms;
    default:
            System.out.println("невдалий номер позиції. спробуте ще раз");
        return singularOrPluralForms;
}
}

    public HashMap<NUMBER,String> defineSingularAndPluralFormsForUniqueForm(LcNounUkrainian lcNounUkrainian){
        new LinguisticCategoriesServiceImpl().listNumeralCasesOfNounInUkrainianOut();
        HashMap<NUMBER,String>  singularOrPluralForms = new HashMap<NUMBER, String>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        switch (n) {
            case 1:
                singularOrPluralForms.put(NUMBER.SINGULAR, lcNounUkrainian.getFormOfWord());
                return singularOrPluralForms;
            case 2:
                singularOrPluralForms.put(NUMBER.PLURAL, lcNounUkrainian.getFormOfWord());
                return singularOrPluralForms;
            case 3:
                singularOrPluralForms.put(NUMBER.SINGULAR, lcNounUkrainian.getFormOfWord());
                singularOrPluralForms.put(NUMBER.PLURAL, lcNounUkrainian.getFormOfWord());
                return singularOrPluralForms;
            default:
                System.out.println("невдалий номер позиції. спробуте ще раз");
                singularOrPluralForms.put(NUMBER.SINGULAR, lcNounUkrainian.getFormOfWord());
                return singularOrPluralForms;
        }
    }

    private GENDER defineGender(){
        System.out.println("Введіть рід іменника");
        new LinguisticCategoriesServiceImpl().listGendersInUkrainianOut();
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        switch (n) {
            case 1:
                return GENDER.MALE;
            case 2:
                return GENDER.FEMALE;
            case 3:
                return GENDER.MEDIUM;
            default:
                System.out.println("невдалий номер позиції. спробуте ще раз");
                return GENDER.MEDIUM;
        }
    }

    private HashMap<CASE, String> defineCasesOfNoun(LcNounUkrainian lcNounUkrainian, ArrayList<CASE> listOfCasesOfNoun){
        System.out.println("Визначення відмінків іменника");

        Scanner scanner = new Scanner(System.in);
        String st;
        HashMap<CASE, String> casesOfWord = new HashMap<CASE, String>();
        for (CASE cases: listOfCasesOfNoun) {
            System.out.println("Введіть "+cases.name() +" відмінок іменника");
            st = scanner.nextLine();
            casesOfWord.put(cases,st);
        }
        return casesOfWord;
    }

    private HashMap<CASE, String> defineCasesOfNounForUniqueForm(LcNounUkrainian lcNounUkrainian, ArrayList<CASE> listOfCasesOfNoun){
        System.out.println("Визначення відмінків іменника");
        Scanner scanner = new Scanner(System.in);
        int n=0;
        HashMap<CASE, String> casesOfWord = new HashMap<CASE, String>();
        HashMap<Integer, CASE> mapOfCases = new HashMap<Integer, CASE>();
        for (CASE cases: listOfCasesOfNoun) {
            ++n;
            System.out.println(n+". "+cases.name());
            mapOfCases.put(n,cases);
        }
        System.out.println("Введіть до скількох відмінків належить ця форма іменника і вкажіть їх номери");
        int q = scanner.nextInt();
        for (int i=0;i<q;i++){
            System.out.println("Введіть номер відмінку");
            n = scanner.nextInt();
            casesOfWord.put(mapOfCases.get(n),lcNounUkrainian.getFormOfWord());
        }
        return casesOfWord;
    }



    @Override
    public LcNoun defineLcNoun(String word) {
        LcNounUkrainian lcNounUkrainian = new LcNounUkrainian(word);
        // will be code for all forms
        return lcNounUkrainian;
    }

    @Override
    public LcNoun defineLcNounUniqueForm(String word) {
        LcNounUkrainian lcNounUkrainian = new LcNounUkrainian(word);
        lcNounUkrainian.setSingularOrPluralForms(defineSingularAndPluralFormsForUniqueForm(lcNounUkrainian));
        lcNounUkrainian.setGender(defineGender());
        lcNounUkrainian.setCasesOfWord(defineCasesOfNounForUniqueForm(lcNounUkrainian,new LinguisticCategoriesServiceImpl().defineListOfCasesOfNoun()));
        return lcNounUkrainian;
    }

}
