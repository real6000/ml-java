package me.brokeski.activations;

import me.brokeski.core.Matrix;

/**
 * Tanh activation function.
 *
 * 2025
 */
public class Tanh implements ActivationFunction {

    @Override
    public Matrix activate(Matrix input) {
        Matrix result = new Matrix(input.rows, input.cols);
        for (int i = 0; i < input.rows; i++) {
            for (int j = 0; j < input.cols; j++) {
                result.data[i][j] = Math.tanh(input.data[i][j]);
            }
        }
        return result;
    }

    @Override
    public Matrix derivative(Matrix input) {
        Matrix grad = new Matrix(input.rows, input.cols);
        for (int i = 0; i < input.rows; i++) {
            for (int j = 0; j < input.cols; j++) {
                double val = Math.tanh(input.data[i][j]);
                grad.data[i][j] = 1 - val * val;
            }
        }
        return grad;
    }
}