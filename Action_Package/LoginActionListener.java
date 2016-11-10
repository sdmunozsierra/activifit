package action_package;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;

import gui_package.Screen;

public class LoginActionListener implements ActionListener{
	private static Border border_default = BorderFactory.createLineBorder(Color.BLACK);
	private static Border border_error = BorderFactory.createLineBorder(Color.RED);
	
	private static JTextField t_login;
	private final JFrame F;

    public LoginActionListener(final JTextField textField, JFrame F){
        super();
        LoginActionListener.t_login = textField;
        LoginActionListener.t_login.setBorder(border_default); // login text field
        this.F = F;
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
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
	//Check for a valid email
	public static boolean isValidEmailAddress(String email) {
		//From http://stackoverflow.com/questions/624581/what-is-the-best-java-email-address-validation-method
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}
	
	//Return the valid email
	public static String returnValidEmail(){
		String valid = t_login.getText();
		return valid;
	}
}//end class
