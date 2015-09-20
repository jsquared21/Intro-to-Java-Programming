/*********************************************************************************
* (Use ScrollBar and Slider) Write a program that uses scroll bars or sliders to *
* select the color for a text, as shown in Figure 16.43b. Four horizontal scroll *
* bars are used for selecting the colors: red, green, blue, and opacity          *
* percentages.                                                                   *
*********************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class Exercise_16_17 extends Application {
	protected Text text = new Text("Show Colors");
	protected Slider slRed = new Slider();
	protected Slider slGreen = new Slider();
	protected Slider slBlue = new Slider();
	protected Slider slOpacity = new Slider();
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a stack pane for text
		StackPane paneForText = new StackPane(text);
		paneForText.setPadding(new Insets(20, 10, 5, 10));

		// Set slider properties
		slRed.setMin(0.0);
		slRed.setMax(1.0);
		slGreen.setMin(0.0);
		slGreen.setMax(1.0);
		slBlue.setMin(0.0);
		slBlue.setMax(1.0);
		slOpacity.setMin(0.0);
		slOpacity.setMax(1.0);

		// Create listeners
		slRed.valueProperty().addListener(ov -> setColor());
		slGreen.valueProperty().addListener(ov -> setColor());
		slBlue.valueProperty().addListener(ov -> setColor());
		slOpacity.valueProperty().addListener(ov -> setColor());
		slOpacity.setValue(1);


		// Create a grid pane for labeled sliders
		GridPane paneForSliders = new GridPane();
		paneForSliders.setAlignment(Pos.CENTER);
		paneForSliders.setVgap(5);
		paneForSliders.setHgap(5);
		paneForSliders.add(new Label("Red"), 0, 0);
		paneForSliders.add(slRed, 1, 0);
		paneForSliders.add(new Label("Green"), 0, 1);
		paneForSliders.add(slGreen, 1, 1);
		paneForSliders.add(new Label("Blue"), 0, 2);
		paneForSliders.add(slBlue, 1, 2);
		paneForSliders.add(new Label("Opacity"), 0, 3);
		paneForSliders.add(slOpacity, 1, 3);

		// Place nodes in a border pane
		BorderPane pane = new BorderPane();
		pane.setTop(paneForText);
		pane.setCenter(paneForSliders);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 150);
		primaryStage.setTitle("Exercise_16_17"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/** Set the text color */
	private void setColor() {
		text.setFill(new Color(slRed.getValue(), slGreen.getValue(), 
				slBlue.getValue(), slOpacity.getValue()));
	}
}