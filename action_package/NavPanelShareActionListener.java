package action_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui_package.Screen;
/** Action Listener Class for going to the share screen
 * @author JSSP Engineers
 * @version 1.0
 */
public class NavPanelShareActionListener implements ActionListener {

	//Local Variables
	private final JFrame F;
	
	/** Constructor
	 * @param JFrame 
	 * */
	public NavPanelShareActionListener(JFrame F){
	        super();
	        this.F = F;
	    }

	/** Action Performed. Triggers the action go to screen share.
	 *  Disposes the current frame.
	 *  @param arg0 Button clicked.
	 *  @see Screen.screen_home()
	 * */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Screen.screen_share();
		F.dispose(); 
	}
}//end class