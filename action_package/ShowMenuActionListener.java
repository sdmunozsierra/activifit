package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;

public class ShowMenuActionListener implements ActionListener {

	// Create private variables
	private final JFrame F;

	/**
	 * Constructor
	 * @param F sets the final JFrame for the AboutUsActionListener
	 */
	public ShowMenuActionListener(JFrame F) {
		super();
		this.F = F;
	}//end Constructor
	
	/**
	 * Method overrides ActionListener to show pop-up screen
	 * Displays the final F JFrame
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Screen.screen_menu();
		//F.dispose(); //Show as popup
	}// end action performed

}// end class
