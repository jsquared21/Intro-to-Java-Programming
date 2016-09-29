/*********************************************************************************
* (Find connected components) Create a new class named MyGraph as a subclass of  *
* MyGraph that contains a method for finding all connected components in a graph *
* with the following header:                                                     *
*                                                                                *
* public List<List<Integer>> getConnectedComponents();                           *
*                                                                                *
* The method returns a List<List<Integer>>. Each element in the list is another  *
* list that contains all the vertices in a connected component. For example, for *
* the graph in Figure 28.21b, getConnectedComponents() returns                   *
* [[0, 1, 2, 3], [4, 5]].                                                        *
*********************************************************************************/
import java.util.*;

public class Exercise_28_04 {
	public static void main(String[] args) throws Exception {
		// Prompt the user to enter a file name
		System.out.print("Enter file name: ");
		Scanner fileName = new Scanner(System.in);
		java.io.File file = new java.io.File(fileName.nextLine());

		// Test if file exists
		if (!file.exists()) {
			System.out.println("The file \"" + file + "\" does not exist.");
			System.exit(0);
		}

		try (
			// Create a Scanner for the file
			Scanner input = new Scanner(file);
		) {
			int NUMBER_OF_VERTICES = input.nextInt();
	
			// Create a list of AbstractGraph.Edge objects 
			ArrayList<AbstractGraph.Edge> edges = new ArrayList<>();
	
			while (input.hasNext()) {
				String s = input.nextLine();
				String[] line = s.split("[\\s+]");

				// Add edges
				for (int j = 1; j < line.length; j++) {
					edges.add(new AbstractGraph.Edge(
						Integer.parseInt(line[0]), Integer.parseInt(line[j])));
				}
			}
			
			// Create a graph
			MyGraph<String> graph = new MyGraph<>(edges, NUMBER_OF_VERTICES);
			System.out.println(graph.getConnectedComponents());
		}
	}
}