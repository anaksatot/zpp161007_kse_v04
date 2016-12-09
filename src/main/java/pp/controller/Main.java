package pp.controller;

import pp.linguisticCategories.LANGUAGE;
import pp.textFileProcessing.TextFileDivideIntoWordsService;
import pp.textFileProcessing.TextFileImproveService;
import pp.textFileProcessing.TextFileReadService;
import pp.textFileProcessing.TextFileDivideIntoWordsServiceImpl;
import pp.textFileProcessing.TextFileImproveServiceImpl;
import pp.textFileProcessing.TextFileReadServiceImpl;
import pp.word.WordUniqueFormUkrainianServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //String pathToFile = "c:\\Nazar\\Java\\Hobbit 4.txt";
        String pathToFile = "e:\\Hobbit 4.txt";
        LANGUAGE language = LANGUAGE.UKRAINIAN;
        TextFileImproveService textFileImprove = new TextFileImproveServiceImpl();
        if (textFileImprove.fileExist(pathToFile) && textFileImprove.fileIsGoodType(pathToFile)) {

            TextFileReadService textFileReadService = new TextFileReadServiceImpl();

            String textInOneString = textFileReadService.read(pathToFile);
            //textOfFile = kseServiceImpl.readTextFromStringAndDivideOnWordsSet(pathToFile);
            //textOfFile = kseServiceImpl.readTextFromStringAndDivideOnWordsList(pathToFile);
            //textOfFile = kseServiceImpl.readTextFromStringAndDivideOnWordsMap(pathToFile);
            TextFileDivideIntoWordsService textFileServiceImpl = new TextFileDivideIntoWordsServiceImpl();
            List<String>  textOfFileDivideOnListWords = textFileServiceImpl.readTextFromStringAndDivideOnWordsList(textInOneString);
            //textOfFile = kseServiceImpl.readTextFromStringAndDivideOnSentencesList(textInOneString);
            //textOfFile = kseServiceImpl.readTextFromStringAndDivideOnSentencesTreeSet(textInOneString);
            System.out.println(textInOneString);
            WordUniqueFormUkrainianServiceImpl parsingTextToWordsUniqueForm = new WordUniqueFormUkrainianServiceImpl();
            parsingTextToWordsUniqueForm.parsingTextOfUniqueWords(textOfFileDivideOnListWords);
        }
    }
}
