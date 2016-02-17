package by.stormnet.calculator.kuzmin.view;

import by.stormnet.calculator.kuzmin.controller.Calculator;
import by.stormnet.calculator.kuzmin.controller.Checker;
import by.stormnet.calculator.kuzmin.controller.IncompatibleMatrixException;
import by.stormnet.calculator.kuzmin.controller.Matrix;
import by.stormnet.calculator.kuzmin.model.Reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Андрей on 14.02.2016.
 */
public class Main {
    public static void main(String[] args){
    	boolean isMatrix = false;
        Matrix matrix1 = null, matrix2 = null, resultMatrix = null;
        Calculator calc = Calculator.getInstance();
        Reader reader = new Reader();
        char op = ' ';
        double numbers[];
        while(true){

            System.out.println("Would you like to work with matrix? [y/n]");


                BufferedReader yNReader = new BufferedReader(new InputStreamReader(System.in));
                String yN = null;
                try {
                    yN = yNReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            char yNArr[] = null;
            try{
               yNArr = yN.toCharArray();

            }catch (NullPointerException ex){
                break;
            }

            	switch(yNArr[0]){
            		case 'Y':
            			isMatrix = true;
            			break;
            		case 'y':
            			isMatrix = true;
            			break;
            		case 'N':            			
            			break;
            		case 'n':
            			break;            	
            				
            	}
            	

        	if(isMatrix){
                System.out.println("+ - *");
                op = reader.getOp();
                if(!Checker.isChecked()){
                    System.out.println("Wrong operation");
                    continue;
                }


                System.out.println("Enter first matrix filePath");

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String matrix1FilePath = null;
                try {
                    matrix1FilePath = bufferedReader.readLine();
                } catch (IOException e) {
                    System.out.println("Some problems with file");
                    continue;

                }


                try{
                    matrix1 = reader.readMatrix(matrix1FilePath);
                    if (matrix1 == null){
                        continue;
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File " + matrix1FilePath + " not found");
                    continue;

                }
                System.out.println("Enter second matrix filePath");
                String matrix2FilePath = null;
                try {
                    matrix2FilePath = bufferedReader.readLine();
                } catch (IOException e) {
                    System.out.println("Some problems in file");
                    continue;

                }

                try{
                    matrix2 = reader.readMatrix(matrix2FilePath);
                    if (matrix2 == null){
                        continue;
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File " + matrix2FilePath + " not found");
                    continue;

                }
            }

            if(!isMatrix){
                op = reader.getOp();
                if(!Checker.isChecked()){
                    System.out.println("Wrong operation");
                    continue;
                }
            }


            if (!isMatrix){
                System.out.println("Enter numbers");
                numbers = reader.getNumbers();
            }
            else
                numbers = null;
            if(numbers == null && !isMatrix) continue;

            switch(op){
                case '+':
                	if(isMatrix){
                        try {
                            resultMatrix = Matrix.add(matrix1, matrix2);
                        } catch (IncompatibleMatrixException e) {
                            e.printStackTrace();
                        }
                    }
                	else{
                		System.out.println(calc.add(numbers[0], numbers[1]));
                	}
                    break;
                case '-':
                	if(isMatrix){
                        try {
                            resultMatrix = Matrix.sub(matrix1, matrix2);
                        } catch (IncompatibleMatrixException e) {
                            e.printStackTrace();
                        }
                    }
                	else{
                		System.out.println(calc.sub(numbers[0], numbers[1]));
                	}
                    break;
                case '*':
                	if(isMatrix){
                        try {
                            resultMatrix = Matrix.mult(matrix1, matrix2);
                        } catch (IncompatibleMatrixException e) {
                            e.printStackTrace();
                        }
                    }
                	else{
                		System.out.println(calc.mult(numbers[0], numbers[1]));
                	}
                    break;
                case '/':
                    if(isMatrix){
                        System.out.println("Illegal matrix operation");
                    }
                    else {
                        System.out.println(calc.div(numbers[0], numbers[1]));
                    }
                    break;
                case '^':
                    if(isMatrix){
                        System.out.println("Illegal matrix operation");
                    }
                    else {
                        System.out.println(calc.power(numbers[0], numbers[1]));
                    }
                    break;
                default:
                    System.out.println("Error");
            }
            if(isMatrix) {
                Matrix.printMatrix(resultMatrix);
            }
            isMatrix = false;

        }

    }
}
