import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class ImagePane extends Pane {
	private int x = 0;
	private Timeline animation;

	ImagePane() {
		getSlide();
		animation = new Timeline(
			new KeyFrame(Duration.millis(2000), e -> nextSlide()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}

	private void getSlide() {
		getChildren().clear();
		getChildren().add(new ImageView(new Image("image/slide" + x + ".jpg")));
	}

	protected void nextSlide() {
		if (x < 24) {
			x += 1;
		}
		else 
			x = 0;
		getSlide();
	}
}