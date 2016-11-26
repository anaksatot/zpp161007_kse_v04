package pp.service;
import pp.entity.*;

public interface WordUniqueFormService {
	void createOrUpdateWordUniqueForm(String wordUnique);
	String firstXSystemOrthographyOfWord(WordUniqueForm wordUniqueForm);
}
