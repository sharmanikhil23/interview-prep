package sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World from the sorting");
        int[] data = new int[] { 5, 4, 3, 2, 1 };
        System.out.println("Before sorting "+Arrays.toString(data));
        Algorithm.bubbleSort(data);
        System.out.println("After sorting  " + Arrays.toString(data));
        
        data = new int[] { 5, 4, 3, 2, 1 };
        System.out.println("Before sorting "+Arrays.toString(data));
        Algorithm.selectionSort(data);
        System.out.println("After sorting  " + Arrays.toString(data));

        data = new int[] { 5, 4, 3, 2, 1 };
        System.out.println("Before sorting "+Arrays.toString(data));
        Algorithm.insertionSort(data);
        System.out.println("After sorting  " + Arrays.toString(data));

        data = new int[] { 5, 4, 3, 2, 1 };
        System.out.println("Before sorting "+Arrays.toString(data));
        Algorithm.cyclicSort(data);
        System.out.println("After sorting  " + Arrays.toString(data));
    }
    
}
