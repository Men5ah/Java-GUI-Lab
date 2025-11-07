import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Step 1: Define an interface (abstraction)
interface Shape {
    void draw(Graphics g);
}

// Step 2: Implement classes that realize the interface
class Circle implements Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius) {
        this.x = x; this.y = y; this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x, y, radius, radius);
    }
}

class RectangleShape implements Shape {
    private int x, y, width, height;

    public RectangleShape(int x, int y, int width, int height) {
        this.x = x; this.y = y; this.width = width; this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }
}

// Step 3: GUI class (Composition + Event Handling)
public class ShapeDrawer extends JFrame implements ActionListener {
    private JComboBox<String> shapeSelector;
    private DrawPanel drawPanel;

    public ShapeDrawer() {
        setTitle("Shape Drawer");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Top control panel
        JPanel topPanel = new JPanel();
        shapeSelector = new JComboBox<>(new String[]{"Circle", "Rectangle"});
        JButton drawButton = new JButton("Draw");
        drawButton.addActionListener(this);

        topPanel.add(new JLabel("Select Shape:"));
        topPanel.add(shapeSelector);
        topPanel.add(drawButton);

        // Drawing area
        drawPanel = new DrawPanel();

        add(topPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selected = (String) shapeSelector.getSelectedItem();
        if ("Circle".equals(selected)) {
            drawPanel.setShape(new Circle(100, 80, 80));
        } else {
            drawPanel.setShape(new RectangleShape(80, 70, 120, 70));
        }
        drawPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShapeDrawer().setVisible(true));
    }
}

// Step 4: Custom JPanel to display shapes (inheritance)
class DrawPanel extends JPanel {
    private Shape shape;

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (shape != null) {
            shape.draw(g);
        }
    }
}
