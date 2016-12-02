package pp.controller;

import pp.linguisticCategories.LANGUAGE;
import pp.service.TextFileDivideIntoWordsService;
import pp.service.TextFileImproveService;
import pp.service.TextFileReadService;
import pp.serviceImpl.*;

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
            List<String>  textOfFile = textFileServiceImpl.readTextFromStringAndDivideOnWordsList(textInOneString);
            //textOfFile = kseServiceImpl.readTextFromStringAndDivideOnSentencesList(textInOneString);
            //textOfFile = kseServiceImpl.readTextFromStringAndDivideOnSentencesTreeSet(textInOneString);
            System.out.println(textInOneString);
            WordUniqueFormUkrainianServiceImpl wordUniqueFormOvnServiceImpl = new WordUniqueFormUkrainianServiceImpl();
            for (String word : textOfFile) {
                System.out.println(word);
                wordUniqueFormOvnServiceImpl.createOrUpdateWordUniqueForm(word);

            }
        }
    }
}
