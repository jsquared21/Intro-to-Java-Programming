import java.util.*;

public class UnweightedGraph<V> extends AbstractGraph<V> {
	/** Construct an empty Graph */
	public UnweightedGraph(){
	}

	/** Construct a graph from vertices and edge stored in arrays */
	public UnweightedGraph(V[] vertices, int[][] edges) {
		super(vertices, edges);
	}

	/** Construct a graph from vertices and edge stored in lists */
	public UnweightedGraph(List<V> vertices, List<Edge> edges) {
		super(vertices, edges);
	}

	/** Construct a graph from integer vertices 0, 1, 2 and egde array */
	public UnweightedGraph(int[][] edges, int numberOfVertices) {
		super(edges, numberOfVertices);
	}

	/** Construct a graph from integer vertices 0, 1, 2 and edge list */
	public UnweightedGraph(List<Edge> edges, int numberOfVertices) {
		super(edges, numberOfVertices);
	}
}