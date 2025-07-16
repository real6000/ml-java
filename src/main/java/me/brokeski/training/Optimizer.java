package me.brokeski.training;

/**
 * Optimizer interface for updating model parameters during training.
 * Intended to be passed into layers or the trainer.
 *
 * Produced in 2025
 */

public interface Optimizer {
    /**
     * Returns the current learning rate, which may change over time.
     *
     * @param currentEpoch The current training epoch (starting at 1).
     * @return The learning rate to use.
     */
    double getLearningRate(int currentEpoch);
}