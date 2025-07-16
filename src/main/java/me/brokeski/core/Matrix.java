package me.brokeski.core;


/**
 * A Lightweight matrix class that serves as the foundation of all math operations
 * used in the neural network. This class includes basic operations such as dot product,
 * addition, transposition, and element-wise function application.
 *
 * This is the core math engine of the ML framework.
 *
 */

public class Matrix {
    public final int rows, cols;
    public double[][] data;

    /**
     * Creates a matrix with the given nmber of rows and columns.
     *
     * @param rows Number of rows.
     * @param cols Number of columns.
     */
    public Matrix(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];

    }

    /**
     * Creates a column matrix from a 1-D array.
     *
     * @param arr Input array.
     * @return A new Matrix object.
     */
    public static Matrix fromArray(double[] arr){
        Matrix m = new Matrix(arr.length, 1);
        for(int i = 0; i < arr.length; i++){
            m.data[i][0] = arr[i];
        }
        return m;
    }

    /**
     * Converts a column matrix to 1D array
     *
     * @return 1D array from the matrix.
     */
    public double[] toArray(){
        double[] arr = new double[rows];
        for(int i = 0; i < rows; i++){
            arr[i] = data[i][0];
        }
        return arr;
    }
    /**
     * Multiplies two matrices using dot product.
     *
     * @param a Left-hand side matrix.
     * @param b Right-hand side matrix.
     * @return The result of matrix multiplication
     */
    public static Matrix dot(Matrix a, Matrix  b){
        if(a.cols != b.rows)
            throw new IllegalArgumentException("Matrix dot: incompatible dimensions.");

        Matrix result = new Matrix(a.rows, b.cols);
        for(int i = 0; i < result.rows; i++){
            for(int j = 0; j < result.cols; j++){
                for(int k = 0; k < a.cols; k++){
                    result.data[i][j] += a.data[i][k] * b.data[k][j];
                }
            }
        }
        return result;
    }
    /**
     * Adds another matrix to this one (element wise).
     *
     * @param m Matrix to add.
     */
    public void add(Matrix m){
        if(m.rows != rows || m.cols != cols)
            throw new IllegalArgumentException("Matrix add: dimensions must match.");

        for (int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                data[i][j] += m.data[i][j];
            }
        }
    }

    /**
     * Applies a function to each element in the matrix
     *
     * @param f Functional interface representing the operation.
     */
    public void applyFunction(Function f){
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                data[i][j] = f.apply(data[i][j]);
            }
        }
    }
    /**
     * Functional interface for element wise function application.
     */
    public interface Function{
        double apply(double x);
    }
    public static Matrix transpose(Matrix m){
        Matrix result = new Matrix(m.cols, m.rows);
        for(int i = 0; i < m.rows; i++){
            for(int j = 0; j < m.cols; j++){
                result.data[j][i] = m.data[i][j];
            }
        }
        return result;
    }

}

