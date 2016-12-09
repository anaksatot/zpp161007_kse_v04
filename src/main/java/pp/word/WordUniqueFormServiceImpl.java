package pp.word;

import pp.word.WordUniqueFormService;
import pp.word.WordUniqueForm;

public abstract class WordUniqueFormServiceImpl implements WordUniqueFormService {
	
	public abstract void createOrUpdateJamOvn(String tiloJam);

	public abstract WordUniqueForm createNewJamOvn(String tloJam);

	public abstract void listOfLinguisticCategory();

}
 