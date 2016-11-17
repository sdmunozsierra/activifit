package action_package;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

import gui_package.Screen;
/**The login mouse adapter that implements the mouse listener interface
 * @author JSSP Engineers
 * @version 1.0
 */
public class LoginMouseAdapter implements MouseListener{
private Border border_blue = BorderFactory.createLineBorder(Screen.blue_belizehole);
	
	private final JTextField field;
    /**
     * @param textField A word taken from user for the login 
     */
    public LoginMouseAdapter(JTextField textField){
        super();
        this.field = textField;
    }
    
	@Override
	public void mouseClicked(MouseEvent arg0) {
		 this.field.setBorder(border_blue); // login text field
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}

}//end class
