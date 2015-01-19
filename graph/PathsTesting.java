package graph;

import org.junit.Test;
import java.util.ArrayList;

import java.util.Arrays;
import static org.junit.Assert.*;

/** Unit tests for the traversal class.
 *  @author Ruhao Xia
 */

/** Test the ShortestPaths. */
public class PathsTesting {

    private class SimpleTest extends SimpleShortestPaths {
        private ArrayList<Integer> a = new ArrayList<Integer>();
        private LabeledGraph<Double, Double> g;
        private boolean used = false;
        protected SimpleTest(LabeledGraph<Double, Double> G,
                             int start, int dest) {
            super(G, start, dest);
            g = G;
        }

        @Override
        protected double getWeight(int u, int v) {
            a.add(u);
            return g.getLabel(u, v);
        }

        @Override
        protected double estimatedDistance(int v) {
            used = true;
            return g.getLabel(v);
        }

        protected ArrayList<Integer> visited() {
            return a;
        }

        protected boolean eD() {
            return used;
        }
    }

    @Test
    public void basicsSP() {
        Graph G = new DirectedGraph();
        LabeledGraph<Double, Double> g = new LabeledGraph<Double, Double>(G);
        g.add();
        g.add();
        g.add();
        g.add();
        g.add();
        g.add();
        g.remove(1);
        g.add(4, 2);
        g.add(2, 3);
        g.add(4, 3);
        g.add(4, 5);
        g.add(5, 6);
        g.add(5, 3);
        g.setLabel(4, 102.0);
        g.setLabel(2, 4.0);
        g.setLabel(3, 0.0);
        g.setLabel(5, 5.1);
        g.setLabel(6, 40.0);

        g.setLabel(4, 2, 12.2);
        g.setLabel(4, 5, 11.2);
        g.setLabel(2, 3, 6.5);
        g.setLabel(4, 3, 102.0);
        g.setLabel(5, 6, 30.0);
        g.setLabel(5, 3, 9.1);
        SimpleTest st = new SimpleTest(g, 4, 3);
        st.setPaths();
        assertEquals("Get ED", 0.0, 102.0, st.estimatedDistance(4));
        assertEquals("Get Weight edge", 0.0,  12.2, st.getWeight(4, 2));
        st.setWeight(3, 3.0);
        assertEquals("Get Weight v", 0.0,  3.0, st.getWeight(3));
        st.setPredecessor(4, 5);
        assertEquals("get Predecessor", 5, st.getPredecessor(4));
        assertEquals("get source", 4, st.getSource());
        assertEquals("get dest", 3, st.getDest());
    }

    @Test
    public void testShortestPath() {
        ArrayList<Integer> result = new ArrayList<>();
        Graph G = new DirectedGraph();
        LabeledGraph<Double, Double> g = new LabeledGraph<Double, Double>(G);
        g.add();
        g.add();
        g.add();
        g.add();
        g.add();
        g.add();
        g.add();
        g.remove(1);
        g.add(4, 2);
        g.add(2, 3);
        g.add(4, 3);
        g.add(4, 5);
        g.add(5, 6);
        g.add(5, 3);
        g.add(6, 7);
        g.setLabel(4, 102.0);
        g.setLabel(2, 4.0);
        g.setLabel(3, 0.0);
        g.setLabel(5, 5.1);
        g.setLabel(6, 40.0);
        g.setLabel(7, 100.0);
        g.setLabel(4, 2, 12.2);
        g.setLabel(4, 5, 11.2);
        g.setLabel(2, 3, 6.5);
        g.setLabel(4, 3, 102.0);
        g.setLabel(5, 6, 30.0);
        g.setLabel(5, 3, 9.1);
        g.setLabel(6, 7, 100.0);
        SimpleTest st = new SimpleTest(g, 4, 3);
        st.setPaths();
        assertEquals("get Paths", Arrays.<Integer>asList(4, 2, 3), st.pathTo());
        assertEquals("visit 5?", 4, st.getPredecessor(5));
        assertFalse(st.visited().contains(6));
        assertTrue(st.eD());
    }
}
