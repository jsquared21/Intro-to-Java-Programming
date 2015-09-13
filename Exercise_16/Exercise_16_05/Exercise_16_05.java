/*********************************************************************************
* (Convert numbers) Write a program that converts between decimal, hex, and      *
* binary numbers, as shown in Figure 16.37c. When you enter a decimal value in   *
* the decimalvalue text field and press the Enter key, its corresponding hex and *
* binary numbers are displayed in the other two text fields. Likewise, you can   *
* enter values in the other fields and convert them accordingly. (Hint: Use the  *
* Integer.parseInt(s, radix) method to parse a string to a decimal and use       *
* Integer.toHexString(decimal) and Integer.toBinaryString(decimal) to obtain a   *
* hex number or a binary number from a decimal.)                                 *
*********************************************************************************/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;

public class Exercise_16_05 extends Application {
	protected TextField tfDecimal = new TextField();
	protected TextField tfHex = new TextField();
	protected TextField tfBinary = new TextField();

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Set text field preferences
		tfDecimal.setAlignment(Pos.BOTTOM_RIGHT);
		tfHex.setAlignment(Pos.BOTTOM_RIGHT);
		tfBinary.setAlignment(Pos.BOTTOM_RIGHT);

		// Create a grid pane and add nodes to it
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(10);
		pane.setVgap(2);
		pane.add(new Label("Decimal"), 0, 0);
		pane.add(tfDecimal, 1, 0);
		pane.add(new Label("Hex"), 0, 1);
		pane.add(tfHex, 1, 1);
		pane.add(new Label("Binary"), 0, 2);
		pane.add(tfBinary, 1, 2);

		// Create and register handlers
		tfDecimal.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				tfHex.setText(Integer.toHexString(
					Integer.parseInt(tfDecimal.getText())));

				tfBinary.setText(Integer.toBinaryString(
					Integer.parseInt(tfDecimal.getText())));
			}
		});

		tfHex.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				tfDecimal.setText(String.valueOf(
					Integer.parseInt(tfHex.getText(), 16)));

				tfBinary.setText(Integer.toBinaryString(
					Integer.parseInt(tfHex.getText(), 16)));
			}
		});

		tfBinary.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				tfDecimal.setText(String.valueOf(
					Integer.parseInt(tfBinary.getText(), 2)));

				tfHex.setText(Integer.toHexString(
					Integer.parseInt(tfBinary.getText(), 2)));
			}
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 100);
		primaryStage.setTitle("Exercise_16_05"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}