package me.brokeski.data;

import me.brokeski.core.Matrix;

/**
 * Represents a single training example with input and target output.
 *
 * fldr: /src/main/java/me/brokeski/training/
 */

public class DataPoint {

    private final Matrix input;
    private final Matrix target;

    /**
     * Constructs a DataPoints with input and target matrices.
     *
     * @param input Input features matrix.
     * @param target Expected output matrix.
     */
    public DataPoint(Matrix input, Matrix target){
        this.input = input;
        this.target = target;
    }

    /**
     * Returns the input matrix.
     *
     * @return Input matrix.
     */
    public Matrix getInput(){
        return input;
    }

    /**
     * Returns the target matrix.
     *
     * @return Target matrix.
     */
    public Matrix getTarget(){
        return target;
    }
}
