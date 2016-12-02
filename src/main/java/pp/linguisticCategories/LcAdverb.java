package pp.linguisticCategories;

import pp.grammaticalCategories.PARTOFSPEECH;

public abstract class LcAdverb extends LinguisticCategory{
    public LcAdverb(String formOfWord) {
        super(PARTOFSPEECH.ADVERB, formOfWord);
    }
}
