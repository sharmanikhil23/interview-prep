public class question3 {
    // lets assume it as the graph and try to solve it
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length + 1][grid[0].length + 1];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == false && grid[i][j] == '1') {
                    result++;
                    check(visited, grid, i, j);
                }
            }
        }
        return result;
    }

    private void check(boolean[][] visited, char[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[row].length || visited[row][column] == true
                || grid[row][column] == '0') {
            return;
        }

        visited[row][column] = true;
        check(visited, grid, row - 1, column);
        check(visited, grid, row, column + 1);
        check(visited, grid, row + 1, column);
        check(visited, grid, row, column - 1);
    }
}
