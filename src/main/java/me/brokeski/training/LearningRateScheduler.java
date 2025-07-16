package me.brokeski.training;

/**
 * Interface for learning rate schedulers that adjust LR over epochs.
 *
 * 2025
 */

public interface LearningRateScheduler {

    /**
     * Returns the learning rate for the given epoch.
     *
     * @param epoch Current epoch (starting at 1).
     * @return Learning rate to use.
     */
    double getLearningRate(int epoch);
}
