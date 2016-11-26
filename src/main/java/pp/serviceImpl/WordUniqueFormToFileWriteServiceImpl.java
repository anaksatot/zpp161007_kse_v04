package pp.serviceImpl;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WordUniqueFormToFileWriteServiceImpl{

	public void writeToJSONfile(String stForJSONParser, String formOfWord) throws ParseException {
		System.out.println(stForJSONParser);
		JSONParser parser = new JSONParser();
		JSONObject WordUniqueFormJSONObj = (JSONObject) parser.parse(stForJSONParser);

    try {
        // Writing to a file
        //
//		File file=new File("c:\\Nazar\\json-jamu\\"+formOfWord+".json");
        File file=new File("e:\\Develop\\json-jamu\\"+formOfWord+".json");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        System.out.println("Writing JSON object to file");
        System.out.println("-----------------------");
        System.out.print(WordUniqueFormJSONObj);
        fileWriter.write(WordUniqueFormJSONObj.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    } catch (IOException e)
    {
        e.printStackTrace();
    }
	}


}
