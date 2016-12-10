package pp.textFileProcessing;

import org.json.simple.parser.ParseException;

public interface TextFileReadAndWriteService {
	String read(String PathToFile);
	void writeToJSONfile(String stForJSONParser, String formOfWord) throws ParseException;
}
