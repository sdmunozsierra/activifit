package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;
/** Class that shows the Help Screen.
 * @author JSSP Engineers
 * @version 1.0
 */
public class RegisterHelpActionListener implements ActionListener {

	// Create private variables
	private final JFrame F;

	/** Constructor
	 * @param JFrame 
	 * */
	public RegisterHelpActionListener(JFrame F) {
		super();
		this.F = F;
	}
	/** Action Performed. Triggers the action go to screen help.
	 *  Disposes the current frame.
	 *  @param arg0 Button clicked.
	 *  @see Screen.screen_help()
	 * */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Screen.screen_help(); // open help
		F.dispose(); // Kill window once launched the next one
	}// end action performed

}// end class