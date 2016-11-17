package chart_package;

import javax.swing.JPanel;

import generator_package.DataGenerator;
import generator_package.Generator_Sleep;
import gui_package.Screen;
import javafx.stage.Stage;
/**This displays and creates a sleep chart by accessing the data 
 * @author JSSP Engineers
 * @version 1.0
 */
public class SleepChart extends Charts {
	
	//Access the data of the current user via Generator
	static DataGenerator localGen = Screen.globalGen;
	
	/**
	 * 
	 * @param opt
	 * @param generator
	 * @return a JPanel chart with the data inserted 
	 */
	/* Testing a drawChart from outside [Debugging] */
	public static JPanel drawChart(int opt, Generator_Sleep generator){
		//Data will be manipulated in order to fit the Sleep criteria
		int[][] data = generator.getRandomData();
		
		
		JPanel night = Charts.jPanelChart(opt, data, null, "Good Night!","Y AXIS TITLE MAN",
				null, null);
		return night;
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
