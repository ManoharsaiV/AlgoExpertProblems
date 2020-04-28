package algoexpert.dynamicprogramming;

public class MaximumSumSubsetWithNoAdjacent {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int[] sumArray = new int[array.length];
        sumArray[0] = array[0];
        sumArray[1] = Math.max(sumArray[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            sumArray[i] = Math.max(sumArray[i - 1], sumArray[i - 2] + array[i]);
        }


        return sumArray[sumArray.length - 1];
    }


    // O(1) space

    public static int maxSubsetSumNoAdjacentImproved(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int first = array[0];
        int second = Math.max(first, array[1]);
        int current = 0;

        for (int i = 2; i < array.length; i++) {
            current = Math.max(second, first + array[i]);
            first = second;
            second = current;
        }

        return second;

    }
}
