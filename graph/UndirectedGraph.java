package graph;

/* See restrictions in Graph.java. */

import java.util.ArrayList;

/** Represents an undirected graph.  Out edges and in edges are not
 *  distinguished.  Likewise for successors and predecessors.
 *
 *  @author Ruhao Xia
 */
public class UndirectedGraph extends GraphObj {

    @Override
    public boolean isDirected() {
        return false;
    }

    @Override
    public int inDegree(int v) {
        if (!contains(v)) {
            return 0;
        }
        return getGraph().get(v).getPred().size();
    }

    @Override
    public int predecessor(int v, int k) {
        if (contains(v)) {
            ArrayList<Integer> pred = getGraph().get(v).getPred();
            int size = pred.size();
            if (k < size) {
                return pred.get(k);
            }
        }
        return 0;
    }

    @Override
    public Iteration<Integer> predecessors(int v) {
        return successors(v);
    }
}
