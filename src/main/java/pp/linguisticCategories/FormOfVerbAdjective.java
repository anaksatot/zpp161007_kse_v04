package pp.linguisticCategories;

import pp.grammaticalCategories.Gender;
import pp.grammaticalCategories.PerfectOrImperfect;

/**
 * Created by Admin on 30.11.2016.
 */
public class FormOfVerbAdjective {
    private Gender gender;
    Boolean isPlural;
    private PerfectOrImperfect PerfectOrImperfect;

    public FormOfVerbAdjective(Gender gender, Boolean isPlural, PerfectOrImperfect perfectOrImperfect) {
        this.gender = gender;
        this.isPlural = isPlural;
        PerfectOrImperfect = perfectOrImperfect;
    }

    public FormOfVerbAdjective(Boolean isPlural, PerfectOrImperfect perfectOrImperfect) {
        this.isPlural = isPlural;
        PerfectOrImperfect = perfectOrImperfect;
    }

    @Override
    public String toString() {
        return "FormOfVerbAdjective{" +
                "gender=" + gender +
                ", isPlural=" + isPlural +
                ", PerfectOrImperfect=" + PerfectOrImperfect +
                '}';
    }
}
