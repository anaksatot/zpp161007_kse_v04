package pp.word;
import pp.word.WordUniqueForm;

public interface WordUniqueFormService {
	void createOrUpdateWordUniqueForm(String wordUnique);
	String firstXSystemOrthographyOfWord(WordUniqueForm wordUniqueForm);
}
