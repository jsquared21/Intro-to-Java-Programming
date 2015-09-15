/*********************************************************************************
* (Demonstrate TextArea properties) Write a program that demonstrates the        *
* properties of a text area. The program uses a check box to indicate whether    *
* the text is wrapped onto next line, as shown in Figure 16.41a.                 *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Exercise_16_12 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a text area
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setWrapText(false);

		// Create a scrollPane
		ScrollPane scrollPane = new ScrollPane(textArea);

		// Create two check boxes
		CheckBox chkEditable = new CheckBox("Editable");
		CheckBox chkWrap = new CheckBox("Wrap");

		// Create a hbox
		HBox paneForButtons = new HBox(5);
		paneForButtons.setAlignment(Pos.CENTER);
		paneForButtons.getChildren().addAll(chkEditable, chkWrap);

		// Create a pane 
		BorderPane pane = new BorderPane();
		pane.setCenter(scrollPane);
		pane.setBottom(paneForButtons);

		// Create and register handlers
		chkEditable.setOnAction(e -> {
			textArea.setEditable(chkEditable.isSelected());
		});

		chkWrap.setOnAction(e -> {
			textArea.setWrapText(chkWrap.isSelected());
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_16_12"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}