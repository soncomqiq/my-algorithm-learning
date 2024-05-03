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

    public static void heapSort(Object[] d) {
        int size = d.length;
        for (int k = size / 2 - 1; k >= 0; k--) {
            fixDown(d, size, k);
        }
        for (int k = size - 1; k > 0; k--) {
            swap(d, 0, k);
            fixDown(d, --size, 0);
        }
    }

    static void fixDown(Object[] d, int size, int k) {
        int c;
        while ((c = 2 * k + 1) < size) {
            if (c < size - 1 && lessThan(d[c], d[c + 1])) {
                c++;
            }
            if (!lessThan(d[k], d[c])) {
                break;
            }
            swap(d, c, k);
            k = c;
        }
    }

    public static void mergeSort(Object[] d) {
        mSortR(d, 0, d.length - 1, d.clone());
    }

    private static void mSortR(Object[] d, int left, int right, Object[] tempObj) {
        if (left < right) {
            int middle = (left + right) / 2;
            // sort left side
            mSortR(tempObj, left, middle, d);
            // sort right side
            mSortR(tempObj, middle + 1, right, d);
            // merge
            merge(tempObj, left, middle, right, d);
        }
    }

    private static void merge(Object[] a, int left, int middle, int right, Object[] b) {
        int i = left;
        int j = middle + 1;
        for (int k = left; k <= right; k++) {
            // left side is out of elements
            if (i > middle) {
                b[k] = a[j++];
                continue;
            }

            // right side is out of elements
            if (j > right) {
                b[k] = a[i++];
                continue;
            }

            // If an element's value is lower, it will be inserted into array B, which is the resulting array.
            b[k] = lessThan(a[i], a[j]) ? a[i++] : a[j++];
        }
    }

    public static void quickSort(Object[] d) {
        qSortR(d, 0, d.length - 1);
    }

    private static void qSortR(Object[] d, int left, int right) {
        if (left < right) {
            // partition will return pivot's index
            int j = partition(d, left, right);
            qSortR(d, left, j - 1);
            qSortR(d, j + 1, right);
        }
    }

    private static int partition(Object[] d, int left, int right) {
        // Improve performance by randomizing pivot
        int randomIdx = left + (int) (Math.random() * (right - left + 1));
        swap(d, randomIdx, left);
        Object pivot = d[left];
        int i = left;
        int j = right + 1;

        while (i < j) {
            // don't need to verify if 'j' will be lower than 'left'
            // because it will at least stop at the pivot.
            while (lessThan(pivot, d[--j])) ;

            // need to confirm if 'i' will exceed 'right' in the scenario
            // where the pivot is the maximum value, as 'i' will endlessly increase.
            while (lessThan(d[++i], pivot)) {
                if (i == right) {
                    break;
                }
            }

            // if it's the last step, don't need to swap them
            if (i < j) {
                swap(d, i, j);
            }
        }

        swap(d, left, j);

        return j;
    }
}
