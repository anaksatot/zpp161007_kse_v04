package pp.service;

import pp.entity.LcNoun;

public interface LcNounUkranianService {

    LcNoun defineLcNoun(String word);

    LcNoun defineLcNounUniqueForm(String word);

}
