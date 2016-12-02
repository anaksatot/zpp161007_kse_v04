package pp.linguisticCategories;

import java.util.HashMap;

/**
 * Created by Admin on 30.11.2016.
 */
public class FormsOfVerbPersonalConjugation {
    private HashMap<FormOfVerbPersonal, String> formsOfVerbPersonal;

    public FormsOfVerbPersonalConjugation(HashMap<FormOfVerbPersonal, String> formsOfVerbInPersonal) {
        this.formsOfVerbPersonal = formsOfVerbInPersonal;
    }

    public FormsOfVerbPersonalConjugation(FormOfVerbPersonal formOfVerbPersonal, String word) {
        HashMap<FormOfVerbPersonal, String> formOfVerbPersonalHashMap = new HashMap<FormOfVerbPersonal, String>();
        formOfVerbPersonalHashMap.put(formOfVerbPersonal,word);
        this.formsOfVerbPersonal = formOfVerbPersonalHashMap;
    }
}

