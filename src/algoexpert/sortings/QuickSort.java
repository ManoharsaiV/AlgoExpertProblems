package algoexpert.sortings;

import java.util.Arrays;

public class QuickSort {
    public static int[] quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
        return array;
    }

    public static void quickSortHelper(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = startIndex;
        int leftIndex = startIndex + 1;
        int rightIndex = endIndex;
        while (leftIndex <= rightIndex) {

            if ((array[leftIndex] > array[pivotIndex]) && (array[rightIndex] < array[pivotIndex])) {
                // both elements at leftIndex and rightIndex are not sorted w.r.t pivotIndex
                // swap elements at leftIndex and rightIndex
                swap(leftIndex, rightIndex, array);

            }
            if (array[leftIndex] <= array[pivotIndex]) {
                // element at leftIndex is sorted w.r.t element at pivotIndex
                // increment leftIndex
                leftIndex++;
            }
            if (array[rightIndex] >= array[pivotIndex]) {
                // element at rightIndex is sorted w.r.t element at pivotIndex
                // decrement rightIndex
                rightIndex--;
            }
        }
        // swap element at pivotIndex with element at final position of rightIndex
        swap(pivotIndex, rightIndex, array);

        // now again apply the quick sort technique on the two sub arrays
        // apply first on the SubArray with less length
        int leftSubArrayLength = rightIndex - 1 - startIndex;
        int rightSubArrayLength = endIndex - (rightIndex + 1);
        boolean leftSubArraySmaller = leftSubArrayLength < rightSubArrayLength;
        if (leftSubArraySmaller) {
            quickSortHelper(array, startIndex, rightIndex - 1);
            quickSortHelper(array, rightIndex + 1, endIndex);
        } else {
            quickSortHelper(array, rightIndex + 1, endIndex);
            quickSortHelper(array, startIndex, rightIndex - 1);
        }
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{5,4,3,2,1})));
    }
}
