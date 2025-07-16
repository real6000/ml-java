package me.brokeski.model;

import me.brokeski.core.*;
import me.brokeski.layers.Layer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * LayeredModel extends NeuralNetwork with saving/loading capabilities.
 *
 * 2025
 */

public class LayeredModel implements Serializable {

    private final List<Layer> layers;

    public LayeredModel() {
        layers = new ArrayList<>();
    }

    public void addLayer(Layer layer){
        layers.add(layer);
    }

    public List<Layer> getLayers(){
        return layers;
    }

    /**
     * Forward pass through all layers.
     *
     * @param input Input matrix.
     * @return Output matrix after passing through all layers.
     * @return
     */
    public Matrix forward(Matrix input){
        Matrix output = input;
        for(Layer layer : layers){
            output = layer.forward(output);

        }
        return output;
    }

    /**
     * Save model layers to file using serialization.
     *
     * @param path File path.
     * @throws IOException on IO errors.
     */
    public void save(String path) throws IOException{
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(layers);
        }
    }

    /**
     * Load model layers from file;
     *
     * @param path File path.
     * @throws IOException On IO errors.
     * @throws ClassNotFoundException On class mismatch.
     */
    @SuppressWarnings("unchecked")
    public void load(String path) throws IOException, ClassNotFoundException{
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
            Object obj = ois.readObject();
            if(obj instanceof List){
                layers.clear();
                layers.addAll((List<Layer>) obj);
            }
        }
    }
}
