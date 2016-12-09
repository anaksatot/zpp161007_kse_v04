package pp.textFileProcessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReadServiceImpl implements TextFileReadService {

    public String read(String PathToFile) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader inBR = new BufferedReader(new FileReader(new File(PathToFile)));
            String s;
            while ((s = inBR.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
            inBR.close();

        } catch (IOException e) {
            System.out.println("file not found");
        }
        return sb.toString();
    }

}
