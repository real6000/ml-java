package me.brokeski.activations;

import me.brokeski.core.Matrix;

/**
 * Sigmoid activation function.
 * f(x) = 1 / (1 + e^(-x))
 * Derivative: f'(x) = f(x) * (1 - f(x))
 *
 */

public class Sigmoid implements ActivationFunction{

    @Override
    public Matrix activate(Matrix input){
        Matrix out = new Matrix(input.rows, input.cols);
        for(int i = 0; i<input.rows; i++){
            for(int j = 0; j< input.cols; j++){
                out.data[i][j] = 1.0/ (1.0 + Math.exp(-input.data[i][j]));

            }
        }
        return out;
    }
    @Override
    public Matrix derivative(Matrix input){
        Matrix activated = activate(input);
        Matrix derivative = new Matrix(input.rows, input.cols);
        for (int i = 0; i < input.rows; i++) {
            for (int j = 0; j < input.cols; j++) {
                double val = activated.data[i][j];
                derivative.data[i][j] = val * (1 - val);
            }
        }
        return derivative;
    }
}
