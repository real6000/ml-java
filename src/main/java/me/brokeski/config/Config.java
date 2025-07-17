package me.brokeski.config;

/**
 * Central configuration class for tuning model hyperparameters and controlling
 * framework behavior across training, evaluation, and saving/loading.
 */
public class Config {
    private double learningRate;
    private int batchSize;
    private int epochs;
    private boolean normalizeInput;
    private String modelSavePath;

    public Config() {
        // Default values
        this.learningRate = 0.01;
        this.batchSize = 32;
        this.epochs = 10;
        this.normalizeInput = true;
        this.modelSavePath = "models/default_model.bin";
    }

    // Getters and Setters
    public double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    public int getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public int getEpochs() {
        return epochs;
    }

    public void setEpochs(int epochs) {
        this.epochs = epochs;
    }

    public boolean isNormalizeInput() {
        return normalizeInput;
    }

    public void setNormalizeInput(boolean normalizeInput) {
        this.normalizeInput = normalizeInput;
    }

    public String getModelSavePath() {
        return modelSavePath;
    }

    public void setModelSavePath(String modelSavePath) {
        this.modelSavePath = modelSavePath;
    }
}
