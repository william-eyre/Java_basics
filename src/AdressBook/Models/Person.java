package AdressBook.Models;

/**
 * Created by william.eyre on 11/10/2016.
 */
public class Person {
    //fields
    private String FirstName;
    private String LastName;

//properties
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    //Constructor


    public Person(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
    }

    public Person() {}

    public Person(String fn)
    {
        this.FirstName = fn;
    }

    @Override
    public String toString() {
        return "Person{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }
}


