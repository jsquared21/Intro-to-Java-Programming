/*********************************************************************************
* (Play, loop, and stop a sound clip) Write a program that meets the following   *
* requirements:                                                                  *
*                                                                                *
* ■ Get an audio file from the class directory using AudioClip.                  *
* ■ Place three buttons labeled Play, Loop, and Stop, as shown in Figure 16.46a. *
* ■ If you click the Play button, the audio file is played once. If you click    *
* the Loop button, the audio file keeps playing repeatedly. If you click the     *
* Stop button, the playing stops.                                                *
*********************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class Exercise_16_22 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create three buttons
		Button play = new Button("Play");
		Button loop = new Button("Loop");
		Button stop = new Button("Stop");

		// Create a pane and set its properties
		HBox pane = new HBox(5);
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.getChildren().addAll(play, loop, stop);

		// Create a audio clip
		AudioClip audio = new AudioClip(
			"http://cs.armstrong.edu/liang/common/audio/anthem/anthem3.mp3");

		// Create and register handlers
		play.setOnAction(e -> {
			audio.play();
		});

		stop.setOnAction(e -> {
			audio.stop();
		});

		loop.setOnAction(e -> {
			audio.setCycleCount(AudioClip.INDEFINITE);
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_16_22"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}