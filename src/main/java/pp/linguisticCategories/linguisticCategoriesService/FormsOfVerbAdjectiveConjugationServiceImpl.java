package pp.linguisticCategories.linguisticCategoriesService;

import pp.linguisticCategories.FormOfVerbAdjective;
import pp.linguisticCategories.FormsOfVerbAdjectiveConjugation;
import pp.grammaticalCategories.GENDER;
import pp.grammaticalCategories.PERFECTORIMPERFECT;
import pp.linguisticCategories.LCDefineDimension;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Admin on 30.11.2016.
 */
public class FormsOfVerbAdjectiveConjugationServiceImpl {
    FormsOfVerbAdjectiveConjugation defineAdjectiveForms(String word, boolean onlyThisForm) {
        if (!onlyThisForm) {
            System.out.println("Визначаємо всі форми дієслова");
            return defineAdjectiveFormOfVerbAllForms(word);
        }
        return defineAdjectiveFormOfVerb(word);
    }

    FormsOfVerbAdjectiveConjugation defineAdjectiveFormOfVerb(String word) {
        FormOfVerbAdjective formOfVerbAdjective = new FormOfVerbAdjective(LCDefineDimension.defineGender(),LCDefineDimension.defineIsPlural(),LCDefineDimension.definePerfectImperfect());
        return new FormsOfVerbAdjectiveConjugation(formOfVerbAdjective, word);
    }

    FormsOfVerbAdjectiveConjugation defineAdjectiveFormOfVerbAllForms(String word) {
        HashMap<FormOfVerbAdjective, String> mapAdjectiveFormOfVerb = new HashMap<FormOfVerbAdjective, String>();
        mapAdjectiveFormOfVerb = loopThroughPerfectImperfectAdjectiveForm(mapAdjectiveFormOfVerb);
        return new FormsOfVerbAdjectiveConjugation(mapAdjectiveFormOfVerb);
    }

    HashMap<FormOfVerbAdjective, String> loopThroughPerfectImperfectAdjectiveForm(HashMap<FormOfVerbAdjective, String> mapAdjectiveFormOfVerb) {
        for (PERFECTORIMPERFECT somePerfectImperfect: PERFECTORIMPERFECT.values()) {
            mapAdjectiveFormOfVerb = loopThroughGenderAdjectiveForm(somePerfectImperfect,mapAdjectiveFormOfVerb);
            mapAdjectiveFormOfVerb = pluralWithoutGenderAdjectiveForm(somePerfectImperfect,mapAdjectiveFormOfVerb);
        }
        return mapAdjectiveFormOfVerb;
    }

    HashMap<FormOfVerbAdjective, String>  loopThroughGenderAdjectiveForm(PERFECTORIMPERFECT somePerfectImperfect, HashMap<FormOfVerbAdjective, String> mapAdjectiveFormOfVerb) {
        Scanner scannerWord = new Scanner(System.in);
        String word;
        for (GENDER someGender: GENDER.values()) {
            word = scannerWord.nextLine();
            if (true) {
                mapAdjectiveFormOfVerb.put(new FormOfVerbAdjective(someGender,false,somePerfectImperfect),word);
            }
        }
        return mapAdjectiveFormOfVerb;
    }

    HashMap<FormOfVerbAdjective, String> pluralWithoutGenderAdjectiveForm(PERFECTORIMPERFECT somePerfectImperfect, HashMap<FormOfVerbAdjective, String> mapAdjectiveFormOfVerb) {
        Scanner scannerWord = new Scanner(System.in);
        String word = scannerWord.nextLine();
        if (true) {
            mapAdjectiveFormOfVerb.put(new FormOfVerbAdjective(true,somePerfectImperfect),word);
        }
        return mapAdjectiveFormOfVerb;
    }

}
