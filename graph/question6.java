import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class question6 {

    public boolean isCycle(int V, int[][] edges) {

        return dfs(V, edges);

    }

    public static boolean dfs(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> data = arrayToArrayList(edges, V);
        boolean[] visited = new boolean[data.size()];

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;

            if (dfs(data, visited, i, -1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> data, boolean[] visited, int node, int prev) {
        ArrayList<Integer> temp = data.get(node);
        boolean result = false;
        for (int i = 0; i < temp.size(); i++) {
            if (prev != temp.get(i) && visited[temp.get(i)] == true) {
                return true;
            } else if (prev != temp.get(i) && visited[temp.get(i)] == false) {
                visited[temp.get(i)] = true;

                result = result || dfs(data, visited, temp.get(i), node);
            }
        }
        return result;
    }

    public static boolean bfs(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> data = arrayToArrayList(edges, V);
        boolean[] visited = new boolean[data.size()];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < visited.length; i++) {

            if (visited[i]) {
                continue;
            }

            q.add(new int[] { i, -1 });
            visited[i] = true;

            while (q.isEmpty() == false) {

                int[] temp = q.poll();

                ArrayList<Integer> neighbours = data.get(temp[0]);

                for (int j = 0; j < neighbours.size(); j++) {

                    if (visited[neighbours.get(j)] == true && neighbours.get(j) != temp[1]) {

                        return true;

                    } else if (visited[neighbours.get(j)] == false) {

                        visited[neighbours.get(j)] = true;
                        q.add(new int[] { neighbours.get(j), temp[0] });

                    }
                }

            }
        }

        return false;
    }

    public static ArrayList<ArrayList<Integer>> arrayToArrayList(int[][] isConnected, int v) {
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            data.add(new ArrayList<>());
        }

        for (int i = 0; i < isConnected.length; i++) {
            int[] temp = isConnected[i];
            data.get(temp[0]).add(temp[1]);
            data.get(temp[1]).add(temp[0]);
        }

        return data;

    }

    public static void main(String[] args) {
        int[][] temp = new int[][] { { 1, 2 }, { 2, 3 } };
        System.out.println(dfs(4, temp));
    }
}
