package pp.service;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface TextFileDivideIntoWordsService {
	public List<String>  readTextFromStringAndDivideOnWordsList(String textInOneString);
	public Set<String>  readTextFromStringAndDivideOnWordsSet(String textInOneString);
	public Map<Integer,String>  readTextFromStringAndDivideOnWordsMap(String textInOneString);
}
