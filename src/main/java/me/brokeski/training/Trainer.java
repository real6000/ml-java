package me.brokeski.training;

import me.brokeski.core.Matrix;
import me.brokeski.data.DataPoint;
import me.brokeski.loss.LossFunction;
import me.brokeski.model.NeuralNetwork;

import java.util.List;

/**
 * Trainer class to handle training loops for a NeuralNetwork.
 * Supports training on batches of DataPoints with specified epochs and learning rate.
 *
 */

public class Trainer {

    private final NeuralNetwork network;
    private final LossFunction lossFunction;
    private final double learningRate;
    private final int epochs;

    /**
     * Constructs a Trainer.
     *
     * @param network NeuralNetwork to train.
     * @param lossFunction Loss function to use.
     * @param learningRate Learning rate for gradient updates.
     * @param epochs Number of training epochs.
     */
    public Trainer(NeuralNetwork network, LossFunction lossFunction,double learningRate, int epochs){
        this.network = network;
        this.lossFunction = lossFunction;
        this.learningRate = learningRate;
        this.epochs = epochs;
    }

    /**
     * Trains the network on the provided dataset.
     *
     * @param dataset List of DataPoints (input-target pairs).
     */
    public void train(List<DataPoint> dataset){
        for(int epoch = 1; epoch <= epochs; epoch++){
            double totalLoss = 0;
            for(DataPoint dp : dataset){
                Matrix output = network.forward(dp.getInput());
                Matrix grad = lossFunction.derivative(output, dp.getTarget());
                totalLoss += lossFunction.compute(output, dp.getTarget());
                network.train(dp.getInput(), dp.getTarget(), learningRate); // still uses internal gradient
                network.train(dp.getInput(), grad, learningRate);
            }
            double averageLoss = totalLoss / dataset.size();
            System.out.printf("Epoch %d/%d - Loss: %.6f%n", epoch, epochs, averageLoss);
        }
    }

    /**
     * Computes Mean Squared Error loss between output and target.
     *
     * @param output Output matrix from the network.
     * @param target Expected target matrix.
     * @return Mean squared error.
     */
    private double computeLoss(Matrix output, Matrix target) {
        double sum = 0;
        for (int i = 0; i < output.rows; i++) {
            for (int j = 0; j < output.cols; j++) {
                double diff = output.data[i][j] - target.data[i][j];
                sum += diff * diff;
            }
        }
        return sum / (output.rows * output.cols);
    }

}
