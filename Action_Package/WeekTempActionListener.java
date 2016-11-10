package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;

public class WeekTempActionListener implements ActionListener {
	//Temp  Week Month 5,6

	// Create private variables
	private final JFrame F;

	// Constructor
	public WeekTempActionListener(JFrame F) {
		super();
		this.F = F;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Screen.screen_customView(5); // open help
		F.dispose(); // Kill window once launched the next one
	}// end action performed

}
