/*********************************************************************************
* (Baby name popularity ranking) Use the data files from Programming             *
* Exercise 12.31 to write a program that enables the user to select a year,      *
* gender, and enter a name to display the ranking of the name for the selected   *
* year and gender, as shown in Figure 21.9. To achieve the best efficiency,      *
* create two arrays for boy’s names and girl’s names, respectively. Each array   *
* has 10 elements for 10 years. Each element is a map that stores a name and its *
* ranking in a pair with the name as the key. Assume the data files are stored   *
* at www.cs.armstrong.edu/liang/data/babynamesranking2001.txt, . . . , and       *
* www.cs.armstrong.edu/liang/data/babynamesranking2010.txt.                      *
*********************************************************************************/
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.util.*;

public class Exercise_21_11 extends Application {
	final int BOYS_NAMES = 1;
	final int GIRLS_NAMES = 3;
	protected ComboBox<String> cboYear = new ComboBox<>();
	protected ComboBox<String> cboGender = new ComboBox<>();
	protected TextField tfName = new TextField();
	protected Button btFindRanking = new Button("Find Ranking");
	protected Label lblResults = new Label("");
	protected Map[] boys = getNames(BOYS_NAMES); 
	protected Map[] girls = getNames(GIRLS_NAMES); 

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {

		// Create and register handle
		btFindRanking.setOnAction(e -> displayRank());

		// Create a Scene and place it in the stage
		Scene scene = new Scene(getPane(), 300, 160);
		primaryStage.setTitle("Exercise_21_11"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/** Displays the ranking for the name of the selected year and gender */
	private void displayRank() {
		lblResults.setText(getGender() + " name " 
			+ tfName.getText() + " is ranked #" + getRank()
			+ " in year " + cboYear.getValue());
	}

	/* Returns selected gender of boy or girl */
	private String getGender() {
		return cboGender.getValue().equals("Male") ? "Boy" : "Girl";
	}

	/** Returns the ranking for the name of the selected year and gender */
	private String getRank() {
		int year = Integer.parseInt(cboYear.getValue()) - 2001;

		if (cboGender.getValue().equals("Male")) {
			return boys[year].get(tfName.getText()) + "";
		}
		else
			return girls[year].get(tfName.getText()) + "";
	}

	/** Returns the ranking pane */
	private BorderPane getPane() {
		// Add items to cboYear
		for (int i = 2001; i <= 2010; i++)
			cboYear.getItems().add(i + "");

		// Add items to cboGender
		cboGender.getItems().addAll("Male", "Female");	
		
		// Create a grid pane
		GridPane gridPane = new GridPane();
		gridPane.setVgap(5);
		gridPane.setPadding(new Insets(5, 0, 5, 0));
		gridPane.setAlignment(Pos.CENTER);
		gridPane.add(new Label("Select a year: "), 0, 0);
		gridPane.add(cboYear, 1, 0);
		gridPane.add(new Label("Boy or girl?: "), 0, 1);
		gridPane.add(cboGender, 1, 1);
		gridPane.add(new Label("Enter a name: "), 0, 2);
		gridPane.add(tfName, 1, 2);
		gridPane.add(btFindRanking, 1, 3);

		// Create a border pane and place node in it
		BorderPane pane = new BorderPane();
		pane.setCenter(gridPane);
		pane.setBottom(lblResults);
		pane.setAlignment(lblResults, Pos.CENTER);

		return pane;
	}

	/** Returns an array of Maps storing ranks  
	  * to names of a specified gender */
	private Map[] getNames(int gender) {
		Map[] array = new Map[10];

		for (int year = 2001, i = 0; year <= 2010 && i < 10; year++, i++) {
			Map<String, String> map = new HashMap<>();
			// Read data from url
			try {
				java.net.URL url = new java.net.URL(
				"http://www.cs.armstrong.edu/liang/data/babynamesranking" 
					+ year + ".txt");
	
				// Create input file from url
				Scanner input = new Scanner(url.openStream());
				while (input.hasNext()) {
					ArrayList<String> list = new ArrayList<>();
					for (int w = 0; w < 5; w++) {
					   list.add(w, input.next());
					}
					map.put(list.get(gender), list.get(0));
				} 
			}
			catch (java.net.MalformedURLException ex) {
				System.out.println("Invalid URL");
			}
			catch (java.io.IOException ex) {
				System.out.println("I/0 Errors: no such file");
			}
			array[i] = map;
		}

		return array;
	}
}
