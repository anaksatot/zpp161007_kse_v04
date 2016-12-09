package pp.word;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pp.linguisticCategories.LANGUAGE;
import pp.linguisticCategories.LinguisticCategory;
import pp.linguisticCategories.LinguisticCategoryForms;
import pp.linguisticCategories.linguisticCategoriesService.*;
import pp.textFileProcessing.TextFileImproveServiceImpl;
import pp.textFileProcessing.WordUniqueFormToFileWriteServiceImpl;

import java.io.*;
import java.util.*;

public class WordUniqueFormUkrainianServiceImpl implements WordUniqueFormService {

    public void parsingTextOfUniqueWords(List<String> textOfFileDivideOnListWords) {

        //1 get all WordUniqueForm
        System.out.println("Start of text parsing");
        final File folder = new File("e:\\Develop\\json-jamu\\");
        HashMap<String, WordUniqueForm> allWordUniqueForm = getAllWordUniqueFormFronJSONfiles(folder);
        //2 try find
        //4 write to JSON
        for (String word : textOfFileDivideOnListWords) {
            if (!allWordUniqueForm.containsKey(word)) {
                try {
                    new WordUniqueFormToFileWriteServiceImpl().writeToJSONfile(stringForJSONParser(createNewWordUniqueForm(word)), word);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public HashMap<String, WordUniqueForm> getAllWordUniqueFormFronJSONfiles(final File folder) {
        HashMap<String, WordUniqueForm> allWordUniqueForm = new HashMap<String, WordUniqueForm>();
        for (final File fileEntry : folder.listFiles()) {
            if (!fileEntry.isDirectory()&&(new TextFileImproveServiceImpl().fileHaveJSONExtension(fileEntry))) {
                WordUniqueForm wordUniqueForm = readJSONfileAndConvertToObject(fileEntry);
                allWordUniqueForm.put(wordUniqueForm.getFormOfWord(),wordUniqueForm);

            }
        }
//        System.out.println("wwwu "+allWordUniqueForm.size());
//        for (Map.Entry<String, WordUniqueForm> wordUniqueFormEntry:allWordUniqueForm.entrySet()) {
//            System.out.println("wuuu "+wordUniqueFormEntry.getValue().toString());
//        }
        return allWordUniqueForm;
    }

    public WordUniqueForm readJSONfileAndConvertToObject(final File someFile) {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(someFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        WordUniqueForm wordUniqueForm = gson.fromJson(br, WordUniqueForm.class);
        return wordUniqueForm;

    }

    public WordUniqueForm readJSONfileAndConvertToObjectV2(final File someFile) {

        JSONParser parser = new JSONParser();
        String nameEmpty = "";

        try {

            Object obj = parser.parse(new FileReader(someFile));
            JSONObject jsonObject = (JSONObject) obj;
            String name = (String) jsonObject.get("formOfWord");
            System.out.println(name);
            return convertJSONObjectToObjectWordUniqueFormV2(jsonObject);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        WordUniqueForm wordUniqueForm = new WordUniqueForm(nameEmpty, LANGUAGE.UKRAINIAN);
       return wordUniqueForm;
    }

    public WordUniqueForm convertJSONObjectToObjectWordUniqueFormV2(JSONObject jsonObject) {

        String name = (String) jsonObject.get("formOfWord");
        Gson gson = new Gson();
        System.out.println(name);
        WordUniqueForm wordUniqueForm = new WordUniqueForm("", LANGUAGE.UKRAINIAN);
        return wordUniqueForm;

    }

    public String stringForJSONParser(WordUniqueForm wordUniqueForm) {

        String stForJsonParser = "{" + "\"" + "formOfWord" + "\"" + ":" + "\"" + wordUniqueForm.getFormOfWord() + "\"" + "," + "\"" + "quantitySymbols" + "\""
                + ":" + wordUniqueForm.getQuantiySymbols() + "," + "\"" + "id" + "\"" + ":" + wordUniqueForm.getUniqueIndex();
        String stForJsonParserLC = "";
        for (LinguisticCategory lingCategory : wordUniqueForm.getLinguisticCategoryForms().getLinguisticCategories()) {
            stForJsonParserLC = stForJsonParserLC + new LCForJSONImpl().getStringLCForJsonParser(lingCategory);
        }
        stForJsonParser = stForJsonParser + "," + stForJsonParserLC + "}";
        return stForJsonParser;
    }

    public WordUniqueForm createNewWordUniqueForm(String word) {
        WordUniqueForm WordUniqueForm = new WordUniqueForm(word, LANGUAGE.UKRAINIAN);
        ArrayList<LinguisticCategory> linguisticCategoriesOfWordUniqueForm = new ArrayList<LinguisticCategory>();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Визнаення слова: " + word.toUpperCase());
        new LinguisticCategoriesServiceImpl().listOfLinguisticCategoryInUkrainianOut();
        int n = scanner2.nextInt();

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
                System.out.println(new LcAdjectiveUkrainianServiceImpl().defineLcAdjective(word).toString());
                break;
            case 5:
                linguisticCategoriesOfWordUniqueForm.add(new LcPronounUkrainianServiceImpl().defineLcPronoun(word));
                System.out.println(new LcPronounUkrainianServiceImpl().defineLcPronoun(word).toString());
                break;
            case 6:
                linguisticCategoriesOfWordUniqueForm.add(new LcPrerositionUkrainianServiceImpl().defineLcPrerosition(word));
                System.out.println(new LcPrerositionUkrainianServiceImpl().defineLcPrerosition(word).toString());
                break;
            case 7:
                linguisticCategoriesOfWordUniqueForm.add(new LcConjunctionUkrainianServiceImpl().defineLcConjunction(word));
                System.out.println(new LcConjunctionUkrainianServiceImpl().defineLcConjunction(word).toString());
                break;
            case 8:
                linguisticCategoriesOfWordUniqueForm.add(new LcNumeralUkrainianServiceImpl().defineLcNumeral(word));
                System.out.println(new LcNumeralUkrainianServiceImpl().defineLcNumeral(word).toString());
                break;
            default:
                System.out.println("Введіть коректний номер!");

        }
        WordUniqueForm.setLinguisticCategoryForms(new LinguisticCategoryForms(linguisticCategoriesOfWordUniqueForm));
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
