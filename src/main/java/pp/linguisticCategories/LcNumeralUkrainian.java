package pp.linguisticCategories;

import pp.grammaticalCategories.PartOfSpeech;
import pp.xmlFileProcessing.XMLfileReadAndWriteServiceImpl;

/**
 * Created by Admin on 09.12.2016.
 */
public class LcNumeralUkrainian extends LcNumeral {
    private static int accountOfWordsLC;
    public int q;
    static {
        accountOfWordsLC = XMLfileReadAndWriteServiceImpl.readFromXMLStatisticInformation().get("totalAccountOfWordsNumeral");
    }

    public LcNumeralUkrainian(PartOfSpeech linguisticCategoryEnum, String formOfWord) {
        super(linguisticCategoryEnum, formOfWord);
        ++accountOfWordsLC;
    }

    public static Integer getAccountOfWordsLC() {
        return accountOfWordsLC;
    }
}
