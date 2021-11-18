import java.util.*;


class Graph {
    private final int verticles;
    private final LinkedList<Integer>[] adj;
    private int[] path;
    List<Integer> tempArray = new ArrayList<>();

    Graph(int verticles) {
        this.verticles = verticles;
        adj = new LinkedList[verticles];
        for (int i = 0; i < verticles; ++i)
            adj[i] = new LinkedList();
    }

    int[] getPath() {
        return path;
    }

    void addEdge(int v, int e) {
        adj[v].add(e);
    }

    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        tempArray.add(v);
        System.out.print(v + " ");
        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
        path = tempArray.stream().mapToInt(i -> i).toArray();
    }
    void DFS(int verticle) {
        boolean[] visited = new boolean[verticles];
        DFSUtil(verticle, visited);
    }
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 0);

        g.DFS(2);
    }
}

//
//
//   0 -- 1
//    \  /
//     2  -- 3 -- 4 -- 5
//
//