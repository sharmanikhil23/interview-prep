import java.util.ArrayList;

public class question12 {

    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> formattedData = transform(V, edges);
        for (int i = 0; i < V; i++) {
            boolean[] visited = new boolean[V];
            visited[i] = true;
            if (dfs(i, visited, formattedData)) {
                return true;
            }

        }

        return false;

    }

    private boolean dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> data) {
        ArrayList<Integer> neighbours = data.get(node);
        boolean result = false;
        for (int j = 0; j < neighbours.size(); j++) {
            int newNode = neighbours.get(j);
            if (visited[newNode]) {
                return true;
            } else {
                visited[newNode] = true;
                result = result || dfs(newNode, visited, data);
                visited[newNode] = false;
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> transform(int v, int[][] edges) {

        ArrayList<ArrayList<Integer>> data = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            data.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            data.get(e[0]).add(e[1]);
        }

        return data;
    }

}
