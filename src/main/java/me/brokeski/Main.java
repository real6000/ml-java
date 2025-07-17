package me.brokeski;

import me.brokeski.activations.Sigmoid;
import me.brokeski.data.DataPoint;
import me.brokeski.data.XORData;
import me.brokeski.layers.DenseLayer;
import me.brokeski.loss.LossFunction;
import me.brokeski.loss.MSE;
import me.brokeski.model.NeuralNetwork;
import me.brokeski.training.Trainer;

import java.util.List;

/**
 * Made by real600
 *
 * This is the entry point of a custom machine learning framework written in Java.
 * The project is built from scratch (with inspiration), using only Java and no external libraries.
 * It includes its own matrix math engine, activation functions, neural network layers,
 * loss functions, and training logic — all designed to be expandable.
 * and don't get me wrong I got a lot of heavy inspiration from stack overflow and
 * existing works from others on machine learning.
 *
 * This file will eventually be used to load data, build a model, train it, and evaluate results.
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("ML Framework Starting...");

        // Avengers!!! Assemble.
        NeuralNetwork nn = new NeuralNetwork();
        nn.addLayer(new DenseLayer(2, 4, new Sigmoid()));
        nn.addLayer(new DenseLayer(4, 1, new Sigmoid()));

        List<DataPoint> data = XORData.getDataset();

        LossFunction loss = new MSE();
        Trainer trainer = new Trainer(nn, 0.5, 10000);
        trainer.train(data);

        System.out.println("Training complete. Testing XOR:");

        for(DataPoint dp : data){
            var output = nn.forward(dp.getInput());
            double[] result = output.toArray();
            System.out.printf("Input: %s, Output: %.4f%n", java.util.Arrays.toString(dp.getInput().toArray()), result[0]);
        }
    }
}