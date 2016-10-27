package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;

public class WeekActionListener implements ActionListener {

	// Create private variables
	private final JFrame F;
	private final int opt;

	// Constructor
	public WeekActionListener(JFrame F, int opt) {
		super();
		this.F = F;
		this.opt = opt;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Screen.screen_customView("Hearbeat @ Rest", "Weekly",opt); // open help
		F.dispose(); // Kill window once launched the next one
	}// end action performed

}// end class
