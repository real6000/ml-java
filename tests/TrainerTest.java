import core.Matrix;
import data.DataPoint;
import data.XORData;
import layers.DenseLayer;
import activations.Sigmoid;
import loss.MSE;
import model.NeuralNetwork;
import training.Trainer;

import java.util.List;

/**
 * Test if Trainer can fit XOR.
 */
public class TrainerTest {
    public static void main(String[] args) {
        NeuralNetwork nn = new NeuralNetwork();
        nn.addLayer(new DenseLayer(2, 4, new Sigmoid()));
        nn.addLayer(new DenseLayer(4, 1, new Sigmoid()));

        List<DataPoint> data = XORData.getDataset();
        Trainer trainer = new Trainer(nn, new MSE(), 0.5, 10_000);
        trainer.train(data);

        System.out.println("Post-training outputs:");
        for (DataPoint dp : data) {
            Matrix out = nn.forward(dp.getInput());
            double predicted = out.toArray()[0];
            System.out.printf("Input: [%s] → %.4f\n",
                    dp.getInput().toArray()[0] + "," + dp.getInput().toArray()[1], predicted);
        }
    }
}
