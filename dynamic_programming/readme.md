# Introduction to Dynamic Programming

## Overview

This repository covers the fundamental concepts of **Dynamic Programming (DP)**.  
The main focus is on converting **recursive solutions** into **optimized DP solutions** using:

- Memoization (Top-Down)
- Tabulation (Bottom-Up)
- Space Optimization

Dynamic Programming is used when problems have **overlapping subproblems** and **optimal substructure**.

---

## Tip

1. Aways keep top down and bottom up approach moving in different direction then it become wasy to come with approach
2. It is also important to make sure from which side you will start solving as it can mess up the time complexicity for you

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
7. [Count Dearrangement](#count-dearrangement) ☢️ Very Important
8. [Painting Fence Algorithm](#painting-fence-algorithm) ☢️ Very Important
9. [Combination Sum 4](#combination-sum-4)
10. [Knap Sack Problem](#knap-sack-problem) ☢️ Very Important
11. [Perfect Square](#perfect-square) ☢️ Very Important
12. [Minimum Cost for Tickets](#minimum-cost-for-tickets) ☢️ Very Important
13. [Maximum Square](#maximum-square) ☢️ Very Important
14. [Min Score Triangulation of Polygon ](#min-score-tiangulation-of-polygon) ☢️ Very Important
15. [Minimum Sideway Jumps](#minimum-sideway-jumps) ☢️ Very Important
16. [Reducing Dishes](#reducing-dishes) ☢️ Better Solution with Greedy
17. [Longest Increasing Subsequence](#longest-increasing-subsequence) ☢️ Very Important must try as can be optimized more after space optimization
18. [Maximum height by stacking cuboid]()☢️ Very Important and very hard to understand
19. [Pizza with 3n Slices ](#pizza-with-3n-slices)☢️ Very Important
20. [Number of Dice Rolls With Target Sum](#number-of-dice-rolls-with-target-sum) Can be further optimized with sliding window
21. [Partition Equal Subset Sum](#partition-equal-subset-sum)
22. [Longest Arithmetic Subsequence](#longest-arithmetic-subsequence)☢️ Very Important must try
23. [Longest Arithmetic Subsequence of Given Difference](#longest-arithmetic-subsequence-of-given-difference)☢️ Very Important must try
24. [Minimum Cost Tree From Leaf Values](#minimum-cost-tree-from-leaf-values)☢️ Very Important must try (can be more optmized with stacks)
25. [Best Time to Buy and Sell Stock](#best-time-to-buy-and-sell-stock)☢️ Very Important must try (Think simple not just with the mind of recursion)
26. [Best Time to Buy and Sell Stock II](#best-time-to-buy-and-sell-stock-II)☢️ Very Important must try
27. [Best Time to Buy and Sell Stock III](#best-time-to-buy-and-sell-stock-III)☢️ Very Important must try(for tabulation just think to cover all states and don't over think)
28. [Best Time to Buy and Sell Stock IV](#best-time-to-buy-and-sell-stock-IV)☢️ Very Important must try
29. [Best Time to Buy and Sell Stock V](#best-time-to-buy-and-sell-stock-V)☢️ Very Important must try (chanllange to manage all of the states)

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

## Count Dearrangement

- Recursion

```
public static int recursion(int n) {
        if (n == 0 || n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return n - 1 * (recursion(n - 1) + recursion(n - 2));
        }
    }

TC: O(2^n)
SC: O(n)
```

- Memoization

```
public static int memorization(int n) {
        int[] result = new int[n + 1];
        Arrays.fill(result, -1);
        return memorization(n, result);
    }

    private static int memorization(int n, int[] result) {
        if (n == 0 || n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (result[n] != -1) {
            return result[n];
        } else {
            return result[n] = (n - 1) * (memorization(n - 1, result) + memorization(n - 2, result));
        }
    }

    TC: O(n)
    SC: 2*O(n)
```

- Tabulation

```
public static int tabulation(int n) {
        if (n == 0 || n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            int[] result = new int[n + 1];
            result[2] = 1;

            for (int i = 3; i < result.length; i++) {
                result[i] = (i - 1) * (result[i - 1] + result[i - 2]);
            }

            return result[n];
        }
    }
    TC: O(n)
    SC: O(n)
```

- Space Optimization

```
public static int spaceOptimization(int n) {
         if (n == 0 || n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            int first = 0;
            int second = 1;
            for (int i = 3; i <= n; i++) {
                int result = (i - 1) * (first + second);
                first = second;
                second = result;
            }
            return second;
        }
    }
TC: O(n)
TC: O(1)
```

## Painting Fence Algorithm

- Recursion

```
    public static int recursion(int n, int k) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return k;
        } else if (n == 2) {
            return k + (k * (k - 1));
        } else {
            return (k - 1) * (recursion(n - 1, k) + recursion(n - 2, k));
        }
    }
    TC:O(2^n)
    SC: O(n)
```

- Memoization

```
public static int memorization(int n, int k) {
        int[] result = new int[n + 1];
        Arrays.fill(result, -1);
        return memorization(n, k, result);
    }

    private static int memorization(int n, int k, int[] result) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return k;
        } else if (n == 2) {
            return k + (k * (k - 1));
        } else if (result[n] != -1) {
            return result[n];
        } else {
            return result[n] = (k - 1) * (memorization(n - 1, k, result) + memorization(n - 2, k, result));
        }
    }
    Tc:O(n)
    sc:2*O(n)
```

- Tabulation

```
public static int tabulation(int n, int k) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return k;
        } else if (n == 2) {
            return k + (k * (k - 1));
        } else {
            int[] result = new int[n + 1];
            result[1] = k;
            result[2] = k + (k * (k - 1));

            for (int i = 3; i <= n; i++) {
                result[i] = (k - 1) * (result[i - 1] + result[i - 2]);
            }

            return result[n];
        }
    }
    Tc:O(n)
    sc:O(n)
```

- Space Optimization

```
public static int spaceOptimization(int n, int k) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return k;
        } else if (n == 2) {
            return k + (k * (k - 1));
        } else {
            int first = k;
            int second = k + (k * (k - 1));

            for (int i = 3; i <= n; i++) {
                int result = (k - 1) * (first + second);
                first = second;
                second = result;
            }

            return second;
        }
    }
    Tc:O(n)
    sc:O(1)
```

## Knap Sack Problem

- Recursion

```
public static int recursion(int w, int val[], int wt[]) {
        return recursion(w, val, wt, 0);
    }

    private static int recursion(int w, int val[], int wt[], int index) {
        if (index >= val.length) {
            return 0;
        } else if (w <= 0) {
            return 0;
        } else {
            int takeIt = 0;
            if (wt[index] <= w) {
                takeIt = val[index] + recursion(w - wt[index], val, wt, index + 1);
                ;
            }

            int ignoreIt = recursion(w, val, wt, index + 1);

            return Math.max(takeIt, ignoreIt);
        }
    }

    TC: O(2^n)
    SC: O(N)
```

- Memoization

```
public static int memorization(int w, int val[], int wt[]) {
        int[][] result = new int[w + 1][val.length + 1];
        for (int[] r : result) {
            Arrays.fill(r, -1);
        }
        return memorization(w, val, wt, 0, result);
    }

    private static int memorization(int w, int val[], int wt[], int index,int[][] result
    ) {
        if (index >= val.length) {
            return 0;
        } else if (w <= 0) {
            return 0;
        } else if (result[w][index] != -1) {
            return result[w][index];
        } else {
            int takeIt = 0;
            if (wt[index] <= w) {
                takeIt = val[index] + memorization(w - wt[index], val, wt, index + 1, result);
            }

            int ignoreIt = memorization(w, val, wt, index + 1, result);

            return result[w][index] = Math.max(takeIt, ignoreIt);
        }
    }
    TC: O(n*w)
    SC: O(n*W)
```

- Tabulation

```
// This works but become hard to further optimize as it depend now on variable rows which is bad so switch it use index as rows and weight as columns
    public static int tabulation(int w, int val[], int wt[]) {
        int[][] result = new int[w + 1][val.length + 1];
        for (int i = 0; i < w + 1; i++) {
            for (int j = 0; j < val.length + 1; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = 0;
                } else {
                    int take = 0;
                    if (wt[j - 1] <= i) {
                        take = val[j - 1] + result[i - wt[j - 1]][j - 1];
                    }
                    int notTake = result[i][j - 1];

                    result[i][j] = Math.max(take, notTake);
                }
            }
        }
        return result[w][val.length];
    }

    // now in this one as result is just depend on the one above it so
    public static int tabulation1(int w, int val[], int wt[]) {
        int[][] result = new int[val.length + 1][w + 1];
        // first loop is for index and second is for the weight
        for (int i = 0; i < val.length + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = 0;
                } else {
                    int take = 0;
                    if (wt[i - 1] <= j) {
                        take = val[i - 1] + result[i-1][j - wt[i - 1]];
                    }
                    int notTake = result[i-1][j];

                    result[i][j] = Math.max(take, notTake);
                }
            }
        }
        return result[val.length][w];
    }


    TC: O(n*w)
    SC: O(w*n)
```

- Space Optimization

```
public static int spaceOptimizationTwoArrays(int w, int val[], int wt[]) {
    // prev represents result[i-1], curr represents result[i]
    int[] prev = new int[w + 1];
    int[] curr = new int[w + 1];

    for (int i = 1; i <= val.length; i++) {
        for (int j = 1; j <= w; j++) {
            int take = 0;
            if (wt[i - 1] <= j) {
                // Look at the previous row (prev) for the remaining capacity
                take = val[i - 1] + prev[j - wt[i - 1]];
            }
            // Look at the previous row (prev) for the 'notTake' case
            int notTake = prev[j];

            curr[j] = Math.max(take, notTake);
        }
        // Very Important: Copy current row to previous row for the next item
        // Or simply: prev = curr.clone();
        // Better yet, just swap references to avoid extra copying:
        System.arraycopy(curr, 0, prev, 0, w + 1);
    }
    return prev[w];
}

TC: O(n*w)
SC: O(w)

    public static int spaceOptimized(int w, int val[], int wt[]) {
    int[] dp = new int[w + 1];

    for (int i = 0; i < val.length; i++) {
        // Go backwards to ensure we use each item only once
        for (int cap = w; cap >= wt[i]; cap--) {
            dp[cap] = Math.max(dp[cap], val[i] + dp[cap - wt[i]]);
        }
    }
    return dp[w];
    }

    TC: O(n*w)
    SC: O(w)
```

## Combination Sum 4

- Recursion

```
    public static int recursion(int[] data, int target) {
        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        } else {
            int result = 0;
            for (int i = 0; i < data.length; i++) {
                result += recursion(data, target - data[i]);
            }
            return result;
        }
    }
    TC:O(3^n)
    SC:O(n)

```

- Memoization

```
 public static int memorization(int[] data, int target) {
        int[] result = new int[target + 1];
        Arrays.fill(result, -1);
        return memorization(data, target, result);
    }

    private static int memorization(int[] data, int target, int[] result) {
        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        } else if (result[target] != -1) {
            return result[target];
        } else {
            int r = 0;
            for (int i = 0; i < data.length; i++) {
                r += memorization(data, target - data[i], result);
            }
            return result[target] = r;
        }
    }

    TC:O(n)
    SC:2*O(n)
```

- Tabulation

```
    public static int tabulation(int[] data, int target) {
        int[] result = new int[target + 1];
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            int temp = 0;
            for (int j = 0; j < data.length; j++) {
                if (i - data[j] >= 0) {
                    temp += result[i - data[j]];
                }
            }
            result[i] = temp;
        }
        return result[target];
    }

    TC:O(target*size of data)
    SC:O(n)
```

- Space Optimization

```
Cannot be done as we do not know to which previous it depend on
```

## Perfect Square

- Recursion

```
 public static int recursion(int n) {
        if (n == 0) {
            return 0;
        }

        int max = Integer.MAX_VALUE;

        for (int i = 1; i * i <= n; i++) {
            max = Math.min(max, 1 + recursion(n - (i * i)));
        }

        return max;
    }

TC: O(sqrt(n)^n)
SC: O(n)
```

- Memoization

```
    public static int memorization(int n) {
        int[] result = new int[n + 1];
        Arrays.fill(result, -1);
        return memorization(n, result);
    }

    private static int memorization(int n, int[] result) {
        if (n == 0) {
            return 0;
        } else if (result[n] != -1) {
            return result[n];
        } else {
            int max = Integer.MAX_VALUE;

            for (int i = 1; i * i <= n; i++) {
                max = Math.min(max, 1 + memorization(n - (i * i), result));
            }

            return result[n] = max;
        }
    }
    TC: O(n*sqrt(n))
    SC: 2* O(n)

```

- Tabulation

```
    public static int tabulation(int n) {
        if (n < 4) {
            return n;
        }
        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;

        for (int i = 4; i < result.length; i++) {
            int max = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                max = Math.min(max, 1 + result[(i - (j * j))]);
            }
            result[i] = max;
        }

        return result[n];
    }

    Tc: O(n*sqrt(n))
    SC: O(n)
```

- Space Optimization

```
It is not possible for this specific Dynamic Programming problem because to calculate the value for $n$, you potentially need to look back at any previous result (like $n-1$, $n-4$, $n-9$, etc.).
```

## Minimum Cost for Tickets

- Recursion

```
public static int recursion(int[] days, int[] cost) {
        return recursion(days, cost, days.length - 1);
    }

    private static int recursion(int[] days, int[] cost, int index) {
        if (index < 0) {
            return 0;
        }

        int oneDayPass = cost[0] + recursion(days, cost, index - 1);
        int sevenDayPass = cost[1] + recursion(days, cost, findIndex(days, index, 7));
        int thirtyDaysPass = cost[2] + recursion(days, cost, findIndex(days, index, 30));

        return Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDaysPass));
    }

    private static int findIndex(int[] days, int index, int pass) {
        int leftDays = days[index] - pass;
        while (index >= 0 && days[index] > leftDays) {
            index--;
        }
        return index;
    }


    // doing everything in same place
    private static int recursion2(int n, int[] days, int[] costs, int index) {
        if (index >= n) {
            return 0;
        }

        int oneDayPass = costs[0] + recursion2(n, days, costs, index + 1);

        int i;
        for (i = index; i < n && days[i] < days[index] + 7; i++)
            ;
        int sevenDayPass = costs[1] + recursion2(n, days, costs, i);

        for (i = index; i < n && days[i] < days[index] + 30; i++)
            ;

        int thirtyDaysPass = costs[2] + recursion2(n, days, costs, i);

        return Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDaysPass));
    }
```

- Memoization

```
    public static int memorization(int[] days, int[] cost) {
        int[] data = new int[days.length];
        Arrays.fill(data, -1);
        return memorization(days, cost, days.length - 1, data);
    }

    private static int memorization(int[] days, int[] cost, int index, int[] result) {
        if (index < 0) {
            return 0;
        }

        if (result[index] != -1) {
            return result[index];
        }

        int oneDayPass = cost[0] + memorization(days, cost, index - 1, result);
        int sevenDayPass = cost[1] + memorization(days, cost, findIndex(days, index, 7), result);
        int thirtyDaysPass = cost[2] + memorization(days, cost, findIndex(days, index, 30), result);

        return result[index] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDaysPass));
    }

    or very optimized

    static HashSet<Integer> isTravelNeeded = new HashSet<>();

    private static int memorization2(int[] dp, int[] days, int[] costs, int currDay) {
        // If we have iterated over travel days, return 0.
        if (currDay > days[days.length - 1]) {
            return 0;
        }

        // If we don't need to travel on this day, move on to next day.
        if (!isTravelNeeded.contains(currDay)) {
            return memorization2(dp, days, costs, currDay + 1);
        }

        // If already calculated, return from here with the stored answer.
        if (dp[currDay] != -1) {
            return dp[currDay];
        }

        int oneDay = costs[0] + memorization2(dp, days, costs, currDay + 1);
        int sevenDay = costs[1] + memorization2(dp, days, costs, currDay + 7);
        int thirtyDay = costs[2] + memorization2(dp, days, costs, currDay + 30);

        // Store the cost with the minimum of the three options.
        return dp[currDay] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
    }

    public static int memorization2(int[] days, int[] costs) {
        // The last day on which we need to travel.
        int lastDay = days[days.length - 1];
        int dp[] = new int[lastDay + 1];
        Arrays.fill(dp, -1);

        // Mark the days on which we need to travel.
        for (int day : days) {
            isTravelNeeded.add(day);
        }

        return memorization2(dp, days, costs, 1);
    }

```

- Tabulation

```
    public static int tabulation(int[] days, int[] cost) {
        int[] data = new int[days.length];
        data[0] = cost[0];

        for (int i = 0; i < data.length; i++) {
            int oneDayPass = cost[0] + data[i - 1];

            // checking how many days will be covered with this one
            int temp = findIndex(days, i, 7);
            int sevenDayPass = cost[1];
            if (temp != -1) {
                sevenDayPass += data[temp];
            }

            temp = findIndex(days, i, 30);
            int thirtyDaysPass = cost[2];
            if (temp != -1) {
                thirtyDaysPass += data[temp];
            }

            data[i] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDaysPass));
        }
        return data[data.length - 1];
    }

    // More faster way to do it
    public int tabulation2(int[] days, int[] costs) {
        // The last day on which we need to travel.
        int lastDay = days[days.length - 1];
        int dp[] = new int[lastDay + 1];
        Arrays.fill(dp, 0);

        int i = 0;
        for (int day = 1; day <= lastDay; day++) {
            // If we don't need to travel on this day, the cost won't change.
            if (day < days[i]) {
                dp[day] = dp[day - 1];
            } else {
                // Buy a pass on this day, and move on to the next travel day.
                i++;
                // Store the cost with the minimum of the three options.
                dp[day] = Math.min(dp[day - 1] + costs[0],
                        Math.min(dp[Math.max(0, day - 7)] + costs[1],
                                dp[Math.max(0, day - 30)] + costs[2]));
            }
        }

        return dp[lastDay];
    }
```

- Space Optimization

```
public int mincostTickets(int[] days, int[] costs) {
    Queue<int[]> last7 = new LinkedList<>();
    Queue<int[]> last30 = new LinkedList<>();
    int totalCost = 0;

    for (int day : days) {
        // Discard expired passes from the queues
        while (!last7.isEmpty() && last7.peek()[0] + 7 <= day) last7.poll();
        while (!last30.isEmpty() && last30.peek()[0] + 30 <= day) last30.poll();

        // Add current options to the queues
        last7.offer(new int[]{day, totalCost + costs[1]});
        last30.offer(new int[]{day, totalCost + costs[2]});

        // The cost for today is the minimum of 1-day pass or the best valid pass in the queues
        totalCost = Math.min(totalCost + costs[0],
                    Math.min(last7.peek()[1], last30.peek()[1]));
    }

    return totalCost;
}
```

## Maximum Square

Approach: So we can be at any index and can check on our right, diag and down and take the smallest one out of three, that will be smallest square possible

- Recursion

```
    static int max = 0;

    public static int recursion(char[][] matrix) {
        max = 0;
        recursion(0, 0, matrix);
        return max * max;
    }

    private static int recursion(int i, int j, char[][] matrix) {
        if (i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }

        int right = recursion(i, j + 1, matrix);
        int down = recursion(i + 1, j, matrix);
        int diag = recursion(i + 1, j + 1, matrix);

        if (matrix[i][j] == '1') {
            int temp = 1 + Math.min(right, Math.min(down, diag));
            max = Math.max(max, temp);
            return temp;
        }

        return 0;
    }
    TC:O(3^M+N)
    SC:O(M+N)

```

- Memoization

```
    public static int memorization(char[][] matrix) {
        int[][] temp = new int[matrix.length][matrix[0].length];
        for (int[] t : temp) {
            Arrays.fill(t, -1);
        }
        max = 0;
        memorization(0, 0, matrix, temp);
        return max * max;
    }

    private static int memorization(int i, int j, char[][] matrix, int[][] temp) {
        if (i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }

        if (temp[i][j] != -1) {
            return temp[i][j];
        }

        int right = memorization(i, j + 1, matrix, temp);
        int down = memorization(i + 1, j, matrix, temp);
        int diag = memorization(i + 1, j + 1, matrix, temp);

        if (matrix[i][j] == '1') {
            int t = 1 + Math.min(right, Math.min(down, diag));
            max = Math.max(max, t);
            return temp[i][j] = t;
        }

        return temp[i][j] = 0;
    }

    TC:O(M*N) // visiting entire array
    SC:O(M*N) + O(M+N)
```

- Tabulation

```
    public static int tabulation(char[][] matrix) {
        max = 0;
        int maxX = matrix.length;
        int maxY = matrix[0].length;

        int[][] temp = new int[maxX + 1][maxY + 1];

        for (int i = maxX - 1; i >= 0; i--) {
            for (int y = maxY - 1; y >= 0; y--) {

                if (matrix[i][y] == '1') {
                    int right = temp[i][y + 1];
                    int down = temp[i + 1][y];
                    int diag = temp[i + 1][y + 1];
                    int t = 1 + Math.min(right, Math.min(down, diag));
                    temp[i][y] = t;
                    max = Math.max(max, t);
                }
            }
        }

        return max * max;
    }
    TC:O(M*N)
    SC:O(M*N)
```

- Space Optimization

```
    public static int spaceOptimization(char[][] matrix) {
        max = 0;
        int maxX = matrix.length;
        int maxY = matrix[0].length;

        int[] dp = new int[maxY + 1];
        for (int i = maxX - 1; i >= 0; i--) {

            int diag = 0;

            for (int y = maxY - 1; y >= 0; y--) {
                int temp = dp[y];
                if (matrix[i][y] == '1') {
                    int t = 1 + Math.min(diag, Math.min(dp[y], dp[y + 1]));
                    dp[y] = t;
                    max = Math.max(max, t);
                } else {
                    dp[y] = 0;
                }
                diag = temp;
            }
        }

        return max * max;
    }

    TC:O(M*N)
    SC:O(N)
```

## Min Score Triangulation of Polygon

Vary nice question, always remeber what you have, 2 make triangle you need 2 points if you can freeze 1st and second and choose any k point (i,j) then you will get triable and solve the smaller problem and recusively solve the other parts too

- Recursion

```
public static int recursion(int[] values) {
        return recursion(values, 0, values.length - 1);
    }

    private static int recursion(int[] values, int i, int j) {
        if (i + 1 == j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {
            int temp = values[i] * values[j] * values[k] + recursion(values, i, k) + recursion(values, k, j);
            min = Math.min(temp, min);
        }

        return min;
    }

    TC: 2^n
    SC: O(n)

```

- Memoization

```
    public static int memorization(int[] values) {
        int[][] result = new int[values.length + 1][values.length + 1];

        for (int[] r : result) {
            Arrays.fill(r, -1);
        }

        return memorization(values, 0, values.length - 1, result);
    }

    private static int memorization(int[] values, int i, int j, int[][] result) {
        if (i + 1 == j) {
            return 0;
        } else if (result[i][j] != -1) {
            return result[i][j];
        }

        int min = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {
            int temp = values[i] * values[j] * values[k] + memorization(values, i, k, result)
                    + memorization(values, k, j, result);
            min = Math.min(temp, min);
        }

        return result[i][j] = min;
    }
    TC: O(n^3) we will have n^2 unique state and each those state has n more
    SC: O(n^2) + O(n)
```

- Tabulation

```
    public static int tabulation(int[] values) {
        int n = values.length;

        int[][] result = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int temp = values[i] * values[j] * values[k] + result[i][k] + result[k][j];
                    min = Math.min(min, temp);
                }
                result[i][j] = min;
            }
        }
        return result[0][n - 1];
    }
    TC: O(n^3)
    SC: O(n^2)
```

- Space Optimization

```
Not possible as if we see result[i][j] is dependent on result[i][k] which is in the same row so easy but result[k][j] for which value can vary from 1 to n so hard to keep track of all of them
```

## Minimum Sideway Jumps

- Recursion

```
    These are 2 different approach with 2 nd one it is easy to come up with tabulation

    public static int recursion(int[] obstacles) {
        return recursion(obstacles, 0, 2);
    }

    private static int recursion1(int[] obstacles, int index, int currentPosition) {
        if (index == obstacles.length) {
            return 0;
        }

        if (obstacles[index + 1] != currentPosition) {
            return recursion1(obstacles, index + 1, currentPosition);
        } else {
            int result = Integer.MAX_VALUE;
            for (int i = 1; i <= 3; i++) {
                if (currentPosition != i && obstacles[index] != -1) {
                    result = Math.min(result, 1 + recursion1(obstacles, index, i));
                }
            }
            return result;
        }
    }

    private static int recursion(int[] obstacles, int index, int currentPosition) {
        if (index == obstacles.length) {
            return 0;
        }

        if (obstacles[index] == currentPosition) {
            return Integer.MAX_VALUE;
        }

        int result = Integer.MAX_VALUE;

        for (int i = 1; i <= 3; i++) {
            if (obstacles[index] != i) {
                if (currentPosition == i) {
                    result = Math.min(result, recursion(obstacles, index + 1, currentPosition));
                } else {
                    int jump = recursion(obstacles, index + 1, i);
                    if (jump != Integer.MAX_VALUE) {
                        result = Math.min(result, 1 + recursion(obstacles, index + 1, i));
                    }
                }
            }
        }

        return result;
    }
    TC: O(2^n) or O(3^n)
    SC: O(n)
```

- Memoization

```
    public static int memorization(int[] obstacles) {
        int[][] result = new int[obstacles.length][4];
        for (int[] r : result) {
            Arrays.fill(r, -1);
        }
        return memorization(obstacles, 0, 2, result);
    }

    private static int memorizaation1(int[] obstacles, int index, int currentPosition, int[][] r) {
        if (index == obstacles.length) {
            return 0;
        }

        if (r[index][currentPosition] != -1) {
            return r[index][currentPosition];
        }

        if (obstacles[index + 1] != currentPosition) {
            return r[index][currentPosition] = memorizaation1(obstacles, index + 1, currentPosition, r);
        } else {
            int result = Integer.MAX_VALUE;
            for (int i = 1; i <= 3; i++) {
                if (currentPosition != i && obstacles[index] != -1) {
                    result = Math.min(result, 1 + memorizaation1(obstacles, index, i, r));
                }
            }
            return r[index][currentPosition] = result;
        }
    }

    private static int memorization(int[] obstacles, int index, int currentPosition, int[][] r) {
        if (index == obstacles.length) {
            return 0;
        }

        if (obstacles[index] == currentPosition) {
            return Integer.MAX_VALUE;
        }

        if (r[index][currentPosition] != -1) {
            return r[index][currentPosition];
        }

        int result = Integer.MAX_VALUE;

        for (int i = 1; i <= 3; i++) {
            if (obstacles[index] != i) {
                if (currentPosition == i) {
                    result = Math.min(result, memorization(obstacles, index + 1, currentPosition, r));
                } else {
                    int jump = memorization(obstacles, index + 1, i, r);
                    if (jump != Integer.MAX_VALUE) {
                        result = Math.min(result, 1 + jump);
                    }
                }
            }
        }

        return r[index][currentPosition] = result;
    }
    TC: O(N*3)
    SC: O(N)
```

- Tabulation

```
    public static int tabulation1(int[] obstacles) {
        int n = obstacles.length - 1;
        int[][] dp = new int[n + 1][4];
        int INF = 1_000_000;

        for (int i = n - 1; i >= 0; i--) {
            // 1. First Pass: Move Forward (All lanes)
            for (int j = 1; j <= 3; j++) {
                if (obstacles[i] == j || obstacles[i + 1] == j) {
                    dp[i][j] = INF;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }

            // 2. Second Pass: Check if jumping sideways at index i is better
            for (int j = 1; j <= 3; j++) {
                if (obstacles[i] == j)
                    continue;
                for (int nextLane = 1; nextLane <= 3; nextLane++) {
                    if (j == nextLane || obstacles[i] == nextLane)
                        continue;

                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][nextLane]);
                }
            }
        }

        return Math.min(dp[0][2], Math.min(1 + dp[0][1], 1 + dp[0][3]));
    }

    TC: O(N*3*3)
    SC: O(N*3)
```

- Space Optimization

```
    public static int spaceOptimized(int[] obstacles) {
        int n = obstacles.length - 1;
        int INF = 1_000_000;

        // This represents dp[i + 1]
        int[] next = new int[4];

        // Base Case: At index n, cost is 0
        // (Java initializes arrays to 0, so next[1]=next[2]=next[3]=0 is already set)

        for (int i = n - 1; i >= 0; i--) {
            int[] curr = new int[4];

            // Pass 1: Move forward from next to curr
            for (int lane = 1; lane <= 3; lane++) {
                if (obstacles[i] == lane || obstacles[i + 1] == lane) {
                    curr[lane] = INF;
                } else {
                    curr[lane] = next[lane];
                }
            }

            // Pass 2: Sideway jumps within curr
            for (int lane = 1; lane <= 3; lane++) {
                if (obstacles[i] == lane)
                    continue;

                for (int otherLane = 1; otherLane <= 3; otherLane++) {
                    if (lane == otherLane || obstacles[i] == otherLane)
                        continue;

                    curr[lane] = Math.min(curr[lane], 1 + curr[otherLane]);
                }
            }

            // Update: current row becomes the 'next' row for the next iteration
            next = curr;
        }

        // Starting at index 0, Lane 2 (allowing for a jump if Lane 2 is blocked)
        return Math.min(next[2], Math.min(1 + next[1], 1 + next[3]));
    }
    TC: O(N*3*3)
    SC: O(1)
```

## Reducing Dishes

- Recursion

```
    Remember to sort it to get the best value

    public static int recursion(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return recursion(satisfaction, 0, 1);
    }

    private static int recursion(int[] satisfaction, int index, int time) {
        if (index >= satisfaction.length) {
            return 0;
        }

        int takeIt = time * satisfaction[index] + recursion(satisfaction, index + 1, time + 1);
        int notTakeIt = recursion(satisfaction, index + 1, time);

        return Math.max(takeIt, notTakeIt);
    }
    TC: O(2^N)
    SC: O(N)

```

- Memoization

```
    public static int memorization(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[][] result = new int[satisfaction.length][satisfaction.length + 1];
        for (int[] r : result) {
            Arrays.fill(r, -1);
        }

        return memorization(satisfaction, 0, 1, result);
    }

    private static int memorization(int[] satisfaction, int index, int time, int[][] result) {
        if (index >= satisfaction.length) {
            return 0;
        }

        if (result[index][time] != -1) {
            return result[index][time];
        }

        int takeIt = time * satisfaction[index] + memorization(satisfaction, index + 1, time + 1, result);
        int notTakeIt = memorization(satisfaction, index + 1, time, result);

        return result[index][time] = Math.max(takeIt, notTakeIt);
    }
    TC: O(N^2)
    SC: O(N^2)

```

- Tabulation

```
    public static int tabulation(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[][] result = new int[satisfaction.length + 1][satisfaction.length + 2];
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            for (int j = satisfaction.length; j > 0; j--) {
                int takeIt = j * satisfaction[i] + result[i + 1][j + 1];
                int notTakeIt = result[i + 1][j];

                result[i][j] = Math.max(takeIt, notTakeIt);
            }
        }

        return result[0][1];
    }

    TC: O(N^2)
    SC: O(N^2)

```

- Space Optimization

```
    public static int spaceOptimized(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;

        // We only need the "next" row to calculate the "current" row
        int[] next = new int[n + 2];

        for (int i = n - 1; i >= 0; i--) {
            int[] curr = new int[n + 2];
            for (int j = i + 1; j >= 1; j--) {
                int takeIt = (j * satisfaction[i]) + next[j + 1];
                int notTakeIt = next[j];

                curr[j] = Math.max(takeIt, notTakeIt);
            }
            next = curr; // The current row becomes the 'next' row for the next dish
        }

        return next[1];
    }
    TC: O(N^2)
    SC: O(N)
```

## Longest Increasing Subsequence

- Recursion

```
    public static int recursion(int[] data) {
        return recursion(data, 0, -1);
    }

    public static int recursion(int[] data, int index, int prev) {
        if (data.length == index) {
            return 0;
        }

        int include = 0;
        if (prev == -1) {
            include = 1 + recursion(data, index + 1, index);
        } else if (prev != -1 && data[prev] < data[index]) {
            include = 1 + recursion(data, index + 1, index);
        }

        int exclude = recursion(data, index + 1, prev);

        return Math.max(include, exclude);

    }
```

- Memoization

```
public static int memorization(int[] data) {
        int result[][] = new int[data.length][data.length];
        for (int[] r : result) {
            Arrays.fill(r, -1);
        }
        return memorization(data, 0, -1, result);
    }

    public static int memorization(int[] data, int index, int prev, int[][] result) {
        if (data.length == index) {
            return 0;
        }

        if (prev != -1 && result[index][prev] != -1) {
            return result[index][prev];
        }

        int include = 0;
        if (prev == -1) {
            include = 1 + memorization(data, index + 1, index, result);
        } else if (prev != -1 && data[prev] < data[index]) {
            include = 1 + memorization(data, index + 1, index, result);
        }

        int exclude = memorization(data, index + 1, prev, result);

        int r = Math.max(include, exclude);

        if (prev != -1) {
            result[index][prev] = r;
        }

        return r;
    }

```

- Tabulation

```
public static int tabulation(int[] data) {
        int n = data.length;

        int[][] result = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                int include = 0;
                if (j == -1) {
                    include = 1 + result[i + 1][i + 1];
                } else if (j != -1 && data[j] < data[i]) {
                    include = 1 + result[i + 1][i + 1];
                }

                int exclude = result[i + 1][j + 1];

                result[i][j + 1] = Math.max(include, exclude);
            }
        }

        return result[0][0];
    }
```

- Space Optimization

```
public static int spaceOptimizedTabulation(int[] data) {
        int n = data.length;
        // We only need two rows: the 'next' row and the 'current' row
        int[] next = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                // Logic is the same, but we use next[] instead of result[i+1][]
                int exclude = next[j + 1];

                int include = 0;
                if (j == -1 || data[i] > data[j]) {
                    include = 1 + next[i + 1];
                }

                curr[j + 1] = Math.max(include, exclude);
            }
            // Move current row to next row for the next iteration of 'i'
            next = curr.clone();
        }

        return next[0];
    }

```

## Pizza with 3n Slices

```
Before solving it think about house of robbers problem as it is very similar but make sure to keep track of how many pizza slices you can choose as it is constraint in this problem
```

| Approach            | Time Complexity | Space Complexity |
| :------------------ | :-------------- | :--------------- |
| **Recursion**       | $O(2^n)$        | $O(n)$           |
| **Memorization**    | $O(n \cdot k)$  | $O(n \cdot k)$   |
| **Tabulation**      | $O(n \cdot k)$  | $O(n \cdot k)$   |
| **Space Optimized** | $O(n \cdot k)$  | $O(k)$           |

## Number of Dice Rolls With Target Sum

```
Not a tough problem and easy tabulation.
Make sure to use all dice and cover all edge cases.
```

| Approach            | Time Complexity     | Space Complexity |
| ------------------- | ------------------- | ---------------- |
| **Recursion**       | _O(kⁿ)_             | _O(n)_           |
| **Memoization**     | _O(n · k · target)_ | _O(n · target)_  |
| **Tabulation**      | _O(n · k · target)_ | _O(n · target)_  |
| **Space Optimized** | _O(n · k · target)_ | _O(target)_      |

## Partition Equal Subset Sum

```
This is easy question but need to redefine the problem

If sum of all the elements are odd mean cannot be divided into 2 different subsets so false

If even then try to see can we able to get half of that sum from array if yes then true else false
```

| Approach            | Time Complexity | Space Complexity |
| ------------------- | --------------- | ---------------- |
| **Recursion**       | _O(2ⁿ)_         | _O(n)_           |
| **Memoization**     | _O(n · T)_      | _O(n · T)_       |
| **Tabulation**      | _O(n · T)_      | _O(n · T)_       |
| **Space Optimized** | _O(n · T)_      | _O(T)_           |

## Longest Arithmetic Subsequence

```
This is very very nice probleam and make you think little extra

So we try to check every paid and use it's difference to see if there is any element in the back whose difference (newElm - pair[left]) == diff (pair[rigt]-pair[left])

if use add it and recursiverly look further

For memoriazation now rather than using an array we used the array of hashmap as every index can have different number of the the diff

and in space optimization as we know the no of element is 500 and if we include - ve as well as 0 then 1001 so make that array
```

| Approach            | Time Complexity | Space Complexity |
| ------------------- | --------------- | ---------------- |
| **Recursion**       | _O(n^2 \* 2ⁿ)_  | _O(n)_           |
| **Memoization**     | _O(n^2)_        | _O(n^2)_         |
| **Tabulation**      | _O(n^2)_        | _O(n^2)_         |
| **Space Optimized** | _O(n^2)_        | _O(n\*d)_        |

## Longest Arithmetic Subsequence of Given Difference

```
Very Similar to above but still little challanging
```

| Approach            | Time Complexity | Space Complexity |
| ------------------- | --------------- | ---------------- |
| **Recursion**       | _O(2ⁿ)_         | _O(n)_           |
| **Memoization**     | _O(n^2)_        | _O(n)_           |
| **Tabulation**      | _O(n)_          | _O(n)_           |
| **Space Optimized** | _O(n)_          | _O(range)_       |

## Unique Binary Search Trees

```
This is very unique problem, the solution depend on which element you pick as the root but do not forget you have to choose all of the different
roots to cover all of the cases

This problem can be easily solved with Catalan Numbers
```

| Approach            | Time Complexity | Space Complexity |
| ------------------- | --------------- | ---------------- |
| **Recursion**       | _O(2ⁿ)_         | _O(n)_           |
| **Memoization**     | _O(n^2)_        | _O(n)_           |
| **Tabulation**      | _O(n^2)_        | _O(n)_           |
| **Space Optimized** |                 |                  |

## Guess Number Higher or Lower II

```
This is not the tough question but to come to recursive solution is little hard and require alot of thinking

Cannot be more optimized

```

| Approach            | Time Complexity | Space Complexity |
| ------------------- | --------------- | ---------------- |
| **Recursion**       | _O(2ⁿ)_         | _O(n)_           |
| **Memoization**     | _O(n^3)_        | _O(n^2)_         |
| **Tabulation**      | _O(n^3)_        | _O(n^2)_         |
| **Space Optimized** |                 |                  |

## Minimum Cost Tree From Leaf Values

```
The hardest part of this question is to find the recurrance relation ship and solve it

This question is not much optimized when solved with recursion but can we done way better with Monotonic Stack
```

| Approach                 | Time Complexity | Space Complexity |
| ------------------------ | --------------- | ---------------- |
| **Recursion**            | _O(2ⁿ)_         | _O(n)_           |
| **Memoization**          | _O(n^4)_        | _O(n^2)_         |
| **Tabulation**           | _O(n^4)_        | _O(n^2)_         |
| **Optimized Tabulation** | _O(n^3)_        | _O(n^2)_         |
| **Monotonic Stack**      | _O(n)_          | _O(n)_           |

## Best Time to Buy and Sell Stock

```
Open your mind i know we are doing recursion play list but have to open the mind as it can be just done with iterative solution
```

| Approach      | Time Complexity | Space Complexity |
| ------------- | --------------- | ---------------- |
| **Iterative** | _O(n)_          | _O(1)_           |

## Best Time to Buy and Sell Stock II

```
Not a tough question just make sure you understand the question completely
```

| Approach                 | Time Complexity   | Space Complexity       |
| ------------------------ | ----------------- | ---------------------- |
| **Recursion**            | _O(2ⁿ)_           | _O(n)_                 |
| **Memoization**          | _O(n\*2)_ =_O(n)_ | _O(n\*2)+O(n)_ =_O(n)_ |
| **Tabulation**           | _O(n\*2)_ =_O(n)_ | _O(n\*2)_ =_O(n)_      |
| **Optimized Tabulation** | _O(n\*2)_ =_O(n)_ | _O(2)_                 |

## Best Time to Buy and Sell Stock III

```
Very Similar to above just now we have limit on number of transactions we can make
```

| Approach                 | Time Complexity      | Space Complexity          |
| ------------------------ | -------------------- | ------------------------- |
| **Recursion**            | _O(2ⁿ)_              | _O(n)_                    |
| **Memoization**          | _O(n\*2\*3)_ =_O(n)_ | _O(n\*2\*3)+O(n)_ =_O(n)_ |
| **Tabulation**           | _O(n\*2\*3)_ =_O(n)_ | _O(n\*2\*3)_ =_O(n)_      |
| **Optimized Tabulation** | _O(n\*2\*3)_ =_O(n)_ | _O(2\*3)_ = _O(1)_        |

## Best Time to Buy and Sell Stock IV

```
99% similar than before just rather than having 2 max transactions now we have K
```

| Approach                 | Time Complexity         | Space Complexity             |
| ------------------------ | ----------------------- | ---------------------------- |
| **Recursion**            | _O(2ⁿ)_                 | _O(n)_                       |
| **Memoization**          | _O(n\*2\*K)_ =_O(n\*K)_ | _O(n\*2\*K)+O(n)_ =_O(n\*K)_ |
| **Tabulation**           | _O(n\*2\*K)_ =_O(n\*K)_ | _O(n\*2\*K)_ =_O(n\*K)_      |
| **Optimized Tabulation** | _O(n\*2\*K)_ =_O(n\*K)_ | _O(2\*K)_ = _O(K)_           |

## Best Time to Buy and Sell Stock V

```
99% similar than before but the hard part is to know how to deal with different states
```

| Approach                 | Time Complexity         | Space Complexity             |
| ------------------------ | ----------------------- | ---------------------------- |
| **Recursion**            | _O(2ⁿ)_                 | _O(n)_                       |
| **Memoization**          | _O(n\*3\*K)_ =_O(n\*K)_ | _O(n\*3\*K)+O(n)_ =_O(n\*K)_ |
| **Tabulation**           | _O(n\*3\*K)_ =_O(n\*K)_ | _O(n\*3\*K)_ =_O(n\*K)_      |
| **Optimized Tabulation** | _O(n\*3\*K)_ =_O(n\*K)_ | _O(3\*K)_ = _O(K)_           |

- Recursion
- Memoization
- Tabulation
- Space Optimization
