# Introduction to Dynamic Programming

## Overview

This repository covers the fundamental concepts of **Dynamic Programming (DP)**.  
The main focus is on converting **recursive solutions** into **optimized DP solutions** using:

- Memoization (Top-Down)
- Tabulation (Bottom-Up)
- Space Optimization

Dynamic Programming is used when problems have **overlapping subproblems** and **optimal substructure**.

---

## Key Concepts

### 1. Memoization (Top-Down)

**Concept:**  
Store the results of expensive recursive calls and reuse them when the same inputs occur again.

**Steps:**

1. Create a DP array initialized with `-1`.
2. Check if the value is already computed:
   ```java
   if (dp[n] != -1) return dp[n];
   ```
3. Store the result before returning:
   ```java
   return dp[n] = recursive_call();
   ```

**Time Complexity:** `O(n)`  
**Space Complexity:** `O(n)`

---

### 2. Tabulation (Bottom-Up)

**Concept:**  
Solve the problem iteratively by building the solution from base cases to the final answer.

**Steps:**

1. Initialize base cases:
   ```java
   dp[0] = 0;
   dp[1] = 1;
   ```
2. Iterate from `2` to `n`.
3. Compute values using previously solved states.

**Time Complexity:** `O(n)`  
**Space Complexity:** `O(n)`

---

### 3. Space Optimization

**Concept:**  
If only the last few states are required, replace the DP array with variables.

**Benefit:**  
Reduces space complexity from `O(n)` to `O(1)`.

---

## How to Identify Dynamic Programming Problems

1. A recurrence relation exists.
2. A recursion tree can be formed.
3. The recursion tree has overlapping subproblems.
4. The problem has optimal substructure.

---

## Practice Problems

- [Fibonacci Series](#fibonacci-series)

---

## Fibonacci Series

The Fibonacci problem is a classic example to understand:

- Recursion

```
public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    TC: O(2^n)
    SC: O(n) for stack
```

- Memoization

```
 public static int fibonacciMemorization(int n) {
        int[] result = new int[n + 1];
        Arrays.fill(result, -1);
        return fibonacciMemorization(n, result);
    }

    private static int fibonacciMemorization(int n, int[] result) {
        if (n == 0 || n == 1) {
            return n;
        } else if (result[n] != -1) {
            return result[n];
        } else {
            return result[n] = fibonacciMemorization(n-1, result) + fibonacciMemorization(n-2,result);
        }
    }
    TC: O(n)
    SC: O(n) + O(n) for stack
```

- Tabulation

```
public static int tabulation(int n) {
        int[] result = new int[n + 1];
        result[1] = 1;

        for (int i = 2; i < n + 1; i++)
            result[i] = result[i - 1] + result[i - 2];

        return result[n];
    }

    TC: O(n)
    SC: O(n)
```

- Space Optimization

```
public static int spaceOptimization(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int first = 0;
        int second = 1;
        int result = 0;

        for (int i = 2; i < n + 1; i++) {
            result = first + second;
            first = second;
            second = result;
        }

        return second;
    }

    TC: O(n)
    SC: O(1)
```

It clearly shows how Dynamic Programming improves performance by avoiding repeated computations.
