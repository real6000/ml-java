package me.brokeski.training;

import me.brokeski.core.Matrix;
import me.brokeski.data.DataPoint;
import me.brokeski.model.NeuralNetwork;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Trainer class to handle training loops for a NeuralNetwork.
 * Supports training on batches of DataPoints with specified epochs and learning rate.
 *
 */

public class Trainer {

    private final NeuralNetwork network;
    private final double learningRate;
    private final int epochs;

    /**
     * Constructs a Trainer.
     *
     * @param network NeuralNetwork to train.
     * @param learningRate Learning rate for gradient updates.
     * @param epochs Number of training epochs.
     */
    public Trainer(NeuralNetwork network,double learningRate, int epochs){
        this.network = network;
        this.learningRate = learningRate;
        this.epochs = epochs;
    }

    /**
     * Trains the network on the provided dataset.
     *
     * @param trainingData List of DataPoints (input-target pairs).
     */
    public void train(List<DataPoint> trainingData) {
        for (int epoch = 0; epoch < epochs; epoch++) {
            double totalLoss = 0.0;

            for (DataPoint dp : trainingData) {
                Matrix input = dp.getInput();
                Matrix target = dp.getTarget();

                Matrix prediction = network.forward(input);
                totalLoss += computeLoss(prediction, target);

                Matrix gradient = computeLossGradient(prediction, target);
                network.backward(gradient, learningRate);
                network.update(learningRate);
            }

            double averageLoss = totalLoss / trainingData.size();
            logLoss(epoch, averageLoss);

            if (epoch % 100 == 0) {
                System.out.println("Epoch " + epoch + " | Loss: " + averageLoss);
            }
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

    private void logLoss(int epoch, double loss) {
        try (FileWriter writer = new FileWriter("logs/training_loss.csv", true)) {
            if (epoch == 0) {
                writer.write("epoch,loss\n"); // header
            }
            writer.write(epoch + "," + loss + "\n");
        } catch (IOException e) {
            System.err.println("Error logging training loss: " + e.getMessage());
        }
    }

    /**
     * Computes the gradient of the MSE loss.
     *
     * @param predicted The predicted output matrix.
     * @param target    The actual target matrix.
     * @return The gradient of the loss.
     */
    private Matrix computeLossGradient(Matrix predicted, Matrix target) {
        Matrix gradient = new Matrix(predicted.rows, predicted.cols);
        for (int i = 0; i < predicted.rows; i++) {
            for (int j = 0; j < predicted.cols; j++) {
                gradient.data[i][j] = 2 * (predicted.data[i][j] - target.data[i][j])
                        / (predicted.rows * predicted.cols);
            }
        }
        return gradient;
    }

}
