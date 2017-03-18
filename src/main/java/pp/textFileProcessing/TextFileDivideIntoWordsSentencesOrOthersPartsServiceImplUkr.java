package pp.textFileProcessing;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFileDivideIntoWordsSentencesOrOthersPartsServiceImplUkr implements TextFileDivideIntoWordsSentencesOrOthersPartsService {

    public List<String> readTextFromStringAndDivideOnWordsList(String textInOneString) {
        return readTextFromStringAndDivideOnWordsArrayList(textInOneString);
}

    @Override
    public List<String> readTextFromStringAndDivideIntoSentencesList(String textInOneString) {
        if (textInOneString.substring(0,1).toCharArray()[0]==65279) { // 65279 is BOM character in txt file
            textInOneString = textInOneString.replace(new String(Character.toChars(65279)),"");
        }
        System.out.println(textInOneString);
        List<String> listOfSentences = new ArrayList(Arrays.asList(textInOneString.split("\\.|\\.\\.\\.|\\?|\\!")));
        ListIterator<String> itr = listOfSentences.listIterator();
        while (itr.hasNext()) {
            String nextOfSentence = itr.next();
            System.out.println(">> "+nextOfSentence.trim());
            if (nextOfSentence.length() == 0) {
                itr.remove();
            }
        }
        return listOfSentences;
    }

    private List<String> readTextFromStringAndDivideOnWordsArrayList(String textInOneString) {
        if (textInOneString.substring(0,1).toCharArray()[0]==65279) { // 65279 is BOM character in txt file
            textInOneString = textInOneString.replace(new String(Character.toChars(65279)),"");
        }
        textInOneString = textInOneString.replace("("," ");
        textInOneString = textInOneString.replace(")"," ");
        textInOneString = textInOneString.replace("\""," ");
        textInOneString = textInOneString.replace("*"," ");
        textInOneString = textInOneString.replace(new String(Character.toChars(8220))," ");
        textInOneString = textInOneString.replace(new String(Character.toChars(8221))," ");
        List<String> listOfWords = new ArrayList(Arrays.asList(textInOneString.split(" |\\.|,|:|;|\\?|\\!|\"|\\n")));
        System.out.println(textInOneString);
        ListIterator<String> itr = listOfWords.listIterator();
        while (itr.hasNext()) {
            String nextOfWords = itr.next();
            if (nextOfWords.length() == 0 || isNumber(nextOfWords) || isSetOfUnderLine(nextOfWords) || isSetOfHyphens(nextOfWords)) {
                itr.remove();
            }
        }
        return listOfWords;
    }

    public static boolean isNumber(String word){
        Pattern p = Pattern.compile("\\d|(.+\\d)");
        Matcher m = p.matcher(word);
        return m.matches();
    }

    public static boolean isSetOfHyphens(String word){
        Pattern p = Pattern.compile("[-]+");
        Matcher m = p.matcher(word);
        return m.matches();
    }

    public static boolean isSetOfUnderLine(String word) {
        Pattern p = Pattern.compile("[_]+");
        Matcher m = p.matcher(word);
        return m.matches();
    }
}


