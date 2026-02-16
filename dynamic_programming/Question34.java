package dynamic_programming;

import java.util.Stack;

public class Question34 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < cols; j++) {
                // Update height: if '1', increment; if '0', reset to 0
                heights[j] = (matrix[i][j] == '1') ? heights[j] + 1 : 0;
            }
            // Calculate max rectangle for the current histogram row
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }
    // public int maximalRectangle(char[][] matrix) {
    // int[] temp = new int[matrix[0].length];
    // int maxArea = 0 ;

    // for(int i=0;i<matrix.length;i++){

    // for(int j=0;j<matrix[i].length;j++){
    // temp[j] = upSearch(matrix, i , j);
    // }

    // maxArea = Math.max(maxArea, largestRectangleArea(temp));
    // }

    // return maxArea;
    // }

    // private int upSearch(char[][] matrix, int i, int j){
    // if(i<0 || j<0){
    // return 0;
    // }else if(matrix[i][j]!='1'){
    // return 0;
    // }else{
    // return 1 + upSearch(matrix, i-1, j);
    // }
    // }

    /**
     * 
     * The piece of code below is coming form the largest histogram problem so what
     * we will do it we will go over all of the different rows create different size
     * histogram provide it to the function and will be done
     * 
     */

    class Data {
        int height;
        int index;

        public Data(int h, int i) {
            this.height = h;
            this.index = i;
        }
    }

    public int largestRectangleArea(int[] heights) {
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
        int n = heights.length;
        while (data.isEmpty() == false) {
            maxHeight = Math.max(maxHeight, data.peek().height * (n - data.peek().index));
            data.pop();
        }

        return maxHeight;
    }
}
