package pp.serviceImpl;

import pp.linguisticCategories.LcAdverb;
import pp.linguisticCategories.LcAdverbUkrainian;
import pp.service.LcAdverbUkrainianService;

/**
 * Created by Admin on 02.12.2016.
 */
public class LcAdverbUkrainianServiceImpl implements LcAdverbUkrainianService {

    @Override
    public LcAdverb defineLcAdverb(String word) {
        return  new LcAdverbUkrainian(word);
    }
}
