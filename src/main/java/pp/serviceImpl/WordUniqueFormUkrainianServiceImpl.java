package pp.serviceImpl;

import org.json.simple.parser.ParseException;
import pp.entity.LinguisticCategory;
import pp.entity.LinguisticCategoryForms;
import pp.entity.WordUniqueForm;
import pp.service.WordUniqueFormService;

import java.util.ArrayList;
import java.util.Scanner;

public class WordUniqueFormUkrainianServiceImpl implements WordUniqueFormService {
    public void createOrUpdateWordUniqueForm(String word) {

        //1 get all WordUniqueForm
        //2 try find
        //3 if not found interaction with human and create
        WordUniqueForm WordUniqueForm = createNewWordUniqueForm(word);
        try {
            new WordUniqueFormToFileWriteServiceImpl().writeToJSONfile(stringForJSONParser(WordUniqueForm),WordUniqueForm.getFormOfWord());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //4 if found write some statistic
        // sooom
        // sraaam

    }

    public String stringForJSONParser(WordUniqueForm wordUniqueForm) {

        String stForJsonParser = "{"+"\""+"formOfWord"+"\""+":"+"\""+wordUniqueForm.getFormOfWord()+"\""+","+"\""+"quantiySymbols"+"\""
                +":"+wordUniqueForm.getQuantiySymbols()+","+"\""+"id"+"\""+":"+wordUniqueForm.getUniqueIndex();
        String stForJsonParserLC = "";
        		for (LinguisticCategory lingCategory: wordUniqueForm.getLinguisticCategoryForms().getLinguisticCategories()) {
                    stForJsonParserLC = stForJsonParserLC + new LCForJSONImpl().getStringLCForJsonParser(lingCategory);
                }
            stForJsonParser = stForJsonParser +"," + stForJsonParserLC + "}";
            System.out.println("string for JSON "+stForJsonParser);
			return 	stForJsonParser;
    }

    public WordUniqueForm createNewWordUniqueForm(String word) {
        WordUniqueForm WordUniqueForm = new WordUniqueForm(word);
        ArrayList<LinguisticCategory> linguisticCategoriesOfWordUniqueForm = new ArrayList<LinguisticCategory>();
        Scanner scanner2 = new Scanner(System.in);
        listOfLinguisticCategory();
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
                default:
                    System.out.println("Введіть коректний номер!");
            }
        WordUniqueForm.setLinguisticCategoryForms(new LinguisticCategoryForms(linguisticCategoriesOfWordUniqueForm));
        System.out.println(WordUniqueForm);
        return WordUniqueForm;
    }


    public  void listOfLinguisticCategory() {
        System.out.println("Перелік частин мови");
        System.out.println("1. Іменник");
        System.out.println("2. Дієслово");
        System.out.println("3. Прислівник");
        System.out.println("4. Прикметник");
        System.out.println("5. Займенник");
        System.out.println("6. Прийменник");
        System.out.println("7. Частка");

    }


}
