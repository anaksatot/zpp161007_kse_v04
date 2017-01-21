package pp.textFileProcessing;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pp.word.WordUniqueForm;

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
            File file=new File(directoryForSaveJSONfilesWordUniqueForm()+formOfWord.toLowerCase()+".json");
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
         return "c:\\Nazar\\json-jamu\\";
        //return "e:\\Develop\\json-jamu\\";
    }

    public String pathToTXTFile(){

        return "c:\\Nazar\\Java\\Hobbit 4.txt";
        //return "e:\\TextForAnalys2.txt";
        //return "e:\\Гобіт.txt";

    }

    public static void serializeWordUniqueForm(WordUniqueForm wordUniqueForm) {

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("e:\\Develop\\ser-jamu\\" + wordUniqueForm.getFormOfWord() + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(wordUniqueForm);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void deserializeWordUniqueForm(String fileName) {
        WordUniqueForm wordUniqueForm =null ;
        try
        {
            FileInputStream fis = new FileInputStream("e:\\Develop\\ser-jamu\\"+fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            wordUniqueForm = (WordUniqueForm)ois.readObject();
            ois.close();
            fis.close();
        }
        catch(ClassNotFoundException nfe)
        {
            nfe.printStackTrace();
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }
        catch (Exception e)
        { e.printStackTrace(); }
        System.out.println("yuhu "+wordUniqueForm.getLanguage()+" "+wordUniqueForm.getFormOfWord()+" "+wordUniqueForm.getLinguisticCategoryForms().getLinguisticCategories().get(0));
    }

}
