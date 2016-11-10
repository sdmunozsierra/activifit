package chart_package;

import javax.swing.JPanel;

import action_package.DataGenerator;
import generator_package.Generator_Temperature;
import gui_package.Screen;
import javafx.stage.Stage;

public class tempChart extends Charts{

	//Access the data of the current user via Generator
	static DataGenerator localGen = Screen.globalGen;
	static double[] colorParams = {035.0, 36.4, 37.5, 38.3};
//	//
//	return "Hypothermia"; //<35.0 °C
//	else if(celcius> HYPOTHERMIA && celcius < NORMAL)
//		return "Normal Cold";  //35.1- 36.4 °C
//	else if(celcius >= NORMAL && celcius < FEVER)
//		return "Normal"; //36.5–37.5 °C
//	else if(celcius >= FEVER && celcius < HYPERPYREXIA)
//		return "Fever"; //37.5 or 38.3 °C
//	else
//		return "Hyperpyrexia"; // <38.3 °C
//	//
	
	/** Returns a JPanel with the invoked data */
	public static JPanel drawChart(int opt){
		double[][] data = localGen.temp.getRandomData();
		JPanel hot = Charts.jPanelChart(opt, null, data, "HOT SINCE 92","�C",
				null, colorParams);
		return hot;
	}
	
	
	/** Testing a drawChart from outside [Debugging] */
	public static JPanel drawChart(int opt, Generator_Temperature generator){
		double[][] data = generator.getRandomData();
		JPanel cold = Charts.jPanelChart(opt, null, data, "TEMP CHART TEST","Y AXIS TITLE MAN",
				null, colorParams);
		return cold;
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
