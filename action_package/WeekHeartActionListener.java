package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;
/** Class that registers a new user.
 * @author JSSP Engineers
 * @version 1.0
 */
public class WeekHeartActionListener implements ActionListener {

	// Create private variables
	private final JFrame F;

	/** Constructor
	 * @param JFrame 
	 * */
	public WeekHeartActionListener(JFrame F) {
		super();
		this.F = F;
	}
	/** Action Performed. Triggers the action go to screen login.
	 *  Disposes the current frame.
	 *  @see Screen.screen_customView(1)
	 * */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Screen.screen_customView(1); // open heart weekly view
		F.dispose(); // Kill window once launched the next one
	}// end action performed

}// end class