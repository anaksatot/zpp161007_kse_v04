package pp.serviceImpl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JFileChooser;

import pp.service.TextFileImproveService;

public class TextFileImproveServiceImpl implements TextFileImproveService {

	public boolean fileExist(String PathToFile) {
	
// 1
//		try {
//			BufferedReader inBR = new BufferedReader(new FileReader(new File("e:/Hobbit 1.txt")));
//			System.out.println(inBR.readLine());
//		} catch (IOException e) {
//			System.out.println("file not found");
//		}
	
// 2		
//		Path fileToDeletePath = Paths.get("e:/Hobbit 5.txt");
  
// 3		
//		String PathToFile = "e:/Hobbit 5.txt";
//		KseImproveTXTImpl pl = new KseImproveTXTImpl();
//		if (pl.FileExist(PathToFile)) {
//			System.out.println("eno");
//		} else {
//			System.out.println("mieno");
//		}
// 4
//		File file = new File("e:/Hobbit 1.txt");
//		if (file.exists()) {
//			System.out.println("eno2");
//		} else {
//			System.out.println("mieno");
//		}
// 5	
//		boolean isFile = new File("e:/Hobbit 1.txt").isFile();
// 6.
//		try {	
//			FileReader fr = new FileReader(PathToFile); 
//			fr.close();
//			return true;	
//		} catch (IOException e){	
//			System.out.println("mieno");
//			return false;	
//		}	
//	7.	
//		File f = new File(PathToFile);
//		if (f.exists() && !f.isDirectory()) {
//			return true;
//		} else {
//			System.out.println("mieno");
//			return false;
//		}
		boolean isFile = new File(PathToFile).isFile();
		if (isFile) {
			return true;
		} else {
			System.out.println("mieno");
			return false;
		}

	}

	public boolean fileIsGoodType(String PathToFile) {
		if (fileHasSupportedExtention(PathToFile)) {
			if (fileIsTrueType(PathToFile)) {
				return true;
				}
			else {return false;}
			}
		else {return false;}		
	}

	private boolean fileIsTrueType(String pathToFile) {	
		//JFileChooser filechooser = new JFileChooser();/// file !!!!!!!!!!!!
		//File file = new File(pathToFile);
		//System.out.println("the extension type:"+filechooser.getTypeDescription(file));
		return true;
	}

	private boolean fileHasSupportedExtention(String pathToFile) {
		File file = new File(pathToFile);
		String ext = getFileExtension(file);
		if (ext.equals("txt")) {			
			return true;
		} else {
			return false;
		}
	}

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
    
    
    private static String getFileName(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(0,fileName.lastIndexOf("."));
        else return "";
    }

	public String fileName(String pathToFile) {
		File file = new File(pathToFile);
		return getFileName(file);
	}
}