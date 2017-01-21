package pp.linguisticCategories.linguisticCategoriesService;

import pp.grammaticalCategories.Case;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 03.12.2016.
 */
public class LinguisticCategoriesServiceImpl {

    public static void listOfLinguisticCategoryInUkrainianOut() {
        System.out.println("Введіть позицію частини мови до якої належить слово!");
        System.out.println("1. Іменник");
        System.out.println("2. Дієслово");
        System.out.println("3. Прислівник");
        System.out.println("4. Прикметник");
        System.out.println("5. Займенник");
        System.out.println("6. Прийменник");
        System.out.println("7. Частка");
        System.out.println("8. Числівник");
    }

    public static void listNumeralCasesOfNounInUkrainianOut(){
        System.out.println("Введіть відмінювання іменника по числах");
        System.out.println("1. однина");
        System.out.println("2. множина");
        System.out.println("3. однини та множини");
    }

    public static void listGendersInUkrainianOut(){
        System.out.println("1. чоловічий");
        System.out.println("2. жіночий");
        System.out.println("3. середній");
    }

    public ArrayList<Case> defineListOfCasesOfNoun(){
        ArrayList<Case> casesOfNoun = new ArrayList<Case>();
        casesOfNoun.add(Case.NOMINATIVE);
        casesOfNoun.add(Case.GENITIVE);
        casesOfNoun.add(Case.DATIVE);
        casesOfNoun.add(Case.ACCUSATIVE);
        casesOfNoun.add(Case.INSTRUMANTAL);
        casesOfNoun.add(Case.LOCATIVE);
        casesOfNoun.add(Case.VOCATIVE);
        return casesOfNoun;
    }

    public ArrayList<String> getListOfTypicalFormsOfVerbInUkrainianOut(){
        ArrayList<String> TypicalFormsOfVerb = new ArrayList<String>();
        TypicalFormsOfVerb.add("Неозначена форма");
        TypicalFormsOfVerb.add("Особові форми");
        TypicalFormsOfVerb.add("Безособова форма");
        TypicalFormsOfVerb.add("Дієприслівникова форма");
        TypicalFormsOfVerb.add("Дієприкметникова форма");
        return TypicalFormsOfVerb;
    }

    public static Map<String, Integer> listOfStatisticItem() {
        Map<String, Integer> statasticItem = new HashMap<String, Integer>();
        statasticItem.put("totalAccountOfWords", 0);
        statasticItem.put("totalAccountOfWordsAdjective", 0);
        statasticItem.put("totalAccountOfWordsAdverb", 0);
        statasticItem.put("totalAccountOfWordsConjunction", 0);
        statasticItem.put("totalAccountOfWordsNoun", 0);
        statasticItem.put("totalAccountOfWordsNumeral", 0);
        statasticItem.put("totalAccountOfWordsPreposition", 0);
        statasticItem.put("totalAccountOfWordsPronoun", 0);
        statasticItem.put("totalAccountOfWordsVerb", 0);
        return statasticItem;
    }
}
