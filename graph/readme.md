### Graph

## Tip

Always make sure we traverse over all of the components as nodes can be non connected too

## Practice Problems

1. [BFS and DFS](#bfs-and-dfs)
2. [Number of Provinces](#Number-of-provinces)
3. [Number of Islands](#Number-of-Islands)
4. [Flood Fill](#flood-fill)
5. [Rotten oranges](#rotting-oranges)
6. [Cycle Detection Non Directed](#cycle-detection)
7. [01 Matrix](#01-matrix)
8. [Surrounded Regions](#surrounded-regions)
9. [Number of Enclaves](#number-of-enclaves)
10. [Distinct Island](#number-of-islands-1)
11. [Bipartite Graph](#bipartitie-graph)
12. [Is Cycle in Directed With DFS](#is-cycle-in-directed-with-dfs) Must Do it
13. [Elevated Safe Path DFS](#elevated-safe-path-dfs)
14. [Topological sort](#topological-sort)
15. [Detecting cycle in directed graph using bfs](#detecting-cycle-in-directed-graph-using-bfs)
16. [Course Schedule 1](#course-schedule-1)
17. [Course Schedule 2](#course-schedule-2)
18. [Elevated Safe Path BFS](#elevated-safe-path-bfs)
19. [Alien Dictionary](#alien-dictionary) ☢️ Very Important must try
20. [Shortest path in Directed Acyclic Graph](#shortest-path-in-directed-acyclic-graph)
21. [Shortest path in undirected graph with unit weights](#shortest-path-in-undirected-graph-with-unit-weights)
22. [Word Ladder - I]
23. [Dijastra]
24. Cheapest Flights Within K Stops
25. [Bellman-Ford Algorithm](#bellman-ford-algorithm) ☢️ Very Important must try
26. [Floyd-Warshall Algorithm](#floyd-warshall-algorithm) ☢️ Very Important must try

## BFS and DFS

```
For bfs we make use of queue and do one level at time

For dfs no need to use queue just keep going deep on edges
```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O(V+E)_        | _O(V)_           | Queue occupy extra storage |
| **DFS**  | _O(V+E)_        | _O(V)_           | Recursive stack            |

## Number of Provinces

```
Again can be done with both bfs and dfs as curecntly i converted the array to adjacency list it cause V^2 of time complexicity but can be in V+E too
```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O(v^2)+O(V+E)_ | _O(V)_           | Queue occupy extra storage |
| **DFS**  | _O(v^2)+O(V+E)_ | _O(V)_           | Recursive stack            |

## Number of Islands

```
Very simple Question just make sure to cover all of the edge cases which are if you are on the boundry it is true same for if you get 0 on any side
```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **DFS**  | _O(M\*N)_       | _O(M\*N)_        | Queue occupy extra storage |

## Flood Fill

```
Very Simple Question just use basic dfs or bfs for this one
```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O(M\*N)_       | _O(M\*N)_        | Queue occupy extra storage |

## Rotting Oranges

```
Not a tough one but there can be multiple things going on at the same time so have to use bfs and make sure to check the null properly in queue
```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O(M\*N)_       | _O(M\*N)_        | Queue occupy extra storage |

## Connected Components in BFS and DFS

```
The question is simple but make sure to see the input properly and follow the proceduce draw it then solve it
```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O(M\*N)_       | _O(M\*N)_        | Queue occupy extra storage |
| **DFS**  | _O(M\*N)_       | _O(M\*N)_        | Recursive stack            |

## 01 Matrix

```
Still stuck in this as thinking should be solved with dfs too
```

## Surrounded Regions

```
Easy question just solve from edges don't start doing something inside as it can messup stuff
```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O(M\*N)_       | _O(M\*N)_        | Queue occupy extra storage |
| **DFS**  | _O(M\*N)_       | _O(M\*N)_        | Recursive stack            |

## Number of Enclaves

```
Again very easy and dead similar to above one
```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O(M\*N)_       | _O(M\*N)_        | Queue occupy extra storage |
| **DFS**  | _O(M\*N)_       | _O(M\*N)_        | Recursive stack            |

## Distinct Islands

```
This is not that tough question but there are couple of things you have to take care of this
First you have to use some datastructure, which store the unique in form of the array list

another important thing to remember is we have to keep hold of initial postition as we are calculating all other connected nodes
```

| Approach | Time Complexity | Space Complexity | Why             |
| -------- | --------------- | ---------------- | --------------- |
| **DFS**  | _O(M\*N)_       | _O(M\*N)_        | Recursive stack |

## Cycle Detection

```
Again very easy
```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O(M\*N)_       | _O(M\*N)_        | Queue occupy extra storage |
| **DFS**  | _O(M\*N)_       | _O(M\*N)_        | Recursive stack            |

## BiPartitie Graph

```
Gaph with either zero cycles or even number of cycles

A graph is bipartite if its vertices can be divided into two independent, disjoint sets (let's call them $U$ and $V$) such that every edge in the graph connects a vertex in $U$ to a vertex in $V$
```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O(M\*N)_       | _O(M\*N)_        | Queue occupy extra storage |
| **DFS**  | _O(M\*N)_       | _O(M\*N)_        | Recursive stack            |

## Is Cycle in Directed With DFS

```
Simple but need to change thinking now as we are done exploring one side we need to undo the visited oen
```

| Approach | Time Complexity | Space Complexity | Why             |
| -------- | --------------- | ---------------- | --------------- |
| **DFS**  | _O(M\*N)_       | _O(M\*N)_        | Recursive stack |

## Elevated Safe Path DFS

```
Very easy question just make sure we are not redoing same thing again and again
```

| Approach | Time Complexity | Space Complexity | Why             |
| -------- | --------------- | ---------------- | --------------- |
| **DFS**  | _O(M\*N)_       | _O(M\*N)_        | Recursive stack |

## Topological sort

```
For BFS approach we have to maintian indegree array which will keep track if
the indegree is 0 or something else and reduce the indegree when we process a
neighbour and one zero add it to queue


This is dfs approach and let's write the strategy

We need to add it in stack and only add the node once we have explored all of
the neighbour

```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O(M\*N)_       | _O(M\*N)_        | Queue occupy extra storage |
| **DFS**  | _O(M\*N)_       | _O(M\*N)_        | Recursive stack            |

## Detecting cycle in directed graph using bfs

```
So we used khans algorith to find the cycle as remember in topological sort
is only possible for acyclic graph so if size of result is less than no of
vertices mean there is cycle as no topological sort is made
```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O(M\*N)_       | _O(M\*N)_        | Queue occupy extra storage |
| **DFS**  | _O(M\*N)_       | _O(M\*N)_        | Recursive stack            |

## Course Schedule 1

```
Again it is based on the Khan algorithm
```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O(M\*N)_       | _O(M\*N)_        | Queue occupy extra storage |

## Course Schedule 2

```
Again it is based on the Khan algorithm
```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O(M\*N)_       | _O(M\*N)_        | Queue occupy extra storage |

## Elevated Safe Path BFS

```
Think about it to solve it with bfs using khan algorithm. We have to reverse edges then only we know we are starting from terminal nodes and topological sort make sence
```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O(M\*N)_       | _O(M\*N)_        | Queue occupy extra storage |

## Alien Dictionary

```
Very good question there are couple of edge cases
1. Invalid inut if left sting is smaller then right and right start with the left
2. Need to consider the nodes which are not in graph but in input
3. One node might have multiple similar edge dso in future may be use some hashset
```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O(M\*N)_       | _O(M\*N)_        | Queue occupy extra storage |

## Shortest path in Directed Acyclic Graph

```
First find the topological sort of the vertices, there is good chance that you are done with toposort and starting node in toposort is not equal to the starting node to use requested

there is good chance that those vertices are not reachable from starting node soyou can avoid doing anything with them and if they are once you start processing the starting node every thing will be good

Better than dijastra or bellman ford

```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O(M\*N)_       | _O(M\*N)_        | Queue occupy extra storage |

## Shortest path in undirected graph with unit weights

```
this is easy question just make sure to first do it on paper
```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O(M\*N)_       | _O(M\*N)_        | Queue occupy extra storage |

## Word Ladder - I

```
Think before start solving and check the top most solution as have better techniques

Try to write psuedocode and try to get idea of TC and alot of time the approch we think is slow
```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O(N\*L\*26)_   | _O(M\*N)_        | Queue occupy extra storage |

## DiJastras

```
Most important Algorithm
```

## Cheapest Flights Within K Stops

```
Very Good question as we have 2 main variable dist and number of haults we can make
Please thing in cases our thing can break before making soution
| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O((N+M)log(M))_   | _O(N)_        | Priority Queue occupy extra|
```

## Bellman-Ford Algorithm

An essential graph algorithm used to find the shortest paths from a single source vertex to all other vertices in a weighted digraph. Unlike Dijkstra's algorithm, Bellman-Ford can handle graphs containing **negative edge weights**.

---

### Key Concepts & Analysis

| Approach         | Time Complexity | Space Complexity | Why                                                                |
| ---------------- | --------------- | ---------------- | ------------------------------------------------------------------ |
| **Bellman-Ford** | _O(V × E)_      | _O(V)_           | Relaxes all $E$ edges $(V - 1)$ times to guarantee shortest paths. |

---

### Algorithm Explanation

The algorithm works based on the **Principle of Relaxation**:

1. **Initialization:** Set the distance to the source node `dist[src] = 0` and all other nodes to infinity (`10^8` or `Integer.MAX_VALUE`).
2. **Relaxation Loop:** Iterate $(V - 1)$ times over all edges. For each edge `(u, v)` with weight `w`:
   - If `dist[u] != ∞` and `dist[u] + w < dist[v]`, update `dist[v] = dist[u] + w`.
3. **Why $(V - 1)$ times?** A simple shortest path in a graph with $V$ vertices contains at most $(V - 1)$ edges. Therefore, relaxing all edges $(V - 1)$ times guarantees that shortest path updates propagate to all reachable vertices.

---

### Handling Negative Weight Cycles

A **negative weight cycle** is a cycle where the sum of all edge weights is less than `0`.

- **The Problem:** If a graph contains a negative weight cycle reachable from the source, a true "shortest path" does not exist because traversing the cycle infinitely will continuously decrease the path weight to $-\infty$.
- **Detection:** Run a **$V$-th relaxation step** on all edges after completing the $(V - 1)$ iterations:
  - If any distance `dist[v]` can still be updated (`dist[u] + w < dist[v]`), it indicates the presence of a **negative weight cycle**.
  - In this case, return `[-1]` or signal that shortest paths cannot be reliably computed.

---

### Potential Edge Cases & Gotchas

- **Unreachable Nodes:** Nodes not connected to the source retain their initial infinite value (e.g., `10^8`).
- **Integer Overflow:** Adding edge weights to `Integer.MAX_VALUE` can cause integer overflow in languages like Java or C++. Always guard check `dist[u] != ∞` before performing `dist[u] + w`.

## Floyd-Warshall Algorithm

An essential Dynamic Programming graph algorithm used to find the **shortest paths between all pairs of vertices** in a weighted directed or undirected graph. Unlike single-source algorithms like Dijkstra or Bellman-Ford, Floyd-Warshall computes the shortest path matrix in a single execution and can handle graphs with **negative edge weights** (as long as there are no negative weight cycles).

---

### Key Concepts & Analysis

| Approach           | Time Complexity | Space Complexity | Why                                                                                                                |
| ------------------ | --------------- | ---------------- | ------------------------------------------------------------------------------------------------------------------ |
| **Floyd-Warshall** | _O(V³)_         | _O(V²)_          | Uses three nested loops over all $V$ vertices to evaluate all possible intermediate nodes for every $(i, j)$ pair. |

---

### Algorithm Explanation

The algorithm is based on **Dynamic Programming** and considers every vertex $k$ as an intermediate node:

1. **Initialization:** Prepare a 2D matrix `dist` of size $V \times V$.
   - `dist[i][j]` holds the weight of the direct edge from $i$ to $j$.
   - `dist[i][i] = 0` for all $i$.
   - If there is no direct edge between $i$ and $j$, set `dist[i][j] = ∞` (e.g., `10^8`).
2. **Dynamic Programming State Transition:**
   Iterate through all possible intermediate vertices $k$ from `0` to `V - 1`:
   - For every pair of source $i$ and destination $j$:
     `dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])`
3. **Outer Loop Order (Crucial):** The intermediate node loop ($k$) **must** be the outermost loop. This ensures that when calculating paths through vertex $k$, all shortest paths using vertices $\{0, 1, \dots, k-1\}$ have already been fully computed.

---

### Handling Negative Weight Cycles

A **negative weight cycle** occurs when a path starts and ends at the same vertex with a net path sum less than `0`.

- **The Problem:** Traversing a negative weight cycle continuously reduces path distances toward $-\infty$, invalidating shortest path computations.
- **Detection:** Check the main diagonal of the distance matrix (`dist[i][i]`) after running the algorithm:
  - If `dist[i][i] < 0` for any vertex $i$, the graph contains a **negative weight cycle** accessible by vertex $i$.

---

### Potential Edge Cases & Gotchas

- **Loop Order Bug:** Placing the intermediate vertex loop $k$ as the innermost loop instead of the outermost loop is a common mistake that yields incorrect results.
- **Integer Overflow / Unreachable Check:** Adding weights to $\infty$ values can lead to overflow errors. Always check that `dist[i][k] != ∞` and `dist[k][j] != ∞` before evaluating `dist[i][k] + dist[k][j]`.
- **Graph Dense vs. Sparse:** Floyd-Warshall performs best on **dense graphs** ($E \approx V^2$). For sparse graphs ($E \ll V^2$), running Dijkstra's algorithm with binary heaps $V$ times is generally faster ($O(V \cdot E \log V)$).
