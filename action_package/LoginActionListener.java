package action_package;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;

import gui_package.Screen;
/**The action listener for clicking the Login button
 * that directs the user to the Login screen.
 * @author JSSP Engineers
 * @version 1.0
 */
public class LoginActionListener implements ActionListener{
	private static Border border_default = BorderFactory.createLineBorder(Color.BLACK);
	private static Border border_error = BorderFactory.createLineBorder(Color.RED);
	
	public static JTextField t_login;
	private final JFrame F;

	/**
	 * Constructor for LoginActionListener
	 * @param textField takes in the email of the person trying to log in
	 * @param F sets the final JFrame for the LoginActionListener
	 */
    public LoginActionListener(final JTextField textField, JFrame F){
        super();
        LoginActionListener.t_login = textField;
        LoginActionListener.t_login.setBorder(border_default); // login text field
        this.F = F;
    }
    /**
     * This method checks that the email inputed into the field is a valid email.
     * After checking that, it checks if the email already exists in the database
     * and if not it sends to the register screen.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
			String input = t_login.getText();
			if (input.equals("") || !isValidEmailAddress(input)) {
				// JOptionPane.showMessageDialog(null, "Invalid
				// characters\nUse letters only!");
				t_login.setBorder(border_error);
				t_login.selectAll();
				t_login.setSelectedTextColor(Color.RED);
			} else {
				// Here will check the User class for a valid email.
				t_login.setEditable(false);
				t_login.setBorder(border_default); // login text field

				// If email was not found on Users class..
				Screen.screen_register();
				F.dispose(); //Kill window once launched the next one
			}//end else
		}//end action performed
		
	/* --Extra Methods-- */
	/**
	 * This method checks if the email inputed into the field is valid.
	 * @param email passes through the email the user has inputed into the system.
	 * @return boolean, either true or false; true if email is valid, false if otherwise.
	 */
	public static boolean isValidEmailAddress(String email) {
		//From http://stackoverflow.com/questions/624581/what-is-the-best-java-email-address-validation-method
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}
	
	/**
	 * Method returns the email that was inputed into the system.
	 * @return String, the valid email
	 */
	public static String returnValidEmail(){
		String valid = t_login.getText();
		return valid;
	}
}//end class
