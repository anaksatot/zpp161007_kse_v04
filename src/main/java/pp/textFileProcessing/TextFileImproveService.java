package pp.textFileProcessing;

public interface TextFileImproveService {
	public boolean fileExist(String PathToFile);
	public boolean fileIsGoodType(String PathToFile);
	public String fileName(String PathToFile);
}
