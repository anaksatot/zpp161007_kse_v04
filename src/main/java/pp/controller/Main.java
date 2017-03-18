package pp.controller;
import pp.databaseProcessing.ManageSentence;
import pp.databaseProcessing.ManageWordUniqueForm;
import pp.linguisticCategories.Language;
import pp.sentence.Sentence;
import pp.sentence.SentenceServiceImplUkrainian;
import pp.textFileProcessing.TextFileDivideIntoWordsSentencesOrOthersPartsServiceImplUkr;
import pp.textFileProcessing.TextFileImproveService;
import pp.textFileProcessing.TextFileImproveServiceImpl;
import pp.textFileProcessing.TextFileReadAndWriteServiceImpl;
import pp.word.WordUniqueForm;
import pp.word.WordUniqueFormUkrainianServiceImpl;
import pp.xmlFileProcessing.XMLfileReadAndWriteServiceImpl;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        XMLfileReadAndWriteServiceImpl.defineSystemParameters();
        String pathToFile = new TextFileReadAndWriteServiceImpl().pathToTXTFile();
        Map<WordUniqueForm,Integer> mapWordsOfCurrentText = null;
        String textInOneString= "";
        TextFileImproveService textFileImprove = new TextFileImproveServiceImpl();
        if (textFileImprove.fileExist(pathToFile) && textFileImprove.fileIsTXT(pathToFile)) {
            textInOneString = new TextFileReadAndWriteServiceImpl().read(pathToFile);
            String thisFileAlreadyTaken = textFileImprove.thisFileAlreadyTaken(textInOneString.length(),textInOneString.substring(0,2));
            if (thisFileAlreadyTaken == "") {
                System.out.println(textInOneString);
                List<String> textOfFileDivideOnListWords = new TextFileDivideIntoWordsSentencesOrOthersPartsServiceImplUkr().readTextFromStringAndDivideOnWordsList(textInOneString);
                mapWordsOfCurrentText = new WordUniqueFormUkrainianServiceImpl().parsingTextIntoUniqueWords(textOfFileDivideOnListWords);
            } else {
                System.out.println("File "+pathToFile+" is already taken and have unique index "+thisFileAlreadyTaken);
            }
       }
        List<Sentence> listSentences = new SentenceServiceImplUkrainian().parsingTextIntoSentences(textInOneString, mapWordsOfCurrentText);
//        ManageWordUniqueForm manageWord = new ManageWordUniqueForm();
//        manageWord.addListWordUniqueForm(mapWordsOfCurrentText.keySet(), Language.UKRAINIAN);
        ManageSentence manageSentence = new ManageSentence();
        for (Sentence sentence:listSentences) {
            manageSentence.addSentence(sentence, Language.UKRAINIAN);
        }

    }
}
