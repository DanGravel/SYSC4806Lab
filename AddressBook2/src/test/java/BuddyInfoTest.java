import application.BuddyInfo;
import org.junit.Test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
public class BuddyInfoTest {

    @Test
    public void getName() {
        BuddyInfo bd = new BuddyInfo("Dan", "Carleton", "555-555-5555");
        assertEquals("Dan", bd.getName());
    }

    @Test
    public void setName() {
        BuddyInfo bd = new BuddyInfo("Dan", "Carleton", "555-555-5555");
        bd.setName("NotDan");
        assertEquals("NotDan", bd.getName());
    }

    @Test
    public void getPhone() {
        BuddyInfo bd = new BuddyInfo("Dan", "Carleton", "555-555-5555");
        assertEquals("555-555-5555", bd.getPhone());
    }

    @Test
    public void setPhone() {
        BuddyInfo bd = new BuddyInfo("Dan", "Carleton", "555-555-5555");
        bd.setPhone("911");
        assertEquals("911", bd.getPhone());
    }

    @Test
    public void getAddress() {
        BuddyInfo bd = new BuddyInfo("Dan", "Carleton", "555-555-5555");
        assertEquals("Carleton", bd.getAddress());
    }

    @Test
    public void setAddress() {
        BuddyInfo bd = new BuddyInfo("Dan", "Carleton", "555-555-5555");
        bd.setAddress("NotCarleton");
        assertEquals("NotCarleton", bd.getAddress());
    }

    @Test public void setAge(){
        BuddyInfo bd = new BuddyInfo("Dan", "Carleton", "555-555-5555");
        bd.setAge(55);
        assertEquals(55, bd.getAge());
    }

    @Test
    public void testJPA() {
        BuddyInfo bd = new BuddyInfo();

        bd.setName("Dan");
        bd.setAddress("Carleton");
        bd.setPhone("555-555-5555");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("application.AddressBook");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(bd);


        tx.commit();

        Query q = em.createQuery("SELECT p FROM BuddyInfo p");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        em.close();

        emf.close();

        assertEquals("Dan", results.get(0).getName());
        assertEquals("Carleton", results.get(0).getAddress());
        assertEquals("555-555-5555", results.get(0).getPhone());
    }
}