package EmployeeProgramme.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by william.eyre on 11/10/2016.
 */
public class generateEmployee {
    public static List<Employee> employees; // this List is a java pre set, and is called <Employee>
    //it is looking at the class Employee, then after the list is named employees


    public static void createEmployee() {
        Employee will = new Employee(0, "Will", "Eyre",
                LocalDate.of(1996,3,5),
                LocalDate.of(2016,9,26),
                "Apprentice");

        Employee robin = new Employee(1, "Robin", "Bradford",
                LocalDate.of(1990,12,8),
                LocalDate.of(2016,9,26),
                "Apprentice");

        employees = new ArrayList<>(); //ArrayList is a subclass of List, it is an array so that the order
        //is as the user inputs the information.
        employees.add(will);
        employees.add(robin);
    }
}
