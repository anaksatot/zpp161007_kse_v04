package pp.linguisticCategories.linguisticCategoriesService;

import pp.linguisticCategories.*;
import pp.grammaticalCategories.Case;
import pp.grammaticalCategories.Number;

import java.util.HashMap;

public class LCForJSONImpl implements LCForJSON {

    @Override
    public String getStringLCForJsonParser(LinguisticCategory lc) {
        switch (lc.getLinguisticCategoryE()) {
            case NOUN:
                return getStringLCForJsonParserLcNounUkrainian((LcNounUkrainian) lc);
            case VERB:
                return getStringLCForJsonParserLcVerbUkrainian((LcVerbUkrainian) lc);
            case ADVERB:
                return getStringLCForJsonParserLcAdverbUkrainian((LcAdverbUkrainian) lc);
            case ADJECTIVE:
                return getStringLCForJsonParserLcAdjectiveUkrainian((LcAdjectiveUkrainian) lc);
            case PRONOUN:
                return getStringLCForJsonParserLcPronounUkrainian((LcPronounUkrainian) lc);
            case PREPOSITION:
                return getStringLCForJsonParserLcPrepositionUkrainian((LcPrepositionUkrainian) lc);
            case CONJUNCTION:
                return getStringLCForJsonParserLcConjunctionUkrainian((LcConjunctionUkrainian) lc);
            case NUMERAL:
                return getStringLCForJsonParserLcNumeralUkrainian((LcNumeralUkrainian) lc);
            default:
                System.out.println("Введіть коректну позицію частини мови!");
                return "";
        }
    }

    public String getStringLCForJsonParserLcNounUkrainianFull(LcNounUkrainian lcNounUkrainian) {
        String stForJsonParser;
        int k = 0;
        stForJsonParser = "\"" + "LcNounUkrainian" + "\"" + ":" + "{";
        stForJsonParser = stForJsonParser + "\"" + "singularOrPluralForm" + "\"" + ":" + "{";
        for (HashMap.Entry<Number, String> singularOrPluralForm : lcNounUkrainian.getSingularOrPluralForms().entrySet()) {
            stForJsonParser = stForJsonParser + "\"" + singularOrPluralForm.getKey().toString() + "\"" + ":" + "\"" + singularOrPluralForm.getValue() + "\"";
            k = k + 1;
            if (k != lcNounUkrainian.getSingularOrPluralForms().size()) {
                stForJsonParser = stForJsonParser + ",";
            }
        }
        stForJsonParser = stForJsonParser + "}";
        k = 0;
        stForJsonParser = stForJsonParser + "," + "\"" + "gender" + "\"" + ":" + "\"" + lcNounUkrainian.getGender().name() + "\"" + ",";
        stForJsonParser = stForJsonParser + "\"" + "casesOfWord" + "\"" + ":" + "{";
        for (HashMap.Entry<Case, String> caseOfWord : lcNounUkrainian.getCasesOfWord().entrySet()) {
            stForJsonParser = stForJsonParser + "\"" + caseOfWord.getKey().toString() + "\"" + ":" + "\"" + caseOfWord.getValue() + "\"";
            k = k + 1;
            if (k != lcNounUkrainian.getCasesOfWord().size()) {
                stForJsonParser = stForJsonParser + ",";
            }
        }
        stForJsonParser = stForJsonParser + "}";
        stForJsonParser = stForJsonParser + "}";
        return stForJsonParser;
    }

    public String getStringLCForJsonParserLcNounUkrainian(LcNounUkrainian lcNounUkrainian) {
        String stForJsonParser;
        stForJsonParser = "\"" + "LcNounUkrainian" + "\"" + ":" + "{";
        // here will be code for define all cases
        stForJsonParser = stForJsonParser + "}";
        return stForJsonParser;
    }

    public String getStringLCForJsonParserLcVerbUkrainian(LcVerbUkrainian lcVerbUkrainian) {
        String stForJsonParser;
        stForJsonParser = "\"" + "LcVerbUkrainian" + "\"" + ":" + "{";
        // here will be code for define all cases
        stForJsonParser = stForJsonParser + "}";
        return stForJsonParser;
    }

    public String getStringLCForJsonParserLcAdverbUkrainian(LcAdverbUkrainian lcAdverbUkrainian) {
        String stForJsonParser;
        stForJsonParser = "\"" + "LcAdverbUkrainian" + "\"" + ":" + "{";
        // here will be code for define all cases
        stForJsonParser = stForJsonParser + "}";
        return stForJsonParser;
    }

    public String getStringLCForJsonParserLcAdjectiveUkrainian(LcAdjectiveUkrainian lcAdjectiveUkrainian) {
        String stForJsonParser;
        stForJsonParser = "\"" + "LcAdjectiveUkrainian" + "\"" + ":" + "{";
        // here will be code for define all cases
        stForJsonParser = stForJsonParser + "}";
        return stForJsonParser;
    }

    public String getStringLCForJsonParserLcPronounUkrainian(LcPronounUkrainian lcPronounUkrainian) {
        String stForJsonParser;
        stForJsonParser = "\"" + "LcPronounUkrainian" + "\"" + ":" + "{";
        // here will be code for define all cases
        stForJsonParser = stForJsonParser + "}";
        return stForJsonParser;
    }

    public String getStringLCForJsonParserLcPrepositionUkrainian(LcPrepositionUkrainian lcPrepositionUkrainian) {
        String stForJsonParser;
        stForJsonParser = "\"" + "LcPrepositionUkrainian" + "\"" + ":" + "{";
        // here will be code for define all cases
        stForJsonParser = stForJsonParser + "}";
        return stForJsonParser;
    }

    public String getStringLCForJsonParserLcConjunctionUkrainian(LcConjunctionUkrainian lcConjunctionUkrainian) {
        String stForJsonParser;
        stForJsonParser = "\"" + "LcConjunctionUkrainian" + "\"" + ":" + "{";
        // here will be code for define all cases
        stForJsonParser = stForJsonParser + "}";
        return stForJsonParser;
    }

    public String getStringLCForJsonParserLcNumeralUkrainian(LcNumeralUkrainian lcNumeralUkrainian) {
        String stForJsonParser;
        stForJsonParser = "\"" + "LcNumeralUkrainian" + "\"" + ":" + "{";
        // here will be code for define all cases
        stForJsonParser = stForJsonParser + "}";
        return stForJsonParser;
    }

}


