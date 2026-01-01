# Sorting Algorithm

- [x] [Bubble Sort](#bubble-sort)
- [x] [Selection Sort](#selection-sort)
- [x] [Insertion Sort](#insertion-sort)
- [x] [Cyclic Sort](#cyclic-sort)
- [x] [Merge Sort](#merge-sort)
- [x] [Quick Sort](#quick-sort)
- [ ] Heap Sort

---

## Bubble Sort

Bubble Sort is a sorting algorithm that repeatedly compares **adjacent elements** and swaps them if they are in the wrong order.

Just like air bubbles in water rise to the surface, the **largest element moves to the end** of the array in each iteration. Hence, it is called _Bubble Sort_.

### Working of Bubble Sort

Suppose we want to sort the elements in **ascending order**.

#### 1. First Iteration (Compare and Swap)

1. Start from the first index and compare the first and second elements.
2. If the first element is greater than the second, swap them.
3. Compare the second and third elements and swap if needed.
4. Continue this process until the last element is reached.

#### 2. Remaining Iterations

1. Repeat the same process for the remaining elements.
2. After each iteration, the **largest unsorted element** is placed at the end.

### Time Complexity

**Worst Case:** `O(n²)`  
**Average Case:** `O(n²)`  
**Best Case (already sorted with optimization):** `O(n)`

**Space Complexity:** `O(1)`

---

## Selection Sort

Selection Sort is a sorting algorithm that selects the **smallest element** from the unsorted part of the array and places it at the beginning.

### Working of Selection Sort

Suppose we want to sort the elements in **ascending order**.

1. Assume the first element is the minimum.
2. Compare the minimum with the remaining elements.
   - If a smaller element is found, update the minimum.
3. After each iteration, place the minimum element at the beginning of the unsorted list.
4. The first element is now sorted.
5. Repeat the process for the remaining unsorted elements until the array is fully sorted.

### Time Complexity

**Worst Case:** `O(n²)`  
**Average Case:** `O(n²)`  
**Best Case:** `O(n²)`

**Space Complexity:** `O(1)`

---

## Insertion Sort

Insertion Sort is a sorting algorithm that places an unsorted element at its correct position in each iteration.

Insertion Sort works similarly to sorting cards in your hand.

### Working of Insertion Sort

1. Assume the first element is already sorted.
2. Take the next element and store it as `key`.
3. Compare `key` with the elements to its left.
   - Shift elements to the right if they are greater than `key`.
4. Insert `key` at its correct position.
5. Repeat this process for all remaining elements.

### Time Complexity

**Worst Case:** `O(n²)`  
**Average Case:** `O(n²)`  
**Best Case (already sorted):** `O(n)`

**Space Complexity:** `O(1)`

Works best for **partially sorted arrays**

---

## Cyclic Sort

Cyclic Sort is used when numbers are given in the range **1 to n** or **0 to n** and we need to sort them.

The core idea of this algorithm is to place each element at the **index where it belongs**.

### Working of Cyclic Sort

1. Start with `index = 0`
2. If `data[index] != index + 1`
   - The correct position of `data[index]` is `data[index] - 1`
   - Swap `data[index]` with `data[data[index] - 1]`
3. Otherwise, increment `index`

By the end, all elements will be in their **correct positions**.

### Time Complexity

**Worst Case:** `O(n)`  
**Average Case:** `O(n)`  
**Best Case:** `O(n)`

**Space Complexity:** `O(1)`

---

## Merge Sort

Merge Sort is a **divide and conquer** sorting algorithm.  
It works by **recursively dividing the array into smaller subarrays** until each subarray contains a single element, and then **merging those subarrays back together in sorted order**.

---

### Working of Merge Sort

#### Divide

[38, 27, 43, 10]
→ [38, 27] and [43, 10]
→ [38] [27] [43] [10]

#### Conquer

Single-element arrays are already sorted:

- [38]
- [27]
- [43]
- [10]

#### Merge

[38] + [27] → [27, 38]
[43] + [10] → [10, 43]
[27, 38] + [10, 43] → [10, 27, 38, 43]

✅ Final sorted array:
[10, 27, 38, 43]

---

### Time Complexity

- **Best Case:** `O(n log n)`
- **Average Case:** `O(n log n)`
- **Worst Case:** `O(n log n)`

---

### Space Complexity

- **Space:** `O(n)`  
  (Extra space is required for merging subarrays)

---

### Key Points

- Merge Sort is **stable**
- Performance is **predictable**
- Widely used for **linked lists** and **large datasets**
- Not an in-place algorithm

--

## Quick Sort

Quick Sort is a **divide and conquer** sorting algorithm.
It works by selecting a **pivot element** and rearranging the array so that:

- Elements **smaller than the pivot** go to the **left**
- Elements **greater than the pivot** go to the **right**
- The pivot ends up in its **correct sorted position**

The same steps are applied recursively to the left and right subarrays.

---

## General Quick Sort Algorithm

```
QUICK_SORT(arr, low, high):
    if low < high:
        pivotIndex = PARTITION(arr, low, high)
        QUICK_SORT(arr, low, pivotIndex - 1)
        QUICK_SORT(arr, pivotIndex + 1, high)
```

---

## Pivot Selection Strategies

---

## 1. Pivot = First Element (Left Pivot)

### Explanation

- The first element is chosen as the pivot.
- All smaller elements are moved to the left of the pivot.

### Algorithm

```
pivot = arr[low]
left  = low + 1
right = high

while left <= right:
    while left <= right and arr[left] < pivot:
        left++

    while left <= right and arr[right] > pivot:
        right--

    if left <= right:
        swap(arr[left], arr[right])
        left++
        right--

swap(arr[low], arr[right])
return right

```

---

## 2. Pivot = Last Element (Right Pivot)

### Explanation

- The last element is chosen as the pivot.
- Uses the **Lomuto partition scheme**.

### Algorithm

```
PARTITION_RIGHT_HOARE(arr, low, high):

    pivot = arr[high]

    left  = low
    right = high - 1

    while left <= right:

        while left <= right and arr[left] < pivot:
            left++

        while left <= right and arr[right] > pivot:
            right--

        if left <= right:
            swap(arr[left], arr[right])
            left++
            right--

    swap(arr[left], arr[high])
    return left

```

---

## 3. Pivot = Middle Element

### Explanation

- The middle element is selected as the pivot.
- Produces more balanced partitions.
- Uses **Hoare partition scheme**.

### Algorithm

```
PARTITION_MIDDLE(arr, low, high):
    mid = (low + high) // 2
    pivot = arr[mid]

    left = low
    right = high

    while left <= right:
        while arr[left] < pivot:
            left = left + 1

        while arr[right] > pivot:
            right = right - 1

        if left <= right:
            swap(arr[left], arr[right])
            left = left + 1
            right = right - 1

    return left
```

### Recursive Calls

```
QUICK_SORT(arr, low, index - 1)
QUICK_SORT(arr, index, high)
```

---

## 4. Pivot = Random Element

### Explanation

- A random element is selected as the pivot.
- Helps avoid worst-case scenarios.
- Commonly used in real systems.

### Algorithm

```
PARTITION_RANDOM(arr, low, high):
    randomIndex = RANDOM(low, high)
    swap(arr[randomIndex], arr[high])

    return PARTITION_RIGHT(arr, low, high)
```

---

## Time Complexity

| Case         | Complexity |
| ------------ | ---------- |
| Best Case    | O(n log n) |
| Average Case | O(n log n) |
| Worst Case   | O(n²)      |

---

## Space Complexity

| Case    | Complexity |
| ------- | ---------- |
| Average | O(log n)   |
| Worst   | O(n)       |

- Quick Sort is an **in-place** algorithm
- Extra space is used only for recursion stack

---

## Key Points

- Divide and Conquer algorithm
- Very fast in practice
- Not a stable sort
- Random pivot is safest for interviews but use the mid one then only time complexicity can be good other wise if array is sorted we can get worst time complexicity
