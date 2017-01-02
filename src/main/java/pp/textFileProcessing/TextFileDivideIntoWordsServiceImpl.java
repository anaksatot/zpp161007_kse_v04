package pp.textFileProcessing;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFileDivideIntoWordsServiceImpl implements TextFileDivideIntoWordsService {

    public List<String> readTextFromStringAndDivideOnWordsList(String textInOneString) {
        return readTextFromStringAndDivideOnWordsArrayList(textInOneString);
}

    private List<String> readTextFromStringAndDivideOnWordsArrayList(String textInOneString) {
        List<String> listOfWords = new ArrayList(Arrays.asList(textInOneString.split(" |\\.|,|:|;|\\?|\"|\\n")));
        ListIterator<String> itr = listOfWords.listIterator();
        while (itr.hasNext()) {
            String nextOfWords = itr.next();
            if (nextOfWords.length() == 0 || isNumber(nextOfWords) || deleteExcessiveGroupOfSymbols(nextOfWords)) {
                itr.remove();
            } else {
                itr.set(nextOfWords.toLowerCase());
            }
        }
        return listOfWords;
    }

    public static boolean isNumber(String word){
        Pattern p = Pattern.compile("\\d|(.+\\d)");
        Matcher m = p.matcher(word);
        return m.matches();
    }

    public static boolean deleteExcessiveGroupOfSymbols(String word) {
        Pattern p = Pattern.compile("--");
        Matcher m = p.matcher(word);
        return m.matches();
    }
}


