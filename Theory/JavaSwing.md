# 🖥️ Introduction to Java Swing

## Connecting Classes, Objects, and Interfaces through GUI Programming



### 🎯 Objectives

By the end of this session, you should be able to:
- Appreciate how **Object-Oriented Programming (OOP)** applies to real-world systems.
- Understand the purpose and structure of **Java Swing** for building graphical user interfaces (GUIs).
- Identify key Swing components and event-handling mechanisms.
- Implement a simple interactive program that uses **classes**, **objects**, and **interfaces** in a GUI.

---

### 🧩 1. What is Java Swing?

**Java Swing** is a part of the **Java Foundation Classes (JFC)** used to create **Graphical User Interfaces (GUIs)**.  
It’s built on top of the older **Abstract Window Toolkit (AWT)** and provides a richer set of components that look and behave consistently across platforms.

#### 💡 Key Points:
- Swing is part of the **`javax.swing`** package.
- It’s **platform-independent** (works the same on Windows, macOS, and Linux).
- Components (buttons, text fields, labels) are **objects** — they are instances of classes such as `JButton`, `JLabel`, and `JTextField`.
- Swing supports **event-driven programming** — actions like button clicks trigger code execution.

---

### 📦 2. Important Imports in Swing

Before writing Swing code, you’ll typically import these packages:

```java
import javax.swing.*;     // Core Swing components like JFrame, JButton, JLabel, etc.
import java.awt.*;        // Layout managers and colors
import java.awt.event.*;  // Event listeners for handling user actions
````

---

### 🧠 3. Connecting Swing to OOP Concepts

| OOP Concept       | How It Appears in Swing                                | Example                                                                   |
| ----------------- | ------------------------------------------------------ | ------------------------------------------------------------------------- |
| **Class**         | Every Swing component is a class.                      | `JButton`, `JLabel`, `JFrame`                                             |
| **Object**        | You create GUI elements as objects.                    | `JButton btn = new JButton("Click Me");`                                  |
| **Encapsulation** | Component behavior and data are bundled together.      | Button’s label is set and managed via methods like `setText()`            |
| **Inheritance**   | Many components extend base classes.                   | `JFrame` extends `Frame`; `JPanel` extends `Container`                    |
| **Interfaces**    | Used for event handling (e.g. `ActionListener`).       | `public class MyFrame implements ActionListener`                          |
| **Polymorphism**  | Different objects share common methods via interfaces. | Any object that implements `ActionListener` can respond to button clicks. |

---

### 🧩 Example: Understanding Classes and Objects

```java
JButton submitButton = new JButton("Submit");
JTextField nameField = new JTextField(15);

// Each of these is an object created from a class.
```

### 🧩 Example: Using an Interface (Event Handling)

```java
submitButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
    }
});
```

Here, `ActionListener` is an **interface**.
We create an **anonymous class** that implements it to handle the button click.

---

## 🧪 4. Interactive Code-Along: "Student Info Form"

Let’s build a simple form that takes a student’s name and age and displays it in a text area.

---

### Step 1: Create a New Java File

Create a file named **`StudentForm.java`**

---

### Step 2: Write the Code

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// A simple Student class (represents data)
class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getInfo() {
        return "Name: " + name + ", Age: " + age;
    }
}

// GUI class (represents behavior and user interaction)
public class StudentForm extends JFrame implements ActionListener {
    private JTextField nameField, ageField;
    private JTextArea outputArea;
    private JButton addButton;

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

        addButton = new JButton("Add Student");
        addButton.addActionListener(this); // Interface method
        add(addButton);

        outputArea = new JTextArea(5, 25);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea));

        setVisible(true);
    }

    // Event-handling method (from ActionListener interface)
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());

        // Create an object of Student
        Student s = new Student(name, age);
        outputArea.append(s.getInfo() + "\n");

        // Clear fields
        nameField.setText("");
        ageField.setText("");
    }

    public static void main(String[] args) {
        new StudentForm();
    }
}
```

---

### Step 3: Run the Program

Open a terminal in the file’s directory and run:

```bash
javac StudentForm.java
java StudentForm
```

You should see a small window with:

* Two text fields (for name and age)
* A button labeled **Add Student**
* A text area that displays the entered student information.

---

### Step 4: Discuss

💬 **What OOP ideas can we see here?**

* `Student` is a **class** used to create **objects**.
* `StudentForm` implements an **interface** (`ActionListener`).
* Methods like `actionPerformed()` demonstrate **behavior** triggered by events.
* Data and behavior are encapsulated within objects.

---

## 🧩 5. Extension Activities

1. Add a "Clear" button that empties the text area.
2. Add validation to ensure the age is a number.
3. Add a `Student ID` field and modify `getInfo()` accordingly.
4. Ask students: *How could we store multiple students in a list?*

---

## 🧭 Summary

* Swing makes it possible to **see** how OOP structures manifest in real-world applications.
* Each component (buttons, labels, panels) is an **object**.
* Interfaces like `ActionListener` let different components **communicate** via events.
* By combining data (`Student`) and interaction (`StudentForm`), we bridge OOP theory with practice.

---

> 🧠 **Key Takeaway:**
> Java Swing isn’t just for creating windows — it’s a practical way to visualize and apply object-oriented principles in action.

```