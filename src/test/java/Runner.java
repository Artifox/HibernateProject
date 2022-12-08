import entity.Language;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

public class Runner {

    @Test
    public void runHibernateTest(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.close();
        HibernateUtil.shutDown();
    }

    @Test
    public void addNewLanguageToDB(){
        Language language = new Language();
        language.setName("Current");
        language.setLastUpdate(new Timestamp(System.currentTimeMillis()));

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.persist(language);

        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutDown();
    }
}
