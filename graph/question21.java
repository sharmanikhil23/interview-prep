import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class question21 {

    public int[] shortestPath(int[][] edges, int N, int M) {
        ArrayList<ArrayList<Integer>> temp1 = fixData(N, edges);

        Queue<int[]> data = new LinkedList<>();
        boolean[] visited = new boolean[N];
        visited[0] = true;

        Integer[] dist = new Integer[N];
        dist[0] = 0;

        data.add(new int[] { 0, 0 });

        while (data.isEmpty() == false) {
            int[] temp = data.poll();

            ArrayList<Integer> neightbour = temp1.get(temp[0]);

            for (int i = 0; i < neightbour.size(); i++) {
                if (visited[neightbour.get(i)] == false) {
                    dist[neightbour.get(i)] = temp[1] + 1;
                    visited[neightbour.get(i)] = true;
                    data.add(new int[] { neightbour.get(i), temp[1] + 1 });
                }
            }
        }

        int[] result = new int[N];
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] != null) {
                result[i] = dist[i];
            } else {
                result[i] = -1;
            }
        }

        return result;
    }

    private ArrayList<ArrayList<Integer>> fixData(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            result.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            result.get(edges[i][0]).add(edges[i][1]);
            result.get(edges[i][1]).add(edges[i][0]);
        }

        return result;
    }

}
