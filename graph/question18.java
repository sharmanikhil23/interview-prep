import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class question18 {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> data = fixData(graph);
        int[] indegree = new int[graph.length];

        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).size(); j++) {
                indegree[data.get(i).get(j)]++;
            }
        }

        Queue<Integer> temp = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                temp.add(i);
            }
        }

        while (temp.isEmpty() == false) {
            int tempData = temp.poll();

            ArrayList<Integer> neighbours = data.get(tempData);

            for (int i = 0; i < neighbours.size(); i++) {
                indegree[neighbours.get(i)]--;

                if (indegree[neighbours.get(i)] == 0) {
                    temp.add(neighbours.get(i));
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }

    private ArrayList<ArrayList<Integer>> fixData(int[][] graph) {
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            data.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                data.get(graph[i][j]).add(i);
            }
        }

        return data;
    }
}
