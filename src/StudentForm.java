import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// A simple Student class (represents data)
class Student {
    private String name;
    private int age;
    private String studentID;
    private String gender;

    public Student(String name, int age, String studentID, String gender) {
        this.name = name;
        this.age = age;
        this.studentID = studentID;
        this.gender = gender;
    }

    public String getInfo() {
        return "Name: " + name + ", Age: " + age + ", ID: " + studentID + ", Gender: " + gender;
    }
}

// GUI class (represents behavior and user interaction)
public class StudentForm extends JFrame implements ActionListener {
    private JTextField nameField, ageField, studentIDField;
    private JTextArea outputArea;
    private JButton addButton;
    private JButton clearButton;
    private JComboBox<String> genderBox;

    public StudentForm() {
        setTitle("Student Info Form");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Name:"));
        nameField = new JTextField(15);
        add(nameField);

        add(new JLabel("Age:"));
        ageField = new JTextField(5);
        add(ageField);

        // ID field
        add(new JLabel("ID:"));
        studentIDField = new JTextField(10);
        add(studentIDField);

        // Gender drop-down
        add(new JLabel("Gender:"));
        String[] gender = {" ", "Male", "Female", "Other"};
        genderBox = new JComboBox<>(gender);
        add(genderBox);


        addButton = new JButton("Add Student");
        addButton.addActionListener(this); // Interface method
        add(addButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);  // same ActionListener
        add(clearButton);

        outputArea = new JTextArea(5, 25);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea));

        setVisible(true);
    }

    // Event-handling method (from ActionListener interface)
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String studentID = studentIDField.getText();
            String gender = (String) genderBox.getSelectedItem();

            // Create an object of Student
            Student s = new Student(name, age, studentID,gender);
            outputArea.append(s.getInfo() + "\n");

            // Clear fields
            nameField.setText("");
            ageField.setText("");
            studentIDField.setText("");
            genderBox.setSelectedIndex(0);

        }else if (e.getSource() == clearButton){
            outputArea.setText("");
        }
    }

    public static void main(String[] args) {
        new StudentForm();
    }
}

