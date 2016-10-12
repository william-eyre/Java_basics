package AdressBook.Models;

/**
 * Created by william.eyre on 11/10/2016.
 */
public class Contact {
    //fields
    Person person;
    Address address;
    String email;
    String number;

   //properties


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    //constructor


    public Contact(Person person) {
        this.person = person;
    }

    public Contact(Address address) {
        this.address = address;
    }

    public Contact(String email) {
        this.email = email;
    }

    public Contact(Person person, Address address, String email, String number) {
        this.person = person;
        this.address = address;
        this.email = email;
        this.number = number;
    }
}
