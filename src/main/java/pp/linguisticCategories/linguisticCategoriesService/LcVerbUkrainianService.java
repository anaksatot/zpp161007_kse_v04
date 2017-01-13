package pp.linguisticCategories.linguisticCategoriesService;

import pp.linguisticCategories.LcVerb;

public interface LcVerbUkrainianService extends LcVerbService {

    LcVerb defineLcVerb(String word, boolean onlyThisForm, boolean inDetail);

    LcVerb defineLcVerbUniqueForm(String word, boolean inDetail);

}
