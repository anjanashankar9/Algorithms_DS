/**
 * Created by ashankar1 on 10/9/15.
 */

/**
 * http://www.geeksforgeeks.org/topological-sorting/
 * Topological Sorting
 *
 */
public class Dag {
    public static void main(String args[]){

        Graph G = new Graph(6);

        G.addEdge(5, 2);
        G.addEdge(5, 0);
        G.addEdge(4, 0);
        G.addEdge(4, 1);
        G.addEdge(2, 3);
        G.addEdge(3, 1);

        G.topologicalSort();
    }
}
