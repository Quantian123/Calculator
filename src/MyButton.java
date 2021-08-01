
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MyButton extends MyButtonShape {
    private Point startPoint;
    private Component root;
    MyButton(ImageIcon icon) {
        super(icon);
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.PLAIN, 50));
        setBorder(null);
        setFocusable(false);
        setPreferredSize(new Dimension(85, 85));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                root= SwingUtilities.getRoot((Component)(e.getSource()));

                int thisX = root.getLocation().x;
                int thisY = root.getLocation().y;

                int xMoved = e.getX() - startPoint.x;
                int yMoved = e.getY() - startPoint.y;

                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                root.setLocation(X, Y);
            }
        });
    }

    MyButton(String string) {
        super(string);
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.PLAIN, 50));
        setBorder(null);
        setFocusable(false);
        setPreferredSize(new Dimension(85, 85));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                root= SwingUtilities.getRoot((Component)(e.getSource()));

                int thisX = root.getLocation().x;
                int thisY = root.getLocation().y;

                int xMoved = e.getX() - startPoint.x;
                int yMoved = e.getY() - startPoint.y;

                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                root.setLocation(X, Y);
            }
        });
    }

}

