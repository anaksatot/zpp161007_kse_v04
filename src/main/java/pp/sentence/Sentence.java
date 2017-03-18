package pp.sentence;

import pp.textFileProcessing.TextFileDivideIntoWordsSentencesOrOthersPartsServiceImplUkr;
import pp.word.WordUniqueForm;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Admin on 3/17/2017.
 */
@Entity
public class Sentence {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name= "dumka")
    private String dumka;
    @Transient private Set<String> setWords;
    @Transient private Map<WordUniqueForm,Integer> wordsUniqueFormInSentence;

    public Sentence(String stSentence, Map<String, WordUniqueForm> mapWordsOfCurrentText) {
        this.dumka = stSentence;
        List<String> listWordsInSentence = new TextFileDivideIntoWordsSentencesOrOthersPartsServiceImplUkr().readTextFromStringAndDivideOnWordsList(stSentence);
        setWords = new HashSet<String>();
        wordsUniqueFormInSentence = new HashMap<WordUniqueForm, Integer>();
        for (String word:listWordsInSentence) {
            setWords.add(word.toLowerCase());
            if (!wordsUniqueFormInSentence.containsKey(mapWordsOfCurrentText.get(word.toLowerCase()))) {
                wordsUniqueFormInSentence.put(mapWordsOfCurrentText.get(word.toLowerCase()),1);
            } else {
                wordsUniqueFormInSentence.put(mapWordsOfCurrentText.get(word.toLowerCase()), wordsUniqueFormInSentence.get(mapWordsOfCurrentText.get(word.toLowerCase()))+ 1);
            }
        }
        System.out.println("<wordsUniqueFormInSentence");
        for (Map.Entry<WordUniqueForm,Integer> word:wordsUniqueFormInSentence.entrySet()) {
           System.out.println(word.getKey()+" - "+word.getValue());
        }
        System.out.println("setWords "+setWords);
        System.out.println(">wordsUniqueFormInSentence");
    }
}
