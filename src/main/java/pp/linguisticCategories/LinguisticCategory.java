package pp.linguisticCategories;

import pp.grammaticalCategories.PARTOFSPEECH;

public abstract class LinguisticCategory {
	private PARTOFSPEECH linguisticCategoryEnum;
	private String formOfWord;

	public LinguisticCategory(PARTOFSPEECH linguisticCategoryE) {
		super();
		this.linguisticCategoryEnum = linguisticCategoryE;
	}

	public PARTOFSPEECH getLinguisticCategoryE() {
		return linguisticCategoryEnum;
	}

	public String getFormOfWord() {
		return formOfWord;
	}

	public void setFormOfWord(String formOfWord) {
		this.formOfWord = formOfWord;
	}

	public LinguisticCategory(PARTOFSPEECH linguisticCategoryEnum, String formOfWord) {
		this.linguisticCategoryEnum = linguisticCategoryEnum;
		this.formOfWord = formOfWord;
	}

}
