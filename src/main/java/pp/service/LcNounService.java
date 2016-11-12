package pp.service;

import pp.entity.CASE;
import pp.entity.LcNoun;

import java.util.ArrayList;

public interface LcNounService {

    LcNoun defineLcNoun(String word);

    LcNoun defineLcNounUniqueForm(String word);

}
