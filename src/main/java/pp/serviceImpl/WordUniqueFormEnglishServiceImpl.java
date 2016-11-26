package pp.serviceImpl;

import pp.entity.*;
import pp.service.WordUniqueFormService;

import java.util.ArrayList;
import java.util.Scanner;

public class WordUniqueFormEnglishServiceImpl implements WordUniqueFormService {
    public void createOrUpdateWordUniqueForm(String tloJam) {
        ArrayList<LinguisticCategory> linguisticCategories;
        //1 get all WordUniqueFormi
        //2 try find
        //3 if not found interaction with human and create
        WordUniqueForm wordUniqueForm = new WordUniqueFormUkrainianServiceImpl().createNewWordUniqueForm(tloJam);
        //4 if found write some statistic
    }

    @Override
    public String firstXSystemOrthographyOfWord(WordUniqueForm wordUniqueForm) {
        return "";
    }

    public WordUniqueForm createNewWordUniqueForm(String tloJam) {
        WordUniqueForm wordUniqueForm = new WordUniqueForm(tloJam, LANGUAGE.ENGLISH);
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
                    linguisticCategoriesOfWordUniqueForm.add(new LcNounEnglish(tloJam));
                    break;
                case 2:
                    linguisticCategoriesOfWordUniqueForm.add(new LcVerb());
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


}
