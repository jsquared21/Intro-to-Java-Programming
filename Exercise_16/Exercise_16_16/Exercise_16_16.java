/*********************************************************************************
* (Use ComboBox and ListView) Write a program that demonstrates selecting items  *
* in a list. The program uses a combo box to specify a selection mode, as shown  *
* in Figure 16.43a. When you select items, they are displayed in a label below   *
* the list.                                                                      *
*********************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.geometry.Orientation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Exercise_16_16 extends Application {
	protected ObservableList<String> items = 
		FXCollections.observableArrayList("China", "Japan", 
			"Korea", "India", "Malaysia", "Vitnam");		
	protected ListView<String> lv = new ListView<>(items);
	protected ComboBox<String> cbo = new ComboBox<>();
	protected Label lblSelectedItems = new Label("Selected items are ");

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Set combo box properties
		cbo.getItems().addAll("SINGLE", "MULTIPLE");
		cbo.setValue("SINGLE");

		// Create a label and set its content display
		Label lblSelectionMode = new Label("Choose Selection Mode:", cbo);
		lblSelectionMode.setContentDisplay(ContentDisplay.RIGHT);

		// Set defaut list view as single
		lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		// Create and register the handlers
		cbo.setOnAction(e -> {
			setMode();
			setText();
		});

		lv.getSelectionModel().selectedItemProperty().addListener(
			ov -> {
			setMode();
			setText();
		});

		// Place nodes in the pane
		BorderPane pane = new BorderPane();
		pane.setTop(lblSelectionMode);
		pane.setCenter(new ScrollPane(lv));
		pane.setBottom(lblSelectedItems);
		pane.setAlignment(lblSelectionMode, Pos.CENTER);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 268, 196);
		primaryStage.setTitle("Exercise_16_16"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/** Set list view selection mode */
	private void setMode() {
		if (cbo.getValue().equals("SINGLE"))
				lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		else
			lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

	/** Set label text to list view selected items */
	private void setText() {
		String  items = "Selected items are ";
		for (String i: lv.getSelectionModel().getSelectedItems())
			items += i + " ";
		lblSelectedItems.setText(items);
	}
}