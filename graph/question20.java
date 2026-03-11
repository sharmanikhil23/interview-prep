import java.util.ArrayList;
import java.util.*;

public class question20 {
    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Integer[]>> data = fixData(V, edges);

        Stack<Integer> topo = new Stack<Integer>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                toposort(data, topo, visited, i);
            }
        }

        int[] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        while (topo.isEmpty() == false) {
            Integer u = topo.pop();
            if (result[u] != Integer.MAX_VALUE) {
                for (Integer[] neighbor : data.get(u)) {
                    int v = neighbor[0];
                    int weight = neighbor[1];
                    if (result[u] + weight < result[v]) {
                        result[v] = result[u] + weight;
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (result[i] == Integer.MAX_VALUE)
                result[i] = -1;
        }

        return result;
    }

    private void toposort(ArrayList<ArrayList<Integer[]>> data, Stack<Integer> result, boolean[] visited, int index) {
        ArrayList<Integer[]> neighbours = data.get(index);

        for (int i = 0; i < neighbours.size(); i++) {
            if (visited[neighbours.get(i)[0]] == false) {
                visited[neighbours.get(i)[0]] = true;
                toposort(data, result, visited, neighbours.get(i)[0]);
            }
        }
        result.push(index);
    }

    private ArrayList<ArrayList<Integer[]>> fixData(int V, int[][] edges) {
        ArrayList<ArrayList<Integer[]>> result = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            result.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            result.get(edges[i][0]).add(new Integer[] { edges[i][1], edges[i][2] });
        }

        return result;
    }
}
