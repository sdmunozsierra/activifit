package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import activifit.Screen;

public class RegisterBackActionListener implements ActionListener {

	// Create private variables
	private final JFrame F;
	
	//Constructor
	public RegisterBackActionListener(JFrame F){
	        super();
	        this.F = F;
	    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Screen.screen_login(); // open login Screen
		F.dispose(); // Kill window once launched the next one
	}// end action performed

}//end class
