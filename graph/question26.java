import java.util.*;

public class question26 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build adjacency list
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int[] f : flights) {
            adj[f[0]].add(new int[] { f[1], f[2] });
        }

        // PriorityQueue ordered by total cost ascending: {city, cost, stops_taken}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[] { src, 0, 0 });

        // Tracks the minimum stops taken to reach each city so far
        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            // First time we poll dst, it's guaranteed to be the minimum cost route within
            // <= k stops
            if (u == dst)
                return cost;

            // Stop expanding if we've exceeded k stops or found a path with >= stops before
            if (stops > k || stops >= minStops[u])
                continue;

            minStops[u] = stops;

            for (int[] neighbor : adj[u]) {
                int v = neighbor[0];
                int price = neighbor[1];
                pq.add(new int[] { v, cost + price, stops + 1 });
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] data = new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0;
        int dest = 3;
        int k = 1;
        question26 question28 = new question26();
        System.out.println(question28.findCheapestPrice(4, data, src, dest, k));
    }
}
