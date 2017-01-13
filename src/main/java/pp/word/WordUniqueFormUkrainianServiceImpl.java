package pp.word;

import com.google.gson.Gson;
import org.json.simple.parser.ParseException;
import pp.linguisticCategories.Language;
import pp.linguisticCategories.LinguisticCategory;
import pp.linguisticCategories.LinguisticCategoryForms;
import pp.linguisticCategories.linguisticCategoriesService.*;
import pp.textFileProcessing.TextFileImproveServiceImpl;
import pp.textFileProcessing.TextFileReadAndWriteServiceImpl;

import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;

public class WordUniqueFormUkrainianServiceImpl implements WordUniqueFormService {

    public void parsingTextOfUniqueWords(List<String> textOfFileDivideOnListWords) {
        WordUniqueForm newWordUniqueForm;
        System.out.println("Start of text parsing");

        boolean inDetail = modeIsInDetail();
        final File folder = new File("e:\\Develop\\json-jamu\\");
        Map<String, WordUniqueForm> allWordUniqueForm = getAllWordUniqueFormFromJSONfiles(folder);
        for (String word : textOfFileDivideOnListWords) {
            if (!allWordUniqueForm.containsKey(word.toLowerCase())) {
//                if (wordIsNotCorrect(word)) {
//                    continue;
//                }
                try {
                    newWordUniqueForm = createNewWordUniqueForm(word, inDetail);
                    new TextFileReadAndWriteServiceImpl().writeToJSONfile(stringForJSONParser(newWordUniqueForm), word);
                    // new TextFileReadAndWriteServiceImpl().serializeWordUniqueForm(newWordUniqueForm);
                    allWordUniqueForm.put(newWordUniqueForm.getFormOfWord(),newWordUniqueForm);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            } else {
                allWordUniqueForm.get(word.toLowerCase()).checkAndWriteFormsWithCapitalAndLowerLetters(word);
            }
            // else {new TextFileReadAndWriteServiceImpl().deserializeWordUniqueForm(word);}
        }

    }

    public Map<String, WordUniqueForm> getAllWordUniqueFormFromJSONfiles(final File folder) {
        Map<String, WordUniqueForm> allWordUniqueForm = new HashMap<String, WordUniqueForm>();
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

    public WordUniqueForm createNewWordUniqueForm(String word, boolean inDetail) {
        WordUniqueForm WordUniqueForm = new WordUniqueForm(word, Language.UKRAINIAN);
        ArrayList<LinguisticCategory> linguisticCategoriesOfWordUniqueForm = new ArrayList<LinguisticCategory>();
        Scanner scanner2 = new Scanner(System.in);

        while (true) {
            System.out.println("Визнаення слова: " + word);
            new LinguisticCategoriesServiceImpl().listOfLinguisticCategoryInUkrainianOut();
            int n = scanner2.nextInt();
            switch (n) {
                case 1:
                    linguisticCategoriesOfWordUniqueForm.add(new LcNounUkrainianServiceImpl().defineLcNounUniqueForm(word,inDetail));
                    break;
                case 2:
                    linguisticCategoriesOfWordUniqueForm.add(new LcVerbUkrainianServiceImpl().defineLcVerbUniqueForm(word,inDetail));
                    break;
                case 3:
                    linguisticCategoriesOfWordUniqueForm.add(new LcAdverbUkrainianServiceImpl().defineLcAdverb(word));
                    //System.out.println(new LcAdverbUkrainianServiceImpl().defineLcAdverb(word).toString());
                    break;
                case 4:
                    linguisticCategoriesOfWordUniqueForm.add(new LcAdjectiveUkrainianServiceImpl().defineLcAdjective(word));
                    //System.out.println(new LcAdjectiveUkrainianServiceImpl().defineLcAdjective(word).toString());
                    break;
                case 5:
                    linguisticCategoriesOfWordUniqueForm.add(new LcPronounUkrainianServiceImpl().defineLcPronoun(word));
                    //System.out.println(new LcPronounUkrainianServiceImpl().defineLcPronoun(word).toString());
                    break;
                case 6:
                    linguisticCategoriesOfWordUniqueForm.add(new LcPrerositionUkrainianServiceImpl().defineLcPrerosition(word));
                    //System.out.println(new LcPrerositionUkrainianServiceImpl().defineLcPrerosition(word).toString());
                    break;
                case 7:
                    linguisticCategoriesOfWordUniqueForm.add(new LcConjunctionUkrainianServiceImpl().defineLcConjunction(word));
                    //System.out.println(new LcConjunctionUkrainianServiceImpl().defineLcConjunction(word).toString());
                    break;
                case 8:
                    linguisticCategoriesOfWordUniqueForm.add(new LcNumeralUkrainianServiceImpl().defineLcNumeral(word));
                    //System.out.println(new LcNumeralUkrainianServiceImpl().defineLcNumeral(word).toString());
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

    public boolean modeIsInDetail() {
        System.out.println("Визначати слова детально чи текучу форму?");
        System.out.println("Якщо детально то введіть з клавіатури0 'y', інакше введіть 'n'");
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try
            {
                int ascii = br.read();
                System.out.println(" Value - "+ascii);
                if (ascii == 121) {
                    return true;
                }
                if (ascii == 110) {
                    return false;
                }
                System.out.println("спробуйте ввести ще раз!");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public boolean wordIsNotCorrect(String word) {

        System.out.println(word.toUpperCase() + " Якщо слово коректне просто натисніть Enter. Якщо некоректне тоді любу клавішу з літерою і тоді Enter");
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try
            {
                int ascii = br.read();
                System.out.println(" Value - "+ascii);
                if (ascii == 10) {
                    return false;
                }
                return true;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return true;
        }
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
