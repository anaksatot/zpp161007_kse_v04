package pp.entity;

public abstract class LinguisticCategory {
	private LC linguisticCategoryEnum; // part of speach
	private String formOfWord;

	public LinguisticCategory(LC linguisticCategoryE) {
		super();
		this.linguisticCategoryEnum = linguisticCategoryE;
	}

	public LC getLinguisticCategoryE() {
		return linguisticCategoryEnum;
	}

	public String getFormOfWord() {
		return formOfWord;
	}

	public void setFormOfWord(String formOfWord) {
		this.formOfWord = formOfWord;
	}

	public LinguisticCategory(LC linguisticCategoryEnum, String formOfWord) {
		this.linguisticCategoryEnum = linguisticCategoryEnum;
		this.formOfWord = formOfWord;
	}

}
