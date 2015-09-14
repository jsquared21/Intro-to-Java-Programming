import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;

public class CirclePane extends Pane {
	private Circle circle1 = new Circle();
	private Circle circle2 = new Circle();

	CirclePane() {
		circle1.setFill(Color.WHITE);
		circle1.setStroke(Color.BLACK);
		circle2.setFill(Color.WHITE);
		circle2.setStroke(Color.BLACK);
		getChildren().addAll(circle1, circle2);
	}
		
		
}