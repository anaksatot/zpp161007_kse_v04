package pp.linguisticCategories;

import jdk.nashorn.internal.objects.NativeRegExp;
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

    public static int getAccountOfWordsLC() {
        return accountOfWordsLC;
    }

}
