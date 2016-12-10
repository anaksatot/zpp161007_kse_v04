package pp.controller;

import pp.linguisticCategories.LANGUAGE;
import pp.textFileProcessing.TextFileDivideIntoWordsService;
import pp.textFileProcessing.TextFileImproveService;
import pp.textFileProcessing.TextFileReadAndWriteService;
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
            TextFileReadAndWriteService textFileReadService = new TextFileReadAndWriteServiceImpl();
            String textInOneString = textFileReadService.read(pathToFile);
            TextFileDivideIntoWordsService textFileServiceImpl = new TextFileDivideIntoWordsServiceImpl();
            List<String>  textOfFileDivideOnListWords = textFileServiceImpl.readTextFromStringAndDivideOnWordsList(textInOneString);
            WordUniqueFormUkrainianServiceImpl parsingTextToWordsUniqueForm = new WordUniqueFormUkrainianServiceImpl();
            parsingTextToWordsUniqueForm.parsingTextOfUniqueWords(textOfFileDivideOnListWords);
        }
    }
}
