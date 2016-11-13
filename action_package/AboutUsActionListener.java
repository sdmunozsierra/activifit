package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
/**The action listener for clicking the About Us button
 * that directs the user to the About Us screen.
 * @author JSSP Engineers
 * @version 1.0
 */
public class AboutUsActionListener implements ActionListener {

	// Create private variables
	private final JFrame F;

	/**
	 * 
	 * @param F 
	 */
	public AboutUsActionListener(JFrame F) {
		super();
		this.F = F;
	}
	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Show as a pop-up screen
		F.dispose();
	}// end action performed

}// end class
