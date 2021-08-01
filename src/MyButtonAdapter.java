import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MyButtonAdapter implements ActionListener  {
    private Object source;
    private AbstractButton button;
    private Component root;
    private MyFrame castedRoot;
    private Display display;

    final String[] numbersFrom0to9 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    static char operator='+';
    static boolean flag=false;
    static double num1 = 0;
    static double num2 = 0;
    static double result = 0;//unnecessary variable
    DecimalFormatSymbols symbols=new DecimalFormatSymbols(Locale.getDefault());
    DecimalFormat decimal=new DecimalFormat();

    @Override
    public void actionPerformed(ActionEvent e) {
        source = e.getSource();
        root = SwingUtilities.getRoot((Component) source);
        castedRoot = (MyFrame) root;
        button = (MyButton) source;
        display = castedRoot.myPanel.display;
        symbols.setDecimalSeparator('.');
        symbols.setExponentSeparator("e");
        decimal.setDecimalFormatSymbols(symbols);

        if(display.getText().length()<7){
            for (int i = 0; i < 10; i++) {
                if (button.getText().equals(numbersFrom0to9[i])) {
                    if (display.getText().equals("0") || (flag)) {
                        display.setText("");
                        flag = false;
                    }
                    display.setText(display.getText().concat(String.valueOf(i)));
                }
            }
        }
        if (button.getText().equals("C")) {
            display.setText("0");
            flag=false;
            num2=num1=result=0;
        }
        if (button.getText().equals(".")&&(!display.getText().contains("."))){
            display.setText(display.getText().concat("."));
        }
        if (button.getText().equals("")){
            System.exit(0);
        }
        if (button.getText().equals(Character.toString((char) 0x00B1))){
            display.setText(decimal.format(Double.parseDouble(display.getText())*(-1)));
        }
        if (button.getText().equals("+")) {
            calculate();
            operator = '+';
            num1 =Double.parseDouble(display.getText());
            flag = true;
        }
        if (button.getText().equals("-")) {
            calculate();
            operator = '-';
            num1 = Double.parseDouble(display.getText());
            flag = true;
        }
        if (button.getText().equals("x")) {
            calculate();
            operator = '*';
            num1 = Double.parseDouble(display.getText());
            flag = true;
        }
        if (button.getText().equals(Character.toString((char) 0x00F7))) {
            calculate();
            operator = '/';
            num1 = Double.parseDouble(display.getText());
            flag = true;
        }
        if (button.getText().equals("=")){
            calculate();
        }
        if (button.getText().equals("%")) {
            percent();
        }
        System.out.println("operator"+" "+"num1"+" "+"num2"+" "+"result"+" "+"flag");       //skasować
        System.out.println(operator+"        "+num1+"  "+num2+"  "+result+"    "+flag);     //na koniec
    }

    private void calculate(){
        num2=Double.parseDouble(display.getText());
        switch (operator) {
            case '+': {
                result=num1+num2;
                num1=result;
                break;
            }
            case '-': {
                result=num1-num2;
                num1=result;
                break;
            }
            case '/': {
                result=num1/num2;
                num1=result;
                break;
            }
            case '*': {
                result=num1*num2;
                num1=result;
                break;
            }
        }
        if ((result>9999999)||((result>0)&&(result<0.000001))){
            decimal.applyPattern("0.0000E0");

        } else decimal.applyPattern("0.######");

        display.setText(decimal.format(result));
        flag=true;
    }
    private void percent(){
        num2=Double.parseDouble(display.getText());
        switch (operator) {
            case '+': {
                result=num1+(num1*num2*0.01);
                num1=result;
                break;
            }
            case '-': {
                result=num1-(num1*num2*0.01);
                num1=result;
                break;
            }
            case '/': {
                result=num1/(num2*0.01);
                num1=result;
                break;
            }
            case '*': {
                result=num1*(num2*0.01);
                num1=result;
                break;
            }
        }
        if ((result>9999999)||((result>0)&&(result<0.000001))){
            decimal.applyPattern("0.0000E0");
        } else decimal.applyPattern("0.######");

        display.setText(decimal.format(result));
        flag=true;
    }
}