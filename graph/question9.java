import java.util.LinkedList;
import java.util.Queue;

public class question9 {
    public int numEnclavesDFS(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (a[i][0] == 1 && visited[i][0] == false) {
                visited[i][0] = true;
                check(a, visited, i, 0);
            }
        }

        for (int i = 0; i < n; i++) {
            if (a[i][m - 1] == 1 && visited[i][m - 1] == false) {
                visited[i][m - 1] = true;
                check(a, visited, i, m - 1);
            }

        }

        for (int i = 0; i < m; i++) {
            if (a[0][i] == 1 && visited[0][i] == false) {
                visited[0][i] = true;
                check(a, visited, 0, i);
            }

        }

        for (int i = 0; i < m; i++) {
            if (a[n - 1][i] == 1 && visited[n - 1][i] == false) {
                visited[n - 1][i] = true;
                check(a, visited, n - 1, i);
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] != true && a[i][j] == 1) {
                    result++;
                }
            }
        }

        return result;

    }

    void check(int a[][], boolean visited[][], int row, int column) {
        if (a[row][column] == 0) {
            return;
        }

        int[] rows = { +1, 0, -1, 0 };
        int[] columns = { 0, +1, 0, -1 };

        for (int i = 0; i < rows.length; i++) {
            if (row + rows[i] >= 0 && row + rows[i] < visited.length && column + columns[i] >= 0
                    && column + columns[i] < visited[0].length
                    && visited[row + rows[i]][column + columns[i]] == false) {
                visited[row + rows[i]][column + columns[i]] = true;
                check(a, visited, row + rows[i], column + columns[i]);
            }
        }
    }

    public int numEnclavesBfs(int[][] board) {
        // just check all of the edge elements and if they are zero then add it to queue
        // else not
        Queue<int[]> data = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 1) {
                visited[0][i] = true;
                data.add(new int[] { 0, i });
            }

            if (board[board.length - 1][i] == 1) {
                visited[board.length - 1][i] = true;
                data.add(new int[] { board.length - 1, i });
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 1) {
                visited[i][0] = true;
                data.add(new int[] { i, 0 });
            }

            if (board[i][board[0].length - 1] == 1) {
                visited[i][board[0].length - 1] = true;
                data.add(new int[] { i, board[0].length - 1 });
            }
        }

        int[] yy = new int[] { -1, 0, 1, 0 };
        int[] xx = new int[] { 0, 1, 0, -1 };

        while (data.isEmpty() == false) {
            int[] temp = data.poll();

            for (int i = 0; i < yy.length; i++) {
                int newY = yy[i] + temp[0];
                int newX = xx[i] + temp[1];

                if (newX >= 0 && newY >= 0 && newX < board[0].length && newY < board.length && !visited[newY][newX]
                        && board[newY][newX] == 1) {
                    visited[newY][newX] = true;
                    data.add(new int[] { newY, newX });
                }
            }

        }

        int result = 0;

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if (visited[i][j] != true && board[i][j] == 1) {
                    result++;
                }
            }
        }

        return result;
    }

}
