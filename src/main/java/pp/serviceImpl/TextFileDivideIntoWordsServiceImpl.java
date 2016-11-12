package pp.serviceImpl;

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

import pp.service.TextFileDivideIntoWordsService;

public class TextFileDivideIntoWordsServiceImpl implements TextFileDivideIntoWordsService {
    public List<String> readTextFromStringAndDivideOnWordsList(String textInOneString) {
        return readTextFromStringAndDivideOnWordsArrayList(textInOneString); // 1. first method ArrayList
    //return readTextFromStringAndDivideOnWordsLinkedList(textInOneString); // 2. second method LinkedList
}

    private List<String> readTextFromStringAndDivideOnWordsArrayList(String textInOneString) {
        List<String> listOfWords = new ArrayList(Arrays.asList(textInOneString.split(" |\\.|,|:|;|\\?|\"|\\n")));
        System.out.println(listOfWords.size());
        Iterator<String> itr = listOfWords.listIterator();
        while (itr.hasNext()) {
            String nextOfWords = itr.next();
            if (nextOfWords.length() == 0) {
                itr.remove();
            }
        }
        return listOfWords;
    }

    private List<String> readTextFromStringAndDivideOnWordsLinkedList(String textInOneString) {
        List<String> listOfWords = new LinkedList(Arrays.asList(textInOneString.split(" |\\.|,|:|;|\\?|\"|\\n")));
        System.out.println(listOfWords.size());
        //Iterator<String> itr = listOfWords.listIterator();
        Iterator<String> itr = listOfWords.iterator();
        while (itr.hasNext()) {
            String nextOfWords = itr.next();
            if (nextOfWords.length() == 0) {
                itr.remove();
            }
        }
        return listOfWords;
    }


    public Set<String> readTextFromStringAndDivideOnWordsSet(String textInOneString) {
        //return readTextAndDivideOnWordsHashSet(pathToFile); // 3. third method HashSet
        //return readTextAndDivideOnWordsTreeSet(pathToFile); // 4. fourth method ArrayList
        return readTextFromStringAndDivideOnWordsLinkedHashSet(textInOneString); // 5. fifth method LinkedHashSet
    }

    private Set<String> readTextFromStringAndDivideOnWordsHashSet(String textInOneString) {
        List<String> listOfWords = new ArrayList(Arrays.asList(textInOneString.split(" |\\.|,|:|;|\\?|\"|\\n|!")));
        Set<String> setOfWords = new HashSet(listOfWords);
        return setOfWords;
    }

    private Set<String> readTextFromStringAndDivideOnWordsLinkedHashSet(String textInOneString) {
        List<String> listOfWords = new LinkedList(Arrays.asList(textInOneString.split(" |\\.|,|:|;|\\?|\"|\\n|!")));
        Set<String> setOfWords = new LinkedHashSet(listOfWords);
        return setOfWords;
    }

    private Set<String> readTextFromStringAndDivideOnWordsTreeSet(String textInOneString) {
        List<String> listOfWords = new ArrayList(Arrays.asList(textInOneString.split(" |\\.|,|:|;|\\?|\"|\\n|!")));
        Set<String> setOfWords = new TreeSet(listOfWords);
        return setOfWords;
    }


    public Map<Integer, String> readTextFromStringAndDivideOnWordsMap(String textInOneString) {
        return readTextFromStringAndDivideOnWordsHashMap(textInOneString); // 6. third method HashMap
        //return readTextAndDivideOnWordsTreeMap(pathToFile); // 7. fourth method TreeMap
        //return readTextAndDivideOnWordsLinkedHashMap(pathToFile); // 8. fifth method LinkedHashMap
    }

    private Map<Integer, String> readTextFromStringAndDivideOnWordsHashMap(String textInOneString) {
        List<String> listOfWords = new ArrayList(Arrays.asList(textInOneString.split(" |\\.|,|:|;|\\?|\"|\\n|!")));
        Iterator<String> itr = listOfWords.iterator();
        while (itr.hasNext()) {
            String nextOfWords = itr.next();
            if (nextOfWords.length() == 0) {
                itr.remove();
            }
        }
        HashMap<Integer, String> mapOfWords = new HashMap();
        Integer i = 0;
        for (String word : listOfWords) {
            i = i + 1;
            mapOfWords.put(i, word);
        }
        return mapOfWords;
    }

    private Map<Integer, String> readTextFromStringAndDivideOnWordsLinkedHashMap(String textInOneString) {
        List<String> listOfWords = new ArrayList(Arrays.asList(textInOneString.split(" |\\.|,|:|;|\\?|\"|\\n|!")));
        Iterator<String> itr = listOfWords.iterator();
        while (itr.hasNext()) {
            String nextOfWords = itr.next();
            if (nextOfWords.length() == 0) {
                itr.remove();
            }
        }
        LinkedHashMap<Integer, String> mapOfWords = new LinkedHashMap();
        Integer i = 0;
        for (String word : listOfWords) {
            i = i + 1;
            mapOfWords.put(i, word);
        }
        return mapOfWords;
    }

    private Map<Integer, String> readTextFromStringAndDivideOnWordsTreeMap(String textInOneString) {
        List<String> listOfWords = new ArrayList(Arrays.asList(textInOneString.split(" |\\.|,|:|;|\\?|\"|\\n|!")));
        Iterator<String> itr = listOfWords.iterator();
        while (itr.hasNext()) {
            String nextOfWords = itr.next();
            if (nextOfWords.length() == 0) {
                itr.remove();
            }
        }
        TreeMap<Integer, String> mapOfWords = new TreeMap();
        Integer i = 0;
        for (String word : listOfWords) {
            i = i + 1;
            mapOfWords.put(i, word);
        }
        return mapOfWords;
    }

    private List<String> readTextFromStringAndDivideOnSentencesArrayList(String textInOneString) {
        List<String> listOfSentences = new ArrayList(Arrays.asList(textInOneString.split("\\.|\\?|!")));
        System.out.println(listOfSentences.size());
        return listOfSentences;
    }

    private Set<String> readTextFromStringAndDivideOnSentencesTreeSet(String textInOneString) {
        List<String> listOfSentences = new ArrayList(Arrays.asList(textInOneString.split("\\.|\\?|\\...")));
        Set<String> setOfSentences = new TreeSet(listOfSentences);
        return setOfSentences;
    }

    public List<String> readTextFromStringAndDivideOnSentencesList(String textInOneString) {
        //return readTextAndDivideOnSentencesLinkedList(textInOneString); // 3. third method HashSet
        return readTextFromStringAndDivideOnSentencesArrayList(textInOneString); // 4. fourth method ArrayList
    }

    public Set<String> readTextFromStringAndDivideOnSentencesSet(String textInOneString) {
        //return readTextAndDivideOnSentencesHashSet(textInOneString); // 3. third method HashSet
        return readTextFromStringAndDivideOnSentencesTreeSet(textInOneString); // 4. fourth method ArrayList
        //return readTextAndDivideOnSentencesLinkedHashSet(textInOneString); // 5. fifth method LinkedHashSet
    }

}


