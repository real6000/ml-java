package me.brokeski.core;

/**
 * Vector utility class for converting arrays into 1D Matrix columns or rows.
 * Helps when reshaping raw input/output arrays.
 *
 * 2025
 */

public class Vector {

    /**
     * Vector utility class for converting arrays into 1D Matrix columns or rows.
     * Helps when reshaping raw input/output arrays.
     *
     * Made by real600
     */
    public static Matrix fromArray(double[] values) {
        Matrix m = new Matrix(values.length, 1);
        for (int i = 0; i < values.length; i++) {
            m.data[i][0] = values[i];
        }
        return m;
    }

    /**
     * Creates a row matrix (1 x n) from a 1D array.
     *
     * @param values The input values.
     * @return Row vector Matrix.
     */
    public static Matrix fromArrayAsRow(double[] values) {
        Matrix m = new Matrix(1, values.length);
        for (int i = 0; i < values.length; i++) {
            m.data[0][i] = values[i];
        }
        return m;
    }


    /**
     * Converts a column matrix to a 1D array.
     *
     * @param m A matrix with one column.
     * @return A 1D array.
     */
    public static double[] toArray(Matrix m) {
        if (m.cols != 1) {
            throw new IllegalArgumentException("Matrix must have one column to convert to array");
        }
        double[] arr = new double[m.rows];
        for (int i = 0; i < m.rows; i++) {
            arr[i] = m.data[i][0];
        }
        return arr;
    }
}
