package me.brokeski.model;

import me.brokeski.core.Matrix;
import me.brokeski.layers.Layer;

import java.util.ArrayList;
import java.util.List;

/**
 * NeuralNetwork class that manages a stack of layers.
 * Provides methods for forward inference and training with backpropagation.
 *
 */
public class NeuralNetwork {

    private final List<Layer> layers = new ArrayList<>();

    /**
     * Adds a layer to the neural network.
     *
     * @param layer Layer to add.
     */
    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    /**
     * Performs forward pass through all layers.
     *
     * @param input Input matrix.
     * @return Output matrix fro mthe last layer.
     */
    public Matrix forward(Matrix input) {
        Matrix output = input;
        for (Layer layer : layers) {
            output = layer.forward(output);

        }
        return output;
    }

    /**
     * Performs the backward pass through the entire network.
     *
     *
     * @param gradOutput The gradient of the loss with respect to the network output.
     * @param learningRate The learning rate.
     */
    public void backward(Matrix gradOutput, double learningRate){
        for (int i = layers.size() - 1; i >= 0; i--){
            gradOutput = layers.get(i).backward(gradOutput, learningRate);
        }
    }

    /**
     * Updates all layer weights using the specified learning rate.
     *
     * @param learningRate The learning rate to use for weight updates.
     */
    public void update(double learningRate) {
        for (Layer layer : layers) {
            layer.update(learningRate);
        }
    }

    /**
     * Performs a single training step using backpropagation.
     *
     * @param input Input data matrix.
     * @param outputGradient Gradient from loss function.
     * @param learningRate Learning rate.
     */
    public void train(Matrix input, Matrix outputGradient, double learningRate) {
        // Forward first to cache values
        forward(input);

        // Backpropagate using external gradient
        Matrix grad = outputGradient;
        for (int i = layers.size() - 1; i >= 0; i--) {
            grad = layers.get(i).backward(grad, learningRate);
        }
    }
}