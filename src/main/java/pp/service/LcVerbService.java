package pp.service;

import pp.entity.LcVerb;

public interface LcVerbService {
    LcVerb defineLcVerb(String word);

    LcVerb defineLcVerbUniqueForm(String word);
}
