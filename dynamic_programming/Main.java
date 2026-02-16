package dynamic_programming;

import java.time.Instant;
import java.util.Stack;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        // question1(45);
        int[] costs = new int[] { 1, 1 };
        largestRectangleArea(costs);
        System.out.println(Question27.recursion(costs));
    }

    static class Data {
        int height;
        int index;

        public Data(int h, int i) {
            this.height = h;
            this.index = i;
        }
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Data> data = new Stack<>();
        int maxHeight = 0;

        for (int i = 0; i < heights.length; i++) {
            // if stack is empty or prev added element is smaller then the new one
            if (data.isEmpty() || data.peek().height <= heights[i]) {
                data.push(new Data(heights[i], i));
                maxHeight = Math.max(maxHeight, heights[i]);
            } else {
                Data temp = null;
                while (data.isEmpty() == false && data.peek().height > heights[i]) {
                    temp = data.peek();
                    data.pop();
                    maxHeight = Math.max(maxHeight, temp.height * (i - temp.index));
                }
                // mean all elements are removed
                if (data.isEmpty()) {
                    data.push(new Data(heights[i], 0));
                } else {
                    data.push(new Data(heights[i], temp.index));
                }

                maxHeight = Math.max(maxHeight, heights[i] * (i - data.peek().index));
            }
        }
        int n = heights.length - 1;
        while (data.isEmpty() == false) {
            maxHeight = Math.max(maxHeight, data.peek().height * (n - data.peek().index));
            data.pop();
        }

        return maxHeight;
    }

    public static void question1(int n) {
        Instant start = Instant.now();
        System.out.println("Basic Recursion " + Question1.fibonacci(n));
        System.out.println("It is done in " + Duration.between(start, Instant.now()).toNanos());

        start = Instant.now();
        System.out.println("Memorization " + Question1.fibonacciMemorization(n));
        System.out.println("It is done in " + Duration.between(start, Instant.now()).toNanos());

        start = Instant.now();
        System.out.println("Tabulation " + Question1.tabulation(n));
        System.out.println("It is done in " + Duration.between(start, Instant.now()).toNanos());

        start = Instant.now();
        System.out.println("Space Optimization " + Question1.spaceOptimization(n));
        System.out.println("It is done in " + Duration.between(start, Instant.now()).toNanos());
    }

}
