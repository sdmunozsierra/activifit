package action_package;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;

import generator_package.Generator;
import gui_package.Screen;
import user_package.*;
/** Class that registers a new user.
 * @author JSSP Engineers
 * @version 1.0
 */

public class RegisterAcceptActionListener implements ActionListener {
	// Border
	private static Border border_error = BorderFactory.createLineBorder(Color.RED);
	// Create Private Variables
	private final JTextField[] t_input_array;
	private final int size;
	private final JFrame F;
	// Input Variables
	private String[] labels = { "Name: ", "Age: ", "Weight: ", "Height: ", "Active Id: ", "Email: " };
	private String n; // name
	private int a; // age
	private int w; // weight
	private int h; // height
	private int id; // active Id
	private String email; // email
	// User
	private User newUser;
	
	
	/** Constructor.
	 *  Sets the size, a local text array, and frame.
	 *  @param JTextField[]. An array of text fields (registration form).
	 *  @param JFrame. 
	 * */
	public RegisterAcceptActionListener(final JTextField[] t_array, JFrame F) {
		super();
		this.size = t_array.length;
		this.t_input_array = new JTextField[size];
		for (int i = 0; i < size; i++) {
			this.t_input_array[i] = t_array[i];
		}
		this.F = F;
	}
	/** Action Performed. Checks the user input, if errors occur, send errors
	 *  to the user form. If no errors, register the user, and create a 
	 *  global generator, to be used everywhere.
	 *  Finally disposes the current Frame.
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean flagError = false;
		extractData(t_input_array);
		//TO-DO change to a switch statement for a better design
		//TO-DO make some pop ups showing what exactly the error is
		if (this.a <0 || this.a > 120) {
			t_input_array[1].setBorder(border_error);
			flagError = true;
		}
		if (this.w < 0 || this.w > 300) {
			t_input_array[2].setBorder(border_error);
			flagError = true;
		} 
		if (this.h < 0 || this.h > 500) {
			t_input_array[3].setBorder(border_error);
			flagError = true;
		} 
		if (this.id < 0 || this.id> 9) {
			t_input_array[4].setBorder(border_error);
			flagError = true;
		} 
		if (!flagError) { //VERY IMPORTANT
			/* After the registration has succeded, the user is going to be
			 * created in the database and the random data is going to be 
			 * generated in order to be used EVERYWHERE else.*/
			registerUser(); // Create a USER
			createGlobalGen(); //Create generators
			//Screen.globalDatabase.printAllDetails(); //Debugging
			//Screen.globalGen.printAllDetails(); //Debugging
			//testSleepGen(); //debugging
			F.dispose();
			Screen.screen_home();
		}
	}// end action performed
	
	/** Register a User in the global database. */
	private void registerUser(){
		this.newUser = new User(n, a, w, h, id, email);
		Screen.globalDatabase.addUserToDatabase(newUser);
		
	}
	/** Create a Global Data Generator. */
	private void createGlobalGen(){
		Generator newGen = new Generator(newUser);
		Screen.globalGen = new DataGenerator(newGen);
	}
	/** Extracts the data from the JTextField. 
	 * @param JTextField[]. The form in a textField array type. */
	private void extractData(JTextField[] data) {
		/*
		 * I don't know if there is a way to loop this instead of hard coding
		 * it..?
		 */
		this.n = data[0].getText();
		this.a = tryParse(data[1].getText());
		this.w = tryParse(data[2].getText());
		this.h = tryParse(data[3].getText());
		this.id = tryParse(data[4].getText());
		this.email = data[5].getText();
	}
	/** Prints the data [debugging purposes] */
	public void printData() {
		int i = 0;
		while (i < size) {
			System.out.println(labels[i] + ": " + t_input_array[i].getText());
			i++;
		}
	}
	/** Method for checking if the parsed Int is really an Integer 
	 * @param String text. Converts the text into an integer.*/
	private static Integer tryParse(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException e) {
			return -1;
		}
	}
	
//	/** Debugging purposes */
//	private static void testSleepGen(){
//		Generator_Sleep test = new Generator_Sleep(Screen.globalDatabase.getCurrentUser());
//		int[][] data = test.getRandomData();
//		test.print2d(data);
//	}

	 // TODO: Create a method for checking the name for invalid chars
}// end class