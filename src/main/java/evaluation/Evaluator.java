package evaluation;

import me.brokeski.core.Matrix;


public class Evaluator {

    /**
     * Computes classification accuracy by comparing predicted and actual labels.
     * Assumes each output matrix is a column vector with one-hot encoded values.
     *
     * @param predictions Predicted output matrix (each column = prediction).
     * @param labels Actual labels matrix (one-hot encoded, each column = label).
     * @return Accuracy as a value between 0 and 1.
     */
    public static double computeAccuracy(Matrix predictions, Matrix labels){
        if(predictions.cols != labels.cols || predictions.rows != labels.rows){
            throw new IllegalArgumentException("Matrix dimensions must match for accuracy computation.");

        }

        int correct = 0;
        int total = predictions.cols;

        for(int col = 0; col < total; col++){
            int predictedIdx = argMax(predictions, col);
            int actualIdx = argMax(labels, col);

            if(predictedIdx == actualIdx){
                correct++;
            }
        }
        return (double) correct / total;
    }


    private static int argMax(Matrix m, int col){
        double max = m.data[0][col];
        int idx = 0;
        for(int i = 1; i < m.rows; i++){
            if(m.data[i][col] > max){
                max = m.data[i][col];
                idx = i;
            }
        }
        return idx;

    }
}
