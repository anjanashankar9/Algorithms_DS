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

        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        if(g.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}
