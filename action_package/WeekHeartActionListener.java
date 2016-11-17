package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;
/** Action listener class for displaying Weekly view
 *  Screen Chart for Heart.
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
	/** Action Performed. Triggers the action go to weekly view.
	 *  Disposes the current frame.
	 *  @param arg0 Button clicked.
	 *  @see Screen.screen_customView(1)
	 * */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Screen.screen_customView(1); // open heart weekly view
		F.dispose(); // Kill window once launched the next one
	}// end action performed

}// end class