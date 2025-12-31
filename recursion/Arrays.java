package recursion;

import java.util.ArrayList;

public class Arrays {

    public int rotatedSearch(int[] nums, int target) {
        return rotatedSearch(nums, target, 0, nums.length - 1);
    }

    /**
     * Very interesting for logic 
     * 
     * Take out binary serach from your mind and think which side is 
     * sorted if left is sorted check if target is in that sorted area if not check the 
     * different side. 
     * 
     * 
     * @param nums
     * @param target
     * @param start
     * @param end
     * @return
     */
    private int rotatedSearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        // LEFT half is sorted
        if (nums[start] <= nums[mid]) {
            if (target >= nums[start] && target < nums[mid]) {
                return rotatedSearch(nums, target, start, mid - 1);
            } else {
                return rotatedSearch(nums, target, mid + 1, end);
            }
        }
        // RIGHT half is sorted
        else {
            if (target > nums[mid] && target <= nums[end]) {
                return rotatedSearch(nums, target, mid + 1, end);
            } else {
                return rotatedSearch(nums, target, start, mid - 1);
            }
        }
    }

    public static ArrayList<Integer> multipleLinearSearch(int[] data, int target) {
        return multipleLinearSearch(data, target, 0);
    }

    public static ArrayList<Integer> multipleLinearSearch(int[] data, int target, int index) {
        ArrayList<Integer> result = new ArrayList<>();
        
        if (index >= data.length) {
            return result;
        }

        if (data[index] == target) {
            result.add(index);
        }

        result.addAll(multipleLinearSearch(data, target, index + 1));

        return result;

    }


    public static int linearSearch(int[] data, int target) {
        return linearSearch(data, target, 0);
    }
    
    private static int linearSearch(int[] data, int target, int index) {
        if (index >= data.length) {
            return -1;
        }
        
        if (data[index] == target) {
            return index;
        } else {
            return linearSearch(data, target, index + 1);
        }
    }

    public static boolean isSortedArray(int[] data) {
        if (data.length > 1) {
            return isSortedArray(data, 1);
        }
        return true;
    }
    
    private static boolean isSortedArray(int[] data, int index) {
        if (index >= data.length) {
            return true;
        }

        if (data[index - 1] <= data[index]) {
            return true && isSortedArray(data, index + 1);
        } else {
            return false;
        }
    }
    
}
