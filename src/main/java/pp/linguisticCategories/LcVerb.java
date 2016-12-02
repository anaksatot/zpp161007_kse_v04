package pp.linguisticCategories;

import pp.grammaticalCategories.PARTOFSPEECH;

public abstract class LcVerb extends LinguisticCategory{

	public LcVerb() {
		super(PARTOFSPEECH.VERB);
	}

	public LcVerb(String formOfWord) {
		super(PARTOFSPEECH.VERB, formOfWord);
	}
}
