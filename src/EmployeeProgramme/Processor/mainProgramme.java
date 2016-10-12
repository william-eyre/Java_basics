package EmployeeProgramme.Processor;

import EmployeeProgramme.GUI.Swing;
import EmployeeProgramme.Models.Employee;
import EmployeeProgramme.Models.generateEmployee;
import EmployeeProgramme.GUI.commandInterface;

import static EmployeeProgramme.Models.generateEmployee.employees;

/**
 * Created by william.eyre on 11/10/2016.
 */
public class mainProgramme {
    public static void main(String[] args) {

        generateEmployee.createEmployee();
        Swing gui = new Swing();
        gui.boomGui();
    }
}
