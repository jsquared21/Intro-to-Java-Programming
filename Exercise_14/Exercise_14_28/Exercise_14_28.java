/*********************************************************************************
* (Random time) Modify the ClockPane class with three new Boolean properties—    *
* hourHandVisible, minuteHandVisible, and secondHandVisible—and their associated *
* accessor and mutator methods. You can use the set methods to make a hand       *
* visible or invisible. Write a test program that displays only the hour and     * 
* minute hands. The hour and minute values are randomly generated. The hour is   *
* between 0 and 11, and the minute is either 0 or 30, as shown in Figure 14.52b. *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.geometry.Pos;

public class Exercise_14_28 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a clock and a label
		ClockPane clock = new ClockPane((int)(Math.random() * 12), 
			((int)(Math.random() * 2) == 1 ? 30 : 0), 0);
		String timeString = clock.getHour() + ":" + clock.getMinute()
			+ ":" + clock.getSecond();
		clock.setSecondHandVisible(false); // Make second hand invisible
		Label time = new Label(timeString);

		// Place clock and label in border pane
		BorderPane pane = new BorderPane();
		pane.setCenter(clock);
		pane.setBottom(time);
		BorderPane.setAlignment(time, Pos.TOP_CENTER);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 250); 
		primaryStage.setTitle("Exercise_14_28"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}