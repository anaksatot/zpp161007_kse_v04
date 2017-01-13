package pp.linguisticCategories;
import java.io.Serializable;
import java.util.ArrayList;

public class LinguisticCategoryForms implements Serializable {
	private boolean isUniqueLinguisticCategorie;
	private ArrayList<LinguisticCategory> linguisticCategory;
	public ArrayList<LinguisticCategory> getLinguisticCategories(){
		return this.linguisticCategory;
	}

	public LinguisticCategoryForms(ArrayList<LinguisticCategory> linguisticCategories) {
		this.linguisticCategory = linguisticCategories;
	}

	public boolean isUniqueLinguisticCategorie() {
		return isUniqueLinguisticCategorie;
	}

}
