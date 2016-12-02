package pp.service;

import pp.linguisticCategories.LcNoun;

public interface LcNounUkranianService extends LcNounService{

    LcNoun defineLcNoun(String word);

    LcNoun defineLcNounUniqueForm(String word);

}
