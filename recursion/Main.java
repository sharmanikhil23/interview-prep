package recursion;

class Main {
    public static void main(String[] args) {
        // basics();
        array();

    }
    
    private static void array() {
        System.out.println("\n\n");
        int[] data = new int[] { 1, 2, 3, 4, 5, 6 };
        System.out.println("This should be sorted array " + Arrays.isSortedArray(data));
        
        data = new int[] { 1, 2, 3, -1, 1 };
        System.out.println("This should not be sorted array " + Arrays.isSortedArray(data));

        System.out.println("\n\n");
        System.out.println("Should be able to find 3 in an array " + Arrays.linearSearch(data, 3));
        
        System.out.println("Should not be able to find 3 in an array " + Arrays.linearSearch(data, -2));
        
        System.out.println("\n\n");
        System.out.println("So we are able to find 1 at indexes "+Arrays.multipleLinearSearch(data, 1));
    }
    
    private static void basics() {
        System.out.println("Printing in the revese Order");
        Basics.printingReverse(10);

        System.out.println("\n\n");

        System.out.println("Printing in Order");
        Basics.printingReverse(10);

        System.out.println("\n\n");
        System.out.println("Testing the fibonacci series of 10 is " + Basics.fibonacci(10));

        System.out.println("\n\n");

        int[] data = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for (int i = 0; i < data.length; i++) {
            if (i != Basics.binarySearch(data, i + 1)) {
                System.out.println("Something is wrong with the algorithm fix it");
            }
        }
        System.out.println("Result of this bunary search should be -1 and we got " + Basics.binarySearch(data, 11));

        System.out.println("\n\n");

        System.out.println("Result of 10! is " + Basics.productOfNumber(10));

        System.out.println("\n\n");

        System.out.println("Result of 1..10 is " + Basics.sumOfNumber(10));

        System.out.println("\n\n");

        System.out.println("Sum of digit 1234 is " + Basics.sumOfDigits(1234));

        System.out.println("\n\n");

        System.out.println("Product of digit 1234 is " + Basics.productOfDigits(1234));

        System.out.println("\n\n");

        System.out.println("Reverse 1234 is " + Basics.reverseNumber(1234));
    }
}
