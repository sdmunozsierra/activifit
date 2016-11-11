package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class AboutUsActionListener implements ActionListener {

	// Create private variables
	private final JFrame F;

	// Constructor
	public AboutUsActionListener(JFrame F) {
		super();
		this.F = F;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Show as a pop-up screen
		F.dispose();
	}// end action performed

}// end class
