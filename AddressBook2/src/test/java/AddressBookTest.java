import application.AddressBook;
import application.BuddyInfo;
import org.junit.Test;

import javax.persistence.*;

import static org.junit.Assert.*;

public class AddressBookTest {

    @Test
    public void addBuddy() {
        AddressBook addrBk = new AddressBook();
        BuddyInfo buddy = new BuddyInfo("Dan","Carleton","555-555-5555");
        addrBk.addBuddy(buddy);
        assertSame(buddy, addrBk.getBuddy("Dan"));
    }

    @Test
    public void removeBuddy() {
        AddressBook addrBk = new AddressBook();
        BuddyInfo buddy = new BuddyInfo("Dan","Carleton","555-555-5555");
        addrBk.addBuddy(buddy);
        addrBk.removeBuddy("Dan");
        assertNull(addrBk.getBuddy("Dan"));
    }

    @Test
    public void testJPA() {
        AddressBook addrBk = new AddressBook();
        BuddyInfo buddy = new BuddyInfo("Dan","Carleton","555-555-5555");
        BuddyInfo buddy2 = new BuddyInfo("Steve","Carleton","555-555-5555");
        addrBk.addBuddy(buddy);
        addrBk.addBuddy(buddy2);



        EntityManagerFactory emf = Persistence.createEntityManagerFactory("application.AddressBook");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(addrBk);

        tx.commit();
    }
}