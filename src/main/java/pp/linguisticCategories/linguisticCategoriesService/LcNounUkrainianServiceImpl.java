package pp.linguisticCategories.linguisticCategoriesService;

import pp.grammaticalCategories.Gender;
import pp.grammaticalCategories.Number;
import pp.grammaticalCategories.Case;
import pp.linguisticCategories.LcNoun;
import pp.linguisticCategories.LcNounUkrainian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Admin on 07.11.2016.
 */
public class LcNounUkrainianServiceImpl implements LcNounUkranianService {

    public HashMap<Number,String> defineSingularAndPluralForms(LcNounUkrainian lcNounUkrainian){
        new LinguisticCategoriesServiceImpl().listNumeralCasesOfNounInUkrainianOut();
        HashMap<Number,String>  singularOrPluralForms = new HashMap<Number, String>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        switch (n) {
            case 1:
                singularOrPluralForms.put(Number.SINGULAR, lcNounUkrainian.getFormOfWord());
                System.out.println(lcNounUkrainian.getFormOfWord());
                return singularOrPluralForms;
            case 2:
                 singularOrPluralForms.put(Number.PLURAL, lcNounUkrainian.getFormOfWord());
                return singularOrPluralForms;
            case 3:
                 singularOrPluralForms.put(Number.SINGULAR, lcNounUkrainian.getFormOfWord());
                singularOrPluralForms.put(Number.PLURAL, lcNounUkrainian.getFormOfWord());
                return singularOrPluralForms;
    default:
            System.out.println("невдалий номер позиції. спробуте ще раз");
        return singularOrPluralForms;
}
}

    public HashMap<Number,String> defineSingularAndPluralFormsForUniqueForm(LcNounUkrainian lcNounUkrainian){
        new LinguisticCategoriesServiceImpl().listNumeralCasesOfNounInUkrainianOut();
        HashMap<Number,String>  singularOrPluralForms = new HashMap<Number, String>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        switch (n) {
            case 1:
                singularOrPluralForms.put(Number.SINGULAR, lcNounUkrainian.getFormOfWord());
                return singularOrPluralForms;
            case 2:
                singularOrPluralForms.put(Number.PLURAL, lcNounUkrainian.getFormOfWord());
                return singularOrPluralForms;
            case 3:
                singularOrPluralForms.put(Number.SINGULAR, lcNounUkrainian.getFormOfWord());
                singularOrPluralForms.put(Number.PLURAL, lcNounUkrainian.getFormOfWord());
                return singularOrPluralForms;
            default:
                System.out.println("невдалий номер позиції. спробуте ще раз");
                singularOrPluralForms.put(Number.SINGULAR, lcNounUkrainian.getFormOfWord());
                return singularOrPluralForms;
        }
    }

    private Gender defineGender(){
        System.out.println("Введіть рід іменника");
        new LinguisticCategoriesServiceImpl().listGendersInUkrainianOut();
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        switch (n) {
            case 1:
                return Gender.MALE;
            case 2:
                return Gender.FEMALE;
            case 3:
                return Gender.MEDIUM;
            default:
                System.out.println("невдалий номер позиції. спробуте ще раз");
                return Gender.MEDIUM;
        }
    }

    private HashMap<Case, String> defineCasesOfNoun(LcNounUkrainian lcNounUkrainian, ArrayList<Case> listOfCasesOfNoun){
        System.out.println("Визначення відмінків іменника");

        Scanner scanner = new Scanner(System.in);
        String st;
        HashMap<Case, String> casesOfWord = new HashMap<Case, String>();
        for (Case cases: listOfCasesOfNoun) {
            System.out.println("Введіть "+cases.name() +" відмінок іменника");
            st = scanner.nextLine();
            casesOfWord.put(cases,st);
        }
        return casesOfWord;
    }

    private HashMap<Case, String> defineCasesOfNounForUniqueForm(LcNounUkrainian lcNounUkrainian, ArrayList<Case> listOfCasesOfNoun){
        System.out.println("Визначення відмінків іменника");
        Scanner scanner = new Scanner(System.in);
        int n=0;
        HashMap<Case, String> casesOfWord = new HashMap<Case, String>();
        HashMap<Integer, Case> mapOfCases = new HashMap<Integer, Case>();
        for (Case cases: listOfCasesOfNoun) {
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
//  //    temporarily swich off define gramatic categ.
//        lcNounUkrainian.setSingularOrPluralForms(defineSingularAndPluralFormsForUniqueForm(lcNounUkrainian));
//        lcNounUkrainian.setGender(defineGender());
//        lcNounUkrainian.setCasesOfWord(defineCasesOfNounForUniqueForm(lcNounUkrainian,new LinguisticCategoriesServiceImpl().defineListOfCasesOfNoun()));
        return lcNounUkrainian;
    }

}
