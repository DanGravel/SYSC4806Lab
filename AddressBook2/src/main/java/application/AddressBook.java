package application;

import javax.persistence.*;
import java.util.Map;
import java.util.HashMap;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Map<String, BuddyInfo> addressbook;

    public AddressBook() {
        addressbook = new HashMap<String, BuddyInfo>();
    }

    public void addBuddy(BuddyInfo bud) {
        addressbook.put(bud.getName(), bud);
    }

    public BuddyInfo getBuddy(String name) {
        return addressbook.get(name);
    }

    public void removeBuddy(String name) {
        addressbook.remove(name);
    }

    public static void main(String[] args) {
        AddressBook ad = new AddressBook();
        BuddyInfo buddy = new BuddyInfo("Keegan", "543 East Orkney", "911");
        ad.addBuddy(buddy);
        BuddyInfo buddy2 = new BuddyInfo("liam", "543 East Orkney", "555");
        ad.addBuddy(buddy2);
    }
}