package pp.linguisticCategories;

import pp.grammaticalCategories.PartOfSpeech;
import pp.xmlFileProcessing.XMLfileReadAndWriteServiceImpl;

/**
 * Created by Admin on 02.12.2016.
 */
public class LcAdjectiveUkrainian extends LcAdjective {
    private static int accountOfWordsLC;
    static {
        accountOfWordsLC = XMLfileReadAndWriteServiceImpl.readFromXMLStatisticInformation().get("totalAccountOfWordsAdjective");
    }

    public LcAdjectiveUkrainian(PartOfSpeech linguisticCategoryEnum, String formOfWord) {
        super(linguisticCategoryEnum, formOfWord);
        ++accountOfWordsLC;
    }

    public static Integer getAccountOfWordsLC() {
        return accountOfWordsLC;
    }

}
