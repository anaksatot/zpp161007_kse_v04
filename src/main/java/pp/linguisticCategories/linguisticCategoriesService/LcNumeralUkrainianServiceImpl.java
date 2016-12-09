package pp.linguisticCategories.linguisticCategoriesService;

import pp.grammaticalCategories.PARTOFSPEECH;
import pp.linguisticCategories.LcNumeral;
import pp.linguisticCategories.LcNumeralUkrainian;

/**
 * Created by Admin on 09.12.2016.
 */
public class LcNumeralUkrainianServiceImpl {
    public LcNumeral defineLcNumeral(String word) {
        return new LcNumeralUkrainian(PARTOFSPEECH.NUMERAL,word);
    }
}
