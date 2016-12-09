package pp.linguisticCategories.linguisticCategoriesService;

import pp.grammaticalCategories.CASE;

import java.util.ArrayList;

/**
 * Created by Admin on 03.12.2016.
 */
public class LinguisticCategoriesServiceImpl {

    public static void listOfLinguisticCategoryInUkrainianOut() {
        System.out.println("Перелік частин мови");
        System.out.println("1. Іменник");
        System.out.println("2. Дієслово");
        System.out.println("3. Прислівник");
        System.out.println("4. Прикметник");
        System.out.println("5. Займенник");
        System.out.println("6. Прийменник");
        System.out.println("7. Частка");

    }

    public static void listNumeralCasesOfNounInUkrainianOut(){
        System.out.println("введіть відмінювання іменника по числах");
        System.out.println("1. однина");
        System.out.println("2. множина");
        System.out.println("3. однини та множини");
    }

    public static void listGendersInUkrainianOut(){
        System.out.println("1. чоловічий");
        System.out.println("2. жіночий");
        System.out.println("3. середній");
    }

    public ArrayList<CASE> defineListOfCasesOfNoun(){
        ArrayList<CASE> CasesOfNoun = new ArrayList<CASE>();
        CasesOfNoun.add(CASE.NOMINATIVE);
        CasesOfNoun.add(CASE.GENITIVE);
        CasesOfNoun.add(CASE.DATIVE);
        CasesOfNoun.add(CASE.ACCUSATIVE);
        CasesOfNoun.add(CASE.INSTRUMANTAL);
        CasesOfNoun.add(CASE.LOCATIVE);
        CasesOfNoun.add(CASE.VOCATIVE);
        return CasesOfNoun;
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

}
