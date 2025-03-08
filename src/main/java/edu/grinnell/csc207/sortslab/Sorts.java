package edu.grinnell.csc207.sortslab;

import java.util.Arrays;

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
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr, int hi, int lo) {
        if(lo < hi){
            int mid = lo + (hi - lo) / 2;
            
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid + lo, hi);
            
            merge(arr, lo, hi);
        }
        
    }
    
    public static <T extends Comparable<? super T>> T[] merge(T[] arr, int hi, int lo) {
        int mid = lo + (hi - lo) / 2;
        
        T[] arr1;
        arr1 = Arrays.copyOfRange(arr, lo, hi);
        
        int j = 0;
        int k = 0;
        
        for(int i = 0; j < mid && k <= hi; i++){
            if(arr[k].compareTo(arr[j]) <= 0){
                arr[i] = arr1[k];
                k++;
            }
            else{
                arr[i] = arr1[j];
                j++;
            }
        }
        if(k != (mid - lo)){
            for(int l = k; l < (mid - lo); l++){
                arr[l] = arr1[k];
                k++;
            }
        } else if(j != (hi - mid)){
            for(int m = j; m < (hi - mid); m++){
                arr[m] = arr1[j];
                j++;
            }
        }
        return arr1;
        
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
    public static <T extends Comparable<? super T>> void quickSort(T[] arr, int lo, int hi) {
        if(lo < hi){
            int pivot = pivoting(arr, lo, hi);
            
            quickSort(arr, lo, hi - 1);
            quickSort(arr, lo + 1, hi);
        }
    }
    
    public static <T extends Comparable<? super T>> int pivoting(T[] arr, int lo, int hi) {
        T pivot = arr[hi];
        int i = lo - 1;
        
        for(int j = lo; j < hi; j++){
            if (arr[j].compareTo(pivot) <= 0){
                i++;
                
                swap(arr, j, i);
            }
        }
        
        swap(arr, (i + 1), hi);
        
        return i + 1;
    }
    
}
