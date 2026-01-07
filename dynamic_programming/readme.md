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

1. [Fibonacci Series](#fibonacci-series)
2. [Minimum Cost to Climb Stair](#minimum-cost-to-climb-stair)
3. [Minimum Number of Coins](#minimum-number-of-coins)
4. [Maximum sum with non adjacent element](#maximum-sum-with-non-adjacent-element)
5. [House Robbers 1](#house-robbers)
6. [Maximum Cut segment](#maximum-cut-segment)

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

## Minimum Cost to Climb Stair

- Recursion

```
public static int recursion(int[] cost) {
        return Math.min(recursion(cost, 0), recursion(cost, 1));
    }

    private static int recursion(int[] cost, int index) {
        // already left the top
        if (index > cost.length - 1) {
            return 0;
        } else if (index == cost.length - 1) {
            return cost[index];
        } else {
            return cost[index] + Math.min(recursion(cost, index + 1), recursion(cost, index + 2));
        }
    }

```

- Memoization

```
public static int memorization(int[] cost) {
        int[] result = new int[cost.length + 1];
        Arrays.fill(result, -1);
        int left = memorization(cost, 0, result);
        Arrays.fill(result, -1);
        int right = memorization(cost, 1, result);
        return Math.min(left,right);
    }

    private static int memorization(int[] cost, int index, int[] result) {
        // already left the top
        if (index > cost.length - 1) {
            return 0;
        } else if (index == cost.length - 1) {
            return cost[index];
        } else if (result[index] != -1) {
            return result[index];
        } else {
            return result[index] = cost[index]
                    + Math.min(memorization(cost, index + 1, result), memorization(cost, index + 2, result));
        }
    }
```

- Tabulation

  little tricky start from what we know:

  we know we can start from index 0 and 1 and has it's result
  and final result will be minimum of last 2 index as from both index we can be on top or pass top with just 1 hop and cost of that hop is 0

```
public static int tabulation(int[] n) {
        int[] result = new int[n.length];
        result[0] = n[0];
        result[1] = n[1];

        for (int i = 2; i < n.length; i++) {
            result[i] = Math.min(result[i - 1], result[i - 2]) + n[i];
        }

        return Math.min(result[result.length - 2], result[result.length - 1]);
    }
```

- Space Optimization

```
public static int spaceOptimization(int[] n) {
        int first = n[0];
        int second = n[1];
        int result;

        for(int i=2;i<n.length;i++){
            result = Math.min(first, second) + n[i];
            first = second;
            second = result;
        }

        return Math.min(first,second);
    }
```

## Minimum Number Of Coins

- Recursion

```
public static int recursion(int[] data, int target) {
        int result = recur(data, target);
        return result != Integer.MAX_VALUE ? result : -1;
    }

    private static int recur(int[] data, int target) {
        if (target == 0) {
            return 0;
        } else if (target < 0) {
            return Integer.MAX_VALUE;
        } else {
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < data.length; i++) {
                int res = recur(data, target - data[i]);

                if (res != Integer.MAX_VALUE) {
                    result = Math.min(result,1 + res);
                }
            }
            return result;
        }
    }
   TC O(K^N)
   SC (N)
```

- Memoization

```
public static int memorization(int[] data, int target) {
        int[] results = new int[target + 1];
        Arrays.fill(results, -1);
        int result = memo(data, target, results);
        return result != Integer.MAX_VALUE ? result : -1;
    }

    private static int memo(int[] data, int target, int[] results) {
        if (target == 0) {
            return 0;
        } else if (target < 0) {
            return Integer.MAX_VALUE;
        } else if(results[target] != -1){
            return results[target];
        }else {
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < data.length; i++) {
                int res = memo(data, target - data[i],results);

                if (res != Integer.MAX_VALUE) {
                    result = Math.min(result, 1 + res);
                }
            }
            return results[target] = result;
        }
    }

    T.C O(N*K)
    S.C O(N) + O(N)
```

- Tabulation

```
public static int tabulation(int[] data, int target) {
        int[] result = new int[target + 1];

        for (int i = 1; i < result.length; i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < data.length; j++) {
                int newTarget = i - data[j];

                if (newTarget >= 0 && result[newTarget] != Integer.MAX_VALUE) {
                    temp = Math.min(temp, 1 + result[newTarget]);
                }
            }
            result[i] = temp;
        }

        return result[target];
    }

    T.C O(N*K)
    S.C O(N)
```

- Space Optimization

```
Not possible as number of data can be of any size so not feasible to keep track of everything in an array
```

## Maximum sum with non adjacent element

- Recursion

```
    public static int recursion(int[] data) {
        return recursion(data, 0);
    }

    private static int recursion(int[] data, int index) {
        if (index >= data.length) {
            return 0;
        }

        int no = recursion(data, index + 1);
        int yes = data[index] + recursion(data, index + 2);

        return Math.max(no, yes);
    }
    TC O(2^n)
    SC O(n)
```

- Memoization

```
    public static int memorization(int[] data) {
        int[] result = new int[data.length + 1];
        Arrays.fill(result, -1);
        return memorization(data, 0, result);
    }

    private static int memorization(int[] data, int index, int[] result) {
        if (index >= data.length) {
            return 0;
        }

        if (result[index] != -1) {
            return result[index];
        }

        int no = memorization(data, index + 1, result);
        int yes = data[index] + memorization(data, index + 2, result);

        return result[index] = Math.max(no, yes);
    }
    sc: O(n)
    tc: O(n)
```

- Tabulation

```
    public static int tabulation(int[] data) {
        if (data.length == 0) {
            return 0;
        } else if (data.length == 1) {
            return data[0];
        }

        int[] result = new int[data.length + 1];
        result[0] = 0; // no data
        result[1] = data[0]; // if only 1 element
        result[2] = Math.max(data[0], data[1]); // if 2 element

        for (int i = 3; i < result.length; i++) {
            int no = result[i - 1];
            int yes = data[i - 1] + result[i - 2];
            result[i] = Math.max(yes, no);
        }

        return result[data.length];
    }
sc: O(n)
tc: O(n)
```

- Space Optimization

```
    public static int spaceOptimization(int[] data) {
         if (data.length == 0) {
            return 0;
        } else if (data.length == 1) {
            return data[0];
        } else {
            int first = data[0];
            int second = Math.max(data[0], data[1]);
            for (int i = 2; i < data.length; i++) {
                int no = second;
                int yes = data[i] + first;
                first = second;
                second = Math.max(yes, no);
            }
            return second;
        }

    }
    TC: O(n)
    SC: 1

```

## House Robbers

- Recursion

```
    public static int recursion(int[] data) {
        return recursion(data, 0);
    }

    private static int recursion(int[] data, int index) {
        if (index >= data.length) {
            return 0;
        }

        int takeIT = data[index] + recursion(data, index + 2);
        int notTakeIt = recursion(data, index + 1);

        return Math.max(takeIT, notTakeIt);
    }

    TC: O(2^n)
    SC: O(n) (stack)
```

- Memoization

```
    public static int memorization(int[] data) {
        int[] result = new int[data.length];
        Arrays.fill(result, -1);
        return memorization(data, 0, result);
    }

    private static int memorization(int[] data, int index, int[] result) {
        if (index >= data.length) {
            return 0;
        }

        if (result[index] != -1) {
            return result[index];
        }
        int takeIT = data[index] + memorization(data, index + 2, result);
        int notTakeIt = memorization(data, index + 1, result);

        return result[index] = Math.max(takeIT, notTakeIt);
    }
    TC: O(n)
    SC: O(n) (stack) + O(n) (array)
```

- Tabulation

```
    public static int tabulation(int[] data) {
        if (data.length == 1) {
            return data[0];
        } else if (data.length == 2) {
            return Math.max(data[0], data[1]);
        } else {
            int[] result = new int[data.length + 1];
            result[1] = data[0];
            result[2] = Math.max(data[0], data[1]);
            for (int i = 3; i < result.length; i++) {
                int takeIt = data[i - 1] + result[i - 2];
                int notTakeIt = result[i - 1];
                result[i] = Math.max(takeIt, notTakeIt);
            }
            return result[data.length];
        }
    }
    TC: O(n)
    SC: O(n) (array)
```

- Space Optimization

```
public static int spaceOptimization(int[] data) {
        if (data.length == 1) {
            return data[0];
        } else if (data.length == 2) {
            return Math.max(data[0], data[1]);
        } else {
            int first = data[0];
            int second = Math.max(data[0], data[1]);
            for (int i = 2; i < data.length; i++) {
                int takeIt = data[i] + first;
                int notTakeIt = second;
                first = second;
                second = Math.max(takeIt, notTakeIt);
            }
            return second;
        }
    }
```

## Maximum Cut segment

- Recursion

```
public static int recursion(int length, int x, int y, int z) {
        if (length == 0) {
            return 0;
        } else if (length < 0) {
            return Integer.MIN_VALUE;
        } else {
            int first = 1 + recursion(length - x, x, y, z);
            int second = 1 + recursion(length - y, x, y, z);
            int third = 1 + recursion(length - z, x, y, z);

            return Math.max(first, Math.max(second, third));
        }
    }
TC: O(3^n)
SC: O(n)
```

- Memoization

```
private static int memorization(int length, int x, int y, int z, int[] result) {
        if (length == 0) {
            return 0;
        } else if (length < 0) {
            return Integer.MIN_VALUE;
        } else if (result[length] != -1) {
            return result[length];
        } else {
            int first = 1 + memorization(length - x, x, y, z, result);
            int second = 1 + memorization(length - y, x, y, z, result);
            int third = 1 + memorization(length - z, x, y, z, result);

            return result[length] = Math.max(first, Math.max(second, third));
        }
    }

    TC:O(n)
    SC:O(n) + O(n)
```

- Tabulation

```
public static int tabulation(int length, int x, int y, int z) {
        int[] result = new int[length + 1];

        int[] cuts = { x, y, z };

        for (int i = 1; i <= length; i++) {
            int temp = Integer.MIN_VALUE;
            for (int cut : cuts) {
                if (i - cut >= 0 && result[i - cut] >= 0) {
                    temp = Math.max(temp, 1 + result[i - cut]);
                }
            }
            result[i] = temp;
        }

        return result[length] == Integer.MIN_VALUE ? 0 : result[length];
    }

    TC: O(n)
    SC: O(n)
```

- Space Optimization

```
Not possible as x,y,z are variables and it will be hard for us know for what particular values we need to store it so not feasible
```

Has similar time and space complexicity as fibonacci series

- Recursion
- Memoization
- Tabulation
- Space Optimization
