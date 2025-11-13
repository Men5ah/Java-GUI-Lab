import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

    interface Shape {
        void draw(Graphics g);
    }
    // circle
    class Circle implements Shape {
        public void draw(Graphics g) {
            g.setColor(Color.BLUE);
            g.fillOval(70, 50, 100, 100); // x, y, width, height
        }
    }

    // rectangle
    class RectangleShape implements Shape {
        public void draw(Graphics g) {
            g.setColor(Color.RED);
            g.fillRect(70, 50, 120, 80);
        }
    }

    class DrawPanel extends JPanel {
        private Shape shape; // Current shape to draw

        public void setShape(Shape shape) {
            this.shape = shape;
            repaint(); // Refresh the panel
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (shape != null) {
                shape.draw(g); // Ask the shape to draw itself
            }
        }
    }

    public class ShapeDrawer extends JFrame implements ActionListener {
        private JComboBox<String> shapeBox;
        private JButton drawButton;
        private DrawPanel drawPanel;

        public ShapeDrawer() {
            setSize(350, 300);

            JPanel controlPanel = new JPanel();
            controlPanel.add(new JLabel("Choose Shape:"));

            shapeBox = new JComboBox<>();
            shapeBox.addItem("Circle");
            shapeBox.addItem("Rectangle");
            controlPanel.add(shapeBox);

            drawButton = new JButton("Draw");
            drawButton.addActionListener(this);
            controlPanel.add(drawButton);

            add(controlPanel, BorderLayout.NORTH);

            // Drawing area
            drawPanel = new DrawPanel();
            drawPanel.setBackground(Color.WHITE);
            add(drawPanel, BorderLayout.CENTER);

            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String selected = (String) shapeBox.getSelectedItem();

            if (selected.equals("Circle")) {
                drawPanel.setShape(new Circle());
            } else if (selected.equals("Rectangle")) {
                drawPanel.setShape(new RectangleShape());
            }
        }

        public static void main(String[] args) {
            new ShapeDrawer();
        }
    }


