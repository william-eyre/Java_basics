package EmployeeProgramme.GUI;

import EmployeeProgramme.Models.Employee;
import com.sun.xml.internal.fastinfoset.util.StringArray;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.awt.event.*;
import java.time.LocalDate;

import static EmployeeProgramme.Models.generateEmployee.employees;

/**
 * Created by william.eyre on 12/10/2016.
 */
public class Swing implements ActionListener
{
    private static JFrame mainFrame;
    private static JPanel listPanel, fieldPanel;
    private static JList<Employee> employeeJList;
    private static JTextField txtFirstName, txtLastName, txtdob, txtHireDate, txtJobRole;
    private int tempId;

    public void boomGui()
    {
        mainFrame = new JFrame("Employee Programme");
        mainFrame.setSize(800, 400);
        mainFrame.setBackground(Color.DARK_GRAY);
        mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        WindowListener l = new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                int confirm = JOptionPane.showOptionDialog(mainFrame,
                        "Are you sure you want to exit?", "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, null, null);
                if (confirm == 0)
                {
                    mainFrame.dispose();
                    System.exit(0);
                }
            }
        };

        mainFrame.addWindowListener(l);

        mainFrame.setJMenuBar(createMenu());
        //set Gridlayout
        JPanel content = (JPanel) mainFrame.getContentPane();
        content.setLayout(new GridLayout(1,2,5,5));
        content.setBackground(Color.ORANGE);

        prepareJlist();

        listPanel = new JPanel();
        listPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        JScrollPane scrollPane = new JScrollPane(createEmployeeList());
        scrollPane.setPreferredSize(new Dimension(380, 320));
        listPanel.add(scrollPane);

        content.add(listPanel);

        fieldPanel = new JPanel();
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Employee's Details");
        fieldPanel.setBorder(title);
        fieldPanel.add(createFieldsPanel(), BorderLayout.CENTER);
        fieldPanel.add(createButtonPanel(), BorderLayout.SOUTH);

        content.add(fieldPanel);


        mainFrame.setVisible(true);

    }

    private JList<Employee> createEmployeeList() {
        DefaultListModel<Employee> listModel = new DefaultListModel<>();
        if(employees.size() > 0)
            for(Employee e : employees)
                listModel.addElement(e);

        employeeJList.setModel(listModel);

        return employeeJList;
    }

    private JMenuBar createMenu()
    {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.GRAY);
        //File menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.addActionListener(this);

        JMenu OptionsMenu = new JMenu("Options");
        OptionsMenu.setMnemonic(KeyEvent.VK_O);
        OptionsMenu.addActionListener(this);



        JMenuItem listMi = new JMenuItem("List all Employees");
        listMi.setMnemonic(KeyEvent.VK_L);
        listMi.addActionListener(this);

        JMenuItem newMi = new JMenuItem("New Employee");
        newMi.setMnemonic(KeyEvent.VK_N);
        newMi.addActionListener(this);

        JMenuItem addMi = new JMenuItem("Add");
        addMi.setMnemonic(KeyEvent.VK_A);
        addMi.addActionListener(this);

        JMenuItem editMi = new JMenuItem("Edit Employee");
        editMi.setMnemonic(KeyEvent.VK_A);
        editMi.addActionListener(this);

        JMenuItem removeMi = new JMenuItem("Remove Employee");
        removeMi.setMnemonic(KeyEvent.VK_R);
        removeMi.addActionListener(this);

        JMenuItem searchMi = new JMenuItem("Search by First Name");
        searchMi.setMnemonic(KeyEvent.VK_R);
        searchMi.addActionListener(this);

        JMenuItem exitMi = new JMenuItem("Exit");
        exitMi.setMnemonic(KeyEvent.VK_E);
        exitMi.addActionListener(this);


        fileMenu.add(newMi);
        fileMenu.add(exitMi);
        fileMenu.add(addMi);
        fileMenu.add(listMi);
        fileMenu.add(removeMi);
        fileMenu.add(searchMi);

        menuBar.add(fileMenu);
        menuBar.add(OptionsMenu);

        return menuBar;
    }

    private JPanel createFieldsPanel()
    {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0,2,5,5));

        JLabel lblFirstName = new JLabel("First Name:");
        inputPanel.add(lblFirstName);
        txtFirstName = new JTextField();
        inputPanel.add(txtFirstName);

        JLabel lblLastName = new JLabel("Last Name:");
        inputPanel.add(lblLastName);
        txtLastName = new JTextField();
        inputPanel.add(txtLastName);

        JLabel lbldob = new JLabel("DOB (YYYY/MM/DD):");
        inputPanel.add(lbldob);
        txtdob = new JTextField();
        inputPanel.add(txtdob);

        JLabel lblhireDate  = new JLabel("Hire Date (YYYY/MM/DD):");
        inputPanel.add(lblhireDate);
        txtHireDate = new JTextField();
        inputPanel.add(txtHireDate);

        JLabel lbljobRole = new JLabel("Job Role:");
        inputPanel.add(lbljobRole);
        txtJobRole = new JTextField();
        inputPanel.add(txtJobRole);

        return inputPanel;
    }

    private void prepareJlist()
    {
        employeeJList = new JList<>();
        employeeJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        employeeJList.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                if(!employeeJList.getValueIsAdjusting())
                {
                if(!employeeJList.isSelectionEmpty()) {
                    tempId = (employeeJList.getSelectedValue().getId());
                    if(tempId >= 0)
                    {
                        loadEmployeeField(tempId);
                    }


                }
            }
        }});
    }

    private JPanel createButtonPanel()
    {
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //implement action, when a button is clicked(BOOM)
            }
        });

        btnPanel.add(btnUpdate);

        return btnPanel;
    }

    private void loadEmployeeField(int index)
    {
        Employee temp = employees.get(index);
        txtFirstName.setText(temp.getFirstName());
        txtLastName.setText(temp.getLastName());
        txtdob.setText(temp.getDob().toString());
        txtHireDate.setText(temp.getHireDate().toString());
        txtJobRole.setText(temp.getJobRole());

    }

    private void cleartxtFields()
    {
        txtFirstName.setText("");
        txtLastName.setText("");
        txtdob.setText("");
        txtHireDate.setText("");
        txtJobRole.setText("");
    }

    private void createEmployee()
    {
        String[] dobArray = txtdob.getText().split("-"); // getting date of birth from the text
        String[] hireDateArray = txtHireDate.getText().split("-"); // getting hire date. they are splitting them into an array

        Employee employeeNew = new Employee(employees.size(),
                txtFirstName.getText(),
                txtLastName.getText(),
                LocalDate.of(Integer.parseInt(dobArray[0]),Integer.parseInt(dobArray[1]),Integer.parseInt(dobArray[2])),
                LocalDate.of(Integer.parseInt(hireDateArray[0]), Integer.parseInt(hireDateArray[1]), Integer.parseInt(hireDateArray[2])),
                txtJobRole.getText());

        employees.add(employeeNew);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String action = e.getActionCommand();

        if ("New Employee".equals(action))
        {
            cleartxtFields();
        }
        else if ("Exit".equals(action))
        {
            System.exit(0);
        }
        else if ("Add".equals(action))
        {
        }
        else if ("Edit Employee".equals(action))
        {
        }
        else if ("Remove Employee".equals(action))
        {
        }
        else if ("Search by First Name".equals(action))
        {
        }

    }
}


