package pp.controller;

import pp.linguisticCategories.LANGUAGE;
import pp.textFileProcessing.TextFileImproveService;
import pp.textFileProcessing.TextFileDivideIntoWordsServiceImpl;
import pp.textFileProcessing.TextFileImproveServiceImpl;
import pp.textFileProcessing.TextFileReadAndWriteServiceImpl;
import pp.word.WordUniqueFormUkrainianServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String pathToFile = new TextFileReadAndWriteServiceImpl().pathToTXTFile();
        LANGUAGE language = LANGUAGE.UKRAINIAN;
        TextFileImproveService textFileImprove = new TextFileImproveServiceImpl();
        if (textFileImprove.fileExist(pathToFile) && textFileImprove.fileIsGoodType(pathToFile)) {
            String textInOneString = new TextFileReadAndWriteServiceImpl().read(pathToFile);
            List<String>  textOfFileDivideOnListWords = new TextFileDivideIntoWordsServiceImpl().readTextFromStringAndDivideOnWordsList(textInOneString);
            new WordUniqueFormUkrainianServiceImpl().parsingTextOfUniqueWords(textOfFileDivideOnListWords);
        }
    }
}
