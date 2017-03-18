package pp.linguisticCategories;

import pp.grammaticalCategories.PartOfSpeech;
import pp.xmlFileProcessing.XMLfileReadAndWriteServiceImpl;

/**
 * Created by Admin on 09.12.2016.
 */
public class LcConjunctionUkrainian extends LcConjunction {
    private static int accountOfWordsLC;
    static {
        accountOfWordsLC = XMLfileReadAndWriteServiceImpl.readFromXMLStatisticInformation().get("totalAccountOfWordsConjunction");
    }

    public LcConjunctionUkrainian(PartOfSpeech linguisticCategoryEnum, String formOfWord) {
        super(linguisticCategoryEnum, formOfWord);
        ++accountOfWordsLC;
    }

    public static Integer getAccountOfWordsLC() {
        return accountOfWordsLC;
    }
}
