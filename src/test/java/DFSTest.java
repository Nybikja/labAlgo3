import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DFSTest {
    Graph g = new Graph(6);


    @Test
    public void dfsTest() {
        int[] expected = {2, 0, 1, 3, 4, 5};
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 0);

        g.DFS(2);

        Assert.assertArrayEquals(expected, g.getPath());
    }
}
