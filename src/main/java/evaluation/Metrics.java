package evaluation;

import me.brokeski.core.Matrix;

/**
 * Provides evaluation metrics for machine learning models.
 */
public class Metrics {

    /**
     * Calculates accuracy by comparing predicted and actual matrices.
     * Assumed one-hot encoded outputs and compares argmax indices per row.
     *
     * @param predicted Model output predictions.
     * @param actual Ground truth labels.
     * @return Accuracy as a value between 0 and 1
     */
    public static double accuracy(Matrix predicted, Matrix actual){
        int correct = 0;
        int total = predicted.getRows();

        for(int i = 0; i < total; i++){
            int predictedIndex = argMax(predicted, i);
            int actualIndex = argMax(actual, i);
            if(predictedIndex == actualIndex){
                correct++;
            }
        }
        return (double) correct / total;
    }

    private static int argMax(Matrix matrix, int row){
        int maxIndex = 0;
        double maxVal = matrix.data[row][0];

        for(int j = 1; j < matrix.getCols(); j++){
            if(matrix.data[row][j] > maxVal){
                maxVal = matrix.data[row][j];
                maxIndex = j;
            }
        }
        return maxIndex;
    }
}
