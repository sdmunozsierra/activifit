package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import activifit.Screen;

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
