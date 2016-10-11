package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import activifit.Screen;
import user_package.*;


public class RegisterAcceptActionListener implements ActionListener {

	// Create Private Variables
	private final JTextField[] t_input_array;
	private final int size;
	private final JFrame F;

	private String[] labels = { "Name: ", "Age: ", "Weight: ", "Height: ", "Active Id: ", "Email: " };

	private String n; // name
	private int a; // age
	private int w; // weight
	private int h; // height
	private int id; // active Id
	private String email; // email
	
	//DATABASE INFO
	private UserDatabase dataB;

	// Constructor
	public RegisterAcceptActionListener(final JTextField[] t_array, JFrame F) {
		super();
		this.size = t_array.length;
		this.t_input_array = new JTextField[size];
		for (int i = 0; i < size; i++) {
			this.t_input_array[i] = t_array[i];
		}
		this.F = F;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("Pressed a button"); //Debugging 
		extractData(t_input_array);
		//I suppose the following can be done with a CASE Statement
		if (this.a == -1) {
			System.out.println("BAD AGE INPUT");
		} else if (this.w == -1) {
			System.out.println("BAD WEIGHT");
		} else if (this.h == -1) {
			System.out.println("BAD HEIGHT");
		} else if (this.id == -1) {
			System.out.println("BAD INDEX");
		} else {
			//printData(); //Debugging purposes
			// If everything all right dispose Screen 
			// Create a USER
			registerUser();
			F.dispose();
			Screen.screen_home();
		}

	}// end action performed
	
	public void registerUser(){
		User newUser = new User(n, a, w, h, id, email);
		dataB.addToDatabase(newUser);
	}
	
	

	// Extracts the data from the JTextField
	public void extractData(JTextField[] data) {
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

	// Prints the data [debugging purposes]
	public void printData() {
		int i = 0;
		while (i < size) {
			System.out.println(labels[i] + ": " + t_input_array[i].getText());
			i++;
		}
	}

	//Method for checking if the parsed Int is really an Integer
	public static Integer tryParse(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	/**
	 * TO-DO: Create a method for checking the name for invalid chars
	 * 
	 * */
}// end class
