package by.stormnet.calculator.kuzmin.controller;

/**
 * Created by Андрей on 14.02.2016.
 */
public class Calculator {
    private static Calculator instance;
    private Calculator(){};

    public static Calculator getInstance(){
        if(instance == null){
            instance = new Calculator();
        }
        return instance;
    }

    public int add(int a, int b){
        return a + b;
    }

    public double add(double a, double b){
        return a + b;
    }

    public int sub(int a, int b){
        return a - b;
    }

    public double sub(double a, double b){
        return a - b;
    }

    public double div(int a, int b){
        return (float)a / b;
    }

    public double div(double a, double b){
        return (double)a / b;
    }

    public int power(int pow, int num){
        int result = num;
        for(int i = 0; i < pow - 1; i++){
            result *= num;
        }
        return result;
    }

    public double power(double pow, double num){
        double result = num;
        int intPow = (int)pow;
        for(int i = 0; i < intPow - 1; i++){
            result *= num;
        }
        return result;
    }

    public int mult(int a, int b){
        return a * b;
    }

    public double mult(double a, double b){
        return a * b;
    }
}
