package pp.word;

import com.google.gson.Gson;
import org.json.simple.parser.ParseException;
import pp.linguisticCategories.Language;
import pp.linguisticCategories.LinguisticCategory;
import pp.linguisticCategories.LinguisticCategoryForms;
import pp.linguisticCategories.linguisticCategoriesService.*;
import pp.textFileProcessing.TextFileImproveServiceImpl;
import pp.textFileProcessing.TextFileReadAndWriteServiceImpl;

import java.io.*;
import java.util.*;

public class WordUniqueFormUkrainianServiceImpl implements WordUniqueFormService {

    public void parsingTextOfUniqueWords(List<String> textOfFileDivideOnListWords) {

        System.out.println("Start of text parsing");
        final File folder = new File("e:\\Develop\\json-jamu\\");
        HashMap<String, WordUniqueForm> allWordUniqueForm = getAllWordUniqueFormFronJSONfiles(folder);
        for (String word : textOfFileDivideOnListWords) {
            if (!allWordUniqueForm.containsKey(word)) {
                try {
                    new TextFileReadAndWriteServiceImpl().writeToJSONfile(stringForJSONParser(createNewWordUniqueForm(word)), word);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public HashMap<String, WordUniqueForm> getAllWordUniqueFormFronJSONfiles(final File folder) {
        HashMap<String, WordUniqueForm> allWordUniqueForm = new HashMap<String, WordUniqueForm>();
        for (final File fileEntry : folder.listFiles()) {
            if (!fileEntry.isDirectory()&&(new TextFileImproveServiceImpl().fileIsJSON(fileEntry.getAbsolutePath()))) {
                WordUniqueForm wordUniqueForm = readJSONfileAndConvertToObject(fileEntry);
                allWordUniqueForm.put(wordUniqueForm.getFormOfWord(),wordUniqueForm);

            }
        }
//        for (Map.Entry<String, WordUniqueForm> wordUniqueFormEntry:allWordUniqueForm.entrySet()) {
//            System.out.println(wordUniqueFormEntry.getValue().toString());
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
        WordUniqueForm WordUniqueForm = new WordUniqueForm(word, Language.UKRAINIAN);
        ArrayList<LinguisticCategory> linguisticCategoriesOfWordUniqueForm = new ArrayList<LinguisticCategory>();
        Scanner scanner2 = new Scanner(System.in);

        while (true) {
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
                    System.out.println("некоректний номер частини мови! спробуйте ще раз!");
                    continue;
            }
            break;
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
