package pp.word;

import com.google.gson.Gson;
import org.json.simple.parser.ParseException;
import pp.linguisticCategories.Language;
import pp.linguisticCategories.LinguisticCategory;
import pp.linguisticCategories.LinguisticCategoryForms;
import pp.linguisticCategories.linguisticCategoriesService.*;
import pp.textFileProcessing.JsonFileReadAndWriteServiceImpl;
import pp.textFileProcessing.TextFileImproveServiceImpl;
import pp.textFileProcessing.TextFileReadAndWriteServiceImpl;
import pp.xmlFileProcessing.XMLfileReadAndWriteServiceImpl;

import java.io.*;
import java.util.*;

public class WordUniqueFormUkrainianServiceImpl implements WordUniqueFormService {

    public Map<WordUniqueForm,Integer>  parsingTextIntoUniqueWords(List<String> textOfFileDivideOnListWords) {

        System.out.println("Start of text parsing into Unique Words!");
        final File folder = new File(TextFileReadAndWriteServiceImpl.directoryForSaveJSONfilesWordUniqueForm());
        JsonFileReadAndWriteServiceImpl jsonFileService = new JsonFileReadAndWriteServiceImpl();
        Map<String, WordUniqueForm> allWordUniqueForm = jsonFileService.getAllWordUniqueFormFromJSONfiles(folder);
        Map<WordUniqueForm,Integer> mapWordsOfCurrentText = listWordsOfCurrentTextAndCreateNewWordsUniqueForm(textOfFileDivideOnListWords, allWordUniqueForm);
        jsonFileService.saveStatisticToJsonFilesForCurrentText(mapWordsOfCurrentText);
         if (new XMLfileReadAndWriteServiceImpl().saveToXMLStatisticInformationCompleted()) {
            System.out.println("Text parsing into Unique Words is finished! Statistic is written!");
        }
        return mapWordsOfCurrentText;
    }

    private Map<WordUniqueForm,Integer> listWordsOfCurrentTextAndCreateNewWordsUniqueForm(List<String> textOfFileDivideOnListWords, Map<String, WordUniqueForm> allWordUniqueForm){
        WordUniqueForm wordUniqueForm;
        TextFileReadAndWriteServiceImpl textFileReadAndWriteServiceImpl = new TextFileReadAndWriteServiceImpl();
        Map<WordUniqueForm,Integer> listWordsOfCurrentText = new HashMap<WordUniqueForm,Integer>();
        for (String word : textOfFileDivideOnListWords) {
            if (!allWordUniqueForm.containsKey(word.toLowerCase())) {
                try {
                    wordUniqueForm = createNewWordUniqueForm(word, modeIsInDetail());
                    textFileReadAndWriteServiceImpl.writeToJSONfile(new JsonFileReadAndWriteServiceImpl().stringForJSONParserWordUniqueForm(wordUniqueForm), word);
                    allWordUniqueForm.put(wordUniqueForm.getFormOfWord(),wordUniqueForm);
                    listWordsOfCurrentText.put(wordUniqueForm,1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            } else {
                wordUniqueForm = allWordUniqueForm.get(word.toLowerCase());
                wordUniqueForm.checkAndWriteFormsWithCapitalAndLowerLetters(word);
                if (!listWordsOfCurrentText.containsKey(wordUniqueForm)) {
                    listWordsOfCurrentText.put(wordUniqueForm,1);
                } else {
                    listWordsOfCurrentText.put(wordUniqueForm, listWordsOfCurrentText.get(wordUniqueForm) + 1);
                }
            }
        }
        return listWordsOfCurrentText;
    }

    public WordUniqueForm createNewWordUniqueForm(String word, boolean inDetail) {
        WordUniqueForm WordUniqueForm = new WordUniqueForm(word, Language.UKRAINIAN);
        ArrayList<LinguisticCategory> linguisticCategoriesOfWordUniqueForm = new ArrayList<LinguisticCategory>();
        Scanner scanner2 = new Scanner(System.in);

        while (true) {
            System.out.println("Визнаення слова: " + word);
            //System.out.println("Визнаення слова xivi system : " + firstXSystemOrthographyOfWord(word, Language.UKRAINIAN));
            //new LinguisticCategoriesServiceImpl().listOfLinguisticCategoryInUkrainianOut();
            //int n = scanner2.nextInt();
            int n = 1;
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

    public Map<String,WordUniqueForm> mapWordsOfCurrentTextStringKey(Map<WordUniqueForm, Integer> mapWordsOfCurrentText){
        Map<String,WordUniqueForm> mapWordsOfCurrentTextNewStructure =new HashMap<String, WordUniqueForm>();
        for (WordUniqueForm  keyWordUniqueForm : mapWordsOfCurrentText.keySet()) {
            mapWordsOfCurrentTextNewStructure.put(keyWordUniqueForm.getFormOfWord(),keyWordUniqueForm);
        }
        return mapWordsOfCurrentTextNewStructure;
    }

    public boolean modeIsInDetail() {
        return false;
//        System.out.println("Визначати слова детально (з відмінками, числами та родами) чи текучу форму?");
//        System.out.println("Якщо детально то введіть з клавіатури 'y', інакше введіть 'n'");
//        while (true) {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            try
//            {
//                int ascii = br.read();
//                System.out.println(" Value - "+ascii);
//                if (ascii == 121) {
//                    return true;
//                }
//                if (ascii == 110) {
//                    return false;
//                }
//                System.out.println("спробуйте ввести ще раз!");
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//        }
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
    public String firstXSystemOrthographyOfWord(String word, Language language) {
        switch (language) {
            case UKRAINIAN:
                return new FirstXSystemOrthographyUkrainian().getFirstXSystemOrthographyForm(word);
            case ENGLISH:
                return new FirstXSystemOrthographyEnglish().getFirstXSystemOrthographyForm(word);
            case GERMANY:
                return new FirstXSystemOrthographyGermany().getFirstXSystemOrthographyForm(word);
        }
        return "";
    }

    class FirstXSystemOrthographyUkrainian implements FirstXSystemOrthography

    {
        public String getFirstXSystemOrthographyForm(String word) {
            System.out.println("cx- "+(int)word.toCharArray()[0]);
            word = word.replace(new String(Character.toChars(1044))+new String(Character.toChars(1079)),new String(Character.toChars(68))+new String(Character.toChars(122))); // Дз
            word = word.replace(new String(Character.toChars(1044))+new String(Character.toChars(1078)),new String(Character.toChars(68))+new String(Character.toChars(120))+new String(Character.toChars(103))); // Дж
            word = word.replace(new String(Character.toChars(1040)),new String(Character.toChars(65)));
            word = word.replace(new String(Character.toChars(1041)),new String(Character.toChars(66)));
            word = word.replace(new String(Character.toChars(1042)),new String(Character.toChars(86)));
            word = word.replace(new String(Character.toChars(1043)),new String(Character.toChars(120))+new String(Character.toChars(72)));
            word = word.replace(new String(Character.toChars(1168)),new String(Character.toChars(71)));
            word = word.replace(new String(Character.toChars(1044)),new String(Character.toChars(68)));
            word = word.replace(new String(Character.toChars(1045)),new String(Character.toChars(69)));
            word = word.replace(new String(Character.toChars(1046)),new String(Character.toChars(120))+new String(Character.toChars(90)));
            word = word.replace(new String(Character.toChars(1047)),new String(Character.toChars(90)));
            word = word.replace(new String(Character.toChars(1048)),new String(Character.toChars(89)));
            word = word.replace(new String(Character.toChars(1049)),new String(Character.toChars(74)));
            word = word.replace(new String(Character.toChars(1050)),new String(Character.toChars(75)));
            word = word.replace(new String(Character.toChars(1051)),new String(Character.toChars(76)));
            word = word.replace(new String(Character.toChars(1052)),new String(Character.toChars(77)));
            word = word.replace(new String(Character.toChars(1053)),new String(Character.toChars(78)));
            word = word.replace(new String(Character.toChars(1054)),new String(Character.toChars(79)));
            word = word.replace(new String(Character.toChars(1055)),new String(Character.toChars(80)));
            word = word.replace(new String(Character.toChars(1056)),new String(Character.toChars(82)));
            word = word.replace(new String(Character.toChars(1057)),new String(Character.toChars(83)));
            word = word.replace(new String(Character.toChars(1058)),new String(Character.toChars(84)));
            word = word.replace(new String(Character.toChars(1059)),new String(Character.toChars(85)));
            word = word.replace(new String(Character.toChars(1060)),new String(Character.toChars(70)));
            word = word.replace(new String(Character.toChars(1061)),new String(Character.toChars(72)));
            word = word.replace(new String(Character.toChars(1062)),new String(Character.toChars(67)));
            word = word.replace(new String(Character.toChars(1063)),new String(Character.toChars(120))+new String(Character.toChars(67)));
            word = word.replace(new String(Character.toChars(1064)),new String(Character.toChars(120))+new String(Character.toChars(83)));
            word = word.replace(new String(Character.toChars(1065)),new String(Character.toChars(120))+new String(Character.toChars(83))+new String(Character.toChars(120))+new String(Character.toChars(99)));
            word = word.replace(new String(Character.toChars(1068)),new String(Character.toChars(126)));
            word = word.replace(new String(Character.toChars(1070)),new String(Character.toChars(74))+new String(Character.toChars(117)));
            word = word.replace(new String(Character.toChars(1071)),new String(Character.toChars(74))+new String(Character.toChars(97)));
            word = word.replace(new String(Character.toChars(1028)),new String(Character.toChars(74))+new String(Character.toChars(101)));
            word = word.replace(new String(Character.toChars(1030)),new String(Character.toChars(73)));
            word = word.replace(new String(Character.toChars(1031)),new String(Character.toChars(74))+new String(Character.toChars(105)));
            //
            word = word.replace(new String(Character.toChars(1076))+new String(Character.toChars(1079)),new String(Character.toChars(100))+new String(Character.toChars(122))); // Дз
            word = word.replace(new String(Character.toChars(1076))+new String(Character.toChars(1078)),new String(Character.toChars(100))+new String(Character.toChars(120))+new String(Character.toChars(103))); // Дж
            word = word.replace(new String(Character.toChars(1072)),new String(Character.toChars(97)));
            word = word.replace(new String(Character.toChars(1073)),new String(Character.toChars(98)));
            word = word.replace(new String(Character.toChars(1074)),new String(Character.toChars(118)));
            word = word.replace(new String(Character.toChars(1075)),new String(Character.toChars(120))+new String(Character.toChars(104)));
            word = word.replace(new String(Character.toChars(1169)),new String(Character.toChars(103)));
            word = word.replace(new String(Character.toChars(1076)),new String(Character.toChars(100)));
            word = word.replace(new String(Character.toChars(1077)),new String(Character.toChars(101)));
            word = word.replace(new String(Character.toChars(1078)),new String(Character.toChars(120))+new String(Character.toChars(122)));
            word = word.replace(new String(Character.toChars(1079)),new String(Character.toChars(122)));
            word = word.replace(new String(Character.toChars(1080)),new String(Character.toChars(121)));
            word = word.replace(new String(Character.toChars(1081)),new String(Character.toChars(106)));
            word = word.replace(new String(Character.toChars(1082)),new String(Character.toChars(107)));
            word = word.replace(new String(Character.toChars(1083)),new String(Character.toChars(108)));
            word = word.replace(new String(Character.toChars(1084)),new String(Character.toChars(109)));
            word = word.replace(new String(Character.toChars(1085)),new String(Character.toChars(110)));
            word = word.replace(new String(Character.toChars(1086)),new String(Character.toChars(111)));
            word = word.replace(new String(Character.toChars(1087)),new String(Character.toChars(112)));
            word = word.replace(new String(Character.toChars(1088)),new String(Character.toChars(114)));
            word = word.replace(new String(Character.toChars(1089)),new String(Character.toChars(115)));
            word = word.replace(new String(Character.toChars(1090)),new String(Character.toChars(116)));
            word = word.replace(new String(Character.toChars(1091)),new String(Character.toChars(117)));
            word = word.replace(new String(Character.toChars(1092)),new String(Character.toChars(102)));
            word = word.replace(new String(Character.toChars(1093)),new String(Character.toChars(104)));
            word = word.replace(new String(Character.toChars(1094)),new String(Character.toChars(99)));
            word = word.replace(new String(Character.toChars(1095)),new String(Character.toChars(120))+new String(Character.toChars(99)));
            word = word.replace(new String(Character.toChars(1096)),new String(Character.toChars(120))+new String(Character.toChars(115)));
            word = word.replace(new String(Character.toChars(1097)),new String(Character.toChars(120))+new String(Character.toChars(115))+new String(Character.toChars(120))+new String(Character.toChars(99)));
            word = word.replace(new String(Character.toChars(1100)),new String(Character.toChars(126)));
            word = word.replace(new String(Character.toChars(1102)),new String(Character.toChars(106))+new String(Character.toChars(117)));
            word = word.replace(new String(Character.toChars(1103)),new String(Character.toChars(106))+new String(Character.toChars(97)));
            word = word.replace(new String(Character.toChars(1108)),new String(Character.toChars(106))+new String(Character.toChars(101)));
            word = word.replace(new String(Character.toChars(1110)),new String(Character.toChars(105)));
            word = word.replace(new String(Character.toChars(1111)),new String(Character.toChars(106))+new String(Character.toChars(105)));
            return word;
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
