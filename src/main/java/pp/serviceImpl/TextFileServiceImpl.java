package pp.serviceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TextFileServiceImpl{

	public void readText(String PathToFile) {
		// here we will read text and divide into many parts
		
	}

	public int createUniqueIDText(String PathToFile) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String createUniqueTitleText(String PathToFile) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String read(String PathToFile) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader inBR = new BufferedReader(new FileReader(new File(PathToFile)));
			//System.out.println(inBR.readLine());
			try {
				String s;
				while ((s = inBR.readLine())!=null) {
					sb.append(s);
					sb.append("\n");
				}	
			}
			finally {
				inBR.close();
			}
		} catch (IOException e) {
			System.out.println("file not found");
		}
		return sb.toString();
	}

	public List<String>  readTextAndDivideOnWordsList(String pathToFile) {			
		return readTextAndDivideOnWordsArrayList(pathToFile); // 1. first method ArrayList
		//return readTextAndDivideOnWordsLinkedList(pathToFile); // 2. second method LinkedList		
	}	

	public List<String>  readTextAndDivideOnWordsArrayList(String pathToFile) {
		List<String> listOfWords = new ArrayList(Arrays.asList(read(pathToFile).split(" |\\.|,|:|;|\\?|\"|\\n")));
		System.out.println(listOfWords.toString());
		Iterator<String> itr = listOfWords.listIterator();
		while (itr.hasNext()) {
		       String nextOfWords = itr.next();
		       System.out.println(nextOfWords);
		       if (nextOfWords.length() == 0) { 
		           itr.remove();
		       }
		 }				
		return listOfWords;
	}		
	public List<String>  readTextAndDivideOnWordsLinkedList(String pathToFile) {
		List<String> listOfWords = new LinkedList(Arrays.asList(read(pathToFile).split(" |\\.|,|:|;|\\?|\"|\\n")));
		System.out.println(listOfWords.size());
		//Iterator<String> itr = listOfWords.listIterator();
		Iterator<String> itr = listOfWords.iterator();
		while (itr.hasNext()) {
		       String nextOfWords = itr.next();
		       if (nextOfWords.length() == 0) { 
		           itr.remove();
		       }
		 }				
		return listOfWords;
	}	

	
	public Set<String>  readTextAndDivideOnWordsSet(String pathToFile) {			
		//return readTextAndDivideOnWordsHashSet(pathToFile); // 3. third method HashSet
		//return readTextAndDivideOnWordsTreeSet(pathToFile); // 4. fourth method ArrayList
		return readTextAndDivideOnWordsLinkedHashSet(pathToFile); // 5. fifth method LinkedHashSet
	}	
	
	public Set<String>  readTextAndDivideOnWordsHashSet(String pathToFile) {
		List<String> listOfWords = new ArrayList(Arrays.asList(read(pathToFile).split(" |\\.|,|:|;|\\?|\"|\\n|!")));
		Set<String> setOfWords = new HashSet(listOfWords);
		return setOfWords;
	}	
	
	public Set<String>  readTextAndDivideOnWordsLinkedHashSet(String pathToFile) {
		List<String> listOfWords = new LinkedList(Arrays.asList(read(pathToFile).split(" |\\.|,|:|;|\\?|\"|\\n|!")));
		Set<String> setOfWords = new LinkedHashSet(listOfWords);
		return setOfWords;
	}	
	
	public Set<String>  readTextAndDivideOnWordsTreeSet(String pathToFile) {
		List<String> listOfWords = new ArrayList(Arrays.asList(read(pathToFile).split(" |\\.|,|:|;|\\?|\"|\\n|!")));
		Set<String> setOfWords = new TreeSet(listOfWords);
		return setOfWords;
	}
	
	
	public Map<Integer,String>  readTextAndDivideOnWordsMap(String pathToFile) {			
		return readTextAndDivideOnWordsHashMap(pathToFile); // 6. third method HashMap
		//return readTextAndDivideOnWordsTreeMap(pathToFile); // 7. fourth method TreeMap
		//return readTextAndDivideOnWordsLinkedHashMap(pathToFile); // 8. fifth method LinkedHashMap
	}	
	
	public Map<Integer,String>  readTextAndDivideOnWordsHashMap(String pathToFile) {
		List<String> listOfWords = new ArrayList(Arrays.asList(read(pathToFile).split(" |\\.|,|:|;|\\?|\"|\\n|!")));
		Iterator<String> itr = listOfWords.iterator();
		while (itr.hasNext()) {
		       String nextOfWords = itr.next();
		       if (nextOfWords.length() == 0) { 
		           itr.remove();
		       }
		 }
		HashMap<Integer,String> mapOfWords = new HashMap();
		Integer i =0;
		for (String word : listOfWords) {
			i = i+1;
			mapOfWords.put(i, word);
		}
		return mapOfWords;
	}	
	
	public Map<Integer,String>  readTextAndDivideOnWordsLinkedHashMap(String pathToFile) {
		List<String> listOfWords = new ArrayList(Arrays.asList(read(pathToFile).split(" |\\.|,|:|;|\\?|\"|\\n|!")));
		Iterator<String> itr = listOfWords.iterator();
		while (itr.hasNext()) {
		       String nextOfWords = itr.next();
		       if (nextOfWords.length() == 0) { 
		           itr.remove();
		       }
		 }
		LinkedHashMap<Integer,String> mapOfWords = new LinkedHashMap();
		Integer i =0;
		for (String word : listOfWords) {
			i = i+1;
			mapOfWords.put(i, word);
		}
		return mapOfWords;
	}	
	
	public Map<Integer,String>  readTextAndDivideOnWordsTreeMap(String pathToFile) {
		List<String> listOfWords = new ArrayList(Arrays.asList(read(pathToFile).split(" |\\.|,|:|;|\\?|\"|\\n|!")));
		Iterator<String> itr = listOfWords.iterator();
		while (itr.hasNext()) {
		       String nextOfWords = itr.next();
		       if (nextOfWords.length() == 0) { 
		           itr.remove();
		       }
		 }
		TreeMap<Integer,String> mapOfWords = new TreeMap();
		Integer i =0;
		for (String word : listOfWords) {
			i = i+1;
			mapOfWords.put(i, word);
		}
		return mapOfWords;
	}	
}
