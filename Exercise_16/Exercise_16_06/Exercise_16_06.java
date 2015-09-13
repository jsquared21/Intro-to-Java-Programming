/*********************************************************************************
* (Demonstrate TextField properties) Write a program that sets the horizontal    *
* alignment and column-size properties of a text field dynamically, as shown in  *
* Figure 16.38a.                                                                 *
*********************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;

public class Exercise_16_06 extends Application {
	protected TextField tfTextField = new TextField();
	protected TextField tfColumnSize = new TextField();

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Set properties for text fields
		tfTextField.setText("JavaFX");
		tfTextField.setAlignment(Pos.BOTTOM_CENTER);
		tfColumnSize.setAlignment(Pos.BOTTOM_RIGHT);
		tfColumnSize.setPrefColumnCount(3);
		tfTextField.setPrefColumnCount(12);
		tfColumnSize.setText("12");

		// Create three radio buttions
		RadioButton rbLeft = new RadioButton("Left");
		RadioButton rbCenter = new RadioButton("Center");
		RadioButton rbRight = new RadioButton("Right");
		rbCenter.setSelected(true);

		// Create a toggle group
		ToggleGroup group = new ToggleGroup();
		rbLeft.setToggleGroup(group);
		rbCenter.setToggleGroup(group);
		rbRight.setToggleGroup(group);
		
		// Create four hbox
		HBox paneForRadioButtons = new HBox(5);
		paneForRadioButtons.getChildren().addAll(rbLeft, rbCenter, rbRight);
		paneForRadioButtons.setAlignment(Pos.BOTTOM_LEFT);

		HBox paneForColumnSize = new HBox(5);
		paneForColumnSize.getChildren().addAll(
			new Label("Colum Size"), tfColumnSize);

		HBox paneForTextField = new HBox(5);
		paneForTextField.setAlignment(Pos.CENTER);
		paneForTextField.getChildren().addAll(
			new Label("Text Field"), tfTextField);

		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(paneForRadioButtons, paneForColumnSize);

		// Create a vBox and place nodes in it
		VBox pane = new VBox(10);
		pane.setPadding(new Insets(5, 5, 5, 5));
		pane.getChildren().addAll(paneForTextField, hbox);

		// Create and register the handlers 
		rbLeft.setOnAction(e -> {
			if (rbLeft.isSelected()) {
				tfTextField.setAlignment(Pos.BOTTOM_LEFT);
			}
		});

		rbCenter.setOnAction(e -> {
			if (rbCenter.isSelected()) {
				tfTextField.setAlignment(Pos.BOTTOM_CENTER);
			}
		});

		rbRight.setOnAction(e -> {
			if (rbRight.isSelected()) {
				tfTextField.setAlignment(Pos.BOTTOM_RIGHT);
			}
		});

		tfColumnSize.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				tfTextField.setPrefColumnCount(Integer.parseInt(
					tfColumnSize.getText()));
			}
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_16_06"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}