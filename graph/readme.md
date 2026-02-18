### Graph

## Tip

Always make sure we traverse over all of the components as nodes can be non connected too

## Practice Problems

1. [BFS and DFS](#bfs-and-dfs)

## BFS and DFS

```
For bfs we make use of queue and do one level at time

For dfs no need to use queue just keep going deep on edges
```

| Approach | Time Complexity | Space Complexity | Why                        |
| -------- | --------------- | ---------------- | -------------------------- |
| **BFS**  | _O(V+E)_        | _O(V)_           | Queue occupy extra storage |
| **DFS**  | _O(V+E)_        | _O(V)_           | Recursive stack            |
