package pp.service;

import pp.entity.LcNoun;

public interface LcNounUkranianService extends LcNounService{

    LcNoun defineLcNoun(String word);

    LcNoun defineLcNounUniqueForm(String word);

}
