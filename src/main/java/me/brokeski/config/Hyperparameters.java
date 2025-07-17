package me.brokeski.config;

/**
 * Holds core hyperparameters for training.
 */
public class Hyperparameters {
    private double learningRate;
    private int epochs;
    private int batchSize;

    public Hyperparameters(){
        //default values
        this.learningRate = 0.01;
        this.epochs = 10000;
        this.batchSize = 32;
    }

    public Hyperparameters(double learningRate, int epochs, int batchSize) {
        this.learningRate = learningRate;
        this.epochs = epochs;
        this.batchSize = batchSize;
    }

    // Getters and setters
    public double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    public int getEpochs() {
        return epochs;
    }

    public void setEpochs(int epochs) {
        this.epochs = epochs;
    }

    public int getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }
}
