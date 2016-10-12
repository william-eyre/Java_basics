package EmployeeProgramme.GUI;

import EmployeeProgramme.Processor.TaskProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by william.eyre on 11/10/2016.
 */
public class commandInterface {
    static Scanner input = new Scanner(System.in);

    public static void display() {
        int choice;
        boolean _isRunning = true;
        while (_isRunning) {
            do {
                System.out.println("Welcome to employee Awesome Programme");
                System.out.println("1. List All Employees");
                System.out.println("2. Add New Employee");
                System.out.println("3. Edit Employee");
                System.out.println("4. Remove an Employee");
                System.out.println("5. Search by First Name");
                System.out.println("BOOM Terminate");
                choice = input.nextInt();
            } while (choice < 1 || choice > 6);

            switch (choice) {
                case 1:
                    TaskProcessing.listAll();
                    display();
                    break;
                case 2:
                    System.out.println(TaskProcessing.createNew(inputDetails()));
                    break;
                case 5:
                    System.out.print("Enter first name to search:");
                    System.out.println(TaskProcessing.SearchByFirstName(input.next()));
                    break;
                case 6:
                    _isRunning = false;
            }
        }
    }
        static List<String> inputDetails()
        {
            List<String> tempEmployee = new ArrayList<>();
            input.nextLine();

            System.out.print("First Name: ");
            tempEmployee.add( input.nextLine());

            System.out.print("Last Name: ");
            tempEmployee.add( input.nextLine());

            System.out.print("DOB (YYYY/MM/DD): ");
            tempEmployee.add( input.nextLine());

            System.out.print("Hire Date (YYYY/MM/DD: ");
            tempEmployee.add( input.nextLine());

            System.out.print("Job Role: ");
            tempEmployee.add( input.nextLine());

            return tempEmployee;
        }
    }


