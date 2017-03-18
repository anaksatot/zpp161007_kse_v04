package pp.databaseProcessing;

import pp.linguisticCategories.Language;
import pp.sentence.Sentence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Admin on 3/17/2017.
 */
public class ManageSentence {
    public Integer addSentence(Sentence sentence, Language language){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Primary");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(sentence);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
        return 0;
    }

}
