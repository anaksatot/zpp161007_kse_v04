package pp.serviceImpl;

import pp.entity.CASE;
import pp.entity.LcNounUkrainian;
import pp.entity.LinguisticCategory;
import pp.entity.NUMBER;
import pp.service.LCForJSON;

import java.util.HashMap;

public class LCForJSONImpl implements LCForJSON{

    @Override
    public String getStringLCForJsonParser(LinguisticCategory lc) {
        switch (lc.getLinguisticCategoryE()) {
            case NOUN:
                return getStringLCForJsonParserLcNounUkrainian((LcNounUkrainian) lc);
            case VERB:
                return "\""+"verb"+"\""+":"+"\""+"vvvvv"+"\"";
            default:
                System.out.println("Введіть !");
                return "";
        }
}

    public String getStringLCForJsonParserLcNounUkrainian(LcNounUkrainian lcNounUkrainian) {
        String stForJsonParser; int k = 0;
        stForJsonParser = "\""+"LcNounUkrainian"+"\""+":"+"{";
        stForJsonParser = stForJsonParser + "\""+"singularOrPluralForm"+"\""+":"+"{";
        for (HashMap.Entry<NUMBER,String> singularOrPluralForm: lcNounUkrainian.getSingularOrPluralForms().entrySet()) {
            stForJsonParser = stForJsonParser+"\""+singularOrPluralForm.getKey().toString()+"\""+":"+"\""+singularOrPluralForm.getValue()+"\"";
            k = k + 1;
            if (k != lcNounUkrainian.getSingularOrPluralForms().size()) {
                stForJsonParser = stForJsonParser +",";
            }
        }
        stForJsonParser = stForJsonParser+"}";
        k = 0;
        stForJsonParser = stForJsonParser +","+"\"" + "gender"+"\""+":"+"\""+ lcNounUkrainian.getGender().name()+"\""+",";
        stForJsonParser = stForJsonParser + "\""+"casesOfWord"+"\""+":"+"{";
        for (HashMap.Entry<CASE,String> caseOfWord: lcNounUkrainian.getCasesOfWord().entrySet()) {
            stForJsonParser = stForJsonParser+"\""+caseOfWord.getKey().toString()+"\""+":"+"\""+caseOfWord.getValue()+"\"";
            k = k + 1;
            if (k != lcNounUkrainian.getCasesOfWord().size()) {
                stForJsonParser = stForJsonParser +",";
            }
        }
        stForJsonParser = stForJsonParser+"}";
        stForJsonParser = stForJsonParser+"}";
        // System.out.println("lcccc "+stForJsonParser);
        return stForJsonParser;
    }

}


