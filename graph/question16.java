import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class question16 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return bfs(numCourses, prerequisites);
    }

    public boolean bfs(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> data = fixingData(V, edges);
        int[] inDegree = new int[V];
        Queue<Integer> temp = new LinkedList<>();

        for (int[] e : edges) {
            inDegree[e[0]]++;
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
        System.out.println(result);
        return result.size() == V ? true : false;

    }

    private ArrayList<ArrayList<Integer>> fixingData(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            data.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            data.get(edges[i][1]).add(edges[i][0]);
        }

        return data;
    }
}
