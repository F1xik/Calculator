package by.stormnet.calculator.kuzmin.controller;

/**
 * Created by Андрей on 14.02.2016.
 */
public class Checker {
    private static boolean checked = false;
    private static boolean numberChecked = true;
    public static boolean isChecked(){
        return checked && numberChecked;
    }
    public static void setCheck(boolean flag){
        checked = flag;
    }
    public static void setNumberCheck(boolean flag){
        numberChecked = flag;
    }
    public void checkOp(char op){
        switch(op){
            case '+':
                checked = true;
                break;
            case '-':
                checked = true;
                break;
            case '*':
                checked = true;
                break;
            case '/':
                checked = true;
                break;
            case '^':
                checked = true;
                break;
            default: checked = false;
        }

    }
}
