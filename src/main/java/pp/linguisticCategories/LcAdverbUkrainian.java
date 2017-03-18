package pp.linguisticCategories;

import pp.xmlFileProcessing.XMLfileReadAndWriteServiceImpl;

/**
 * Created by Admin on 02.12.2016.
 */
public class LcAdverbUkrainian extends LcAdverb{
    private static int accountOfWordsLC;
    static {
        accountOfWordsLC = XMLfileReadAndWriteServiceImpl.readFromXMLStatisticInformation().get("totalAccountOfWordsAdverb");
    }

    public LcAdverbUkrainian(String formOfWord) {
        super(formOfWord);
        ++accountOfWordsLC;
    }

    public static Integer getAccountOfWordsLC() {
        return accountOfWordsLC;
    }

}
