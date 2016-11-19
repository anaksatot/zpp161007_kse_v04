package pp.entity;

public class LcVerb extends LinguisticCategory{

	public LcVerb() {
		super(LC.VERB);
	}

	public LcVerb(String formOfWord) {
		super(LC.NOUN, formOfWord);
	}
}
