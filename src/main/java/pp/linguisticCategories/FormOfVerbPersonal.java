package pp.linguisticCategories;

import pp.grammaticalCategories.PerfectOrImperfect;
import pp.grammaticalCategories.Pronoun;
import pp.grammaticalCategories.Time;

/**
 * Created by Admin on 30.11.2016.
 */
public class FormOfVerbPersonal {
    private Time time;
    private Pronoun person;
    private PerfectOrImperfect perfectOrImperfect;

    public FormOfVerbPersonal(PerfectOrImperfect perfectOrImperfect, Time time, Pronoun person) {
        this.time = time;
        this.person = person;
        this.perfectOrImperfect = perfectOrImperfect;
    }
}
