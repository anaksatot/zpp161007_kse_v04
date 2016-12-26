package pp.linguisticCategories;


import pp.grammaticalCategories.PartOfSpeech;

public abstract class LcNoun extends LinguisticCategory{


	public LcNoun(String formOfWord) {
		super(PartOfSpeech.NOUN, formOfWord);
	}


}
