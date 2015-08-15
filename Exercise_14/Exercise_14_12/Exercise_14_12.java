/*********************************************************************************
* (Display a bar chart) Write a program that uses a bar chart to display the     *
* percentages of the overall grade represented by projects, quizzes, midterm     *
* exams, and the final exam, as shown in Figure 14.46b. Suppose that projects    *
* take 20 percent and are displayed in red, quizzes take 10 percent and are      *
* displayed in blue, midterm exams take 30 percent and are displayed in green,   *
* and the final exam takes 40 percent and is displayed in orange. Use the        *
* Rectangle class to display the bars. Interested readers may explore the JavaFX *
* BarChart class for further study.                                              *
*********************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

public class Exercise_14_12 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a HBox
		HBox hBox = new HBox(15);
		hBox.setAlignment(Pos.BOTTOM_CENTER);

		String[] type = {"Project", "Quiz", "Midterm", "Final"};
		double[] grade = {20, 10, 30, 40};

		double max = getMax(grade);

		double height = 200;
		double width = 150;

		StackPane pane = new StackPane();
		pane.setPadding(new Insets(20, 15, 5, 15));

		// Create 4 rectangles
		Rectangle r1 = new Rectangle(0, 0, width, height * grade[0] / max);
		r1.setFill(Color.RED);
		Rectangle r2 = new Rectangle(0, 0, width, height * grade[1] / max);
		r2.setFill(Color.BLUE);
		Rectangle r3 = new Rectangle(0, 0, width, height * grade[2] / max);
		r3.setFill(Color.GREEN);
		Rectangle r4 = new Rectangle(0, 0, width, height * grade[3] / max);
		r4.setFill(Color.ORANGE);

		// Create 4 Text objects
		Text t1 = new Text(0, 0, type[0] + " -- " + grade[0] + "%");
		Text t2 = new Text(0, 0, type[1] + " -- " + grade[1] + "%");
		Text t3 = new Text(0, 0, type[2] + " -- " + grade[2] + "%");
		Text t4 = new Text(0, 0, type[3] + " -- " + grade[3] + "%");
		
		hBox.getChildren().addAll(getVBox(t1, r1), getVBox(t2, r2), 
			getVBox(t3, r3), getVBox(t4, r4));
		pane.getChildren().add(hBox);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_14_12"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	public double getMax(double[] l) {
		double max = l[0];
		for (int i = 0; i < l.length; i++) {
			if (l[i] > max)
				max = l[i];
		}
		return max;
	}

	public VBox getVBox(Text t, Rectangle r) {
		VBox vBox = new VBox(5);
		vBox.setAlignment(Pos.BOTTOM_LEFT);
		vBox.getChildren().addAll(t, r);
		return vBox;
	}
}