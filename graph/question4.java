import java.util.LinkedList;
import java.util.Queue;

public class question4 {
    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean visited[][] = new boolean[image.length][image[0].length];
        int sColor = image[sr][sc];

        Queue<Node> queue = new LinkedList<>();
        image[sr][sc] = color;
        visited[sr][sc] = true;
        queue.add(new Node(sr, sc));

        while (queue.isEmpty() == false) {
            Node temp = queue.poll();

            int[] i = new int[] { -1, 0, 1, 0 };
            int[] j = new int[] { 0, 1, 0, -1 };

            for (int k = 0; k < i.length; k++) {
                int newR = temp.x + i[k];
                int newC = temp.y + j[k];

                if (newR >= 0 && newC >= 0 && newR < image.length && newC < image[0].length
                        && visited[newR][newC] == false && image[newR][newC] == sColor) {
                    image[newR][newC] = color;
                    visited[newR][newC] = true;
                    queue.add(new Node(newR, newC));
                }
            }
        }

        return image;

    }
}
