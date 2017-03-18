package pp.word;

import pp.linguisticCategories.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordUniqueFormEnglishServiceImpl implements WordUniqueFormService {
    public void createOrUpdateWordUniqueForm(String formOfWord) {

    }

    public WordUniqueForm createNewWordUniqueForm(String formOfWord) {
        WordUniqueForm wordUniqueForm = new WordUniqueForm(formOfWord, Language.ENGLISH);
        ArrayList<LinguisticCategory> linguisticCategoriesOfWordUniqueForm = new ArrayList<LinguisticCategory>();
        Scanner scannerName = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int i = 0,n, q = 0;
        System.out.println("How many linguistic categories has this word?");
        q = scanner2.nextInt();
        if (q > 0) {
            listOfLinguisticCategory();
        }
        while (i<q) {
            System.out.println("input item of ling. category to which belongs word!");
            n = scanner2.nextInt();
            switch (n) {
                case 1:
                    linguisticCategoriesOfWordUniqueForm.add(new LcNounEnglish(formOfWord));
                    break;
                default:
                    System.out.println("try input true item of l. category");
            }
            i = i+1;

        }
        wordUniqueForm.setLinguisticCategoryForms(new LinguisticCategoryForms(linguisticCategoriesOfWordUniqueForm));
        System.out.println(wordUniqueForm);
        return wordUniqueForm;
    }

    public  void listOfLinguisticCategory() {
        System.out.println("Input item of form for this word");
        System.out.println("1. Noun");
        System.out.println("2. Verb");
        System.out.println("3. Adverb");
        System.out.println("4. Adjective");
        System.out.println("5. Pronoun");
        System.out.println("6. Proposition");
        System.out.println("7. Conjunction");

    }


    @Override
    public String firstXSystemOrthographyOfWord(String word, Language language) {
        return "";
    }

    @Override
    public Map<WordUniqueForm, Integer> parsingTextIntoUniqueWords(List<String> textOfFileDivideOnListWords) {
        return null;
    }
}
