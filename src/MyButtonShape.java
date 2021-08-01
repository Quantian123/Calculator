import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MyButtonShape extends JButton {
    MyButtonShape(ImageIcon icon){
        super(icon);
        setContentAreaFilled(false);
    }
    MyButtonShape(String string){
        super(string);
        setContentAreaFilled(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d =(Graphics2D)g;
        if (getModel().isArmed()) {
            g2d.setColor(Color.white);
        } else {
            g2d.setColor(getBackground());
        }
        g2d.fillOval(0, 0, getSize().width, getSize().height);
        super.paintComponent(g2d);
    }
    Shape shape;
    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }
}

