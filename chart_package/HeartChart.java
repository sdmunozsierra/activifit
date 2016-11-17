package chart_package;

import javax.swing.JPanel;

import action_package.DataGenerator;
import generator_package.Generator_Heartbeat;
import gui_package.Screen;
import javafx.stage.Stage;
/**This returns to the users display a chart of data containing the heart rates.
 * @author JSSP Engineers
 * @version 1.0
 */
public class HeartChart extends Charts{

	//Access the data of the current user via Generator
	static DataGenerator localGen = Screen.globalGen;
	
	//Chart Variables
	static int[] colorParameters = {0, 60, 90, 100};
	// Bradychardia -> Average -> Above average -> Tachycardia
	
	/*Returns a JPanel with the invoked data */
	/**
	 * 
	 * @param opt The 
	 * @return The JPanel chart containing the heart data
	 */
	public static JPanel drawChart(int opt){
		int[][] data = localGen.heart.getRandomData();
		JPanel love = Charts.jPanelChart(opt, data, null, "HEART CHART TEST","Y AXIS TITLE MAN",
				colorParameters, null);
		return love;
	}
	/** Testing a drawChart from outside [Debugging]
	 * @param opt
	 * @param generator
	 * @return The chart containing the heart data
	 */
	public static JPanel drawChart(int opt, Generator_Heartbeat generator){
		int[][] data = generator.getRandomData();
		JPanel love = Charts.jPanelChart(opt, data, null, "HEART CHART TEST","Y AXIS TITLE MAN",
				colorParameters, null);
		return love;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
	}
}//end class
