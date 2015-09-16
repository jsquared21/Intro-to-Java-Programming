/*********************************************************************************
* (Control a group of fans) Write a program that displays three fans in a group, *
* with control buttons to start and stop all of them, as shown in Figure 16.44.  *
*********************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.collections.ObservableList;

public class Exercise_16_19 extends Application {
	// Create two buttons
	protected Button btStartAll = new Button("Start All");
	protected Button btStopAll = new Button("Stop All");

	@Override // Override the start method in the appliction class
	public void start(Stage primaryStage) {
		// Create a two hboxs
		HBox paneForFans = new HBox(5);
		paneForFans.setAlignment(Pos.CENTER);
		paneForFans.getChildren().addAll(getFan(), getFan(), getFan());

		HBox paneForButtons = new HBox(5);
		paneForButtons.setAlignment(Pos.CENTER);
		paneForButtons.getChildren().addAll(btStartAll, btStopAll);

		// Create a pane
		BorderPane pane = new BorderPane();
		pane.setCenter(paneForFans);
		pane.setBottom(paneForButtons);

		// Create a list of fan panes
		ObservableList<Node> list = paneForFans.getChildren();

		// Create and register handlers
		btStopAll.setOnAction(e -> {
			for (Node x : list) {
				((FanPane)((BorderPane)x).getCenter()).pause();
			}
		});

		btStartAll.setOnAction(e -> {
			for (Node x : list) {
				((FanPane)((BorderPane)x).getCenter()).play();
			}
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 610, 200);
		primaryStage.setTitle("Exercise_16_19"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/** Returns a fan pane */
	public BorderPane getFan() {
		// Create three buttons
		Button btPause = new Button("Pause");
		Button btResume = new Button("Resume");
		Button btReverse = new Button("Reverse");

		// Place buttons in a hbox
		HBox paneForButtons = new HBox(5);
		paneForButtons.getChildren().addAll(btPause, btResume, btReverse);

		// Create a fan pane
		FanPane fan = new FanPane();

		// Create a slider and set its properties
		Slider slider = new Slider();
		slider.setMax(5);
		fan.rateProperty().bind(slider.valueProperty());

		// Create a border pane
		BorderPane pane = new BorderPane();
		pane.setStyle("-fx-border-color: black");
		pane.setTop(paneForButtons);
		pane.setCenter(fan);
		pane.setBottom(slider);

		// Create and register the handlers
		btPause.setOnAction(e -> {
			fan.pause();
		});

		btResume.setOnAction(e -> {
			fan.play();
		});

		btReverse.setOnAction(e -> {
			fan.reverse();
		});

		return pane;
	}
}