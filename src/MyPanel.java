import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    Display display;

    MyPanel() {
        setBackground(Color.BLACK);
        setFocusable(true);
        add(display=new Display());
        add(new ButtonPanel());
        setPreferredSize(new Dimension(400, 600));
        setFocusable(true);
    }
}
