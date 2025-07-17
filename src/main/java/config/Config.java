package config;


/**
 * Centralized configuration for training parameters and other constants.
 */
public class Config {
    public static final double LEARNING_RATE = 0.01;
    public static final int EPOCHS = 10000;
    public static final int BATCH_SIZE = 32;
    public static final int INPUT_SIZE = 784; //example for MNIST 28x28
    public static final int OUTPUT_SIZE = 10; //number of classes
}
