package pp.serviceImpl;

import pp.linguisticCategories.LcVerb;
import pp.linguisticCategories.LcVerbUkrainian;
import pp.service.LcVerbUkrainianService;

import java.util.ArrayList;
import java.util.Scanner;

public class LcVerbUkrainianServiceImpl implements LcVerbUkrainianService{

    @Override
    public LcVerb defineLcVerb(String word, boolean onlyThisForm) {
        if (onlyThisForm) {
            return defineLcVerbUniqueForm(word);
        }
        return null;
    }

    @Override
    public LcVerb defineLcVerbUniqueForm(String word) {

        LcVerbUkrainian lcVerbUkrainian = new LcVerbUkrainian(word);
        Scanner scanner = new Scanner(System.in);
        outListOfTypicalFormsOfVerb();
        //System.out.println("Введіть до скількох типових форм належить ця форма дієслова");
        //int q = scanner.nextInt();
        int q =1; // for another languiges it can be more forms
        for (int i=0;i<q;i++){
            System.out.println("введіть номер форми дієслова:");
            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    lcVerbUkrainian.setFormOfVerbInfinitive(defineInfinitiveLcVerbForm(word));
                    break;
                case 2:
                    lcVerbUkrainian.setFormOfVerbPersonal(new FormsOfVerbPersonalConjugationServiceImpl().definePersonalForms(word, true));
                    break;
                case 3:
                    lcVerbUkrainian.setFormOfVerbImpersonal(defineImpersonLcVerbForm(word));
                    break;
                case 4:
                    lcVerbUkrainian.setFormOfVerbAdverb(defineAdverbLcVerbForm(word));
                    break;
                case 5:
                    lcVerbUkrainian.setFormOfVerbAdjective(new FormsOfVerbAdjectiveConjugationServiceImpl().defineAdjectiveForms(word,true));
                    break;
                default:
                    System.out.println("невдалий номер позиції. спробуте ще раз");
            }
        }
        System.out.println(lcVerbUkrainian);
        return lcVerbUkrainian;
    }

    private String defineInfinitiveLcVerbForm(String word){
        return word;
    }

    private String defineImpersonLcVerbForm(String word){
        return word;
    }

    private String defineAdverbLcVerbForm(String word){
        return word;
    }

    private ArrayList<String> getListOfTypicalFormsOfVerb(){
        ArrayList<String> TypicalFormsOfVerb = new ArrayList<String>();
        TypicalFormsOfVerb.add("Неозначена форма");
        TypicalFormsOfVerb.add("Особові форми");
        TypicalFormsOfVerb.add("Безособова форма");
        TypicalFormsOfVerb.add("Дієприслівникова форма");
        TypicalFormsOfVerb.add("Дієприкметникова форма");
        return TypicalFormsOfVerb;
    }

    private void outListOfTypicalFormsOfVerb(){
        System.out.println("Типові форми дієслова:");
        ArrayList<String> listTypicalFormsOfVerb = getListOfTypicalFormsOfVerb();
        for (String typicalForm: listTypicalFormsOfVerb) {
            System.out.println(typicalForm);
        }
    }
}
