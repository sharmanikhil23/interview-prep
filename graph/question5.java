import java.util.LinkedList;
import java.util.Queue;

public class question5 {
    public int orangesRotting(int[][] grid) {
        int maxX = grid[0].length;
        int maxY = grid.length;

        Queue<int[]> rotten = new LinkedList<>();
        int notRotten = 0;

        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                if (grid[i][j] == 2) {
                    rotten.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    notRotten++;
                }
            }
        }

        rotten.add(null);

        int result = 0;
        int[] iDir = new int[] { -1, 0, 1, 0 };
        int[] jDir = new int[] { 0, 1, 0, -1 };

        while (rotten.isEmpty() == false) {
            int[] temp = rotten.poll();

            if (temp == null) {
                if (!rotten.isEmpty()) {
                    rotten.add(null);
                    result++;
                }
            } else {
                for (int k = 0; k < iDir.length; k++) {
                    int newR = temp[0] + iDir[k];
                    int newC = temp[1] + jDir[k];

                    if (newR >= 0 && newC >= 0 && newR < grid.length && newC < grid[0].length
                            && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        rotten.add(new int[] { newR, newC });
                        notRotten--;
                    }
                }
            }
        }

        // for(int r = 0; r < maxY; r++){
        // for(int c = 0; c < maxX; c++){
        // if(grid[r][c] == 1){
        // return -1;
        // }
        // }
        // }

        return notRotten == 0 ? result : -1;
    }
}
