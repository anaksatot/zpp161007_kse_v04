package pp.linguisticCategories;

import pp.grammaticalCategories.PartOfSpeech;
import pp.xmlFileProcessing.XMLfileReadAndWriteServiceImpl;

/**
 * Created by Admin on 09.12.2016.
 */
public class LcPronounUkrainian extends LcPronoun {
    private static int accountOfWordsLC;
    static {
        accountOfWordsLC = XMLfileReadAndWriteServiceImpl.readFromXMLStatisticInformation().get("totalAccountOfWordsPronoun");
    }

    public LcPronounUkrainian(PartOfSpeech linguisticCategoryEnum, String formOfWord) {
        super(linguisticCategoryEnum, formOfWord);
        ++accountOfWordsLC;
    }

    public static Integer getAccountOfWordsLC() {
        return accountOfWordsLC;
    }
}
