package pp.linguisticCategories.linguisticCategoriesService;

import pp.grammaticalCategories.PartOfSpeech;
import pp.linguisticCategories.LcAdjectiveUkrainian;

/**
 * Created by Admin on 02.12.2016.
 */
public class LcAdjectiveUkrainianServiceImpl implements LcAdjectiveUkrainianService {
    @Override
    public LcAdjectiveUkrainian defineLcAdjective(String word) {
        return new LcAdjectiveUkrainian(PartOfSpeech.ADJECTIVE,word);
    }
}
