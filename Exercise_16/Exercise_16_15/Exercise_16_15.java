/*********************************************************************************
* (Demonstrate Label properties) Write a program to let the user dynamically set *
* the properties contentDisplay and graphicTextGap, as shown in Figure 16.42b.   *
*********************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;

public class Exercise_16_15 extends Application {
	protected ComboBox<String> cbo = new ComboBox<>(); // Create a combo box

	@Override // Override the start method in the Appliction class
	public void start(Stage primaryStage) {
		// Set properties for combobox
		cbo.getItems().addAll("TOP", "BOTTOM", "LEFT", "RIGHT");
		cbo.setStyle("-fx-color: green");
		cbo.setValue("LEFT");

		// Create a text field
		TextField tfGap = new TextField("0");
		tfGap.setPrefColumnCount(3);

		// Create a hox to hold labels a text field and combo box
		HBox paneForSettings = new HBox(10);
		paneForSettings.setAlignment(Pos.CENTER);
		paneForSettings.getChildren().addAll(new Label("contentDisplay:"),
			cbo, new Label("graphicTextGap:"), tfGap);

		// Create an imageview
		ImageView image = new ImageView(new Image("image/grapes.gif"));

		// Label the image
		Label lblGrapes = new Label("Grapes", image);
		lblGrapes.setGraphicTextGap(0);

		// Place the image and its label in a stack pane
		StackPane paneForImage = new StackPane(lblGrapes);

		// Create and register handlers
		cbo.setOnAction(e -> {
			lblGrapes.setContentDisplay(setDisplay());
		});

		tfGap.setOnAction(e -> {
			lblGrapes.setGraphicTextGap(Integer.parseInt(tfGap.getText()));
		});

		// Place nodes in a border pane
		BorderPane pane = new BorderPane();
		pane.setTop(paneForSettings);
		pane.setCenter(paneForImage);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 400, 200);
		primaryStage.setTitle("Exericse_16_15"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/** Returns the selected content display */
	private ContentDisplay setDisplay() {
		if (cbo.getValue().equals("TOP"))
			return ContentDisplay.TOP;
		else if (cbo.getValue().equals("BOTTOM"))
			return ContentDisplay.BOTTOM;
		else if (cbo.getValue().equals("LEFT"))
			return ContentDisplay.LEFT;
		else
			return ContentDisplay.RIGHT; 
	}
}