package me.brokeski.io.preprocessing;

import me.brokeski.core.Matrix;

/**
 * Normalizer class to scale input data between 0 and 1, feature-wise (column-wise).
 */
public class Normalizer {
    private double[] minValues;
    private double[] maxValues;

    /**
     * Fits the normalizer on the data, computing min and max per column.
     *
     * @param data Input matrix.
     */
    public void fit(Matrix data) {
        int cols = data.getCols();
        int rows = data.getRows();

        minValues = new double[cols];
        maxValues = new double[cols];

        // Initialize min and max with first row values
        for (int j = 0; j < cols; j++) {
            minValues[j] = data.data[0][j];
            maxValues[j] = data.data[0][j];
        }

        // Compute min and max per column
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (data.data[i][j] < minValues[j]) {
                    minValues[j] = data.data[i][j];
                }
                if (data.data[i][j] > maxValues[j]) {
                    maxValues[j] = data.data[i][j];
                }
            }
        }
    }

    /**
     * Transforms data by scaling features to [0, 1] range using min and max.
     *
     * @param data Input matrix.
     * @return Normalized matrix.
     */
    public Matrix transform(Matrix data) {
        int cols = data.getCols();
        int rows = data.getRows();

        Matrix normalized = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double min = minValues[j];
                double max = maxValues[j];
                double val = data.data[i][j];
                normalized.data[i][j] = (val - min) / (max - min + 1e-8); // avoid divide by zero
            }
        }

        return normalized;
    }

    /**
     * Convenience method: fits and transforms data in one step.
     *
     * @param data Input matrix.
     * @return Normalized matrix.
     */
    public Matrix fitTransform(Matrix data) {
        fit(data);
        return transform(data);
    }
}
