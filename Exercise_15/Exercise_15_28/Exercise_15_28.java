/*********************************************************************************
* (Display a running fan) Write a program that displays a running fan, as shown  *
* in Figure 15.33c. Use the Pause, Resume, Reverse buttons to pause, resume,     *
* and reverse fan running.                                                       *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class Exercise_15_28 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		FanPane fanPane = new FanPane();

		// Create three buttons
		Button btPause = new Button("Pause");
		Button btResume = new Button("Resume");
		Button btReverse = new Button("Reverse");
		HBox hBox = new HBox(5);
		hBox.setAlignment(Pos.CENTER);

		// Place nodes in panes
		hBox.getChildren().addAll(btPause, btResume, btReverse);


		// Create a border pane
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(fanPane);
		borderPane.setBottom(hBox);

		btPause.setOnAction(e -> {
			fanPane.pause();
		});

		btResume.setOnAction(e -> {
			fanPane.play();
		});

		btReverse.setOnAction(e -> {
			fanPane.reverse();
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 250, 250);
		primaryStage.setTitle("Exercise_15_28"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		fanPane.requestFocus();
	}
}