package me.brokeski.visualization;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Visualizes training loss over epochs using a line chart.
 */
public class LossChart extends ApplicationFrame {
    public LossChart(String title, List<Double> lossValues) {
        super(title);
        JFreeChart chart = createChart(lossValues);
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(panel);
    }

    private JFreeChart createChart(List<Double> lossValues){
        XYSeries series = new XYSeries("Loss");

        for(int epoch = 0; epoch < lossValues.size(); epoch++){
            series.add(epoch + 1, lossValues.get(epoch));
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        return ChartFactory.createXYLineChart(
                "Training Loss Over Epochs",
                "Epoch,",
                "Loss",
                dataset
        );
    }

    public static void showChart(List<Double> lossValues){
        LossChart chart = new LossChart("Loss Chart", lossValues);
        chart.pack();
        chart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chart.setVisible(true);
    }
}
