package ru.vsu.cs.avdeeva_p_a;

public class BubbleSort implements Sort {
    private int comparisonNumber;
    private int exchangesNumber;

    public BubbleSort(int comparisonNumber, int exchangesNumber) {
        this.comparisonNumber = comparisonNumber;
        this.exchangesNumber = exchangesNumber;
    }

    @Override
    public void sort(int[] array) {
        int size = array.length;
        for (int i = 1; i < size - 1; i++) {
            for (int j = size - 1; j >= i; j--) {
                this.comparisonNumber++;
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    this.exchangesNumber++;
                }
            }
        }
    }

    @Override
    public int getComparisonNumber() {
        return comparisonNumber;
    }

    @Override
    public int getExchangesNumber() {
        return exchangesNumber;
    }
}