import gui_package.Screen;
import javafx.application.Application;
import javafx.stage.Stage;

//Can be renamed as main
public class runMVC extends Application{
	//Model, View, Controller Class (a.k.a. main)
	public static void main(String args[]){
		
		Screen gui = new Screen();
		launch(args);
				
	}//end main

	@Override
	public void start(Stage arg0) throws Exception {
		
	}
}//end class
