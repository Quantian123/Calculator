import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MyFrame extends JFrame {
    public static void main(String[] args) {
        new MyFrame();
    }
    private Point startPoint;
    private Component root;
    MyPanel myPanel;

    MyFrame(){
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(myPanel=new MyPanel());
        pack();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                root = SwingUtilities.getRoot((Component) (e.getSource()));

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

