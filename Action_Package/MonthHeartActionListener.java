package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;

public class MonthHeartActionListener implements ActionListener {
	// Create private variables
		private final JFrame F;

		// Constructor
		public MonthHeartActionListener(JFrame F) {
			super();
			this.F = F;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Screen.screen_customView(2); // open help
			F.dispose(); // Kill window once launched the next one
		}// end action performed
}
