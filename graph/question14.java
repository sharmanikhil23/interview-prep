import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class question14 {

    /**
     * 
     * For BFS approach we have to maintian indegree array which will keep track if
     * the indegree is 0 or something else and reduce the indegree when we process a
     * neighbour and one zero add it to queue
     */
    public ArrayList<Integer> bfs(int V, int[][] edges) {
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

        return result;

    }

    /**
     * 
     * This is dfs approach and let's write the strategy
     * 
     * We need to add it in stack and only add the node once we have explored all of
     * the neighbour
     */
    public ArrayList<Integer> dfs(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> data = fixingData(V, edges);

        boolean[] visited = new boolean[V];
        Stack<Integer> tempResult = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, data, visited, tempResult);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (tempResult.isEmpty() == false) {
            result.add(tempResult.pop());
        }
        return result;
    }

    private void dfs(int index, ArrayList<ArrayList<Integer>> data, boolean[] visited, Stack<Integer> tempResult) {

        ArrayList<Integer> neighbour = data.get(index);

        for (int i = 0; i < neighbour.size(); i++) {
            if (!visited[neighbour.get(i)]) {
                visited[neighbour.get(i)] = true;
                dfs(neighbour.get(i), data, visited, tempResult);
            }
        }
        tempResult.push(index);
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