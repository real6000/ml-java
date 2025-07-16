import activations.Sigmoid;
import core.Matrix;
import data.DataPoint;
import data.XORData;
import layers.DenseLayer;
import loss.MSE;
import model.NeuralNetwork;
import training.Trainer;
import utils.Logger;

import java.util.List;

/**
 * Demonstrates XOR training using the framework.
 *
 * 2025
 */
public class XORExample {
    public static void main(String[] args) {
        Logger.info("Starting XOR example...");

        NeuralNetwork nn = new NeuralNetwork();
        nn.addLayer(new DenseLayer(2, 4, new Sigmoid()));
        nn.addLayer(new DenseLayer(4, 1, new Sigmoid()));

        List<DataPoint> data = XORData.getDataset();
        Trainer trainer = new Trainer(nn, new MSE(), 0.5, 10000);
        trainer.train(data);

        Logger.info("Training complete. Testing predictions:");

        for (DataPoint dp : data) {
            Matrix out = nn.forward(dp.getInput());
            double prediction = out.toArray()[0];
            System.out.printf("Input: [%s] → %.4f\n",
                    dp.getInput().toArray()[0] + "," + dp.getInput().toArray()[1], prediction);
        }
    }
}
