package algoexpert.sortings;

public class HeapSort {
    public static int[] heapSort(int[] array) {
        // build max heap first
        array = buildMaxHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            // swap the root of max heap with the last element of heap
            swap(0, i, array);
            shiftDown(0, i-1, array);
        }
        return array;

    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    public static int[] buildMaxHeap(int[] array) {
        // grab first parent  from bottom of the heap
        int firstParentIndex = (int) Math.floor((array.length - 2) / 2);
        for (int currentIndex = firstParentIndex; currentIndex >= 0; currentIndex--) {
            shiftDown(currentIndex, array.length - 1, array);
        }


        return array;

    }

    public static void shiftDown(int currentIdx, int endIdx, int[] heap) {
        int childOneIdx = currentIdx * 2 + 1;
        int childTwoIdx = 0;
        while (childOneIdx <= endIdx) {
            if (currentIdx * 2 + 2 <= endIdx) {
                childTwoIdx = 2 * currentIdx + 2;
            } else {
                childTwoIdx = -1;
            }
            int indexToSwap = 0;
            if (childTwoIdx != -1 && heap[childTwoIdx] > heap[childOneIdx]) {
                indexToSwap = childTwoIdx;
            } else {
                indexToSwap = childOneIdx;
            }

            if (heap[indexToSwap] > heap[currentIdx]) {
                swap(currentIdx, indexToSwap, heap);
                // now update currentIdx because, the element which is previously
                // at currentIdx is swapped with the element at indexToSwap
                // we do not know yet if the element we just swapped is at its right position or not
                // so, we track the number by updating the currentIndex
                currentIdx = indexToSwap;
                childOneIdx = currentIdx * 2 + 1;
            } else {
                return ;
            }
        }
    }


}
