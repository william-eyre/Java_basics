package EmployeeProgramme.Models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by william.eyre on 11/10/2016.
 */
public  class Person {
    // Members
    /*
    fields- private
    properties = getters and setters
    methods
    events
    exception handling
     */

    //Fields
    private String FirstName;
    private String LastName;
    private LocalDate dob;
    private Short Height;
    private Double Weight;
    private int NOT_BORN =0;

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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    //constructor - overloading


    public Person(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
    }

    public Person(String firstName, String lastName, LocalDate dob) {
        FirstName = firstName;
        LastName = lastName;
        this.dob = dob;
    }

    public Person() {}

    public Person(String fn) {
        this.FirstName = fn;
    }

    //method
    public long getAge() {
        if (dob == null) {
            return NOT_BORN;
        }
        long years = ChronoUnit.YEARS.between(dob, LocalDate.now());
        return years;
    }

    @Override
    public String toString() {
        return "{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", dob=" + dob +
                ", Height=" + Height +
                ", Weight=" + Weight +
                '}';
    }
}