package pp.textFileProcessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFileDivideIntoWordsServiceImpl implements TextFileDivideIntoWordsService {

    public List<String> readTextFromStringAndDivideOnWordsList(String textInOneString) {
        return readTextFromStringAndDivideOnWordsArrayList(textInOneString);
}

    private List<String> readTextFromStringAndDivideOnWordsArrayList(String textInOneString) {
        List<String> listOfWords = new ArrayList(Arrays.asList(textInOneString.split(" |\\.|,|:|;|\\?|\"|\\n")));
        Iterator<String> itr = listOfWords.listIterator();
        while (itr.hasNext()) {
            String nextOfWords = itr.next();
            if (nextOfWords.length() == 0 || isNumber(nextOfWords)) {
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
}


