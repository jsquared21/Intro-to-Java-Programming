import java.util.*;

public class UnweightedGraph<V> extends AbstractGraph<V> {
	/** Construct an empty graph */
	public UnweightedGraph() {
	}

	/** Construct a graph from vertices and edges stored in arrays */
	public UnweightedGraph(V[] vertices, int[][] edges) {
		super(vertices, edges);
	}

	/** Construct a graph from vertices and edges stored in List */
	public UnweightedGraph(List<V> vertices, List<Edge> edges) {
		super(vertices, edges);
	}

	/** Construct a graph for interger vertices 0, 1, 2 and edge list */
	public UnweightedGraph(List<Edge> edges, int numberOfVertices) {
		super(edges, numberOfVertices);
	}

	/** Construct a graph from integer vertices 0, 1, and edge array */
	public UnweightedGraph(int[][] edges, int numberOfVertices) {
		super(edges, numberOfVertices);
	}
}