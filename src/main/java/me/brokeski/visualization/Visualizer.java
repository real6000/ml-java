package me.brokeski.visualization;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Visualizes data such as training loss over epochs using charts.
 */
public class Visualizer {

    /**
     * Displays a line chart for training loss over time.
     *
     * @param lossHistory List of loss values per epoch.
     */
    public static void showLossChart(List<Double> lossHistory) {
        XYSeries series = new XYSeries("Training Loss");

        for (int epoch = 0; epoch < lossHistory.size(); epoch++) {
            series.add(epoch + 1, lossHistory.get(epoch));
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Training Loss Over Epochs",
                "Epoch",
                "Loss",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(800, 600));

        JFrame frame = new JFrame("Loss Visualization");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
