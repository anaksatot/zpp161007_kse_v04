package pp.linguisticCategories;

import java.util.HashMap;

/**
 * Created by Admin on 30.11.2016.
 */
public class FormsOfVerbAdjectiveConjugation {
    private HashMap<FormOfVerbAdjective, String> formsOfVerbAdjective;

    public FormsOfVerbAdjectiveConjugation(HashMap<FormOfVerbAdjective, String> formsOfVerbAdjective) {
        this.formsOfVerbAdjective = formsOfVerbAdjective;
    }

    public FormsOfVerbAdjectiveConjugation(FormOfVerbAdjective formOfVerbAdjective, String word) {
        HashMap<FormOfVerbAdjective, String> formOfVerbAdjectiveHashMap = new HashMap<FormOfVerbAdjective, String>();
        formOfVerbAdjectiveHashMap.put(formOfVerbAdjective,word);
        this.formsOfVerbAdjective = formOfVerbAdjectiveHashMap;
    }

    @Override
    public String toString() {
        return "FormsOfVerbAdjectiveConjugation{" +
                "formsOfVerbAdjective=" + formsOfVerbAdjective +
                '}';
    }
}