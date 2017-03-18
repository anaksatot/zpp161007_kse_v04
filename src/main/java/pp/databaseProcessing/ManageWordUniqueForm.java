package pp.databaseProcessing;

import org.hibernate.Session;
import pp.linguisticCategories.Language;
import pp.word.WordUniqueForm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Set;

/**
 * Created by Admin on 3/7/2017.
 */
public class ManageWordUniqueForm {

    public Integer addWordUniqueForm(String formOfWord, Language language){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Primary");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist( new WordUniqueForm(formOfWord , language) );
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
        return 0;
    }

    public Integer addListWordUniqueForm(Set<WordUniqueForm> setWordUniqueForm, Language language){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Primary");
        EntityManager entityManager = factory.createEntityManager();
        for (WordUniqueForm wordUniqueForm: setWordUniqueForm) {
            entityManager.getTransaction().begin();
            entityManager.persist( new WordUniqueForm(wordUniqueForm.getFormOfWordXIVsystem() , language) );
            entityManager.getTransaction().commit();
        }
        entityManager.close();
        factory.close();
        return 0;
    }
}
