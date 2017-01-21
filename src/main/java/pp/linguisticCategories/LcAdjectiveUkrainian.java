package pp.linguisticCategories;

import pp.grammaticalCategories.PartOfSpeech;

/**
 * Created by Admin on 02.12.2016.
 */
public class LcAdjectiveUkrainian extends LcAdjective {
    private static int accountOfWordsLC;
    public LcAdjectiveUkrainian(PartOfSpeech linguisticCategoryEnum, String formOfWord) {
        super(linguisticCategoryEnum, formOfWord);
        ++accountOfWordsLC;
        System.out.println(accountOfWordsLC);
    }

    public static Integer getAccountOfWordsLC() {
        return accountOfWordsLC;
    }

}
