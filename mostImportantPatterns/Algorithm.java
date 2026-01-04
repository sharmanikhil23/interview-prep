package mostImportantPatterns;

import java.util.ArrayList;
import java.util.List;

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
        int e = num.length - 1;

        while (s < e) {
            if (num[s] + num[e] == target) {
                return new int[] { s + 1, e + 1 };
            } else if (num[s] + num[e] > target) {
                e--;
            } else {
                s++;
            }
        }

        return new int[] { -1, -1 };
    }

    // Two pointer but extra list
    public static String reverseWord1(String s) {
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

     public String reverseWords(String s) {
        char[] data = s.toCharArray();

        // Step 1: reverse whole string
        reverse(data, 0, data.length - 1);

        int i = 0; // write pointer
        int j = 0; // read pointer

        while (j < data.length) {
            if (data[j] != '.') {

                // add dot between words
                if (i != 0) data[i++] = '.';

                int wordStart = i;

                // copy word
                while (j < data.length && data[j] != '.') {
                    data[i++] = data[j++];
                }

                // reverse the word back
                reverse(data, wordStart, i - 1);
            } else {
                j++;
            }
        }

        return new String(data, 0, i);
    }

    private static void reverse(char[] data, int start, int end) {
        while (start < end) {
            char temp = data[start];
            data[start] = data[end];
            data[end] = temp;
            start++;
            end--;
        }
    }
    

    


}
