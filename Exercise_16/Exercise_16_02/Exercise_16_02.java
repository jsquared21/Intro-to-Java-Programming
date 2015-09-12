/***********************************************************************************
* (Select geometric figures) Write a program that draws various figures, as shown  *
* in Figure 16.36b. The user selects a figure from a radio button and uses a check *
* box to specify whether it is filled.                                             *
***********************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;

public class Exercise_16_02 extends Application {
	protected Circle circle = new Circle(50);	// Create a circle
	protected Rectangle rectangle = new Rectangle(); // Create a Rectangle
	protected Ellipse ellipse = new Ellipse(); // Crate an Ellipse


	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Set shape properties
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
		rectangle.setStroke(Color.BLACK);
		rectangle.setWidth(150);
		rectangle.setFill(Color.WHITE);
		rectangle.setHeight(100);
		ellipse.setFill(Color.WHITE);
		ellipse.setStroke(Color.BLACK);
		ellipse.setRadiusX(100);
		ellipse.setRadiusY(50);

		// Create a hbox to hold buttons
		HBox paneForButtons = new HBox(5);
		paneForButtons.setAlignment(Pos.CENTER);
		RadioButton rbCircle = new RadioButton("Circle"); 
		RadioButton rbRectangle = new RadioButton("Rectangle"); 
		RadioButton rbEllipse = new RadioButton("Ellipse"); 

		// Create a toggle group for shapes
		ToggleGroup group = new ToggleGroup();
		rbCircle.setToggleGroup(group);
		rbRectangle.setToggleGroup(group);
		rbEllipse.setToggleGroup(group);

		// Create a check box
		CheckBox chkFill = new CheckBox("Fill");

		// Place buttons in the hbox
		paneForButtons.getChildren().addAll(rbCircle, 
			rbRectangle, rbEllipse, chkFill);

		// Create a stack pane to hold the shapes
		StackPane paneForShapes = new StackPane();
		paneForShapes.setStyle("-fx-border-color: black");

		// Create a border pane to hold nodes
		BorderPane pane = new BorderPane();
		pane.setBottom(paneForButtons);
		pane.setCenter(paneForShapes);

		// Create and register handlers
		rbCircle.setOnAction(e -> {
			if (rbCircle.isSelected()) {
				paneForShapes.getChildren().clear();
				paneForShapes.getChildren().add(circle);
			}
		});

		rbRectangle.setOnAction(e -> {
			if (rbRectangle.isSelected()) {
				paneForShapes.getChildren().clear();
				paneForShapes.getChildren().add(rectangle);
			}
		});

		rbEllipse.setOnAction(e -> {
			if (rbEllipse.isSelected()) {
				paneForShapes.getChildren().clear();
				paneForShapes.getChildren().add(ellipse);
			}
		});

		chkFill.setOnAction(e -> {
			if (chkFill.isSelected()) {
				circle.setFill(Color.BLACK);
				rectangle.setFill(Color.BLACK);
				ellipse.setFill(Color.BLACK);
			} else {
				circle.setFill(Color.WHITE);
				rectangle.setFill(Color.WHITE);
				ellipse.setFill(Color.WHITE);			}
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 400, 150);
		primaryStage.setTitle("Exercise_16_02"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}