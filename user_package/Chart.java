package gui_package;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import action_package.DataGenerator;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.embed.swing.JFXPanel;
import javax.swing.*;




import user_package.Generator;
import user_package.User;


// IMPORT SWING INTEROP

public class Chart extends Application{
	// Variables to test the chart
	static User tempUsr = new User("UsainBolt", 15, 165, 165, 5, "gay@hotmail.com");
	static Generator tempGen = new Generator(tempUsr);
	static DataGenerator dataGen = new DataGenerator(tempGen);

	// Main method
	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				initAndShowGUI();
//			}
//		});
	
		
		Frame F = new Frame("Test");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		panel.add(barChartHeartbeatDetails());
		
		F.add(panel);
		F.setSize(1200, 800);
		F.setVisible(true);
		//F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		//Display CHART!
		//launch(args);
		 

	/** BarChart */
	public static JPanel barChartHeartbeatDetails() {
		// Now you can import Java FX 'applications'.
		final JFXPanel fxPanel = new JFXPanel();
		Stage stage = new Stage();
		// Create a new container
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

		//Bar Chart information
		stage.setTitle("Bar Chart Sample");
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);
		bc.setTitle("Heartbeat Summary"); //Title
		xAxis.setLabel("Week");	//xAxis label
		yAxis.setLabel("Beats per Minute (BPM)");	//yAxis label
		
		//Data Information
		int[][] data = dataGen.heart.sendRandomData();
		
		//Chart Series
		XYChart.Series series1 = new XYChart.Series();
		series1.setName("CURRENT MONTH");
		XYChart.Series series2 = new XYChart.Series();
		series2.setName("CURRENT WEEK NUMBER");
		XYChart.Series series3 = new XYChart.Series();
		series3.setName("CURRENT HOUR");
		
		//Deposit Data
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (i == 0) { // Month data
					series1.getData().add(new XYChart.Data("wEEk#" + (j + 1), data[i][j]));
				}
				if (i == 1) {// Week data
					series2.getData().add(new XYChart.Data("DAY#" + (j + 1), data[i][j]));
				}
				if (i == 2) {// day data
					series3.getData().add(new XYChart.Data("HOUR#" + (j + 1), data[i][j]));
				} // end if
			} // end for
		} // end for
		
		//Scene Settings
		Scene scene = new Scene(bc, 1200, 800);
		bc.getData().addAll(series1, series2, series3);
		stage.setScene(scene);
		stage.show();
		
		//ADD TO JPANEL
		// Add FXPanel to container
		container.add(fxPanel);
		//initFX(fxPanel);
		fxPanel.setScene(scene);

		
		return container; // return the FXPanel
	}
	
	
	
	/** INIT OVERRIDE*/
	@Override
	public void init() {
	    // create javafx panel for charts
	    chartFxPanel = new JFXPanel();
	    chartFxPanel.setPreferredSize(new Dimension(PANEL_WIDTH_INT, PANEL_HEIGHT_INT));
	}
	
	/** Get rid of error */
	public class SwingInterop extends JApplet {
	    private static  JFXPanel chartFxPanel;
	// rest of the SwingInterop class code here
	}
	
	/** Create Scene */
	private void createScene() {
	    chart = createBarChart();
	    chartFxPanel.setScene(new Scene(chart));
	}
	
	/** Create a chart */
	private BarChart createBarChart() {
		
		
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);
		bc.setTitle("Heartbeat Summary"); //Title
		xAxis.setLabel("Week");	//xAxis label
		yAxis.setLabel("Beats per Minute (BPM)");	//yAxis label
		
		//Data Information
		int[][] data = dataGen.heart.sendRandomData();
		
		//Chart Series
		XYChart.Series series1 = new XYChart.Series();
		series1.setName("CURRENT MONTH");
		XYChart.Series series2 = new XYChart.Series();
		series2.setName("CURRENT WEEK NUMBER");
		XYChart.Series series3 = new XYChart.Series();
		series3.setName("CURRENT HOUR");
		
		//Deposit Data
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (i == 0) { // Month data
					series1.getData().add(new XYChart.Data("wEEk#" + (j + 1), data[i][j]));
				}
				if (i == 1) {// Week data
					series2.getData().add(new XYChart.Data("DAY#" + (j + 1), data[i][j]));
				}
				if (i == 2) {// day data
					series3.getData().add(new XYChart.Data("HOUR#" + (j + 1), data[i][j]));
				} // end if
			} // end for
		} // end for
		
		//Scene Settings
		bc.getData().addAll(series1, series2, series3);
//
//		Platform.runLater(new Runnable() {
//			public void run() {
//				XYChart.Series<String, Number> s = (XYChart.Series<String, Number>) chart.getData().get(row);
//				BarChart.Data data = s.getData().get(column);
//				data.setYValue(value);
//			}
//		}
	    return bc;
	  }

	/** Action Listener */
	/* Changing JavaFX Data in Response to a Change in Swing Data */
	public void actionPerformed(ActionEvent arg0) {
		// Create a new runnable method
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// The following changes the data in a FX thing
				// fxlabel.setText("Action performed");
			}
		});// end new runnable

	}// end action performed

	/* Changing Swing Data in Response to a Change in JavaFX Data */
	public void actionPrf() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Code to change Swing data.
			}
		});// end runnable
	}// end actionPrf

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
//	/**
//	 * /** JavaFX Panel */
//	public static JPanel chartFXPanel(JFrame F) {
//		// Now you can import Java FX 'applications'.
//		final JFXPanel fxPanel = new JFXPanel();
//
//		JPanel container = new JPanel();
//		container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
//
//		container.add(fxPanel); // add the JFXPanel to container
//		initFX(fxPanel);
//		
//		return container; // return the FXPanel
//	}
//
//	/** Init the FXPanel */
//	private static void initFX(JFXPanel fxPanel) {
//		// This method is invoked on the JavaFX thread
//		Scene scene = createScene();
//		fxPanel.setScene(scene);
//	}
//	
//	private static Scene createScene() {
//        Group  root  =  new  Group();
//        Scene  scene  =  new  Scene(root, Color.ALICEBLUE);
//        Text  text  =  new  Text();
//        
//        text.setX(40);
//        text.setY(100);
//        text.setFont(new Font(25));
//        text.setText("Welcome JavaFX!");
//
//        root.getChildren().add(text);
//
//        return (scene);
//    }*
//	 **/

}// end class
