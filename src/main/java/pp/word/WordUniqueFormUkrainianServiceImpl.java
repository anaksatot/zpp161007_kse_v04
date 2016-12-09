package pp.word;

import pp.linguisticCategories.LANGUAGE;
import pp.linguisticCategories.LinguisticCategory;
import pp.linguisticCategories.LinguisticCategoryForms;
import pp.linguisticCategories.linguisticCategoriesService.*;

import java.util.ArrayList;
import java.util.Scanner;

public class WordUniqueFormUkrainianServiceImpl implements WordUniqueFormService {
    public void createOrUpdateWordUniqueForm(String word) {

        //1 get all WordUniqueForm
        //2 try find
        //3 if not found interaction with human and create
        WordUniqueForm WordUniqueForm = createNewWordUniqueForm(word);
        //4 write to JSON
//        try {
//            new WordUniqueFormToFileWriteServiceImpl().writeToJSONfile(stringForJSONParser(WordUniqueForm), WordUniqueForm.getFormOfWord());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        ;

        //5 if found write some statistic
        // sooom
        // sraaam
    }


    public String stringForJSONParser(WordUniqueForm wordUniqueForm) {

        String stForJsonParser = "{" + "\"" + "formOfWord" + "\"" + ":" + "\"" + wordUniqueForm.getFormOfWord() + "\"" + "," + "\"" + "quantitySymbols" + "\""
                + ":" + wordUniqueForm.getQuantiySymbols() + "," + "\"" + "id" + "\"" + ":" + wordUniqueForm.getUniqueIndex();
        String stForJsonParserLC = "";
        for (LinguisticCategory lingCategory : wordUniqueForm.getLinguisticCategoryForms().getLinguisticCategories()) {
            stForJsonParserLC = stForJsonParserLC + new LCForJSONImpl().getStringLCForJsonParser(lingCategory);
        }
        stForJsonParser = stForJsonParser + "," + stForJsonParserLC + "}";
        System.out.println("string for JSON " + stForJsonParser);
        return stForJsonParser;
    }

    public WordUniqueForm createNewWordUniqueForm(String word) {
        WordUniqueForm WordUniqueForm = new WordUniqueForm(word, LANGUAGE.UKRAINIAN);
        ArrayList<LinguisticCategory> linguisticCategoriesOfWordUniqueForm = new ArrayList<LinguisticCategory>();
        Scanner scanner2 = new Scanner(System.in);
        new LinguisticCategoriesServiceImpl().listOfLinguisticCategoryInUkrainianOut();
        int n;
        System.out.println("Введіть позицію частини мови до якої належить слово!");
        n = scanner2.nextInt();
        switch (n) {
            case 1:
                linguisticCategoriesOfWordUniqueForm.add(new LcNounUkrainianServiceImpl().defineLcNounUniqueForm(word));
                break;
            case 2:
                linguisticCategoriesOfWordUniqueForm.add(new LcVerbUkrainianServiceImpl().defineLcVerbUniqueForm(word));
                break;
            case 3:
                linguisticCategoriesOfWordUniqueForm.add(new LcAdverbUkrainianServiceImpl().defineLcAdverb(word));
                System.out.println(new LcAdverbUkrainianServiceImpl().defineLcAdverb(word).toString());
                break;
            case 4:
                linguisticCategoriesOfWordUniqueForm.add(new LcAdjectiveUkrainianServiceImpl().defineLcAdjective(word));
                System.out.println(new LcAdverbUkrainianServiceImpl().defineLcAdverb(word).toString());
                break;
            default:
                System.out.println("Введіть коректний номер!");
        }
        WordUniqueForm.setLinguisticCategoryForms(new LinguisticCategoryForms(linguisticCategoriesOfWordUniqueForm));
        System.out.println(WordUniqueForm);
        return WordUniqueForm;
    }



    @Override
    public String firstXSystemOrthographyOfWord(WordUniqueForm wordUniqueForm) {
        switch (wordUniqueForm.getLanguage()) {
            case UKRAINIAN:
                return new FirstXSystemOrthographyUkrainian().getFirstXSystemOrthographyForm(wordUniqueForm.getFormOfWord());
            case ENGLISH:
                return new FirstXSystemOrthographyEnglish().getFirstXSystemOrthographyForm(wordUniqueForm.getFormOfWord());
            case GERMANY:
                return new FirstXSystemOrthographyGermany().getFirstXSystemOrthographyForm(wordUniqueForm.getFormOfWord());
        }
        return "";
    }

    class FirstXSystemOrthographyUkrainian implements FirstXSystemOrthography

    {
        public String getFirstXSystemOrthographyForm(String word) {
            return "xUA_" + word;
        }
    }

    class FirstXSystemOrthographyEnglish implements FirstXSystemOrthography {
        public String getFirstXSystemOrthographyForm(String word) {
            return "xEn_" + word;
        }
    }

    class FirstXSystemOrthographyGermany implements FirstXSystemOrthography {
        public String getFirstXSystemOrthographyForm(String word) {
            return "xDe_" + word;
        }
    }

}
