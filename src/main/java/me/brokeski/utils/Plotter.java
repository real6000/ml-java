package me.brokeski.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Plotter utility to export training data (loss, accuracy, etc.)
 * to CSV files for visualization outside Java.
 * It can be used to save data to a CSV with this eg. function:
 * "Plotter.saveToCSV(lossList, "loss.csv", "Loss");"
 *
 * 2025
 */

public class Plotter {

    public static void saveToCSV(List<Double> values, String filename, String header){
        try(FileWriter writer = new FileWriter(filename)){
            writer.write(header + "\n");
            for(double val : values){
                writer.write(val + "\n");
            }
        }catch(IOException e){
            Logger.error("Failed to write CSV: " + e.getMessage());
        }
    }
}
