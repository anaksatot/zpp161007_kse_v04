package pp.service;

import pp.linguisticCategories.LcNoun;

public interface LcNounService {

    LcNoun defineLcNoun(String word);

    LcNoun defineLcNounUniqueForm(String word);

}
