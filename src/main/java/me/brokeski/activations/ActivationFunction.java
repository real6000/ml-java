package me.brokeski.activations;

import me.brokeski.core.Matrix;

/**
 * Interface for activation functions used in neural network layers.
 * All activation functions must implement methods for forward activation
 * and computing the derivative used in backpropagation.
 *
 */

public interface ActivationFunction {
    /**
     * Applies the activation function to the given input matrix (element wise).
     *
     * @param input Matrix to activate.
     * @return Activated output.
     */
    Matrix activate(Matrix input);

    /**
     * Computes the derivative of the activation function with respect to input.
     *
     * @param input Input matrix (before activation).
     * @return Derivative matrix.
     */
    Matrix derivative(Matrix input);
}
