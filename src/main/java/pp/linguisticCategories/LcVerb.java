package pp.linguisticCategories;

import pp.grammaticalCategories.PartOfSpeech;

public abstract class LcVerb extends LinguisticCategory{

	public LcVerb() {
		super(PartOfSpeech.VERB);
	}

	public LcVerb(String formOfWord) {
		super(PartOfSpeech.VERB, formOfWord);
	}
}
