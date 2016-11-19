package pp.service;

import pp.entity.LcVerb;

public interface LcVerbUkrainianService extends LcVerbService {

    LcVerb defineLcVerb(String word);

    LcVerb defineLcVerbUniqueForm(String word);

}
