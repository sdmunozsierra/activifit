package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;

/* This class will be a more dynamic way to implement the actions for buttons
 * in the Home Screen, requiring a opt parameter 
 * This will remove the need for having multiple action listeners*/
public class HomeMenuActionListener implements ActionListener {

	private final JFrame F;

	// Opt in order 0: HEART 1: STEPS 2: TEMP 3: SLEEP 4: SHARE
	private int opt;

	// Simple Constructor
	public HomeMenuActionListener(JFrame F) {
		super();
		this.F = F;
	}
	
	// Constructor with opt
	public HomeMenuActionListener(JFrame F, int opt) {
		super();
		this.F = F;
		this.opt = opt;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (opt) {
		case 0:
			Screen.screen_heart();
			F.dispose(); // Kill window once launched the next one
			break;
			
		case 1:
			Screen.screen_steps();
			F.dispose(); // Kill window once launched the next one
			break;

		case 2:
			Screen.screen_temperature(); // open login Screen
			F.dispose(); // Kill window once launched the next one
			break;

		case 3:
			Screen.screen_sleep(); // open login Screen
			F.dispose(); // Kill window once launched the next one
			break;

		case 4:
			Screen.screen_share(); // open login Screen
			F.dispose(); // Kill window once launched the next one
			break;

		}// end case
	}// end action performed

}// end class
