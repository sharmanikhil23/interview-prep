
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;;

public class question1 {
    /**
     * This basic parsing question both bfd and dfs
     */
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();

        for (int j = 0; j < adj.size(); j++) {
            if (visited[j])
                continue;

            queue.add(j);
            visited[j] = true;

            while (queue.isEmpty() == false) {
                Integer temp = queue.poll();
                bfs.add(temp);

                ArrayList<Integer> neighbours = adj.get(temp);

                for (int i = 0; i < neighbours.size(); i++) {
                    if (visited[neighbours.get(i)] == false) {
                        visited[neighbours.get(i)] = true;
                        queue.add(neighbours.get(i));
                    }
                }
            }
        }

        return bfs;
    }

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> bfs = new ArrayList<>();

        for (int j = 0; j < adj.size(); j++) {
            if (visited[j])
                continue;

            visited[j] = true;
            bfs.addAll(dfs(adj, visited, j));
        }

        return bfs;
    }

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(node);

        ArrayList<Integer> neighbours = adj.get(node);

        for (int i = 0; i < neighbours.size(); i++) {
            if (visited[neighbours.get(i)] == false) {
                visited[neighbours.get(i)] = true;
                result.addAll(dfs(adj, visited, neighbours.get(i)));
            }
        }

        return result;
    }

}
