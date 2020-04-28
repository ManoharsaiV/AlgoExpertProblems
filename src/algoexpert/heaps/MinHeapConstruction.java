package algoexpert.heaps;

import java.util.ArrayList;
import java.util.List;

public class MinHeapConstruction {
    List<Integer> heap = new ArrayList<Integer>();

    public MinHeapConstruction(List<Integer> array) {
        heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array) {
        // grab firstParent Node index from bottom
        int firstParentNodeIdx = (array.size() - 2) / 2;
        for (int currIndex = firstParentNodeIdx; currIndex >= 0; currIndex--) {
            siftDown(currIndex, array.size() - 1, array);
        }

        return array;

    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
        int childOneIdx = 2 * currentIdx + 1;
        int childTwoIdx = 0;
        while (childOneIdx <= endIdx) {
            if (currentIdx * 2 + 2 <= endIdx) {
                childTwoIdx = 2 * currentIdx + 2;
            } else {
                childTwoIdx = -1;
            }
            int indexToSwap = 0;
            if (childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
                indexToSwap = childTwoIdx;
            } else {
                indexToSwap = childOneIdx;
            }

            if (heap.get(indexToSwap) < heap.get(currentIdx)) {
                swap(currentIdx, indexToSwap, heap);
                currentIdx = indexToSwap;
                childOneIdx = currentIdx * 2 + 1;
            } else {
                return;
            }
        }
    }

    public void siftUp(int currentIdx, List<Integer> heap) {
        int parentIdx = (int) Math.floor((currentIdx - 1) / 2);
        while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
            swap(currentIdx, parentIdx, heap);
            currentIdx = parentIdx;
            parentIdx = (int) Math.floor((currentIdx - 1) / 2);
        }
    }

    public int peek() {
        return heap.get(0);
    }

    public int remove() {
        // swap root with the last value of heap
        swap(0, heap.size() - 1, heap);
        // value to be removed is the last value
        int valueToRemove = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);
        siftDown(0, heap.size() - 1, heap);
        return valueToRemove;

    }

    public void insert(int value) {
        heap.add(value);
        siftUp(heap.size() - 1, heap);
    }

    public void swap(int i, int j, List<Integer> heap) {
        Integer temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void printHeap(List<Integer> heap) {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(1);
        for (int i = 1; i < 9; i++) {
            array.add(array.get(i - 1) + 1);
        }
        MinHeapConstruction m = new MinHeapConstruction(array);
        System.out.println(m.buildHeap(array));
    }
}
