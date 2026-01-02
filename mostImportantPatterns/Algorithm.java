package mostImportantPatterns;

public class Algorithm {
    
    /**
     * This is to remove duplicate
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int s = 0;
        int f = 1;

        while (f < nums.length && s < f) {
            if (nums[s] == nums[f]) {
                f++;
            } else {
                // mean it is worth swapping
                if (Math.abs(f - s) > 1) {
                    s++;
                    int temp = nums[s];
                    nums[s] = nums[f];
                    nums[f] = temp;
                    f++;
                } else {
                    s++;
                    f++;
                }
            }
        }
        return s+1;
    }
    
    public static int removeDuplicates1(int[] nums) {
        int s = 0;
        int f = 1;

        while(f < nums.length && s<f){
            if(nums[s] == nums[f]){
                f++;
            }else{
                // mean it is worth swapping
                s++;
                f++;
            }
        }
        return s+1;
    }


/**
 * Array will be already sorted need to find indexes for which sum is equal to target
 * @param num
 * @param target
 * @return
 */
    public static int[] twoSum(int[] num, int target) {
        int s = 0; 
        int e = num.length-1;

        while(s<e){
            if(num[s]+num[e] == target){
                return new int[]{s+1,e+1};
            }else if(num[s]+num[e] > target){
                e--;
            }else{
                s++;
            }
        }

        return new int[]{-1,-1};
    }
}
