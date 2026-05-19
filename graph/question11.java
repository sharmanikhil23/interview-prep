import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class question11 {

    class Node {
        int node;
        int parent;
        int color; // 1 mean red 0 mean blue

        Node(int n, int p, int c) {
            this.node = n;
            this.parent = p;
            this.color = c;
        }
    }

    public boolean isBipartite(int[][] graph) {
        return dfs(graph);
    }

    private boolean dfs(int[][] graph) {
        ArrayList<ArrayList<Integer>> data = format(graph);
        Node[] visited = new Node[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] != null) {
                continue;
            } else {
                Node temp = new Node(i, -1, 0);
                visited[i] = temp;
                if (dfs(visited, data, temp) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(Node[] visited, ArrayList<ArrayList<Integer>> data, Node current) {
        ArrayList<Integer> neighbours = data.get(current.node);
        boolean result = true;
        for (int j = 0; j < neighbours.size(); j++) {
            int newNode = neighbours.get(j);
            if (visited[newNode] != null) {
                if (current.parent != newNode && visited[newNode].color != getColor(current.color)) {
                    return false;
                } else {
                    continue;
                }
            } else {
                Node temp2 = new Node(newNode, current.node, getColor(current.color));
                visited[newNode] = temp2;
                result = result && dfs(visited, data, temp2);
            }
        }
        return result;
    }

    private boolean bfs(int[][] graph) {
        ArrayList<ArrayList<Integer>> data = format(graph);
        Node[] visited = new Node[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] != null) {
                continue;
            } else {
                Queue<Node> queue = new LinkedList<>();
                Node temp = new Node(i, -1, 0);
                queue.add(temp);
                visited[i] = temp;

                while (!queue.isEmpty()) {
                    Node temp1 = queue.poll();

                    ArrayList<Integer> neighbours = data.get(temp1.node);
                    // either parent,
                    // already visited with same color
                    // already viisted with different color
                    // not visited

                    for (int j = 0; j < neighbours.size(); j++) {
                        int newNode = neighbours.get(j);
                        if (visited[newNode] != null) {
                            if (temp1.parent != newNode && visited[newNode].color != getColor(temp1.color)) {
                                return false;
                            } else {
                                continue;
                            }
                        } else {
                            Node temp2 = new Node(newNode, temp1.node, getColor(temp1.color));
                            visited[newNode] = temp2;
                            queue.add(temp2);
                        }
                    }
                }
            }
        }
        return true;
    }

    private int getColor(int c) {
        return c == 1 ? 0 : 1;
    }

    public ArrayList<ArrayList<Integer>> format(int[][] graph) {
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            data.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                data.get(i).add(graph[i][j]);
            }
        }

        return data;
    }

}
