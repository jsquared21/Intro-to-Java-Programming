import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Exercise31_06Server {
	// IO Streams
	private ObjectInputStream objectFromClient;
	private ObjectOutputStream objectToClient;
	private DataOutputStream dataToClient;
	private DataInputStream dataFromClient;

	// Create a list of student addresses
	private List<StudentAddress> addresses = new ArrayList<>();

	// Limit the concurrent connections to two clients
	private static final int CONCURRENT_CONNECTIONS = 2;

	// Create a semaphore
	private static Semaphore semaphore = new Semaphore(CONCURRENT_CONNECTIONS);

	public static void main(String[] args) {		
		new Exercise31_06Server();
	}

	public Exercise31_06Server() {
		try {
			// Create a server socket
			ServerSocket serverSocket = new ServerSocket(8000);
			System.out.println("Server started ");

			while (true) {
				// Listen for a new connection request
				Socket socket = serverSocket.accept();			

				// Create and start a new thread for the connection
				new Thread(new HandleAClient(socket)).start();
			}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				objectFromClient.close();
				objectToClient.close();
				dataFromClient.close();
				dataToClient.close();
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	// Define the thread class for handling new connection
	class HandleAClient implements Runnable {
		private Socket socket; // A connected socket

		/** Construct a thread */
		public  HandleAClient(Socket socket) {
			this.socket = socket;
		}

		/* Run a thread */
		public void run() {
			try {
				semaphore.acquire(); // Acquire a permit

				// Create an input stream from the socket
				dataFromClient = new DataInputStream(socket.getInputStream());
				String command = dataFromClient.readUTF();

				if (command.equals("ADD_STUDENT")) { // Add object to list
					objectFromClient = new ObjectInputStream(socket.getInputStream());

					// Read object from input and add it to addresses
					StudentAddress object = (StudentAddress)objectFromClient.readObject();
					addresses.add(object);
					System.out.println("Number of students: " + addresses.size());

					// Send object index to client
					dataToClient = new DataOutputStream(socket.getOutputStream());
					dataToClient.writeInt(addresses.indexOf(object));
					dataToClient.writeInt(addresses.size());
				}
				else if (command.equals("GET_INDEX")) { // Send object to client
					// Read data from input
					int index = dataFromClient.readInt();
					System.out.println("Client wants address at index: " + index);
					if (index < 0)
				 		index = 0;
				 	if (index >= addresses.size())
				 		index = addresses.size() - 1;

				 	// Send the specified object and its index to client
					objectToClient = new ObjectOutputStream(socket.getOutputStream());					
					objectToClient.writeObject(addresses.get(index));

					dataToClient = new DataOutputStream(socket.getOutputStream());
					dataToClient.writeInt(index);

					// Send the number of addresses stored
					dataToClient.writeInt(addresses.size()); 
					objectToClient.flush();
					System.out.println("Address at index " + index + " sent to client");
				}
				else if (command.equals("GET_LAST")) { 
					// Send last object to client
					int index = addresses.size() - 1;
					objectToClient = new ObjectOutputStream(socket.getOutputStream());					
					objectToClient.writeObject(addresses.get(index));

					dataToClient = new DataOutputStream(socket.getOutputStream());
					dataToClient.writeInt(index);

					// Send the number of addresses stored
					dataToClient.writeInt(addresses.size());
					objectToClient.flush();
					System.out.println("Address at index " + index + " sent to client");
				}
			}
			catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			finally {
				semaphore.release(); // Release a permit
			}
		}
	}
}