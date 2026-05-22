
import java.util.LinkedList;
import java.util.Queue;

public class question7 {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Initialize result matrix and queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] { i, j });
                } else {
                    mat[i][j] = Integer.MAX_VALUE; // Use mat directly to save memory
                }
            }
        }

        int[] rows = { -1, 0, 1, 0 };
        int[] cols = { 0, 1, 0, -1 };

        // Step 2: Single-pass Multi-Source BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int s = 0; s < 4; s++) {
                int nRow = r + rows[s];
                int nCol = c + cols[s];

                // If the neighbor is valid and we found a shorter path to it
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n) {
                    if (mat[nRow][nCol] > mat[r][c] + 1) {
                        mat[nRow][nCol] = mat[r][c] + 1;
                        queue.add(new int[] { nRow, nCol });
                    }
                }
            }
        }

        return mat;
    }
}
