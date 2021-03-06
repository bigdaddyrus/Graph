package graph;
import java.util.ArrayDeque;
/* See restrictions in Graph.java. */

/** Implements a depth-first traversal of a graph.  Generally, the
 *  client will extend this class, overriding the visit and
 *  postVisit methods, as desired (by default, they do nothing).
 *  @author Ruhao Xia
 */
public class DepthFirstTraversal extends Traversal {

    /** A depth-first Traversal of G, using FRINGE as the fringe. */
    protected DepthFirstTraversal(Graph G) {
        super(G, new ArrayDeque2<Integer>());
    }

    @Override
    protected boolean postVisit(int v) {
        return super.postVisit(v);
    }

    @Override
    protected boolean shouldPostVisit(int v) {
        return true;
    }

    /** A FIFO ArrayDeque with add override. */
    protected static class ArrayDeque2<Integer> extends ArrayDeque<Integer> {

        /** A ArrayDeque2 Constructor. */
        public ArrayDeque2() {
            super();
        }

        @Override
        public boolean add(Integer e) {
            addFirst(e);
            return true;
        }
    }

}
