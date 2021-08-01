import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel{
    private MyButton[] number =new MyButton[11];
    private MyButton[] function =new MyButton[5];
    private MyButton[] other =new MyButton[4];
    ButtonPanel(){
        setFocusable(true);
        setLayout(new GridLayout(5,4,10,10));
        setBackground(Color.BLACK);

        add(other[0]=new MyButton("C"));
        add(other[1]=new MyButton(Character.toString((char) 0x00B1)));
        add(other[2]=new MyButton("%"));
        add(function[0]=new MyButton(Character.toString((char) 0x00F7)));
        add(number[0]=new MyButton("7"));
        add(number[1]=new MyButton("8"));
        add(number[2]=new MyButton("9"));
        add(function[1]=new MyButton("x"));
        add(number[3]=new MyButton("4"));
        add(number[4]=new MyButton("5"));
        add(number[5]=new MyButton("6"));
        add(function[2]=new MyButton("-"));
        add(number[6]=new MyButton("1"));
        add(number[7]=new MyButton("2"));
        add(number[8]=new MyButton("3"));
        add(function[3]=new MyButton("+"));
        add(other[3]=new MyButton(new ImageIcon("C:\\Users\\kksie\\IdeaProjects\\CalculatorBis\\power_symbol.png")));
        add(number[9]=new MyButton("0"));
        add(number[10]=new MyButton("."));
        add(function[4]=new MyButton("="));

        for (int i = 0; i< number.length; i++){
            number[i].setBackground(Color.lightGray);
            number[i].addActionListener(new MyButtonAdapter());
        }
        for (int i = 0; i< function.length; i++){
            function[i].setBackground(new Color(255,128,0));
            function[i].addActionListener(new MyButtonAdapter());
        }
        for (int i = 0; i< other.length; i++){
            other[i].setForeground(Color.black);
            other[i].setBackground(Color.darkGray);
            other[i].setFont(new Font("Arial", Font.BOLD, 50));
            other[i].addActionListener(new MyButtonAdapter());
        }
    }
}
