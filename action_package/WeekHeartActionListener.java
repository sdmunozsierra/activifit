package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;

public class WeekHeartActionListener implements ActionListener {

	// Create private variables
	private final JFrame F;

	// Constructor
	public WeekHeartActionListener(JFrame F) {
		super();
		this.F = F;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Screen.screen_customView(1); // open help
		F.dispose(); // Kill window once launched the next one
	}// end action performed

}// end class
