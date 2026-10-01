import java.util.ArrayList;
import java.util.Arrays;

public class question29 {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {
        ArrayList<Integer> result = new ArrayList<>();

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int d = edges[j][2];
                if (dist[u] == Integer.MAX_VALUE) {
                    continue;
                } else {
                    int newD = dist[u] + d;
                    dist[edges[j][1]] = Math.min(dist[v], newD);
                }
            }
        }

        for (int j = 0; j < edges.length; j++) {
            int u = edges[j][0];
            int v = edges[j][1];
            int d = edges[j][2];
            if (dist[u] == Integer.MAX_VALUE) {
                continue;
            } else {
                int newD = dist[u] + d;
                if (dist[v] > newD) {
                    result.add(-1);
                    return result;
                }
                dist[edges[j][1]] = Math.min(dist[v], newD);
            }
        }

        for (int d : dist) {
            if (d == Integer.MAX_VALUE) {
                result.add(100000000);
            } else {
                result.add(d);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[][] data = new int[][] { { 1, 3, 2 }, { 4, 3, -1 }, { 2, 4, 1 }, { 1, 2, 1 }, { 0, 1, 5 } };
        question29 question29 = new question29();
        System.out.println(question29.bellmanFord(5, data, 0));
    }
}
