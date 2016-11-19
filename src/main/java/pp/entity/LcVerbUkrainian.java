package pp.entity;

import java.util.HashMap;

public class LcVerbUkrainian extends LcVerb {
    private String infinitiveForm;
    private String impersonalForm;
    private String adverbForm;

    private HashMap<GENDER, String> adjectiveSingularForms;
    private String adjectivePluralForm;
    private HashMap<CASE, String> pastPerfectCasesByPerson;
    private HashMap<CASE, String> pastImPerfectCasesByPerson;
    private HashMap<CASE, String> presentPerfectCasesByPerson;
    private HashMap<CASE, String> futurePerfectCasesByPerson;
    private HashMap<CASE, String> futureImPerfectCasesByPerson;

    public LcVerbUkrainian(String formOfWord) {
        super(formOfWord);
    }
}
