package pp.sentence;

import pp.word.WordUniqueForm;

import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 3/17/2017.
 */
public interface SentenceService {
    List<Sentence> parsingTextIntoSentences(String textInOneString, Map<WordUniqueForm,Integer> wordsUniqueForm);
}
