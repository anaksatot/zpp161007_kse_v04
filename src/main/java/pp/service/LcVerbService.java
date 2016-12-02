package pp.service;

import pp.linguisticCategories.LcVerb;

public interface LcVerbService {
    LcVerb defineLcVerb(String word, boolean onlyThisForm);

    LcVerb defineLcVerbUniqueForm(String word);
}
