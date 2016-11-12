package pp.serviceImpl;

import pp.entity.*;
import pp.service.WordUniqueFormService;

public abstract class WordUniqueFormServiceImpl implements WordUniqueFormService {
	
	public abstract void createOrUpdateJamOvn(String tiloJam);

	public abstract WordUniqueForm createNewJamOvn(String tloJam);

	public abstract void listOfLinguisticCategory();

}
 