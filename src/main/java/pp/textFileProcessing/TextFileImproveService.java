package pp.textFileProcessing;


public interface TextFileImproveService {
	boolean fileExist(String pathToFile);
	boolean fileIsTXT(String pathToFile);
	boolean fileIsJSON(String pathToFile);
	String thisFileAlreadyTaken(int lengthOfText, String firstHundredSymbols);
}
