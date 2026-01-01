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
    

    public static void mergeSort(int[] data) {
        mergeSort(data, 0, data.length-1);
    }
    
    private static void mergeSort(int[] data, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(data, start, mid);
            mergeSort(data, mid + 1, end);
            mergeTogether(data, start, mid, end);
        }
    }
    
    private static void mergeTogether(int[] data, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start; // sybolize the left array or left part
        int j = mid + 1; // sybolize the right array or right part for add
        int index = 0;

        while (i <= mid && j <= end) {
            if (data[i] < data[j]) {
                temp[index++] = data[i++];
            } else {
                temp[index++] = data[j++];
            }
        }

        while (i <= mid) {
            temp[index++] = data[i++];
        }

        while (j <= end) {
            temp[index++] = data[j++];
        }

        index = start;
        for (i = 0; i < temp.length; i++) {
            data[index++] = temp[i];
        }
    }
    
    public static void quickSortLeft(int[] array) {
        quickSortLeft(array, 0, array.length - 1);
    }
    
    private static void quickSortLeft(int[] array, int left, int right) {
        if (left < right) {
            int pivot = pivotLeft(array, left, right);
            quickSortLeft(array, left, pivot - 1);
            quickSortLeft(array, pivot+1, right);
        }
    }
    
    private static int pivotLeft(int[] array, int low, int high) {
        //likely one element
        if (low == high) {
            return low;
        } else {
            int pivot = low;
            int left = low + 1;
            int right = high;

            while (left <= right) {
                while (left <= right && array[left] < array[pivot]) {
                    left++;
                }

                while (left <= right && array[right] > array[pivot]) {
                    right--;
                }

                if (left <= right) {
                    swap(array, left, right);
                    left++;
                    right--;
                }

                swap(array, pivot, right);
            }
            return right;
        }
    }

    public static void quickSortRight(int[] array) {
        quickSortLeft(array, 0, array.length - 1);
    }
    
    private static void quickSortRight(int[] array, int left, int right) {
        if (left < right) {
            int pivot = pivotRight(array, left, right);
            quickSortRight(array, left, pivot - 1);
            quickSortRight(array, pivot+1, right);
        }
    }

    private static int pivotRight(int[] array, int low, int high) {
        //likely one element
        if (low == high) {
            return low;
        } else {
            int pivot = high;
            int left = low;
            int right = high - 1;

            while (left <= right) {
                while (left <= right && array[left] < array[pivot]) {
                    left++;
                }

                while (left <= right && array[right] > array[pivot]) {
                    right--;
                }

                if (left <= right) {
                    swap(array, left, right);
                    left++;
                    right--;
                }
                swap(array, pivot, left);
            }
            return left;
        }
    }
    
    public static void quickSort(int[] array) {
        quickSortLeft(array, 0, array.length - 1);
    }
    
    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = pivotMiddle(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot+1, right);
        }
    }
    // we assume our mid element is in the correct position
    private static int pivotMiddle(int[] array, int low, int high) {
        int mid = (low + high) / 2;
        int left = low;
        int right = high;

        while (left <= right) {
            while (array[left] < array[mid]) {
                left++;
            }

            while (array[right] > array[mid]) {
                right--;
            }

            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }

        return mid;
    }
    // It is the helper method to swap elements
    private static void swap(int[] data, int start, int end) {
        int temp = data[start];
        data[start] = data[end];
        data[end] = temp;
    }
}
