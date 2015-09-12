/*********************************************************************************
* (Create a miles/kilometers converter) Write a program that converts miles and  *
* kilometers, as shown in Figure 16.37b. If you enter a value in the Mile text   *
* field and press the Enter key, the corresponding kilometer measurement is      *
* displayed in the Kilometer text field. Likewise, if you enter a value in the   *
* Kilometer text field and press the Enter key, the corresponding miles is       *
* displayed in the Mile text field.                                              *
*********************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;

public class Exercise_16_04 extends Application {
	final double KILOMETERS_PER_MILE = 1.602307322544464;
	protected TextField tfMile = new TextField();
	protected TextField tfKilometer = new TextField();

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Set text fields alignment
		tfMile.setAlignment(Pos.BOTTOM_RIGHT);
		tfKilometer.setAlignment(Pos.BOTTOM_RIGHT);

		// Create a gridpane and place nodes into it
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.add(new Label("Mile"), 0, 0);
		pane.add(tfMile, 1, 0);
		pane.add(new Label("Kilometer"), 0, 1);
		pane.add(tfKilometer, 1, 1);

		// Create and register the handlers
		tfMile.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER &&
				tfMile.getText().length() > 0) {
				double miles = Double.parseDouble(tfMile.getText());
				tfKilometer.setText(String.valueOf(miles * KILOMETERS_PER_MILE));
			}
		});

		tfKilometer.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER &&
				tfKilometer.getText().length() > 0) {
				double kilometers = Double.parseDouble(tfKilometer.getText());
				tfMile.setText(String.valueOf(kilometers / KILOMETERS_PER_MILE));
			}
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 60);
		primaryStage.setTitle("Exercise_16_04"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}