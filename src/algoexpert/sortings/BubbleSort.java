package algoexpert.sortings;

import java.util.Arrays;

public class BubbleSort {
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }
        int counter = 0;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1 - counter; i++) {
                if (array[i] > array[i + 1]) {
                    swap(i, i + 1, array);
                    isSorted = false;
                }
            }
            counter++;
        }

        return array;
    }

    public static void swap(int i, int j, int[] array) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{8, 5, 2, 9, 5, 6, 3})));
    }

}
