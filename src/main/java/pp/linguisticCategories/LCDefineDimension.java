package pp.linguisticCategories;

import pp.grammaticalCategories.GENDER;
import pp.grammaticalCategories.PERFECTORIMPERFECT;
import pp.grammaticalCategories.PRONOUN;
import pp.grammaticalCategories.TIME;

/**
 * Created by Admin on 30.11.2016.
 */
public  class LCDefineDimension {
    public static GENDER defineGender() {
        return GENDER.MALE;
    }

    public static boolean defineIsPlural() {
        return false;
    }

    public static PERFECTORIMPERFECT definePerfectImperfect(){
        return PERFECTORIMPERFECT.PERFECT;
    }

    public static TIME defineTime() {
        return TIME.PRESENT;
    }

    public static PRONOUN definePerson() {
        return PRONOUN.HE;
    }
}