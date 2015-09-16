import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.geometry.Insets;

public class StopWatch extends StackPane {
	// Data field
	private int hour;
	private int minute;
	private int second;
	private Text text = new Text();
	private Timeline animation; // animate stopwatch

	/** Construct a default StopWatch */
	public StopWatch() {
		setPadding(new Insets(5, 15, 5, 15));
		clear();
		text.setFont(Font.font(30));
		getChildren().add(text);
		animation = new Timeline(
			new KeyFrame(Duration.millis(1000), e -> run()));
		animation.setCycleCount(Timeline.INDEFINITE);
	}

	/** Play animation */
	public void play() {
		animation.play();
	}

	/** Pause animation */
	public void pause() {
		animation.pause();
	}

	/** Animate stopwatch */
	protected void run() {
		if (minute == 59)
			hour = hour + 1; 

		if (second == 59) 
		  minute = minute + 1;

		second = second < 59 ? second + 1 : 0;

		text.setText(getTime());
	}

	/** Reset stopwatch */
	public void clear() {
		hour = 0;
		minute = 0;
		second = 0;
		text.setText(getTime());
	}

	/** Return time as a string */
	private String getTime() {
		return pad(hour) + ":" + pad(minute) + ":" + pad(second);
	}

	/** Return n as padded string */
	private String pad(int n) {
		return n < 10 ? "0" + n : n + "";
	}
}