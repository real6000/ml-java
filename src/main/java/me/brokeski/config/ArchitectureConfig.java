package me.brokeski.config;

/**
 * Defines the archiecture of the neural network.
 */
public class ArchitectureConfig {
    private int inputNodes;
    private int hiddenNodes;
    private int outputNodes;
    private int hiddenLayers;

    public ArchitectureConfig(){
        // Default: 1 hidden layer with 16 nodes
        this.inputNodes = 2;
        this.hiddenNodes = 16;
        this.outputNodes = 1;
        this.hiddenLayers = 1;
    }

    public ArchitectureConfig(int inputNodes, int hiddenNodes, int outputNodes, int hiddenLayers) {
        this.inputNodes = inputNodes;
        this.hiddenNodes = hiddenNodes;
        this.outputNodes = outputNodes;
        this.hiddenLayers = hiddenLayers;
    }

    public int getInputNodes() {
        return inputNodes;
    }

    public void setInputNodes(int inputNodes) {
        this.inputNodes = inputNodes;
    }

    public int getHiddenNodes() {
        return hiddenNodes;
    }

    public void setHiddenNodes(int hiddenNodes) {
        this.hiddenNodes = hiddenNodes;
    }

    public int getOutputNodes() {
        return outputNodes;
    }

    public void setOutputNodes(int outputNodes) {
        this.outputNodes = outputNodes;
    }

    public int getHiddenLayers() {
        return hiddenLayers;
    }

    public void setHiddenLayers(int hiddenLayers) {
        this.hiddenLayers = hiddenLayers;
    }
}

