package by.stormnet.calculator.kuzmin.model;

import by.stormnet.calculator.kuzmin.controller.Checker;
import by.stormnet.calculator.kuzmin.controller.Matrix;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Андрей on 14.02.2016.
 */
public class Reader {
    private boolean correct = false;
    private Checker checker = new Checker();
    public Reader(){

    }
    public double[] getNumbers(){
        Scanner scanner = new Scanner(System.in);
        double[] input = new double[2];
        double fNumber = 0;
        double sNumber = 0;
        try{
        	System.out.println("Enter first number");
            fNumber = scanner.nextDouble();
            correct = true;
        }catch(Exception e){
            correct = false;
            System.out.println("Error in first number");
            Checker.setNumberCheck(false);
            return null;
        }
        //correct = true;
        if(correct){
            try{
            	System.out.println("Enter second number");
                sNumber = scanner.nextDouble();
                correct = true;
                Checker.setNumberCheck(true);
            }catch(Exception e){
                correct = false;
                Checker.setNumberCheck(false);
                System.out.println("Error in second number");
                return null;
            }

        }


        String str = null;
        str = scanner.nextLine();
        try{
            if(!str.equals("")){
                System.out.println("Error! MORE THEN 2 NUMBERS WERE ENTERED");
                scanner.close();
                return null;
            }
        }catch(Exception e){

        }
        input[0] = fNumber;
        input[1] = sNumber;

        return input;

    }
    public char getOp(){


        System.out.println("Enter type of operation");
        String operation = " ";
        char op = ' ';
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            operation = bufferedReader.readLine();
            op = operation.toCharArray()[0];

        }catch(Exception e){
            System.out.println("Error in type of operation");
            Checker.setCheck(false);
        }
        checker.checkOp(op);


        return op;
    }
    public Matrix readMatrix(String filepath) throws FileNotFoundException {
        double matrix[][];
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(filepath)));
        int rows = 0, columns = 0;
        rows = scanner.nextInt();
        columns = scanner.nextInt();
        matrix = new double[rows][columns];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                try{
                    matrix[i][j] = scanner.nextDouble();
                }catch (NoSuchElementException ex){
                    System.out.println("Wrong matrix format");
                    return null;
                }

            }
        }
        Matrix fileMatrix = new Matrix(matrix);
        scanner.close();
        return fileMatrix;

    }
}
