import java.util.ArrayList;
import java.util.List;

public class question13 {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        Boolean[] result = new Boolean[graph.length];
        boolean[] outerVisited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (outerVisited[i] == false) {
                boolean[] innerVisited = new boolean[graph.length];
                innerVisited[i] = true;
                outerVisited[i] = true;
                dfs(graph, i, result, outerVisited, innerVisited);
            }
        }
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if (result[i] != null && result[i] == true) {
                results.add(i);
            }
        }

        return results;
    }

    private static boolean dfs(int[][] graph, int node, Boolean[] result, boolean[] outerVisited,
            boolean[] innerVisited) {

        if (result[node] != null) {
            return result[node];
        }

        int[] neighbours = graph[node];
        boolean temp = true;

        for (int i = 0; i < neighbours.length; i++) {
            if (innerVisited[neighbours[i]]) {
                // mean already visited
                temp = temp && false;
            } else {
                innerVisited[neighbours[i]] = true;
                outerVisited[neighbours[i]] = true;
                temp = dfs(graph, neighbours[i], result, outerVisited, innerVisited) && temp;
                innerVisited[neighbours[i]] = false;
            }
        }

        return result[node] = temp;
    }
}
