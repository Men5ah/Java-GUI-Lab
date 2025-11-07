# 🧠 Java Swing & OOP — Exercise Sheet

## Applying Classes, Objects, and Interfaces through GUI Programming

## 🎯 Learning Outcomes

After completing these exercises, students should be able to:

- Demonstrate understanding of how **classes**, **objects**, and **interfaces** work together in Java.
- Build simple GUI programs using **Swing** components.
- Handle user interactions using **event-driven programming**.
- Apply OOP concepts to extend and improve existing GUI programs.

---

## 🧩 Section A — Conceptual Questions

Answer the following in your notes or as short written responses.

1. What is the difference between **AWT** and **Swing** in Java?  
2. Explain what happens when you click a button connected to an `ActionListener` in Swing.  
3. How does the concept of **encapsulation** appear in Swing components like `JTextField` or `JButton`?  
4. In the `StudentForm` demo:
   - (a) Which class represents the **data**?  
   - (b) Which class handles **user interaction**?  
   - (c) Which **interface** is implemented for event handling?  
5. Why is it useful for GUI applications to use **interfaces** like `ActionListener` instead of hard-coding actions directly into buttons?

---

## 💻 Section B — Coding Exercises

### 🧠 Exercise 1: Modify the Student Form

Open your previous `StudentForm.java` file.

#### Task:

1. Add a new field for **Student ID** (`JTextField`).
2. Update the `Student` class and its constructor to store the ID.
3. Modify the `getInfo()` method to display the ID along with the name and age.
4. Test the program by adding multiple students.

✅ **Hint:** You only need to add a few lines — focus on the `Student` class and the section where data is read from the text fields.

---

### ⚙️ Exercise 2: Add a “Clear” Button

#### Task:

Add another button labeled **“Clear”** below the “Add Student” button that, when clicked, clears the `outputArea` text.

✅ **Hint:**  

- Add a second `JButton` named `clearButton`.  
- Attach another `ActionListener` or use the same one and check which button was pressed using `e.getSource()`.

---

### 🔄 Exercise 3: Add a Combo Box for Gender

#### Task:

Add a drop-down (`JComboBox`) that lets users select a gender (e.g., “Male”, “Female”, “Other”).  
Include the selected gender in the output message.

✅ **Hint:**  

- Use `String gender = (String) genderBox.getSelectedItem();`  
- Pass it into the `Student` constructor and display it in `getInfo()`.

---

## 🧮 Section C — Build Your Own GUI

### 🏗️ Exercise 4: Mini “Shape Drawer”

Create a new file called **`ShapeDrawer.java`** and build a small GUI that draws either a **Circle** or a **Rectangle** when a button is clicked.

#### Requirements:

1. Define a `Shape` **interface** with a `draw(Graphics g)` method.  
2. Create `Circle` and `RectangleShape` classes that **implement** `Shape`.  
3. Use a `JComboBox` to let the user pick which shape to draw.  
4. Create a `JPanel` subclass (`DrawPanel`) to handle the drawing.  
5. When the user clicks a “Draw” button, repaint the panel with the selected shape.

✅ **Expected Behavior:**  
Selecting “Circle” or “Rectangle” and pressing **Draw** should display the corresponding shape.

---

## 🧩 Section D — Reflection

Answer these brief reflection questions after you’ve finished the tasks:

1. How did implementing an interface (`ActionListener` or `Shape`) help organize your code?
2. In what ways do GUI programs demonstrate the idea of **objects interacting** with each other?
3. How could inheritance make it easier to add more features or new shapes in your GUI?

---

## 🧭 Summary

Through these exercises, you’ve:

- Practiced creating and using **classes**, **objects**, and **interfaces**.  
- Seen how OOP principles make GUI programs modular and maintainable.  
- Built small but real-world programs that visually respond to user actions.  

> 🧩 **Key Takeaway:**  
> Every button, text box, and window in Swing is an **object**, and event handling is where **interfaces and classes** come together in practice.
