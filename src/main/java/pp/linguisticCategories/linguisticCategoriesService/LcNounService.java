package pp.linguisticCategories.linguisticCategoriesService;

import pp.linguisticCategories.LcNoun;

public interface LcNounService {

    LcNoun defineLcNoun(String word);

    LcNoun defineLcNounUniqueForm(String word, boolean inDetail);

}
