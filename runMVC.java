import activifit.Screen;
//import action_package.*;
import user_package.UserDatabase;

//Can be renamed as main
public class runMVC {
	//Model, View, Controller Class (a.k.a. main)
	public static void main(String args[]){
		Screen gui = new Screen();
		UserDatabase database = new UserDatabase();
		
		gui.screen_login();
		
	}//end main
	

}
