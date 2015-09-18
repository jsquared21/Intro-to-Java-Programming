import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class CarPane extends Pane {
	private double x;
	private double y = 40;
	private double radius = 5;
	private Rectangle rectangle;
	private Polygon polygon;
	private Circle circle1;
	private Circle circle2;
	private Timeline animation;

	/** Construct and animate a default CarPane */
	CarPane() {
		drawCar();
		animation = new Timeline(
			new KeyFrame(Duration.millis(50), e -> moveCar()));
		animation.setCycleCount(Timeline.INDEFINITE);
	}

	/** Create a car an place it in the pane */
	private void drawCar() {
		getChildren().clear();
		rectangle = new Rectangle(x, y - 20, 50, 10);
		polygon = new Polygon(x + 10, y - 20, x + 20, y - 30, x + 30, 
			y - 30, x + 40, y - 20);
		circle1 = new Circle(x + 15, y - 5, radius);
		circle2 = new Circle(x + 35, y - 5, radius);
		getChildren().addAll(rectangle, circle1, circle2, polygon);
	}

	/** Set y to specified value */
	public void setY(double y) {
		this.y = y;
	}

	/** Set x to specified value */
	public void setX(double x) {
		this.x = x;
	}

	/** return x */
	public double getX() {
		return x;
	}

	/** return y */
	public double getY() {
		return y;
	}

	/** Pause animation */
	public void pause() {
		animation.pause();
	}

	/** Play animation */
	public void play() {
		animation.play();
	}

	/** Set the animation rate to a specified amount */
	public void setSpeed(double speed) {
		if (speed <= 100)
			animation.setRate(speed);
	}

	/** Increase rate by 1 */
	public void increaseSpeed() {
		animation.setRate(animation.getRate() + 1);
	}

	/** decrease rate by 1 */
	public void decreaseSpeed() {
		animation.setRate(animation.getRate() > 0 ? animation.getRate() - 1 : 0);
	}

	/** Redraw car with new x value */
	protected void moveCar() {
		if (x <= getWidth()) {
			x += 1;	
		} 
		else
			x = 0;
		drawCar();
	}
}