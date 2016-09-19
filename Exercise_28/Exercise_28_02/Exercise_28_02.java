/*********************************************************************************
* (Create a file for a graph) Modify Listing 28.1, TestGraph.java, to create a   *
* file representing graph1. The file format is described in Programming Exercise *
* 28.1. Create the file from the array defined in lines 8–21 in Listing 28.1.    *
* The number of vertices for the graph is 12, which will be stored in the first  *
* line of the file. The contents of the file should be as follows:               *
*********************************************************************************/

public class Exercise_28_02 {
	public static void main(String[] args) throws Exception {
		final int NUMBER_OF_VERTICES = 12;

		// Edge array from Listing 28.1 lines 8-21
		int[][] edges = {
			{0, 1}, {0, 3}, {0, 5},
			{1, 0}, {1, 2}, {1, 3},
			{2, 1}, {2, 3}, {2, 4}, {2, 10},
			{3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
			{4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
			{5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
			{6, 5}, {6, 7},
			{7, 4}, {7, 5}, {7, 6}, {7, 8},
			{8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
			{9, 8}, {9, 11},
			{10, 2}, {10, 4}, {10, 8}, {10, 11},
			{11, 8}, {11, 9}, {11, 10}
		};

		// Create a graph
		Graph<Integer> graph = new UnweightedGraph<>(edges, NUMBER_OF_VERTICES);
		java.io.File file = new java.io.File("GraphFile.txt");
		if (file.exists()) {
			System.out.print("File already exists");
			System.exit(0);
		}

		try (
			// Create writer
			java.io.PrintWriter output = new java.io.PrintWriter(file);
		) {
			// Write graph to file
			output.println(graph.getSize());
			for (int i = 0; i < graph.getSize(); i++) {
				output.print(graph.getVertex(i) + " ");
				for (Integer e : graph.getNeighbors(i)) {
					output.print(e + " ");
				}
				output.println();
			}
		}	
	}
}