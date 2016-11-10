package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;

/* Class for going back to the home screen */
public class NavPanelBackActionListener implements ActionListener {

	// Create private variables
	private final JFrame F;
	
	//Constructor
	public NavPanelBackActionListener(JFrame F){
	        super();
	        this.F = F;
	    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Screen.screen_home(); // open Home Screen
		F.dispose(); // Kill window once launched the next one
	}// end action performed

}//end class
