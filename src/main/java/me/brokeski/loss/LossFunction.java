package me.brokeski.loss;

import me.brokeski.core.Matrix;

/**
 * Interface for loss functions used in neural network training.
 * Provides methods to compute loss and its gradient.
 *
 * Produced in 2025
 */

public interface LossFunction {

    /**
     * Computes the loss value between output and target.
     *
     * @param output The predicted output from the model.
     * @param target The true expected output.
     * @reutrn Scalar loss value.
     */
    double compute(Matrix output, Matrix target);

    /**
     * Computes the gradient of the loss with respect to the output.
     *
     * @param output The predicted output.
     * @param target The true expected output.
     * @return Gradient matrix (same shape as output).
     */
    Matrix derivative(Matrix output, Matrix target);
}
