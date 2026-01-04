# DSA Patterns

This repository contains the **most important Data Structures & Algorithms patterns** that are frequently asked in interviews.

You can track your progress using the checklist below.

---

## Array & Strings

- [x] [Two Pointers](#two-pointers)
- [ ] Sliding Window
- [ ] Prefix Sum
- [ ] Kadane’s Algorithm
- [ ] Merge Intervals
- [ ] Cyclic Sort
- [ ] Dutch National Flag / Three Pointers

---

## Linked List

- [ ] Fast & Slow Pointers
- [ ] Reverse Linked List
- [ ] Merge Two Sorted Lists
- [ ] Detect Cycle in Linked List
- [ ] Remove N-th Node From End

---

## Stack & Queue

- [ ] Stack for Monotonic Problems
- [ ] Queue / Deque
- [ ] Next Greater / Smaller Element
- [ ] Sliding Window Maximum
- [ ] Balanced Parentheses / Valid Expression

---

## Binary Tree / Binary Search Tree

- [ ] BFS / Level Order Traversal
- [ ] DFS (Preorder, Inorder, Postorder)
- [ ] Bottom-Up / Top-Down Approach
- [ ] Tree Diameter / Max Depth / Height
- [ ] Lowest Common Ancestor
- [ ] Serialize / Deserialize Tree

---

## Heap / Priority Queue

- [ ] Min Heap / Max Heap
- [ ] Kth Largest / Smallest Element
- [ ] Merge K Sorted Lists
- [ ] Sliding Window Median

---

## Graphs

- [ ] BFS
- [ ] DFS
- [ ] Topological Sort
- [ ] Cycle Detection
- [ ] Dijkstra’s Algorithm
- [ ] Kruskal / Prim (MST)
- [ ] Connected Components

---

## Dynamic Programming

- [ ] 0/1 Knapsack
- [ ] Unbounded Knapsack
- [ ] Longest Common Subsequence (LCS)
- [ ] Longest Increasing Subsequence (LIS)
- [ ] Minimum/Maximum Path Sum
- [ ] Matrix DP / Grid DP

---

## Backtracking

- [ ] Subsets / Subsequence
- [ ] Permutations / Combinations
- [ ] N-Queens Problem
- [ ] Word Search / Sudoku Solver

---

## Greedy

- [ ] Activity Selection
- [ ] Fractional Knapsack
- [ ] Minimum Platforms
- [ ] Interval Scheduling

---

## Miscellaneous

- [ ] Bit Manipulation Patterns
- [ ] Sliding Window Maximum / Minimum
- [ ] Union-Find / Disjoint Set
- [ ] Top K Frequent Elements

---

## Two Pointers

These kind of problems usually involve two pointers:

The two-pointer technique is a sliding or scanning strategy where you use two indices (pointers) to traverse an array or string in a way that reduces time complexity.

Instead of using nested loops (O(n²)), two pointers often allow you to solve problems in O(n) or O(n log n) time.

---

When to Use Two Pointers

Two pointers are usually applied when:

1. The array or string is sorted (common case).

2. You need to find pairs or subarrays that satisfy a condition.

3. You want to avoid nested loops to reduce complexity.

---

Two Main Variants:

```
One slow-runner and the other fast-runner.
```

A classic example is to remove duplicates from a sorted array, which is available for you to practice [here](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/) .

There is another variation to that:

```
One pointer starts from the beginning while the other pointer starts from the end.
They move toward each other until they both meet. Let's take a look at a classic problem: Reverse the characters in a string:
```

### Classic problems:

1. [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/)

#### First approach

```
public static int removeDuplicates(int[] nums) {
        int s = 0;
        int f = 1;

        while(f < nums.length && s<f){
            if(nums[s] == nums[f]){
                f++;
            }else{
                // mean it is worth swapping
                if(Math.abs(f-s)>1){
                    s++;
                    int temp = nums[s];
                    nums[s] = nums[f];
                    nums[f] = temp;
                    f++;
                }else{
                    s++;
                    f++;
                }
            }
        }
        return s;
    }
```

### Second Approach

```
Use the hash set but for in place we need to use above approach
```

2. [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/)

#### First Approach

```
Brute force O(n^2)
use two loops for this
```

### Second Approach

```
Time O(n) , Space O(n)
Use hashset and pick one element at time

```

### Third Approach

```
Time O(n) space O(1)

Use Two pointers one and start and one at end
if sum > target, end -- else start ++ until sum is equal

public int[] twoSum(int[] num, int target) {
        int s = 0;
        int e = num.length-1;

        while(s<e){
            if(num[s]+num[e] == target){
                return new int[]{s,e};
            }else if(num[s]+num[e] > target){
                e--;
            }else{
                s++;
            }
        }

        return new int[]{-1,-1};
    }
```

3. [Reverse Words in a String](https://www.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1)

#### First Approach

```
Using two pointer by using extra list

class Solution {
    public String reverseWords(String s) {
       List<String> temp = new ArrayList<>();
       int start = 0;
       int prev = 0;
       boolean firstChar = false;

       while(start<s.length()){
           if(s.charAt(start) == '.'){
               if(firstChar){
                  temp.add(s.substring(prev,start));
               }
               firstChar = false;
               start++;
           }else{
               if(firstChar){
                   start++;
               }else{
                   firstChar = true;
                   prev = start;
                   start++;
               }
           }
       }
        // if last character is not . then we have to add
       if(firstChar){
           temp.add(s.substring(prev,start));
       }

       //System.out.println(temp);
       String result = "";
       for(int i= temp.size()-1;i>=0;i--){
           if(i==0){
               result += temp.get(i);

           }else{
               result += temp.get(i) +".";
           }
       }

       return result;

    }
}

```

#### Second Approach ⚠️ **Important:** Must try it

```
Again 2 pointer but first we will reverse the string then

public static String reverseWords(String s) {
        // Convert the string to a char array
        // for in-place operations
        char[] chars = s.toCharArray();
        int n = chars.length;

        // Reverse the entire string
        reverse(chars, 0, n - 1);

        int i = 0;
        for (int l = 0; l < n; ++l) {
            if (chars[l] != '.') {

                // Add a dot between words if needed
                if (i != 0) chars[i++] = '.';

                // Find the end of the word
                int r = l;
                while (r < n && chars[r] != '.') chars[i++] = chars[r++];

                // Reverse the current word
                reverse(chars, i - (r - l), i-1);

                // Move to next word
                l = r;
            }
        }

        return new String(chars, 0, i);
    }

    // Utility to reverse part of the char array
    private static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
```
