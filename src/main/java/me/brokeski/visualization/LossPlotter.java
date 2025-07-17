package me.brokeski.visualization;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.List;

/**
 * Visualizes training loss over epochs using a line chart.
 */
public class LossPlotter extends JFrame {
    private final DefaultCategoryDataset dataset;

    public LossPlotter(String title){
        super(title);
        dataset = new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createLineChart(
                "Training Loss Over Epochs",
                "Epoch",
                "Loss",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );
        setContentPane(new ChartPanel(chart));
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * Adds a single loss value for a given epoch to the plot.
     *
     * @param epoch Epoch number.
     * @param loss  Loss value.
     */
    public void addLoss(int epoch, double loss){
        dataset.addValue(loss, "Loss", Integer.toString(epoch));
    }

    /**
     * Adds a full list of losses to the plot.
     *
     * @param losses List of loss values.
     */
    public void setLosses(List<Double> losses){
        for(int i = 0; i < losses.size(); i++){
            dataset.addValue(losses.get(i), "Loss", Integer.toString(i + 1));
        }
    }

    /**
     * Displays the plot window.
     */
    public void showPlot(){
        setVisible(true);
    }
}
