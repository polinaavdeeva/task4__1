package myButtons;

import ru.vsu.cs.avdeeva_p_a.CocktailSort;
import ru.vsu.cs.avdeeva_p_a.Sort;
import utils.JTableUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class ListenerShakerSortButton implements ActionListener {
    JTable table1;

    public ListenerShakerSortButton(JTable table1) {
        this.table1 = table1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Sort shakerSort = new CocktailSort(0, 0);
        int[] array = null;
        try {
            array = JTableUtils.readIntArrayFromJTable(table1);
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }

        shakerSort.sort(array);

        JTableUtils.writeArrayToJTable(table1, array);
    }
}