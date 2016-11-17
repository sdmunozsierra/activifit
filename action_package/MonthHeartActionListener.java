package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;
/**The action listener is for clicking the button to display monthly heart rate
 * that directs the user to a graph of data.
 * @author JSSP Engineers
 * @version 1.0
 */
public class MonthHeartActionListener implements ActionListener {
	// Create private variables
		private final JFrame F;

		// Constructor
		/**
		 * 
		 * @param F A JFrame to display the chart of data for the heart rate
		 */
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
