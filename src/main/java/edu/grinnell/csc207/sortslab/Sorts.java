package edu.grinnell.csc207.sortslab;

/**
 * A collection of sorting algorithms over generic arrays.
 */
public class Sorts {

    /**
     * Swaps indices <code>i</code> and <code>j</code> of array
     * <code>arr</code>.
     *
     * @param <T> the carrier type of the array
     * @param arr the array to swap
     * @param i the first index to swap
     * @param j the second index to swap
     */
    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static <T extends Comparable<T>> int binarySearch(T value, T[] arr, int lo, int hi) {
        if(lo > hi){
            return -1;
        } else {
            int mid = lo + (hi - lo) / 2;
            if(value.compareTo(arr[mid]) < 0) {
                return binarySearch(value, arr, lo, mid);
            } else if (value.compareTo(arr[mid]) > 0) {
                return binarySearch(value, arr, mid + 1, hi);
            } else {
                return mid;
            }
            
        }
    }

    /**
     * Sorts the array according to the bubble sort algorithm:
     * <pre>
     * [ unprocessed | i largest elements in order ]
     * </pre>
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[i]) < 0) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * Sorts the array according to the selection sort algorithm:
     * <pre>
     * [ i smallest elements in order | unprocessed ]
     * </pre>
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] arr) {
        // TODO: fill me in!
        for (int i = 0; i < arr.length - 1; i++) {
            int lowestIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[lowestIndex]) < 0) {
                    lowestIndex = j;
                }
            }
            swap(arr, i, lowestIndex);
        }
    }

    /**
     * Sorts the array according to the insertion sort algorithm:
     * <pre>
     * [ i elements in order | unprocessed ]
     * </pre>
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
        // TODO: fill me in!
        for(int i = 0; i < arr.length -1; i++) {
            for(int j = i + 1; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--){
                    swap(arr, j - 1,j);
                
            }
        }
    }

    /**
     * Sorts the array according to the merge sort algorithm:
     * <pre>
     * [ sorted | sorted ] -> [ sorted ]
     * </pre>
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
        // TODO: fill me in!
        
        
    }

    /**
     * Sorts the array according to the quick sort algorithm:
     * <pre>
     * []
     * </pre>
     *
     * @param <T>
     * @param arr
     */
    public static <T extends Comparable<? super T>> void quickSort(T[] arr) {
        // TODO: fill me in!
    }
}
