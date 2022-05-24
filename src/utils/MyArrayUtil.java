package utils;

import java.util.Random;

public class MyArrayUtil {
    public static int[] setRandomArray(int numElements, int arrSize) {
        Random rnd = new Random();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = rnd.nextInt(numElements) + 1;
        }
        return arr;
    }

    public static int[] setArr() {
        Random rnd = new Random();
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(50) + 1;
        }
        return arr;
    }
}