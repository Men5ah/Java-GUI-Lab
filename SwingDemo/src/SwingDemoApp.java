import javax.swing.*; //Java Swing Framework
import java.awt.*; //Abstract Window Toolkit
import java.awt.event.*; //Event Handling


public class SwingDemoApp extends JFrame implements ActionListener{
    // Creating a simple student form
    private JTextField nameField, ageField; //Uses the JTextField class
    private JButton submitButton; //Uses the JButton class
    private JTextArea outputArea; //Uses the JTextArea class

    // Step 2: Constructor (GUI setup)
    public SwingDemoApp() {
        setTitle("Student Form");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Name:"));
        nameField = new JTextField(15);
        add(nameField);

        add(new JLabel("Age:"));
        ageField = new JTextField(5);
        add(ageField);

        submitButton = new JButton("Add Student");
        submitButton.addActionListener(this);
        add(submitButton);

        outputArea = new JTextArea(5, 25);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea));

        setVisible(true);
    }

    // Step 3: Event handling (Interface implementation)
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());

        Student s = new Student(name, age); // Creating an object
        outputArea.append(s.getInfo() + "\n");

        nameField.setText("");
        ageField.setText("");
    }

    //main method
    public static void main(String[] args) {
        new SwingDemoApp();
    }

}


class Student{
    private String name;
    private int age;

    //constructor
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    //Getter methods
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    //Display Info
    public String getInfo(){
        return "Name: " + name + ", Age: " + age;
    }
}
