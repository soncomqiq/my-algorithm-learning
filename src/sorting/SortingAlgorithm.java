package sorting;

import java.util.Arrays;

public class SortingAlgorithm {


    public SortingAlgorithm() {

    }

    public void run() {
        int noOfElements = 50000;
        int maxValue = 500000;
        Integer[] randomArray = new Integer[noOfElements];
        for (int i = 0; i < noOfElements; i++) {
            randomArray[i] = (int) (Math.random() * maxValue);
        }

        testSortingPerformance(SortingAlgo.SELECTION, randomArray.clone(), false);
        testSortingPerformance(SortingAlgo.BUBBLE, randomArray.clone(), false);
        testSortingPerformance(SortingAlgo.INSERTION, randomArray.clone(), false);
        testSortingPerformance(SortingAlgo.HEAP, randomArray.clone(), false);
        testSortingPerformance(SortingAlgo.MERGE, randomArray, false);
        testSortingPerformance(SortingAlgo.QUICK, randomArray.clone(), false);
    }

    public Integer[] testSortingPerformance(SortingAlgo algo, Integer[] sortingArr, boolean printArr) {
        System.out.printf("========== %s SORT ==========\n", algo.toString());
        long timeStart = System.nanoTime();
        if (printArr) {
            System.out.print("Before :");
            System.out.println(Arrays.stream(sortingArr).toList());
        }
        switch (algo) {
            case BUBBLE -> ArrayUtil.bubbleSort2(sortingArr);
            case SELECTION -> ArrayUtil.selectionSort(sortingArr);
            case INSERTION -> ArrayUtil.insertionSort(sortingArr);
            case HEAP -> ArrayUtil.heapSort(sortingArr);
            case MERGE -> ArrayUtil.mergeSort(sortingArr);
            case QUICK -> ArrayUtil.quickSort(sortingArr);
        }
        long timeEnd = System.nanoTime();
        if (printArr) {
            System.out.print("After :");
            System.out.println(Arrays.stream(sortingArr).toList());
        }
        System.out.printf("Total time is %f sec\n", ((double) (timeEnd - timeStart)) / 1000000000);
        return sortingArr;
    }
}
