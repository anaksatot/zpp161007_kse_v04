package pp.textFileProcessing;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface TextFileDivideIntoWordsSentencesOrOthersPartsService {
	List<String>  readTextFromStringAndDivideOnWordsList(String textInOneString);
	List<String>  readTextFromStringAndDivideIntoSentencesList(String textInOneString);
}
