package chart_package;

import javax.swing.JPanel;

import action_package.DataGenerator;
import generator_package.Generator_Steps;
import gui_package.Screen;
import javafx.stage.Stage;

public class StepChart extends Charts {

	// Access the data of the current user via Generator
	static DataGenerator localGen = Screen.globalGen;
	static int[] colorParams = {500, 1500, 2000, 3000};

	/** Returns a JPanel with the invoked data */
	public static JPanel drawChart(int opt) {
		int[][] data = localGen.steps.getRandomData();
		//int[] parameters = localGen.steps.sendParameters();
		JPanel run = Charts.jPanelChart(opt, data, null, "VAMOS A DARLE LA VUELTA AL MUNDO", "Y AXIS TITLE MAN",
				colorParams, null);
		return run;
	}


	/** Testing a drawChart from outside [Debugging] */
	public static JPanel drawChart(int opt, Generator_Steps generator) {
		int[][] data = generator.getRandomData();
		//int[] param = generator.sendParameters();
		JPanel runforest = Charts.jPanelChart(opt, data, null, "VAMOS A DARLE LA VUELTA AL MUNDO", "Y AXIS TITLE MAN",
				colorParams, null);
		return runforest;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}
}
