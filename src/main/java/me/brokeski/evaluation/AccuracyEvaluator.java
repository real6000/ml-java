package me.brokeski.evaluation;

import me.brokeski.core.Matrix;

/**
 * Evaluates the accuracy of predictions compared to actual labels.
 */
public class AccuracyEvaluator {

    /**
     * Calculates the accuracy percentage.
     *
     * @param predictions Matrix where each row is a prediction.
     * @param actuals     Matrix where each row is the actual label.
     * @return Accuracy as a percentage (0–100).
     */
    public double evaluate(Matrix predictions, Matrix actuals) {
        if (predictions.rows != actuals.rows || predictions.cols != actuals.cols) {
            throw new IllegalArgumentException("Matrix dimensions must match for evaluation.");
        }

        int correct = 0;
        for (int i = 0; i < predictions.rows; i++) {
            int predictedIndex = maxIndex(predictions.data[i]);
            int actualIndex = maxIndex(actuals.data[i]);
            if (predictedIndex == actualIndex) {
                correct++;
            }
        }

        return 100.0 * correct / predictions.rows;
    }

    private int maxIndex(double[] row) {
        int maxIdx = 0;
        for (int i = 1; i < row.length; i++) {
            if (row[i] > row[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
