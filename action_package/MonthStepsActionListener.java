package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;
/**The action listener is for clicking the button to display monthly steps
 * that directs the user to a graph of data.
 * @author JSSP Engineers
 * @version 1.0
 */
public class MonthStepsActionListener implements ActionListener {
	// * Steps Week Month 3,4

	// Create private variables
	private final JFrame F;
    /**
     * 
     * @param F A JFrame to display monthly step data
     */
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
}//end class