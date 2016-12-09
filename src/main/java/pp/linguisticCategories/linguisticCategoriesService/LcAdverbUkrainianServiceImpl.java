package pp.linguisticCategories.linguisticCategoriesService;

import pp.linguisticCategories.LcAdverb;
import pp.linguisticCategories.LcAdverbUkrainian;

/**
 * Created by Admin on 02.12.2016.
 */
public class LcAdverbUkrainianServiceImpl implements LcAdverbUkrainianService {

    @Override
    public LcAdverb defineLcAdverb(String word) {
        return  new LcAdverbUkrainian(word);
    }
}
