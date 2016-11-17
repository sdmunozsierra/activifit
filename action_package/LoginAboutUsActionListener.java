package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;
/**The action listener for clicking the Login About Us button
 * that directs the user to the Login screen.
 * @author JSSP Engineers
 * @version 1.0
 */
public class LoginAboutUsActionListener implements ActionListener {

	// Create private variables
	private final JFrame F;
	/**
	 * Constructor for LoginAboutUsActionListener without opt
	 * @param F sets the final JFrame for the LoginAboutUsActionListener
	 */
	public LoginAboutUsActionListener(JFrame F) {
		super();
		this.F = F;
	}
	/**
	 * Method overrides ActionListener to show pop-up screen.
	 * Displays the final F JFrame
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Screen.screen_about(); // open about us
		//F.dispose();// Show as pop-up
	}// end action performed

}// end class
