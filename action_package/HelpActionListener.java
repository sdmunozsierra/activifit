package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class HelpActionListener implements ActionListener {

	// Create private variables
	private final JFrame F;

	// Constructor
	public HelpActionListener(JFrame F) {
		super();
		this.F = F;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		/* Should check if it is going to redirect to the same help
		 * screen, or if it has to be a specialized one */
		F.dispose(); 
	}// end action performed

}// end class
