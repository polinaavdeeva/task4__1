package myButtons;

import ru.vsu.cs.avdeeva_p_a.BubbleSort;
import ru.vsu.cs.avdeeva_p_a.Sort;
import utils.JTableUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class ListenerBubbleSortButton implements ActionListener {
    JTable table1;

    public ListenerBubbleSortButton(JTable table1) {
        this.table1 = table1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Sort bubbleSort = new BubbleSort(0, 0);
        int[] array = null;
        try {
            array = JTableUtils.readIntArrayFromJTable(table1);
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }

        ((BubbleSort) bubbleSort).sort(array);

        JTableUtils.writeArrayToJTable(table1, array);
    }
}