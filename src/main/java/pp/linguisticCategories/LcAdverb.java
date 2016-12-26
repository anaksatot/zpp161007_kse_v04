package pp.linguisticCategories;

import pp.grammaticalCategories.PartOfSpeech;

public abstract class LcAdverb extends LinguisticCategory{
    public LcAdverb(String formOfWord) {
        super(PartOfSpeech.ADVERB, formOfWord);
    }
}
