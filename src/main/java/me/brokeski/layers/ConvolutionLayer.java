package me.brokeski.layers;

import me.brokeski.core.Matrix;

/**
 * Placeholder for a simple 1D convolution layer.
 * In full CNNs, this would apply filters (kernels) over an input feature map.
 *
 * For now, it just returns the input (identity layer).
 *
 * 2025
 */

public class ConvolutionLayer extends Layer{

    /**
     * For now, this acts as an identity layer -- passes input straight through.
     *
     * @param input Input matrix.
     * @return Same input, unchanged.
     */
    @Override
    public Matrix forward(Matrix input) {
        return input; //placeholdr
    }

    /**
     * Backward also just returns the same gradient.
     *
     * @param outputGradient The gradient coming from the layer ahead.
     * @param learningRate The learning rate (not used)
     * @return Same gradient.
     */
    @Override
    public Matrix backward(Matrix outputGradient, double learningRate) {
        return outputGradient; //placeholder
    }
}
