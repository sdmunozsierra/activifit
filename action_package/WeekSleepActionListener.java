package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;
/** Class that registers a new user.
 * @author JSSP Engineers
 * @version 1.0
 */
public class WeekSleepActionListener implements ActionListener {
	
	// Create private variables
	private final JFrame F;

	/** Constructor
	 * @param JFrame 
	 * */
	public WeekSleepActionListener(JFrame F) {
		super();
		this.F = F;
	}
	/** Action Performed. Triggers the action go to weekly view.
	 *  Disposes the current frame.
	 *  @param arg0 Button clicked.
	 *  @see Screen.screen_customView(7)
	 * */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Screen.screen_customView(7); // weekly view 
		F.dispose(); // Kill window once launched the next one
	}// end action performed

}