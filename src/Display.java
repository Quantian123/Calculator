import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Display extends JTextField {
    private Point startPoint;
    private Component root;

    Display(){
        setHorizontalAlignment(SwingConstants.RIGHT);
        setBorder(null);
        setEditable(false);
        setFont(new Font("Arial", Font.PLAIN, 90));
        setForeground(Color.WHITE);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(370,100));
        setText("0");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                root=SwingUtilities.getRoot((Component)(e.getSource()));

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

