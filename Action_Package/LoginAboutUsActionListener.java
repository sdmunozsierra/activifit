package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import activifit.Screen;
public class LoginAboutUsActionListener implements ActionListener {

	// Create private variables
	private final JFrame F;

	// Constructor
	public LoginAboutUsActionListener(JFrame F) {
		super();
		this.F = F;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Screen.screen_about(); // open about us
		//F.dispose();// Show as pop-up
	}// end action performed

}// end class
