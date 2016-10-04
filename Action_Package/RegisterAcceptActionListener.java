package action_package;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class RegisterAcceptActionListener implements ActionListener {
	private static Border border_default = BorderFactory.createLineBorder(Color.BLACK);
	private static Border border_error = BorderFactory.createLineBorder(Color.RED);

	private final JTextField[] t_input_array;
	private final int size;
	private final JFrame F;

	public String name;
	public int age;
	public int weight;
	public int height;
	public int actId;
	public String email;
	
	int invalidArgs;
	
	// Constructor
	public RegisterAcceptActionListener(final JTextField[] t_array, JFrame F){
    	super();
        this.size = t_array.length;
    	this.t_input_array = new JTextField[size];
        for (int i = 0; i < size; i++) {
			this.t_input_array[i] = t_array[i];
			this.t_input_array[i].setBorder(border_default); // login text field
		}
        this.F = F;
        this.invalidArgs = 0;
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		fillInputs();
		
		if(validateName(this.name)){
			t_input_array[0].setBorder(border_error);
			t_input_array[0].selectAll();
			t_input_array[0].setSelectedTextColor(Color.RED);
		}
		
		
	}// end action performed
	
	 private static boolean validateName(String name){
		 return name.matches( "[A-Z][a-zA-Z]*" );
	 }
	 
	 private void fillInputs(){
		 this.name = this.t_input_array[0].getText();
		 this.age = Integer.parseInt(this.t_input_array[1].getText());
		 this.weight = Integer.parseInt(this.t_input_array[2].getText());
		 this.height = Integer.parseInt(this.t_input_array[3].getText());
		 this.actId = Integer.parseInt(this.t_input_array[4].getText());
		 this.email = this.t_input_array[5].getText();
	 }
}
