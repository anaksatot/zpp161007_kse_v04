package pp.linguisticCategories;

import pp.grammaticalCategories.PartOfSpeech;

/**
 * Created by Admin on 09.12.2016.
 */
public class LcNumeralUkrainian extends LcNumeral {
    private static int accountOfWordsLC;
    public LcNumeralUkrainian(PartOfSpeech linguisticCategoryEnum, String formOfWord) {
        super(linguisticCategoryEnum, formOfWord);
        ++accountOfWordsLC;
    }

    public static Integer getAccountOfWordsLC() {
        return accountOfWordsLC;
    }
}
