import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.util.List;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Exercise_16_14 extends Application {
	protected Text text = new Text("Programming is fun");
	protected ComboBox<String> cboFontName = new ComboBox<>();
	protected ComboBox<String> cboFontSize = new ComboBox<>();
	protected CheckBox chkBold = new CheckBox("Bold");
	protected CheckBox chkItalic = new CheckBox("Italic");

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create and add a list of font families to cboFontName
		List<String> families = Font.getFamilies();
		ObservableList<String> fonts = 
			FXCollections.observableArrayList(families);
		cboFontName.getItems().addAll(fonts);

		// Create and add a list of font sizes to cboFontSize
		ArrayList<String> list = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			list.add(String.valueOf(i));
		}
		ObservableList<String> sizes =
			FXCollections.observableArrayList(list);
		cboFontSize.getItems().addAll(sizes);

		// Create a hbox for two combo boxes and their labels
		HBox paneForComboBoxes = new HBox(5);
		paneForComboBoxes.setAlignment(Pos.CENTER);
		paneForComboBoxes.getChildren().addAll(
			new Label("Font Name"), cboFontName, 
			new Label("Font Size"), cboFontSize);

		// Create a text
		text.setFont(Font.font(50));
		StackPane paneForText = new StackPane(text);
		paneForText.setPadding(new Insets(20, 5, 20, 5));

		// Create a hbox for check boxes and their labels
		HBox paneForCheckBoxes = new HBox(5);
		paneForCheckBoxes.setAlignment(Pos.CENTER);
		paneForCheckBoxes.getChildren().addAll(chkBold, chkItalic);

		// Set default selections
		cboFontName.setValue("Times New Roman");
		cboFontSize.setValue("30");
		text.setFont(Font.font(getName(), 
			getWegiht(), getPosture(), getSize()));

		// Create and register handlers
		chkBold.setOnAction(e -> setDisplay());
		chkItalic.setOnAction(e -> setDisplay());
		cboFontName.setOnAction(e -> setDisplay());
		cboFontSize.setOnAction(e -> setDisplay());

		// Create a border pane
		BorderPane pane = new BorderPane();
		pane.setTop(paneForComboBoxes);
		pane.setCenter(paneForText);
		pane.setBottom(paneForCheckBoxes);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 1000, 500);
		primaryStage.setTitle("Exercise_16_14"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/** Set text font properties to specified values */
	private void setDisplay() {
		text.setFont(Font.font(getName(), getWegiht(), getPosture(), getSize()));
	}

	/* Return selected font name */
	private String getName() {
		return cboFontName.getValue();
	}

	/* Return font weight */
	private FontWeight getWegiht() {
		return chkBold.isSelected() ? FontWeight.BOLD : FontWeight.NORMAL;
	}

	/* Return font posture */
	private FontPosture getPosture() {
		return chkItalic.isSelected() ? FontPosture.ITALIC : FontPosture.REGULAR;
	}

	/* Return selected font size */
	private int getSize() {
		return Integer.parseInt(cboFontSize.getValue());
	}
}