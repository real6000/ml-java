package me.brokeski.layers;

/**
 * Abstract class representing a neural network layer.
 * Each layer must implement methods for forward and backward passes.
 *
 * Layers are stackable and can have their own weights, biases, and gradients.
 *
 */

import me.brokeski.core.Matrix;

public abstract class Layer {

    /**
     * Performs the forward pass using the given input matrix.
     *
     * @param input The input matrix for this layer.
     * @return The output matrix after applying this layer.
     */
    public abstract Matrix forward(Matrix input);

    /**
     * Performs the backward pass using the gradient from the next layer.
     *
     * @param outputGradient The gradient coming from the layer ahead.
     * @param learningRate The learnign rate to apply during weight updates.
     * @return The gradient with respect to the input of this layer.
     */
    public abstract Matrix backward(Matrix outputGradient , double learningRate);
}
