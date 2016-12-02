package pp.linguisticCategories;

public class LcVerbUkrainian extends LcVerb {
    private String formOfVerbInfinitive;
    private FormsOfVerbPersonalConjugation formOfVerbPersonal;
    private String formOfVerbImpersonal;
    private String formOfVerbAdverb;
    private FormsOfVerbAdjectiveConjugation formOfVerbAdjective;

    public LcVerbUkrainian(String formOfWord) {
        super(formOfWord);
    }

    public void setFormOfVerbInfinitive(String infinitiveForm) {
        this.formOfVerbInfinitive = infinitiveForm;
    }

    public void setFormOfVerbPersonal(FormsOfVerbPersonalConjugation formOfVerbPersonal) {
        this.formOfVerbPersonal = formOfVerbPersonal;
    }

    public void setFormOfVerbImpersonal(String impersonalForm) {
        this.formOfVerbImpersonal = impersonalForm;
    }

    public void setFormOfVerbAdverb(String adverbForm) {
        this.formOfVerbAdverb = adverbForm;
    }

    public void setFormOfVerbAdjective(FormsOfVerbAdjectiveConjugation formOfVerbAdjective) {
        this.formOfVerbAdjective = formOfVerbAdjective;
    }

    @Override
    public String toString() {
        return "LcVerbUkrainian{" +
                "formOfVerbInfinitive='" + formOfVerbInfinitive + '\'' +
                ", formOfVerbPersonal=" + formOfVerbPersonal +
                ", formOfVerbImpersonal='" + formOfVerbImpersonal + '\'' +
                ", formOfVerbAdverb='" + formOfVerbAdverb + '\'' +
                ", formOfVerbAdjective=" + formOfVerbAdjective +
                '}';
    }
}
