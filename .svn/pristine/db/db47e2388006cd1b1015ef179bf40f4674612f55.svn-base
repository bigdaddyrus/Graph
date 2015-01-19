package graph;
import java.util.ArrayList;
/* See restrictions in Graph.java. */

/** Represents a general unlabeled directed graph whose vertices are denoted by
 *  positive integers. Graphs may have self edges.
 *
 *  @author Ruhao Xia
 */
public class DirectedGraph extends GraphObj {

    @Override
    public boolean isDirected() {
        return true;
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
        ArrayList<Integer> pred = new ArrayList<>();
        if (contains(v)) {
            pred = getGraph().get(v).getPred();
            return Iteration.iteration(pred);
        }
        return Iteration.iteration(pred);
    }


}
