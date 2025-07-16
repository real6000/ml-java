package me.brokeski.layers;

import me.brokeski.activations.ActivationFunction;
import me.brokeski.core.Matrix;

import java.util.Random;

/**
 * Fully connected layer (Dense Layer) with weights, biases,
 * and an activation function. Used in feedforward neural networks.
 *
 */

public class DenseLayer extends Layer{

    private final int inputSize, outputSize;
    private Matrix weights, bias;
    private Matrix inputCache, zCache;
    private final ActivationFunction activation;

    /**
     * Constructs a dense layer with the given input/output size and activation function.
     *
     * @param inputSize Number of input neurons.
     * @param outputSize Number of output neurons.
     * @param activation Activation function to use.
     * @return
     */
    public DenseLayer(int inputSize, int outputSize, ActivationFunction activation) {
        this.inputSize = inputSize;
        this.outputSize = outputSize;
        this.activation = activation;

        this.weights = new Matrix(outputSize, inputSize);
        this.bias = new Matrix(outputSize, 1);
        randomizeParameters();
    }

    private void randomizeParameters(){
        Random rand = new Random();
        for(int i = 0; i<weights.rows; i++)
            for(int j = 0; j < weights.cols; j++)
                weights.data[i][j] = rand.nextGaussian() * 0.01;

        for(int i = 0; i < bias.rows; i++)
            bias.data[i][0] = 0.0;
    }

    /**
     * Forward pass: Z = W*X + B -> A = activation(Z)
     *
     * @param input Input matrix of shape (inputSize x 1)
     * @return Output matrix (after activation)
     */
    @Override
    public Matrix forward(Matrix input) {
        inputCache = input;
        zCache = Matrix.dot(weights, input);
        zCache.add(bias);
        return activation.activate(zCache);
    }

    /**
     * Backward pass: computes gradients sand updates weights and bias:
     *
     * @param outputGradient Gradient from next layer (∂L/∂A)
     * @param learningRate Learning rate for parameter updates
     * @return Gradient to pass to previous layer (∂L/∂X)
     */
    @Override
    public Matrix backward(Matrix outputGradient, double learningRate) {
        Matrix dZ = new Matrix(zCache.rows, zCache.cols);
        Matrix activated = activation.activate(zCache);
        Matrix dA = outputGradient;

        for(int i = 0; i < dZ.rows; i++)
            for(int j = 0; j < dZ.cols; j++)
                dZ.data[i][j] = dA.data[i][j] * activation.derivative(zCache).data[i][j];

        Matrix dW = Matrix.dot(dZ, Matrix.transpose(inputCache));
        Matrix dB = dZ;

        //update weights and biases
        for (int i = 0; i < weights.rows; i++)
            for (int j = 0; j < weights.cols; j++)
                weights.data[i][j] -= learningRate * dW.data[i][j];

        for (int i = 0; i < bias.rows; i++)
            bias.data[i][0] -= learningRate * dB.data[i][0];

        return Matrix.dot(Matrix.transpose(weights), dZ);
    }
}
