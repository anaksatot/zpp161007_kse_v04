package pp.linguisticCategories.linguisticCategoriesService;

import pp.grammaticalCategories.PARTOFSPEECH;
import pp.linguisticCategories.LcConjunction;
import pp.linguisticCategories.LcConjunctionUkrainian;

/**
 * Created by Admin on 09.12.2016.
 */
public class LcConjunctionUkrainianServiceImpl {
    public LcConjunction defineLcConjunction(String word) {
        return new LcConjunctionUkrainian(PARTOFSPEECH.CONJUNCTION,word);
    }
}
