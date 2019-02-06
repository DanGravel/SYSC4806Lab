package application;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String phone;
    private String address;
    private int age;

    public BuddyInfo() {

    }

    public BuddyInfo(String name, String address, String phone, int age){
        this(name, phone, address);
        this.age = age;
    }

    public BuddyInfo(String name, String address, String phone){
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {this.age = age;}

    public int getAge() {return age;}

    @Override
    public String toString() {
       return "Name: " + name +" Address: " + address + " Phone: " + phone;
    }
}