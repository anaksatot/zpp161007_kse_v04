package pp.linguisticCategories;

/**
 * Created by Admin on 02.12.2016.
 */
public class LcAdverbUkrainian extends LcAdverb{
    private static int accountOfWordsLC;
    public LcAdverbUkrainian(String formOfWord) {
        super(formOfWord);
        ++accountOfWordsLC;
        System.out.println(accountOfWordsLC);
    }

    public static Integer getAccountOfWordsLC() {
        return accountOfWordsLC;
    }

}
