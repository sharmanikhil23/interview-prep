import java.util.ArrayList;
import java.util.HashSet;

public class question10 {
    int countDistinctIslands(int[][] grid) {
        HashSet<ArrayList<String>> unique = new HashSet<>();
        int maxY = grid.length;
        int maxX = grid[0].length;
        boolean[][] visited = new boolean[maxY][maxX];

        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    visited[i][j] = true;
                    unique.add(dfs(grid, visited, i, j, i, j));
                }
            }
        }

        return unique.size();

    }

    ArrayList<String> dfs(int[][] grid, boolean[][] visited, int prevY, int prevX, int y, int x) {
        ArrayList<String> result = new ArrayList<>();
        String temp = (y - prevY) + " , " + (x - prevX);
        result.add(temp);

        int[] rows = { +1, 0, -1, 0 };
        int[] columns = { 0, +1, 0, -1 };

        for (int i = 0; i < rows.length; i++) {

            int newX = x + columns[i];
            int newY = y + rows[i];
            if (newX >= 0 && newX < visited[0].length && newY >= 0
                    && newY < visited.length
                    && visited[newY][newX] == false && grid[newY][newX] == 1) {
                visited[newY][newX] = true;
                result.addAll(dfs(grid, visited, prevY, prevX, newY, newX));
            }
        }
        return result;
    }
}
