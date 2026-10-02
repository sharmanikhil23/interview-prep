import java.util.Arrays;

public class Question30 {

    public void floydWarshall(int[][] dist) {
        int y = dist.length;
        int x = dist[0].length;
        int max = 100000000;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if (dist[j][i] != max && dist[i][k] != max && dist[j][k] > dist[j][i] + dist[i][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] data = new int[][] { { 0, 4, 108, 5, 108 }, { 108, 0, 1, 108, 6 }, { 2, 108, 0, 3, 108 },
                { 108, 108, 1, 0, 2 }, { 1, 108, 108, 4, 0 } };
        Question30 question30 = new Question30();
        question30.floydWarshall(data);
        for (int[] d : data) {
            System.out.println(Arrays.toString(d));
        }

    }
}
