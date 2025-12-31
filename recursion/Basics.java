package recursion;

public class Basics {

    /**
     * this will print it in order like 1, 2,3....
     * @param i
     */
    public static void printInOrder(int i) {
        if (i <= 0) {
            return;
        }
        int temp = i - 1;
        printInOrder(temp);
        System.out.println(i);
    }

    /**
     * This will print in the reverse order
     * @param i
     */
    public static void printingReverse(int i) {
        if (i == 0) {
            return;
        }

        System.out.println(i);
        printingReverse(--i);
    }

    /**
     * This is to get the result of the fibonacci just with pure recursion
     */
    public static int fibonacci(int i) {
        if (i == 0 || i == 1) {
            return 1;
        }

        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    /**
     * Binary search please provide the sorted array
     */
    public static int binarySearch(int[] data, int target) {
        return binarySearch(data, target, 0, data.length - 1);
    }

    private static int binarySearch(int[] data, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (data[mid] == target) {
            return mid;
        } else if (data[mid] > target) {
            return binarySearch(data, target, start, end - 1);
        } else {
            return binarySearch(data, target, mid + 1, end);
        }
    }

    /**
     * This is used to product of the numbers
     * @param n
     * int number
     * @return
     * product of the number 
     */
    public static int productOfNumber(int n) {
        if (n == 0) {
            return 1;
        }

        return n * productOfNumber(n - 1);
    }
    
    /**
     * This is used to perform the sum of number
     * @param i
     * @return
     */
    public static int sumOfNumber(int i) {
        if (i == 0) {
            return 0;
        }

        return i + sumOfNumber(i - 1);
    }

    /**
     * This is used to get the sum of the digits
     * 1234 == 1+2+3+4
     */
    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        int divisor = (int) Math.pow(10, digit(n));
        return (n / divisor) + (sumOfDigits((int) n % divisor));
    }
    
    /**
     * This is used to get the product of the digits
     * 1234 == 1*2*3*4
     */
    public static int productOfDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int divisor = (int) Math.pow(10,digit(n));
        return (n / divisor) * (productOfDigits((int) n % divisor));
    }
    
    private static int digit(int n){
        return (int) Math.log10(n);
    }

    public static int reverseNumber(int n) {
        return reverseNumber(n, digit(n) + 1);
    }
    
    private static int reverseNumber(int i, int digits) {
        if (i == 0) {
            return 0;
        }
        int tempDigit = digit(i)+1;
        int divisor = (int) Math.pow(10,digit(i));
        return (int) (Math.pow(10, digits - tempDigit) * (i / divisor)) + reverseNumber(i % divisor, digits);

    }

}
