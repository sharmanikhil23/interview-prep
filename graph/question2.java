
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class question2 {

    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();

        for (int i = 0; i < isConnected.length; i++) {
            data.add(new ArrayList<>());
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    data.get(i).add(j);
                }
            }
        }

        return dfs(data);
    }

    public int dfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        int result = 0;

        for (int j = 0; j < adj.size(); j++) {
            if (visited[j])
                continue;

            visited[j] = true;
            dfs(adj, visited, j);
            result++;
        }

        return result;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node) {

        ArrayList<Integer> neighbours = adj.get(node);

        for (int i = 0; i < neighbours.size(); i++) {
            if (visited[neighbours.get(i)] == false) {
                visited[neighbours.get(i)] = true;
                dfs(adj, visited, neighbours.get(i));
            }
        }

        return;
    }

    public int bfs(ArrayList<ArrayList<Integer>> adj) {
        int result = 0;
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();

        for (int j = 0; j < adj.size(); j++) {
            if (visited[j])
                continue;
            result++;
            queue.add(j);
            visited[j] = true;

            while (queue.isEmpty() == false) {
                Integer temp = queue.poll();

                ArrayList<Integer> neighbours = adj.get(temp);

                for (int i = 0; i < neighbours.size(); i++) {
                    if (visited[neighbours.get(i)] == false) {
                        visited[neighbours.get(i)] = true;
                        queue.add(neighbours.get(i));
                    }
                }
            }
        }

        return result;
    }
}
