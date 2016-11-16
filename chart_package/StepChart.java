package chart_package;

import javax.swing.JPanel;

import action_package.DataGenerator;
import generator_package.Generator_Steps;
import gui_package.Screen;
import javafx.stage.Stage;
/** Class that registers a new user.
 * @author JSSP Engineers
 * @version 1.0
 */
public class StepChart extends Charts {

	// Access the data of the current user via Generator
	static DataGenerator localGen = Screen.globalGen;
	static int[] colorParams = {500, 1500, 2000, 3000};

	/** Returns a JPanel of type Steps. Requires the time frequency.
	 * @param opt (1 - day, 2 - week, 3- month, 4 - all)
	 * @return JPanel of type Step
	 * */
	public static JPanel drawChart(int opt) {
		int[][] data = localGen.steps.getRandomData();
		//int[] parameters = localGen.steps.sendParameters();
		JPanel run = Charts.jPanelChart(opt, data, null, "VAMOS A DARLE LA VUELTA AL MUNDO", "Number of Steps",
				colorParams, null);
		return run;
	}
	/** Testing a drawChart from outside [Debugging] 
	 * @param opt (1 - day, 2 - week, 3- month, 4 - all)
	 * @return JPanel of type Step*/
	public static JPanel drawChart(int opt, Generator_Steps generator) {
		int[][] data = generator.getRandomData();
		//int[] param = generator.sendParameters();
		JPanel runforest = Charts.jPanelChart(opt, data, null, "VAMOS A DARLE LA VUELTA AL MUNDO", "Y AXIS TITLE MAN",
				colorParams, null);
		return runforest;
	}
	/**Extended method from Application package. Unimplemented to override
	 * start method from Application class.
	 * 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	}
}