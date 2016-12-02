package pp.linguisticCategories;

import pp.grammaticalCategories.GENDER;
import pp.grammaticalCategories.PERFECTORIMPERFECT;

/**
 * Created by Admin on 30.11.2016.
 */
public class FormOfVerbAdjective {
    private GENDER gender;
    Boolean isPlural;
    private PERFECTORIMPERFECT PerfectOrImperfect;

    public FormOfVerbAdjective(GENDER gender, Boolean isPlural, PERFECTORIMPERFECT perfectOrImperfect) {
        this.gender = gender;
        this.isPlural = isPlural;
        PerfectOrImperfect = perfectOrImperfect;
    }

    public FormOfVerbAdjective(Boolean isPlural, PERFECTORIMPERFECT perfectOrImperfect) {
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
