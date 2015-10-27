/***********************************************************************************
* (Combine colliding bouncing balls) The example in Section 20.7 displays          *
* multiple bouncing balls. Extend the example to detect collisions. Once two balls *
* collide, remove the later ball that was added to the pane and add its radius to  *
* the other ball, as shown in Figure 20.17b. Use the Suspend button to suspend     *
* the animation and the Resume button to resume the animation. Add a mouse         *
* pressed handler that removes a ball when the mouse is pressed on the ball.       *
***********************************************************************************/
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.collections.ObservableList;
import java.util.*;

public class Exercise_20_05 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		MultipleBallPane ballPane = new MultipleBallPane();
		ballPane.setStyle("-fx-border-color: yellow");

		// Create four buttons
		Button btSuspend = new Button("Suspend");
		Button btResume = new Button("Resume");
		Button btAdd = new Button("+");
		Button btSubtract = new Button("-");
		HBox hBox = new HBox(10);
		hBox.getChildren().addAll(
			btSuspend, btResume, btAdd, btSubtract);
		hBox.setAlignment(Pos.CENTER);

		// Add or remove a ball
		btAdd.setOnAction(e -> ballPane.add());
		btSubtract.setOnAction(e -> ballPane.subtract());
		ballPane.setOnMousePressed(e -> {
			for (Node node: ballPane.getChildren()) {
				Ball ball = (Ball)node;
				if (ball.contains(e.getX(), e.getY())) {
					ballPane.getChildren().remove(ball);
				}
			}
		});

		// Pause and resume animation
		btSuspend.setOnAction(e -> ballPane.pause());
		btResume.setOnAction(e -> ballPane.play());

		// Use a scroll bar to control animation speed
		ScrollBar sbSpeed = new ScrollBar();
		sbSpeed.setMax(20);
		sbSpeed.setValue(10);
		ballPane.rateProperty().bind(sbSpeed.valueProperty());

		// Create a border pane
		BorderPane pane = new BorderPane();
		pane.setCenter(ballPane);
		pane.setTop(sbSpeed);
		pane.setBottom(hBox);

		// Create a scene and place the in the stage
		Scene scene = new Scene(pane, 350, 200);
		primaryStage.setTitle("Exercise_20_05"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	private class MultipleBallPane extends Pane {
		private Timeline animation;

		public MultipleBallPane() {
			// Create an animation for moving the ball
			animation = new Timeline(
				new KeyFrame(Duration.millis(50), e -> moveBall()));
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.play(); // Start animation
		}

		public void add() {
			Color color = new Color(Math.random(),
				Math.random(), Math.random(), 0.5);
			getChildren().add(new Ball(30, 30, 5, color));
		}

		public void subtract() {
			if (getChildren().size() > 0) {
				getChildren().remove(getChildren().size() - 1);
			}
		}

		public void play() {
			animation.play();
		}

		public void pause() {
			animation.pause();
		}

		public void increaseSpeed() {
			animation.setRate(animation.getRate() + 0.1);
		}

		public void decreaseSpeed() {
			animation.setRate(
				animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
		}

		public DoubleProperty rateProperty() {
			return animation.rateProperty();
		}

		protected void moveBall() {
			for (Node node: this.getChildren()) {
				Ball ball = (Ball)node;
				// Check boundaries
				if (ball.getCenterX() < ball.getRadius() ||
					 ball.getCenterX() > getWidth() - ball.getRadius()) {
					ball.dx *= -1; // Change ball move direction
				}
				if (ball.getCenterY() < ball.getRadius() ||
					 ball.getCenterY() > getHeight() - ball.getRadius()) {
					ball.dy *= -1; // Change ball move direction
				}

				// Adjust ball position
				ball.setCenterX(ball.dx + ball.getCenterX());
				ball.setCenterY(ball.dy + ball.getCenterY());

				// Check if balls collide
				ArrayList<Node> list = new ArrayList<>(this.getChildren());
				for (int i = getChildren().indexOf(node) + 1; 
					  i < list.size(); i++) {
					Ball nextBall = (Ball)list.get(i);
					if (intersects(ball, nextBall)) {
						// Remove the later ball that was added to  
						// pane and add its radius to the other ball
						ball.setRadius(ball.getRadius() + 
							nextBall.getRadius());
						getChildren().remove(nextBall);
					}
				}
			}
		}

		/** Returns true if circles inIntersect */
		private boolean intersects(Ball ball, Ball nextBall) {
			return Math.sqrt(Math.pow(ball.getCenterX() - nextBall.getCenterX(), 2) + 
					 Math.pow(ball.getCenterY() - nextBall.getCenterY(), 2)) 
					 <= ball.getRadius() + nextBall.getRadius();
		}
	}

	class Ball extends Circle {
		private double dx = 1, dy = 1;

		Ball(double x, double y, double radius, Color color) {
			super(x, y, radius);
			setFill(color); // Set ball color
		}
	}
}