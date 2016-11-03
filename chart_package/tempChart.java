package chart_package;

import javax.swing.JPanel;

import action_package.DataGenerator;
import generator_package.Generator_Temperature;
import gui_package.Screen;
import javafx.stage.Stage;

public class tempChart extends Charts{

	//Access the data of the current user via Generator
	static DataGenerator localGen = Screen.globalGen;
	
	
	
	/** Returns a JPanel with the invoked data */
	public static JPanel drawChart(int opt){
		double[][] data = localGen.temp.getRandomData();
		JPanel hot = Charts.jPanelChart(opt, null, data, "HOT SINCE 92","Y AXIS TITLE MAN");
		return hot;
		//TODO Change colors? override?
		//@Override
		//createChart(1, null, data, "title", "yAxis");
		
	}
	
	
	/** Testing a drawChart from outside [Debugging] */
	public static JPanel drawChart(int opt, Generator_Temperature generator){
		double[][] data = generator.getRandomData();
		JPanel cold = Charts.jPanelChart(opt, null, data, "TEMP CHART TEST","Y AXIS TITLE MAN");
		return cold;
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
