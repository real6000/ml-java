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
    public void addLayer(Layer layer){
        layers.add(layer);
    }

    /**
     * Performs forward pass through all layers.
     *
     * @param input Input matrix.
     * @return Output matrix fro mthe last layer.
     */
    public Matrix forward(Matrix input){
        Matrix output = input;
        for(Layer layer : layers){
            output = layer.forward(output);

        }
        return output;
    }
    /**
     * Performs a single training step using backpropagation.
     *
     * @param input Input data matrix.
     * @param target Expected output matrix.
     * @param learningRate Learning rate for updates.
     */
    public void train(Matrix input, Matrix target, double learningRate){
        //forward pass
        Matrix output = forward(input);

        //Compute simple Mean Squared Error loss gradient: dL/dOutput = 2*(output - target)
        Matrix lossGrad = new Matrix(output.rows, output.cols);
        for(int i =0; i<output.rows; i++){
            for(int j = 0; j < output.cols; j++){
                lossGrad.data[i][j] = 2 * (output.data[i][j] - target.data[i][j]);
            }
        }
        //Backpropagation through layers in reverse order
        Matrix grad = lossGrad;
        for(int i = layers.size() - 1; i >= 0; i--){
            grad = layers.get(i).backward(grad, learningRate);
        }
    }
}
