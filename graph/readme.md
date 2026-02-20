### Graph

## Tip

Always make sure we traverse over all of the components as nodes can be non connected too

## Practice Problems

1. [BFS and DFS](#bfs-and-dfs)
2. [Number of Provinces](#Number-of-provinces)
3. [Number of Islands](#Number-of-Islands)
4. [Flood Fill](#flood-fill)

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
| **DFS**  | _O(M\*N)_       | _O(M\*N)_        | Queue occupy extra storage |
