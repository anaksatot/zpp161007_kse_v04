package pp.textFileProcessing;

import java.util.List;
import java.util.Set;

public interface TextFileDivideIntoSentencesService {
	public List<String>  readTextFromStringAndDivideOnSentencesArrayList(String textInOneString);	
	public Set<String>  readTextFromStringAndDivideOnSentencesTreeSet(String textInOneString);
}
