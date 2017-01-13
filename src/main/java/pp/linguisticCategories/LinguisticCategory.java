package pp.linguisticCategories;

import pp.grammaticalCategories.PartOfSpeech;

import java.io.Serializable;

public abstract class LinguisticCategory implements Serializable {
	private PartOfSpeech linguisticCategoryEnum;
	private String formOfWord;

	public LinguisticCategory(PartOfSpeech linguisticCategoryE) {
		super();
		this.linguisticCategoryEnum = linguisticCategoryE;
	}

	public PartOfSpeech getLinguisticCategoryE() {
		return linguisticCategoryEnum;
	}

	public String getFormOfWord() {
		return formOfWord;
	}

	public void setFormOfWord(String formOfWord) {
		this.formOfWord = formOfWord;
	}

	public LinguisticCategory(PartOfSpeech linguisticCategoryEnum, String formOfWord) {
		this.linguisticCategoryEnum = linguisticCategoryEnum;
		this.formOfWord = formOfWord;
	}

}
