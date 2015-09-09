/*********************************************************************************
* (Control a clock) Modify Listing 14.21, ClockPane.java, to add the animation   *
* into this class and add two methods start() and stop() to start and stop the   *
* clock. Write a program that lets the user control the clock with the Start and *
* Stop buttons, as shown in Figure 15.36a.                                       *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class Exercise_15_32 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a clock pane
		ClockPane clock = new ClockPane();

		// Create a hBox and set it porperties
		HBox hBox = new HBox(5);
		hBox.setAlignment(Pos.CENTER);

		// Create two buttons
		Button btStop = new Button("Stop");
		Button btStart = new Button("Start");

		// Create and register handler
		btStop.setOnAction(e -> clock.pause());
		btStart.setOnAction(e -> clock.play());

		// Place buttons in hBox
		hBox.getChildren().addAll(btStop, btStart);

		// Create a border pane and place the nodes in to it
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(clock);
		borderPane.setBottom(hBox);

		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 250, 270);
		primaryStage.setTitle("Exercise_15_32"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}