package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;
<<<<<<< HEAD
/**The action listener for clicking the help button from the login screen
 * that directs the user to the help screen.
 * @author JSSP Engineers
 * @version 1.0
 */
public class LoginHelpActionListener implements ActionListener {

	// Create private variables
	private final JFrame F;

	// Constructor
	/**
	 * 
	 * @param F
	 */
	public LoginHelpActionListener(JFrame F) {
		super();
		this.F = F;
	}
    
	@Override
	public void actionPerformed(ActionEvent arg0) {
		/* Should check if it is going to redirect to the same help
		 * screen, or if it has to be a specialized one */
		Screen.screen_help(); // open help screen
		//F.dispose(); // This will be disabled because help screen is only a popout
	}// end action performed

}// end class
=======

public class LoginHelpActionListener implements ActionListener {

	// Create private variables
	private final JFrame F;

	// Constructor
	public LoginHelpActionListener(JFrame F) {
		super();
		this.F = F;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		/* Should check if it is going to redirect to the same help
		 * screen, or if it has to be a specialized one */
		Screen.screen_help(); // open help screen
		//F.dispose(); // This will be disabled because help screen is only a popout
	}// end action performed

}// end class
>>>>>>> branch 'master' of https://github.com/sdmunozsierra/activifit.git
