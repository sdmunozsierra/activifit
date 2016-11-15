package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;
/** Class for going back to the home screen
 * @author JSSP Engineers
 * @version 1.0
 */
public class NavPanelBackActionListener implements ActionListener {

	//Local Variables
	private final JFrame F;
	
	/** Constructor
	 * @param JFrame 
	 * */
	public NavPanelBackActionListener(JFrame F){
	        super();
	        this.F = F;
	    }

	/** Action Performed. Triggers the action go to screen home.
	 *  Disposes the current frame.
	 *  @see Screen.screen_home()
	 * */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Screen.screen_home();
		F.dispose(); 
	}
}//end class