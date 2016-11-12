package pp.serviceImpl;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pp.entity.*;
import pp.service.WordUniqueFormService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordUniqueFormUkrainianServiceImpl implements WordUniqueFormService {
    public void createOrUpdateWordUniqueForm(String word) {

        //1 get all WordUniqueForm
        //2 try find
        //3 if not found interaction with human and create
        //WordUniqueForm WordUniqueForm2 = new WordUniqueForm(tloJam);
        //linguisticCategories = new WordUniqueFormUkranianServiceImpl().createNewWordUniqueForm(tloJam);
        WordUniqueForm WordUniqueForm = createNewWordUniqueForm(word);
        try {
            safeOfNewWordUniqueFormInIndividualFile(WordUniqueForm);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //4 if found write some statistic
        // sooom
        // sraaam

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
                    linguisticCategoriesOfWordUniqueForm.add(new LcVerb());
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

public void safeOfNewWordUniqueFormInIndividualFile(WordUniqueForm WordUniqueForm) throws ParseException {
    System.out.println(WordUniqueForm);
//    String stForJSON;
    JSONParser parser = new JSONParser();
//    stForJSON = WordUniqueForm.stringForJsonParser();
//    JSONObject WordUniqueFormJSONObj = (JSONObject) parser.parse(stForJSON);
//
//    try {
//        // Writing to a file
//        //
//        //File file=new File("c:\\Nazar\\json-jamu\\"+WordUniqueForm.getTloJam()+".json");
//        File file=new File("e:\\Develop\\json-jamu\\"+WordUniqueForm.getTloJam()+".json");
//        file.createNewFile();
//        FileWriter fileWriter = new FileWriter(file);
//        System.out.println("Writing JSON object to file");
//        System.out.println("-----------------------");
//        System.out.print(WordUniqueFormJSONObj);
//        fileWriter.write(WordUniqueFormJSONObj.toJSONString());
//        fileWriter.flush();
//        fileWriter.close();
//    } catch (IOException e)
//    {
//        e.printStackTrace();
//    }
}
    public void safeOfNewWordUniqueFormInIndividualFileOld(WordUniqueForm WordUniqueForm){
        JSONObject WordUniqueFormJSONObj = new JSONObject();
        JSONObject WordUniqueFormJSONObjLCforms = new JSONObject();
        JSONObject WordUniqueFormJSONObjLC = new JSONObject();
        WordUniqueFormJSONObj.put("tloJam", WordUniqueForm.getTloJam());
        WordUniqueFormJSONObjLCforms.put("isUniqueLinguisticCategorie",WordUniqueForm.getLinguisticCategoryForms().isUniqueLinguisticCategorie());
        //
        ArrayList<LinguisticCategory> linguisticCategories = WordUniqueForm.getLinguisticCategoryForms().getLinguisticCategories();
        // JSONArray listOfLinguisticCategories = new JSONArray();
        for (LinguisticCategory lingCat:
                linguisticCategories) {

            WordUniqueFormJSONObjLC.put("LinguisticCategoryE",lingCat.getLinguisticCategoryE().toString());
            //WordUniqueFormJSONObjLC.put("Gender",lingCat.getGender());


            //
        }

        for (int k =0; k < linguisticCategories.size();k++) {
            //WordUniqueFormJSONObjLC.put("LinguisticCategoryE",linguisticCategories.get(k).getClass().);
            // WordUniqueFormJSONObjLC.put("Gender",lingCat.getGender());


            //
        }
        System.out.println("llllp"+linguisticCategories.toString());

        WordUniqueFormJSONObjLCforms.put("LinguisticCategoryForms",WordUniqueFormJSONObjLC);
        WordUniqueFormJSONObj.put("LinguisticCategoryForms",WordUniqueFormJSONObjLCforms);
        // WordUniqueFormJSONObj.put("States", listOfStates);
        try {
            // Writing to a file
            //
            File file=new File("E:\\Develop\\json-jamu\\"+WordUniqueForm.getTloJam()+".json");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            System.out.println("Writing JSON object to file");
            System.out.println("-----------------------");
            System.out.print(WordUniqueFormJSONObj);
            fileWriter.write(WordUniqueFormJSONObj.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
