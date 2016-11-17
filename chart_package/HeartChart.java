package chart_package;

import javax.swing.JPanel;

import generator_package.DataGenerator;
import generator_package.Generator_Heartbeat;
import gui_package.Screen;
import javafx.stage.Stage;

public class HeartChart extends Charts{

	//Access the data of the current user via Generator
	static DataGenerator localGen = Screen.globalGen;
	
	//Chart Variables
	static int[] colorParameters = {0, 60, 90, 100};
	// Bradychardia -> Average -> Above average -> Tachycardia
	
	/** Returns a JPanel with the invoked data */
	public static JPanel drawChart(int opt){
		int[][] data = localGen.heart.getRandomData();
		JPanel love = Charts.jPanelChart(opt, data, null, "HEART CHART TEST","Y AXIS TITLE MAN",
				colorParameters, null);
		return love;
	}
	
	/** Testing a drawChart from outside [Debugging] */
	public static JPanel drawChart(int opt, Generator_Heartbeat generator){
		int[][] data = generator.getRandomData();
		JPanel love = Charts.jPanelChart(opt, data, null, "HEART CHART TEST","Y AXIS TITLE MAN",
				colorParameters, null);
		return love;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
