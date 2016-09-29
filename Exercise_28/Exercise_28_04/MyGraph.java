import java.util.*;

public class MyGraph<V> extends UnweightedGraph<V> {
	/** Construct an empty graph */
	public MyGraph() {
	}

	/** Construct a graph from vertices and edges stored in lists */
	public MyGraph(List<V> vertices, List<Edge> edges) {
		super(vertices, edges);
	}

	/** Construct a graph from vertices and edges stored in arrays */
	public MyGraph(V[] vertices, int[][] edges) {
		super(vertices, edges);
	}

	/** Construct a grpah from Integer vertices 0, 1, 2 and an edge list */
	public MyGraph(List<Edge> edges, int numberOfVertices) {
		super(edges, numberOfVertices);
	}

	/** Construct a grpah from integer vertices 0, 1, 2 and an edge array */
	public MyGraph(int[][] edges, int numberOfVertices) {
		super(edges, numberOfVertices);
	}

	/** Return a list of all connected components in a graph */
	public List<List<Integer>> getConnectedComponents() {
		List<List<Integer>> components = new ArrayList<>();
		List<Integer> v = new ArrayList<>(vertices.size());
		for (int i = 0; i < vertices.size(); i++)
			v.add(i);

		getConnectedComponents(v, components);
		return components;
	}

	/** Recursive method for finding connected components */
	public void getConnectedComponents(
			List<Integer> v, List<List<Integer>> components) {
		if (v.size() > 0) {
			List<Integer> c = dfs(v.get(0)).getSearchOrder();
			components.add(c);
			v.removeAll(c);
			getConnectedComponents(v, components);
		}
	}
}