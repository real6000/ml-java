package me.brokeski.io.serialization;

import me.brokeski.model.NeuralNetwork;

import java.io.*;

/**
 * Handles saving and loading of trained neural network models.
 * Serialization format: basic Java object stream.
 */

public class ModelIO {

    /**
     * Saves the model to the given file path.
     *
     * @param model The trained neural network to save.
     * @param filepath File path to store the model.
     * @throws IOException In the event that an IO error occurs.
     */
    public static void saveModel(NeuralNetwork model, String filepath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {
            oos.writeObject(model);
            System.out.println("Model saved successfully to " + filepath);
        } catch (IOException e) {
            System.err.println("Failed to save model: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Loads model from disk.
     * @param filePath Path to the saved model file.
     * @return The loaded NeuralNetwork, or null if loading failed.
     */
    public static NeuralNetwork loadModel(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Object obj = ois.readObject();
            if (obj instanceof NeuralNetwork) {
                System.out.println("Model loaded successfully from " + filePath);
                return (NeuralNetwork) obj;
            } else {
                System.err.println("Invalid object in file: not a NeuralNetwork instance.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to load model: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}