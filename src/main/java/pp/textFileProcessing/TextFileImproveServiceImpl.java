package pp.textFileProcessing;

import com.google.common.io.Files;
import java.io.File;


public class TextFileImproveServiceImpl implements TextFileImproveService {

	public boolean fileExist(String pathToFile) {
		if (!new File(pathToFile).isFile()) {
			System.out.println("File not found " + pathToFile);
		}
		return new File(pathToFile).isFile();
	}

	public boolean fileIsTXT(String pathToFile) {
		return Files.getFileExtension(pathToFile).equals("txt");
	}

	public  boolean fileIsJSON(String pathToFile) {
		return Files.getFileExtension(pathToFile).equals("json");
	}
}