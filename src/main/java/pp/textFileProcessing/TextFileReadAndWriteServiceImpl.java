package pp.textFileProcessing;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class TextFileReadAndWriteServiceImpl implements TextFileReadAndWriteService {

    public String read(String PathToFile) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader inBR = new BufferedReader(new FileReader(new File(PathToFile)))) {
            String s;
            while ((s = inBR.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } catch (IOException e) {
            System.out.println("file not readable");
            return "";
        }
        return sb.toString();
    }

    public void writeToJSONfile(String stForJSONParser, String formOfWord) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject WordUniqueFormJSONObj = (JSONObject) parser.parse(stForJSONParser);
        try {
            File file=new File(directoryForSaveJSONfilesWordUniqueForm()+formOfWord+".json");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            System.out.println("Writing JSON object to file "+file.getCanonicalPath());
            System.out.print(WordUniqueFormJSONObj);
            fileWriter.write(WordUniqueFormJSONObj.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public String directoryForSaveJSONfilesWordUniqueForm(){
        // return "c:\\Nazar\\json-jamu\\";
        return "e:\\Develop\\json-jamu\\";
    }

    public String pathToTXTFile(){

        //return "c:\\Nazar\\Java\\Hobbit 4.txt";
        return "e:\\TextForAnalys2.txt";
        //return "e:\\Гобіт.txt";

    }
}
