package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;
/**The action listener is for clicking the button ok that redirects to login screen
 * @author JSSP Engineers
 * @version 1.0
 */

public class LogoutAcceptActionListener implements ActionListener {
	// Create private variables
	private final JFrame F;

	// Constructor
	/**
	 * 
	 * @param F A JFrame to display the chart of data for the heart rate
	 */
	public LogoutAcceptActionListener(JFrame F) {
		super();
		this.F = F;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Screen.screen_login(); // login screen
		F.dispose(); // Kill window once launched the next one
	}// end action performed
}
