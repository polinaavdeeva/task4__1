package myButtons;

import ru.vsu.cs.avdeeva_p_a.BubbleSort;
import ru.vsu.cs.avdeeva_p_a.CocktailSort;
import ru.vsu.cs.avdeeva_p_a.Sort;
import utils.JTableUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class ListenerButton1 implements ActionListener {

    JTable table1;
    JRadioButton radioButton1;
    JRadioButton radioButton2;

    public ListenerButton1(JTable table1, JRadioButton radioButton1, JRadioButton radioButton2) {
        this.table1 = table1;
        this.radioButton1 = radioButton1;
        this.radioButton2 = radioButton2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Sort bubble, shaker;
        int[] array = null;
        if (radioButton1.isSelected()) {
            bubble = new BubbleSort(0, 0);
            try {
                array = JTableUtils.readIntArrayFromJTable(table1);
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
            bubble.sort(array);
        } else if (radioButton2.isSelected()) {
            shaker = new CocktailSort(0, 0);
            try {
                array = JTableUtils.readIntArrayFromJTable(table1);
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
            shaker.sort(array);
        }
        JTableUtils.writeArrayToJTable(table1, array);
    }
}