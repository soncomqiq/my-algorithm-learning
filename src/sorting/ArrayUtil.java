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

    }
}
