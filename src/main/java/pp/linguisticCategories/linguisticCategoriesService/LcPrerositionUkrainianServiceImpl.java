package pp.linguisticCategories.linguisticCategoriesService;

import pp.grammaticalCategories.PARTOFSPEECH;
import pp.linguisticCategories.LcPreposition;
import pp.linguisticCategories.LcPrepositionUkrainian;

/**
 * Created by Admin on 09.12.2016.
 */
public class LcPrerositionUkrainianServiceImpl {
    public LcPreposition defineLcPrerosition(String word) {
        return  new LcPrepositionUkrainian(PARTOFSPEECH.PREPOSITION,word);
    }
}
