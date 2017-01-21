package pp.linguisticCategories;

import pp.grammaticalCategories.PartOfSpeech;

/**
 * Created by Admin on 09.12.2016.
 */
public class LcConjunctionUkrainian extends LcConjunction {
    private static int accountOfWordsLC;
    public LcConjunctionUkrainian(PartOfSpeech linguisticCategoryEnum, String formOfWord) {
        super(linguisticCategoryEnum, formOfWord);
        ++accountOfWordsLC;
    }

    public static Integer getAccountOfWordsLC() {
        return accountOfWordsLC;
    }
}
