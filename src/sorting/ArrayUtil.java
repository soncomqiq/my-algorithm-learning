package sorting;

public class ArrayUtil {
    public static void swap(Object[] d, int i, int j) {
        Object temp = d[i];
        d[i] = d[j];
        d[j] = temp;
    }

    private static boolean lessThan(Object a, Object b) {
        return ((Comparable) a).compareTo(b) < 0;
    }

    public static void selectionSort(Object[] d) {
        for (int k = d.length - 1; k > 0; k--) {
            int max = k;
            for (int i = 0; i < k; i++) {
                if (lessThan(d[max], d[i])) {
                    max = i;
                }
            }
            swap(d, max, k);
        }
    }

    public static void bubbleSort(Object[] d) {
        for (int k = d.length - 1; k > 0; k--) {
            for (int i = 0; i < k; i++) {
                if (lessThan(d[i + 1], d[i])) {
                    swap(d, i, i + 1);
                }
            }
        }
    }

    public static void bubbleSort2(Object[] d) {
        for (int k = d.length - 1; k > 0; k--) {
            boolean sorted = true;
            for (int i = 0; i < k; i++) {
                if (lessThan(d[i + 1], d[i])) {
                    swap(d, i, i + 1);
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

    public static void insertionSort(Object[] d) {
        for (int k = 1; k < d.length; k++) {
            Object t = d[k];
            int j = k - 1;
            while (j >= 0 && lessThan(t, d[j])) {
                d[j + 1] = d[j];
                j--;
            }
            d[j + 1] = t;
        }
    }

    // h-sequence -> 1,2,4,8, --> O(n^2)
    // Sedgewick 1,8,23,77 --> O(n^(4/3))
    public static void shellSort(Object[] d) {
        for (int h = d.length / 2; h > 0; h /= 2) {
            for (int m = 0; m < h; m++) {
                for (int k = h + m; k < d.length; k += h) {
                    Object t = d[k];
                    int j = k - h;
                    while (j >= 0 && lessThan(t, d[j])) {
                        d[j + h] = d[j];
                        j -= h;
                    }
                    d[j + h] = t;
                }
            }

        }
    }

    // Optimized by Gonnet
    public static void shellSortGonnet(Object[] d) {
        for (int h = d.length / 2; h > 0; h = h == 2 ? 1 : (int) (h / 2.2)) {
            for (int m = 0; m < h; m++) {
                for (int k = h + m; k < d.length; k += h) {
                    Object t = d[k];
                    int j = k - h;
                    while (j >= 0 && lessThan(t, d[j])) {
                        d[j + h] = d[j];
                        j -= h;
                    }
                    d[j + h] = t;
                }
            }

        }
    }
}
