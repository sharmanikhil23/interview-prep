import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class question15 {
    /**
     * So we used khans algorith to find the cycle as remember in topological sort
     * is only possible for acyclic graph so if size of result is less than no of
     * vertices mean there is cycle as no topological sort is made
     * 
     */
    public boolean isCyclic(int V, int[][] edges) {
        return bfs(V, edges);
    }

    public boolean bfs(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> data = fixingData(V, edges);
        int[] inDegree = new int[V];
        Queue<Integer> temp = new LinkedList<>();

        for (int[] e : edges) {
            inDegree[e[1]]++;
        }

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                temp.add(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        while (temp.isEmpty() == false) {
            int tempData = temp.poll();
            result.add(tempData);

            ArrayList<Integer> neighbours = data.get(tempData);

            for (int i = 0; i < neighbours.size(); i++) {
                inDegree[neighbours.get(i)]--;

                if (inDegree[neighbours.get(i)] == 0) {
                    temp.add(neighbours.get(i));
                }
            }
        }

        return result.size() == V ? false : true;

    }

    private ArrayList<ArrayList<Integer>> fixingData(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            data.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            data.get(edges[i][0]).add(edges[i][1]);
        }

        return data;
    }
}
