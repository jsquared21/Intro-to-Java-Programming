import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class TablePane extends HBox {
	// Data Field
	private TextField tfRectangle1X = new TextField();
	private TextField tfRectangle1Y = new TextField();
	private TextField tfRectangle1Width = new TextField();
	private TextField tfRectangle1Height = new TextField();
	private TextField tfRectangle2X = new TextField();
	private TextField tfRectangle2Y = new TextField();
	private TextField tfRectangle2Width = new TextField();
	private TextField tfRectangle2Height = new TextField();
	private Rectangle rectangle1 = new Rectangle(79.0, 20.0, 40.0, 50.0);;
	private Rectangle rectangle2 = new Rectangle(110.0, 33.0, 50.0, 20.0);
	private VBox paneForTable1;
	private VBox paneForTable2;

	/** Construct a default TablePane */
	TablePane() {
		rectangle1.setStroke(Color.BLACK);
		rectangle1.setFill(Color.WHITE);
		rectangle2.setStroke(Color.BLACK);
		rectangle2.setFill(Color.WHITE);
		setTextProperties();
		getTable();
	}

	/** Return rectangle1 */
	public Rectangle getRectangle1() {
		return rectangle1;
	}

	/** Return rectangle2 */
	public Rectangle getRectangle2() {
		return rectangle2;
	}

	/** Return rectangle1 x */
	public double getRectangle1X() {
		return rectangle1.getX();
	}

	/** Return rectangle2 x */
	public double getRectangle2X() {
		return rectangle2.getX();
	}

	/** Return rectangle1 y */
	public double getRectangle1Y() {
		return rectangle1.getY();
	}

	/** Return rectangle2 y */
	public double getRectangle2Y() {
		return rectangle2.getY();
	}

	/** Set new rectangle1 x */
	public void setRectangle1X(double x) {
		rectangle1.setX(x);
	}

	/** Set new rectangle1 width */
	public void setRectangle1Width(double width) {
		rectangle1.setWidth(width);
	}

	/** Set new rectangle1 height */
	public void setRectangle1Height(double height) {
		rectangle1.setHeight(height);
	}

	/** Return rectangle1 width */
	public double getRectangle1Width() {
		return rectangle1.getWidth();
	}

	/** Return rectangle1 height */
	public double getRectangle1Height() {
		return rectangle1.getHeight();
	}

	/** Return rectangle2 height */
	public double getRectangle2Height() {
		return rectangle2.getHeight();
	}

	/** Return rectangle2 width */
	public double getRectangle2Width() {
		return rectangle2.getWidth();
	}

	/** Set new rectangle1 y */
	public void setRectangle1Y(double y) {
		rectangle1.setY(y);
	}

	/** Set new rectangle2 x */
	public void setRectangle2X(double x) {
		rectangle2.setX(x);
	}

	/** Set new rectangle2 y */
	public void setRectangle2Y(double y) {
		rectangle2.setY(y);
	}

	/** Set new text */
	public void setTfRectangle1X(String text) {
		tfRectangle1X.setText(text);
	}

	/** Set new text */
	public void setTfRectangle1Y(String text) {
		tfRectangle1Y.setText(text);
	}

	/** Set new text */
	public void setTfRectangle1Width(String text) {
		tfRectangle1Width.setText(text);
	}

	/** Set new text */
	public void setTfRectangle1Height(String text) {
		tfRectangle1Height.setText(text);
	}

	/** Set new text */
	public void setTfRectangle2X(String text) {
		tfRectangle2X.setText(text);
	}

	/** Set new text */
	public void setTfRectangle2Y(String text) {
		tfRectangle2Y.setText(text);
	}

	/** Set new text */
	public void setTfRectangle2Width(String text) {
		tfRectangle2Width.setText(text);
	}

	/** Set new text */
	public void setTfRectangle2Height(String text) {
		tfRectangle2Height.setText(text);
	}


	/** Add two Tables to vbox */
	private void getTable() {
		// Create table for rectangle1 
		paneForTable1 = getTable(tfRectangle1X, 
			tfRectangle1Y, tfRectangle1Width, tfRectangle1Height, 1);
		
		// Create table for rectangle2 
		paneForTable2 = getTable(tfRectangle2X, 
			tfRectangle2Y, tfRectangle2Width, tfRectangle2Height, 2);

		getChildren().addAll(paneForTable1, paneForTable2);
	}

	/** Return a table */
	private VBox getTable(TextField x, TextField y, 
		TextField width, TextField height, int n) {
		VBox vBox = new VBox(2);
		vBox.setStyle("-fx-border-color: Black");
		vBox.getChildren().addAll(new Label("Enter rectangle " + 
			n + " info:"), getGrid(x, y, width, height));
		return vBox;
	}

	/** Return a grid pane of rectangle info */
	private GridPane getGrid(TextField x, TextField y, 
		TextField width, TextField height) {
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(2);
		gridPane.add(new Label("X:"), 0, 0);
		gridPane.add(x, 1, 0);
		gridPane.add(new Label("Y:"), 0, 1);
		gridPane.add(y, 1, 1);
		gridPane.add(new Label("Width:"), 0, 2);
		gridPane.add(width, 1, 2);
		gridPane.add(new Label("Height:"), 0, 3);
		gridPane.add(height, 1, 3);
		return  gridPane;
	}

	/** Set retangles to text field data */
	public void redraw() {
		if (Double.parseDouble(tfRectangle1X.getText()) != rectangle1.getX()) {
			rectangle1.setX(Double.parseDouble(tfRectangle1X.getText()));
		}

		if (Double.parseDouble(tfRectangle1Y.getText()) != rectangle1.getY()) {
			rectangle1.setY(Double.parseDouble(tfRectangle1Y.getText()));
		}

		if (Double.parseDouble(
			tfRectangle1Width.getText()) != rectangle1.getWidth()) {
			rectangle1.setWidth(Double.parseDouble(tfRectangle1Width.getText()));
		}

		if (Double.parseDouble(
			tfRectangle1Height.getText()) != rectangle1.getHeight()) {
			rectangle1.setHeight(Double.parseDouble(tfRectangle1Height.getText()));
		}

		if (Double.parseDouble(tfRectangle2X.getText()) != rectangle2.getX()) {
			rectangle2.setX(Double.parseDouble(tfRectangle2X.getText()));
		}

		if (Double.parseDouble(tfRectangle2Y.getText()) != rectangle2.getY()) {
			rectangle2.setY(
				Double.parseDouble(tfRectangle2Y.getText()));
		}

		if (Double.parseDouble(
			tfRectangle2Width.getText()) != rectangle2.getWidth()) {
			rectangle2.setWidth(
				Double.parseDouble(tfRectangle2Width.getText()));
		}

		if (Double.parseDouble(
			tfRectangle2Height.getText()) != rectangle2.getHeight()) {
			rectangle2.setHeight(
				Double.parseDouble(tfRectangle2Height.getText()));
		}
 
	}

	/** Set default text field properties */
	private void setTextProperties() {
		tfRectangle1X.setPrefColumnCount(3);
		tfRectangle1Y.setPrefColumnCount(3);
		tfRectangle1Width.setPrefColumnCount(3);
		tfRectangle1Height.setPrefColumnCount(3);
		tfRectangle2X.setPrefColumnCount(3);
		tfRectangle2Y.setPrefColumnCount(3);
		tfRectangle2Width.setPrefColumnCount(3);
		tfRectangle2Height.setPrefColumnCount(3);
		tfRectangle1X.setText(String.valueOf(rectangle1.getX()));
		tfRectangle1Y.setText(String.valueOf(rectangle1.getY()));
		tfRectangle1Width.setText(String.valueOf(rectangle1.getWidth()));
		tfRectangle1Height.setText(String.valueOf(rectangle1.getHeight()));
		tfRectangle2X.setText(String.valueOf(rectangle2.getX()));
		tfRectangle2Y.setText(String.valueOf(rectangle2.getY()));
		tfRectangle2Width.setText(String.valueOf(rectangle2.getWidth()));
		tfRectangle2Height.setText(String.valueOf(rectangle2.getHeight()));
		setAlignment(Pos.CENTER);
		setSpacing(5);
	}
}