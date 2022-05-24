package myButtons;

import org.jfree.chart.ChartPanel;
import ru.vsu.cs.avdeeva_p_a.JChartSort;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerPerformanceTestButton implements ActionListener {

    ChartPanel chartPanel;
    JPanel graphPanel;
    JFrame frame;

    public ListenerPerformanceTestButton(ChartPanel chartPanel, JPanel graphPanel, JFrame frame) {
        this.chartPanel = chartPanel;
        this.graphPanel = graphPanel;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] sortNames = {"Bubble", "Shaker"};
        int[] sizes = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
        JChartSort graph = new JChartSort(chartPanel, graphPanel, frame);
        graph.performanceTestDemo(sortNames, sizes);
    }
}