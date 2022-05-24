package gui;

import myButtons.*;
import org.jfree.chart.ChartPanel;
import utils.JTableUtils;

import javax.swing.*;
import java.awt.*;

public class WindowGUI extends JFrame {
    private JPanel mainPanel;
    private JButton buttonShakerSort;
    private JButton buttonBubbleSort;
    private JButton buttonPerformanceTest;
    private JButton buttonRandom1;
    private JButton buttonRandom2;
    private JButton buttonRandom3;
    private JTable table1;
    private JPanel graphPanel;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JButton button1;
    private JRadioButton firstVariantButtonsRadioButton;
    private JRadioButton secondVariantButtonsRadioButton;
    private ChartPanel chartPanel;

    public WindowGUI() {
        this.setLayout(new FlowLayout());
        this.setTitle("Task4");
        //this.setMaximumSize();
        this.setContentPane(mainPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(100, 100, 920, 350);
        this.setResizable(false);

        radioButton1.setVisible(false);
        radioButton2.setVisible(false);
        buttonBubbleSort.setVisible(false);
        buttonShakerSort.setVisible(false);
        button1.setVisible(false);

        JTableUtils.initJTableForArray(table1, 50, false, true, false, true);
        table1.setRowHeight(20);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(firstVariantButtonsRadioButton);
        group1.add(secondVariantButtonsRadioButton);

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);

        buttonRandom1.addActionListener(new ListenerRandomButton1(table1));
        buttonRandom3.addActionListener(new ListenerRandomButton2(table1));
        buttonRandom2.addActionListener(new ListenerRandomButton3(table1));
        buttonBubbleSort.addActionListener(new ListenerBubbleSortButton(table1));
        buttonShakerSort.addActionListener(new ListenerShakerSortButton(table1));
        buttonPerformanceTest.addActionListener(new ListenerPerformanceTestButton(chartPanel, graphPanel, this));
        button1.addActionListener(new ListenerButton1(table1, radioButton1, radioButton2));

        firstVariantButtonsRadioButton.addActionListener(e -> {
            if (e.getSource() == firstVariantButtonsRadioButton) {
                buttonBubbleSort.setVisible(true);
                buttonShakerSort.setVisible(true);
                button1.setVisible(false);
                radioButton1.setVisible(false);
                radioButton2.setVisible(false);
            }
        });

        secondVariantButtonsRadioButton.addActionListener(e -> {
            if (e.getSource() == secondVariantButtonsRadioButton) {
                buttonBubbleSort.setVisible(false);
                buttonShakerSort.setVisible(false);
                button1.setVisible(true);
                radioButton1.setVisible(true);
                radioButton2.setVisible(true);
            }
        });
    }

    public void setChartPanel(ChartPanel chartPanel) {
        this.chartPanel = chartPanel;
    }
}