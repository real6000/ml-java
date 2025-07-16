package me.brokeski.training;

/**
 * Step decay scheduler reduces learning rate by a factor every specified number of epochs.
 *
 * 2025
 */

public class StepDecayScheduler implements LearningRateScheduler{

    private final double initialLearningRate;
    private final int stepSize;
    private final double decayFactor;

    /**
     * Constructs a step decay scheduler.
     *
     * @param initialLearningRate Initial learning rate.
     * @param stepSize Number of epochs between each decay.
     * @param decayFactor Multiplicative factor to decay LR (e.g. 0.5).
     */
    public StepDecayScheduler(double initialLearningRate, int stepSize, double decayFactor) {
        this.initialLearningRate = initialLearningRate;
        this.stepSize = stepSize;
        this.decayFactor = decayFactor;
    }

    @Override
    public double getLearningRate(int epoch) {
        int steps = epoch/stepSize;
        return initialLearningRate * Math.pow(decayFactor, steps);
    }
}
