package pp.serviceImpl;

import pp.entity.LcVerb;
import pp.entity.LcVerbUkrainian;
import pp.service.LcVerbUkrainianService;

public class LcVerbUkrainianServiceImpl implements LcVerbUkrainianService{

    @Override
    public LcVerb defineLcVerb(String word) {
        return null;
    }

    @Override
    public LcVerb defineLcVerbUniqueForm(String word) {
        LcVerbUkrainian lcVerbUkrainian = new LcVerbUkrainian(word);
//        lcVerbUkrainian.setSingularOrPluralForms(defineSingularAndPluralFormsForUniqueForm(lcVerbUkrainian));
//        lcVerbUkrainian.setGender(defineGender());
//        lcVerbUkrainian.setCasesOfWord(defineCasesOfNounForUniqueForm(lcVerbUkrainian,defineListOfCasesOfNoun()));
        return lcVerbUkrainian;
    }
}
