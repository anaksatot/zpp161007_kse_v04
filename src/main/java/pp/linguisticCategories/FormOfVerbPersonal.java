package pp.linguisticCategories;

import pp.grammaticalCategories.PERFECTORIMPERFECT;
import pp.grammaticalCategories.PRONOUN;
import pp.grammaticalCategories.TIME;

/**
 * Created by Admin on 30.11.2016.
 */
public class FormOfVerbPersonal {
    private TIME time;
    private PRONOUN person;
    private PERFECTORIMPERFECT perfectOrImperfect;

    public FormOfVerbPersonal(PERFECTORIMPERFECT perfectOrImperfect, TIME time, PRONOUN person) {
        this.time = time;
        this.person = person;
        this.perfectOrImperfect = perfectOrImperfect;
    }
}
