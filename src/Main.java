import sorting.ArrayUtil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Selection Sort
        Integer[] arr1 = new Integer[]{3, 4, 7, 23, 54, 3, 2, 6, 7};
        System.out.println(Arrays.stream(arr1).toList());
        ArrayUtil.selectionSort(arr1);
        System.out.println(Arrays.stream(arr1).toList());

        // Selection Sort
        Integer[] arr2 = new Integer[]{3, 4, 7, 23, 54, 3, 2, 6, 7};
        System.out.println(Arrays.stream(arr2).toList());
        ArrayUtil.bubbleSort(arr2);
        System.out.println(Arrays.stream(arr2).toList());

        // Selection Sort
        Integer[] arr3 = new Integer[]{3, 4, 7, 23, 54, 3, 2, 6, 7};
        System.out.println(Arrays.stream(arr3).toList());
        ArrayUtil.insertionSort(arr3);
        System.out.println(Arrays.stream(arr3).toList());
    }
}