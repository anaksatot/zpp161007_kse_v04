package pp.textFileProcessing;

import com.google.gson.Gson;
import org.json.simple.parser.ParseException;
import pp.linguisticCategories.LinguisticCategoryForms;
import pp.word.WordUniqueForm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 2/24/2017.
 */
public class JsonFileReadAndWriteServiceImpl {
    public Map<String, WordUniqueForm> getAllWordUniqueFormFromJSONfiles(final File folder) {
        Map<String, WordUniqueForm> allWordUniqueForm = new HashMap<String, WordUniqueForm>();
        for (final File fileEntry : folder.listFiles()) {
            if (!fileEntry.isDirectory()&&(new TextFileImproveServiceImpl().fileIsJSON(fileEntry.getAbsolutePath()))) {
                WordUniqueForm wordUniqueForm = readJSONfileAndConvertToObject(fileEntry);
                allWordUniqueForm.put(wordUniqueForm.getFormOfWord(),wordUniqueForm);
            }
        }
        return allWordUniqueForm;
    }

    public WordUniqueForm readJSONfileAndConvertToObject(final File someFile) {
        System.out.println("huhff "+someFile);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(someFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        WordUniqueForm wordUniqueForm = gson.fromJson(br, WordUniqueForm.class);
        LinguisticCategoryForms linguisticCategoryForms = wordUniqueForm.getLinguisticCategoryForms();
        return wordUniqueForm;

    }

    public String stringForJSONParserWordUniqueForm(WordUniqueForm wordUniqueForm) {

        String stForJsonParser = "{" + "\"" + "formOfWord" + "\"" + ":" + "\"" + wordUniqueForm.getFormOfWord() + "\"" + "," + "\"" + "quantityOfSymbols" + "\""
                + ":" + wordUniqueForm.getQuantitySymbols() + "," + "\"" + "id" + "\"" + ":" + "\""+ wordUniqueForm.getId()
                + "\"" + "," + "\"" + "accountWordsOfThisUniqueForm" + "\"" + ":" + "\""+ wordUniqueForm.getAccountWordsOfThisUniqueForm()+ "\"";
        String stForJsonParserLC = "";
//        for (LinguisticCategory lingCategory : wordUniqueForm.getLinguisticCategoryForms().getLinguisticCategories()) {
//            stForJsonParserLC = stForJsonParserLC + new LCForJSONImpl().getStringLCForJsonParser(lingCategory);
//        }
        stForJsonParser = stForJsonParser + "," + stForJsonParserLC + "}";
        return stForJsonParser;
    }

    public void saveStatisticToJsonFilesForCurrentText(Map<WordUniqueForm,Integer> listWordsOfCurrentText){
                for (Map.Entry<WordUniqueForm,Integer>wordOfCurrentText: listWordsOfCurrentText.entrySet()) {
            wordOfCurrentText.getKey().setAccountWordsOfThisUniqueForm(wordOfCurrentText.getValue()+wordOfCurrentText.getKey().getAccountWordsOfThisUniqueForm());
            try {
                new TextFileReadAndWriteServiceImpl().writeToJSONfile(stringForJSONParserWordUniqueForm(wordOfCurrentText.getKey()), wordOfCurrentText.getKey().getFormOfWord());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

}
