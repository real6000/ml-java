package me.brokeski.training;

/**
 * Stochastic Gradient Descent (SGD) optimizer with constant learning rate.
 *
 * 2025
 */

public class SGD implements Optimizer{

    private final double learningRate;

    /**
     * Constructs a basic SGD optimizer.
     *
     * @param learningRate The fixed learning rate to use.
     */
    public SGD(double learningRate) {
        this.learningRate = learningRate;
    }

    @Override
    public double getLearningRate(int currentEpoch) {
        return learningRate;
    }
}
