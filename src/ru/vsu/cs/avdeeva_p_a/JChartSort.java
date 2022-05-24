package ru.vsu.cs.avdeeva_p_a;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class JChartSort {

    ChartPanel chartPanel;
    JPanel graphPanel;
    JFrame frame;

    public JChartSort (ChartPanel chartPanel, JPanel graphPanel, JFrame frame) {
        this.chartPanel = chartPanel;
        this.graphPanel = graphPanel;
        this.frame = frame;
    }

    private static double[][] performanceTest(int[] sizes, String[] sortsName) {
        Sort bubbleSort, shakerSort;
        Random rnd = new Random();
        double[][] result = new double[sortsName.length][sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            int[] arr1 = new int[sizes[i]];
            int[] arr2 = new int[sizes[i]];
            for (int j = 0; j < arr1.length; j++) {
                arr1[j] = rnd.nextInt(100000);
                arr2[j] = rnd.nextInt(100000);
            }

            bubbleSort = new BubbleSort(0 , 0);
            shakerSort = new CocktailSort(0 , 0);

            bubbleSort.sort(arr1);
            shakerSort.sort(arr2);

            int moment1 = bubbleSort.getComparisonNumber() + bubbleSort.getExchangesNumber();
            int moment2 = shakerSort.getComparisonNumber() + shakerSort.getExchangesNumber();

            result[0][i] = moment1;
            result[1][i] = moment2;
        }

        return result;
    }

    private void customizeChartDefault(JFreeChart chart) {
        XYPlot plot = chart.getXYPlot();
        XYDataset ds = plot.getDataset();

        for (int i = 0; i < ds.getSeriesCount(); i++) {
            chart.getXYPlot().getRenderer().setSeriesStroke(i, new BasicStroke(2));
        }

        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.setRangeGridlinePaint(Color.BLACK);
    }

    public void performanceTestDemo(String[] sortNames, int[] sizes) {
        double[][] result = performanceTest(sizes, sortNames);

        DefaultXYDataset ds = new DefaultXYDataset();
        double[][] data = new double[2][result.length];
        data[0] = Arrays.stream(sizes).asDoubleStream().toArray();
        for (int i = 0; i < result.length; i++) {
            data = data.clone();
            System.out.println(Arrays.toString(result[i]));
            data[1] = result[i];
            ds.addSeries(sortNames[i], data);
        }

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Sort efficiency",
                "Array dimension (number of elements)",
                "Number of comparisons + number of exchanges",
                ds
        );
        customizeChartDefault(chart);

        final int height = frame.getSize().height;
        final int width = frame.getSize().width;

        if (chartPanel == null) {
            chartPanel = new ChartPanel(chart);
            frame.setSize(width, height * 2);
            graphPanel.add(chartPanel, BorderLayout.CENTER);
            graphPanel.updateUI();

        } else {
            chartPanel.setChart(chart);
        }

    }
}