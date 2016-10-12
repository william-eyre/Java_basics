package AdressBook.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by william.eyre on 11/10/2016.
 */
public class GenerateAddress {
    public static List<Contact> contacts;
    public static void createContacts() {
        Contact will = new Contact (new Person("Will", "Eyre"),
                new Address("64", "Zoo Lane", "London", "London", "Zo0 8ap"),
                "elephant@zoomail.com", "07984685926");

        Contact indiana = new Contact (new Person("Indiana", "Jones"),
                new Address("14", "Valley of the Kings", "Egypt", "Egypt", "EG8 9VK"),
                "Indie@digging.com", "07849303857");
        contacts = new ArrayList<>();
        contacts.add(will);
        contacts.add(indiana);


    }
}
