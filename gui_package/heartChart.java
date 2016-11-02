package gui_package;

import javax.swing.JPanel;

import action_package.DataGenerator;
import javafx.stage.Stage;
import user_package.Generator_Heartbeat;

public class heartChart extends Charts{

	//Access the data of the current user via Generator
	static DataGenerator localGen = Screen.globalGen;
	
	
	
	/** Returns a JPanel with the invoked data */
	public static JPanel drawChart(int opt){
		int[][] data = localGen.heart.getRandomData();
		JPanel love = Charts.jPanelChart(opt, data, null, "HEART CHART TEST","Y AXIS TITLE MAN");
		return love;
	}
	
	/** Testing a drawChart from outside */
	public static JPanel drawChart(int opt, Generator_Heartbeat generator){
		int[][] data = generator.getRandomData();
		JPanel love = Charts.jPanelChart(opt, data, null, "HEART CHART TEST","Y AXIS TITLE MAN");
		return love;
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
