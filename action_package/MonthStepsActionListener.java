package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;

public class MonthStepsActionListener implements ActionListener {
	// * Steps Week Month 3,4

	// Create private variables
	private final JFrame F;

	// Constructor
	public MonthStepsActionListener(JFrame F) {
		super();
		this.F = F;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Screen.screen_customView(4); // open help
		F.dispose(); // Kill window once launched the next one
	}// end action performed
}