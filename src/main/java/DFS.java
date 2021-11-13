import java.util.*;


class DFS {
    private final ArrayList<Integer>[] lists;
    private final boolean[] visited;

    DFS(int numberOfPoints) {
        lists = new ArrayList[numberOfPoints];
        visited = new boolean[numberOfPoints];

        for (int i = 0; i < numberOfPoints; i++)
            lists[i] = new ArrayList<>();
    }

    void addEdge(int parent, int child) {
        lists[parent].add(child);
    }

    void search(int index) {
        visited[index] = true;
        System.out.print(index + " ");

        for (Object o : lists[index]) {
            int adj = (int) o;
            if (!visited[adj])
                search(adj);
        }
    }


    public static void main(String[] args) {
        DFS d = new DFS(7);

        d.addEdge(0, 1);
        d.addEdge(0, 2);
        d.addEdge(1, 2);
        d.addEdge(2, 3);
        d.addEdge(3, 4);
        d.addEdge(2, 4);
        d.addEdge(3, 5);


        d.search(0);
    }
}


//      0            5
//    /   \         /
//   1 ---- 2 ---- 3
//             \ /
//              4