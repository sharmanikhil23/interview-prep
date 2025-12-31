package sorting;

public class Algorithm {
    
    // sort like the bubbles
    public static void bubbleSort(int[] data) {

        int size = data.length;

        for (int i = 0; i < size; i++) {
            for (int j = 1; j < size - i; j++) {
                if (data[j-1] > data[j]) {
                    swap(data, j-1, j);
                }
            }
        }

    }
    
    //find the smallest element and place it to the correct index
    public static void selectionSort(int[] data) {
        
        int size = data.length;
    
        for (int i = 0; i < size; i++) {
            int smallest = i;
            for (int j = i+1; j < size; j++) {
                if (data[smallest] > data[j]) {
                    smallest = j;
                }
            }
            swap(data, i, smallest);
        }
    }
    
    // It's like we sort the cards we pick one card assume it as it is sorted and start sorting around it
    public static void insertionSort(int[] data) {

        int size = data.length;

        for (int i = 1; i < size; i++) {
            int j = i;
            while (j >= 1) {
                if (data[j] < data[j - 1]) {
                    swap(data, j, j - 1);
                }
                j--;
            }
        }
    }
    
    // Cyclic Sort aka place element in the correct index
    public static void cyclicSort(int[] data) {
        int index = 0;

        while (index < data.length) {
            if (data[index] - 1 != index) {
                swap(data, index, data[index] - 1);
            } else {
                index++;
            }
        }
    }
    
    // It is the helper method to swap elements
    private static void swap(int[] data, int start, int end) {
        int temp = data[start];
        data[start] = data[end];
        data[end] = temp;
    }
}
