package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
/**The action listener for clicking the Help button
 * that directs the user to the Help screen.
 * @author JSSP Engineers
 * @version 1.0
 */
public class HelpActionListener implements ActionListener {

	// Create private variables
	private final JFrame F;

	/**
	 * Constructor
	 * @param F sets the final JFrame for the HelpActionListener
	 */
	public HelpActionListener(JFrame F) {
		super();
		this.F = F;
	}//end Constructor
	
	/**
	 * Method overrides ActionListener to show pop-up screen.
	 * It should check if it is going to redirect to the same help 
	 * screen, or if it has to be a specialized one.
	 * Displays the final F JFrame
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		F.dispose(); 
	}// end action performed

}// end class
