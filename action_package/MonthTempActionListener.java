package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;
/**The action listener is for clicking the button to display monthly body temperature
 * that directs the user to a graph of data.
 * @author JSSP Engineers
 * @version 1.0
 */
public class MonthTempActionListener implements ActionListener {
	//Temp  Week Month 5,6

	// Create private variables
	private final JFrame F;
    /**
     * 
     * @param F A JFrame to display the monthly body temperature chart
     */
	// Constructor
	public MonthTempActionListener(JFrame F) {
		super();
		this.F = F;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Screen.screen_customView(6); // open help
		F.dispose(); // Kill window once launched the next one
	}// end action performed
}//end class