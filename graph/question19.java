import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class question19 {
    public static String findOrder(String[] word) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < word.length; i++) {
            String prev = word[i - 1];
            String curr = word[i];

            int j = 0;
            int k = 0;

            // Edge Case: If prev is a longer prefix of curr (e.g., "apple", "app"), it's
            // invalid
            if (prev.length() > curr.length() && prev.startsWith(curr)) {
                return "";
            }

            while (j < prev.length() && k < curr.length()) {
                char first = prev.charAt(j);
                char second = curr.charAt(k);

                if (charToIndex(first) != charToIndex(second)) {
                    graph.get(charToIndex(first)).add(charToIndex(second));
                    break;
                } else {
                    j++;
                    k++;
                }
            }
        }

        Integer[] inDegree = new Integer[26];

        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                if (inDegree[i] == null) {
                    inDegree[i] = 0;
                }

                if (inDegree[graph.get(i).get(j)] == null) {
                    inDegree[graph.get(i).get(j)] = 1;
                } else {
                    inDegree[graph.get(i).get(j)]++;
                }
            }
        }

        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < word[i].length(); j++) {
                int temp = charToIndex(word[i].charAt(j));

                if (inDegree[temp] == null) {
                    inDegree[temp] = 0;
                    ;
                }

            }
        }

        return bfsTopoSort(graph, inDegree);
    }

    private static String bfsTopoSort(ArrayList<ArrayList<Integer>> graph, Integer[] inDegree) {

        Queue<Integer> data = new LinkedList<>();
        String result = "";
        int nodes = 0;

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == null) {
                continue;
            } else if (inDegree[i] == 0) {
                data.add(i);
                nodes++;
            } else {
                nodes++;
            }
        }

        while (data.isEmpty() == false) {
            int temp = data.poll();
            result += indexToChar(temp);

            ArrayList<Integer> neigh = graph.get(temp);

            for (int i = 0; i < neigh.size(); i++) {
                inDegree[neigh.get(i)]--;
                if (inDegree[neigh.get(i)] == 0) {
                    data.add(neigh.get(i));
                }
            }
        }
        // System.out.println(result);

        return result.length() == nodes ? result : "";
    }

    private static int charToIndex(char c) {
        int cT = c + 0;
        return cT - 97;
    }

    private static char indexToChar(int i) {
        return (char) (i + 97);
    }

    public static void main(String[] args) {
        String[] data = new String[] { "bbdcb", "acaca", "cdab", "ccaa", "cca", "dbab" };
        System.out.println(findOrder(data));
    }
}
