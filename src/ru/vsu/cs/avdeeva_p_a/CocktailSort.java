package ru.vsu.cs.avdeeva_p_a;

public class CocktailSort implements Sort {
    private int comparisonNumber;
    private int exchangesNumber;

    public CocktailSort(int comparisonNumber, int exchangesNumber) {
        this.comparisonNumber = comparisonNumber;
        this.exchangesNumber = exchangesNumber;
    }

    @Override
    public void sort(int[] arr) {
        int temp;
        int leftSide = 0;
        int rightSide = arr.length - 1;
        do {
            for (int i = leftSide; i < rightSide; i++) {
                this.comparisonNumber++;
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    this.exchangesNumber++;
                }
            }
            rightSide--;
            for (int i = rightSide; i > leftSide; i--) {
                this.comparisonNumber++;
                if (arr[i] < arr[i - 1]) {
                    temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    this.exchangesNumber++;
                }
            }
            leftSide++;
        } while (leftSide < rightSide);
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