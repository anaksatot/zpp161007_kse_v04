package pp.linguisticCategories.linguisticCategoriesService;

import pp.linguisticCategories.LcVerb;
import pp.linguisticCategories.LcVerbUkrainian;

import java.util.ArrayList;
import java.util.Scanner;

public class LcVerbUkrainianServiceImpl implements LcVerbUkrainianService{

    @Override
    public LcVerb defineLcVerb(String word, boolean onlyThisForm, boolean inDetail) {
        if (onlyThisForm) {
            return defineLcVerbUniqueForm(word, inDetail);
        }
        return null;
    }

    @Override
    public LcVerb defineLcVerbUniqueForm(String word, boolean inDetail) {

        LcVerbUkrainian lcVerbUkrainian = new LcVerbUkrainian(word);
        if (inDetail) {
            Scanner scanner = new Scanner(System.in);
            outListOfTypicalFormsOfVerb();
            while (true) {
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
                        lcVerbUkrainian.setFormOfVerbAdjective(new FormsOfVerbAdjectiveConjugationServiceImpl().defineAdjectiveForms(word, true));
                        break;
                    default:
                        System.out.println("невдалий номер позиції. спробуте ще раз");
                        continue;
                }
                break;
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

    private void outListOfTypicalFormsOfVerb(){
        System.out.println("Типові форми дієслова:");
        ArrayList<String> listTypicalFormsOfVerb = new LinguisticCategoriesServiceImpl().getListOfTypicalFormsOfVerbInUkrainianOut();
        for (String typicalForm: listTypicalFormsOfVerb) {
            System.out.println(typicalForm);
        }
    }
}
