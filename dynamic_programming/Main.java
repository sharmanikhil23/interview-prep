package dynamic_programming;

import java.time.Instant;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        // question1(45);
        int[] days = new int[] { 1, 4, 6, 7, 8, 20 };
        int[] costs = new int[] { 7, 2, 15 };
        System.out.println(Question12.tabulation(days, costs));
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
