package pp.word;
import pp.linguisticCategories.Language;

import java.util.List;
import java.util.Map;

public interface WordUniqueFormService {
	String firstXSystemOrthographyOfWord(String word, Language language);
	Map<WordUniqueForm,Integer> parsingTextIntoUniqueWords(List<String> textOfFileDivideOnListWords);
}
