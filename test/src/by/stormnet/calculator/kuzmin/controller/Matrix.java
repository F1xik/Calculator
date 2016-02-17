package by.stormnet.calculator.kuzmin.controller;

/**
 * Created by Андрей on 15.02.2016.
 */
public class Matrix {
    private int rows;
    private int columns;
    private double matrix[][];

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix(double matrix[][]){
        this.matrix = matrix.clone();
        rows = matrix.length;
        columns = matrix[0].length;
    }

    public static Matrix add(Matrix m1, Matrix m2) throws IncompatibleMatrixException{
        if(m1.getRows() != m2.getRows() || m1.getColumns() != m2.getColumns()){
            throw new IncompatibleMatrixException();
        }
        double result[][] = new double[m1.getRows()][m1.getColumns()];
        for(int i = 0; i < m1.getRows(); i++){
            for(int j = 0; j < m1.getColumns(); j++){
                result[i][j] = m1.getMatrix()[i][j] + m2.getMatrix()[i][j];
            }
        }
        Matrix mResult = new Matrix(result);
        return mResult;
    }
    public static Matrix sub(Matrix m1, Matrix m2) throws IncompatibleMatrixException{
        if(m1.getRows() != m2.getRows() || m1.getColumns() != m2.getColumns()){
            throw new IncompatibleMatrixException();
        }
        double result[][] = new double[m1.getRows()][m1.getColumns()];
        for(int i = 0; i < m1.getRows(); i++){
            for(int j = 0; j < m1.getColumns(); j++){
                result[i][j] = m1.getMatrix()[i][j] - m2.getMatrix()[i][j];
            }
        }
        Matrix mResult = new Matrix(result);
        return mResult;
    }
    public static Matrix mult(Matrix m1, Matrix m2) throws IncompatibleMatrixException{
        if(m1.getRows() != m2.getColumns()){
            throw new IncompatibleMatrixException();
        }
        double sum = 0;
        double result[][] = new double[m1.getRows()][m2.getColumns()];
        for(int i = 0; i < m1.getRows(); i++){
            for(int j = 0; j < m2.getColumns(); j++){
                for(int k = 0; k < m1.getColumns(); k++){
                    sum += m1.getMatrix()[i][k] * m2.getMatrix()[k][j];
                }
                result[i][j] = sum;
                sum = 0;

            }
        }

        Matrix mResult = new Matrix(result);
        return mResult;
    }
    public static void printMatrix(Matrix m){
        for(int i = 0; i < m.getColumns(); i++){
            for(int j = 0; j < m.getColumns(); j++){
                System.out.print(m.getMatrix()[i][j] + " ");
            }
            System.out.println();
        }

    }
}
