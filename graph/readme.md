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
