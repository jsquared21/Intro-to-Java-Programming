/*********************************************************************************
* (Address book) Write a program that stores, retrieves, adds, and updates       *
* addresses as shown in Figure 17.20. Use a fixed-length string for storing each *
* attribute in the address. Use random access file for reading and writing an    *
* address. Assume that the size of name, street, city, state, and zip is 32, 32, * 
* 20, 2, 5 bytes, respectively.                                                  *
*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import java.io.*;

public class Exercise_17_09 extends Application {
	protected AddressBookPane pane = new AddressBookPane();
	final int NAME = 32; 
	final int STREET = 32; 
	final int CITY = 20; 
	final int STATE = 2; 
	final int ZIP = 5; 
	protected int count = 0;

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create and register handlers
		pane.btAdd.setOnAction(e -> add());
		pane.btFirst.setOnAction(e -> first());
		pane.btNext.setOnAction(e -> next());
		pane.btPrevious.setOnAction(e -> previous());
		pane.btLast.setOnAction(e -> last());
		pane.btUpdate.setOnAction(e -> update());

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 360, 130);
		primaryStage.setTitle("Exericse_17_09"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/** Write an address to file */
	private void add() {
		try ( // Create a random access file
			RandomAccessFile inout = 
				new RandomAccessFile("AddressBook.dat", "rw");
		) {
			inout.seek(inout.length());
		 	write(inout);
		}
		catch (FileNotFoundException ex) {}
		catch (IOException ex) {}
		catch (IndexOutOfBoundsException ex) {}
	}

	/** Read the first address from the file */
	private void first() {
		try ( // Create a random access file
			RandomAccessFile inout = 
				new RandomAccessFile("AddressBook.dat", "rw");
		) {
			if (inout.length() > 0) {
				inout.seek(0);
				read(inout);
				System.out.println("Reading address #1");
				count = 1;
			}
			else {
				System.out.println("Address is empty!");
			}
		}
		catch (IOException ex) {}
	}

	/** Read the next Address from the file */
	private void next() {
		try ( // Create a random access file
			RandomAccessFile inout = 
				new RandomAccessFile("AddressBook.dat", "rw");
		) {
			if (count * 91 < inout.length()) {
				inout.seek(count * 91);
				read(inout);
				count++;
				System.out.println("Reading address #" + count);
			}
			else {
				System.out.println("End of file!");
			}
		}
		catch (IOException ex) {}
	}

	/** Read the previous Address from the file */
	private void previous() {
		try ( // Create a random access file
			RandomAccessFile inout = 
				new RandomAccessFile("AddressBook.dat", "rw");
		) {
			if (count > 1) 
				count--;
			else
				count = 1;
			inout.seek((count * 91) - 91);
			read(inout);
			System.out.println("Reading address #" + count);
		}
		catch (IOException ex) {}
	}

	/** Read last address from file */
	private void last() {
		try ( // Create a random access file
			RandomAccessFile inout = 
				new RandomAccessFile("AddressBook.dat", "rw");
		) {
			count = ((int)inout.length()) / 91;
			inout.seek((count * 91) - 91);
			read(inout);
			System.out.println("Reading address #" + count);
		}
		catch (IOException ex) {}
	}

	/** Edit and address in file */
	private void update() {
		try ( // Create a random access file
			RandomAccessFile inout = 
				new RandomAccessFile("AddressBook.dat", "rw");
		) {
		 	inout.seek(count * 91 - 91);
		 	write(inout);
		}
		catch (FileNotFoundException ex) {}
		catch (IOException ex) {}
	}

	/** Write addreass to file */
	private void write(RandomAccessFile inout) throws IOException {
		inout.write(fixedLength(pane.tfName.getText().getBytes(), NAME)); 
		inout.write(fixedLength(pane.tfStreet.getText().getBytes(), STREET));
		inout.write(fixedLength(pane.tfCity.getText().getBytes(), CITY));
		inout.write(fixedLength(pane.tfState.getText().getBytes(), STATE));
		inout.write(fixedLength(pane.tfZip.getText().getBytes(), ZIP));
		System.out.println("Address #" + count + " saved!");
	}

	/** Read address from file */
	private void read(RandomAccessFile inout) throws IOException {
		int pos;
		byte[] name = new byte[NAME];	
		pos = inout.read(name);
		pane.tfName.setText(new String(name));

		byte[] street = new byte[STREET];	
		pos += inout.read(street);
		pane.tfStreet.setText(new String(street));

		byte[] city = new byte[CITY];	
		pos += inout.read(city);
		pane.tfCity.setText(new String(city));

		byte[] state = new byte[STATE];	
		pos += inout.read(state);
		pane.tfState.setText(new String(state));

		byte[] zip = new byte[ZIP];	
		pos += inout.read(zip);
		pane.tfZip.setText(new String(zip));
	}

	/** Return a byte[] of fixed-length */
	private byte[] fixedLength(byte[] x, int n) {
		byte[] b = new byte[n];
		for (int i = 0; i < x.length; i++) {
			b[i] = x[i];
		}
		return b;
	}
}