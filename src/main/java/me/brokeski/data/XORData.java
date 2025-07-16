package me.brokeski.data;

import me.brokeski.core.Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides the XOR dataset for training/testing.
 *
 * Produced in 2025
 */

public class XORData {

    /**
     * Returns a list of DataPoint objects representing the XOR truth table.
     *
     * Inputs and targets are column matrices.
     *
     * @return List of XOR DataPoints.
     */
    public static List<DataPoint> getDataset(){
        List<DataPoint> dataset = new ArrayList<>();

        double[][] inputs = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 1}
        };

        double[][] outputs = {
                {0},
                {1},
                {1},
                {0}
        };

        for (int i = 0; i < inputs.length; i++) {
            Matrix input = Matrix.fromArray(inputs[i]);
            Matrix target = Matrix.fromArray(outputs[i]);
            dataset.add(new DataPoint(input, target));
        }

        return dataset;
    }
}
