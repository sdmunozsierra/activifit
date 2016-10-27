package gui_package;

import java.awt.Dimension;
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
	//Screen resolutions
	public final static int rx = 320; // horizontal resolution
	public final static int ry = 568; // vertical resolution
	
	
	
	// Main method
	// Must figure out how to send that to another class
	// OPT 1: Make another runnable()
	// OPT 2: Take a picture and insert it lol
	public static void main(String[] args) {
	
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                personalGUI();
            }
        });
		
	}//end main
		
		 
	
	/** Add to GUI*/
	private static void personalGUI(){
		// This method is invoked on the EDT thread

		//Create a new JFrame!!! and JPanel
		JFrame F = new JFrame("Test");
		//Create a FXPanel
		final JFXPanel fxPanel = new JFXPanel();
		
		//Panel Create panel
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		panel.add(fxPanel);
		F.add(panel);
		F.setSize(rx, ry);
		F.setVisible(true);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Run latter 
		Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //initFX(fxPanel);
            	initFXHeart(fxPanel, 3);
            }
       });
		
		
	}
	

	/** Heartbeat Charts, Scenes, and Init */
	/** Create a Heart FX */
	private static void initFXHeart(JFXPanel fxPanel, int opt) {
        // This method is invoked on the JavaFX thread
        Scene scene = heartScene(opt);
        fxPanel.setScene(scene);
    }
	
	/** Create a Heart Scene */
	private static Scene heartScene(int opt){
		BarChart heartChart = BarChartHeart(opt);
		Scene scene = new Scene(heartChart);
		return (scene);
	}
	
	/** Create a Heart Chart */
	private static BarChart BarChartHeart(int opt) {
		/*	OPT =>
		 *  Use 1 for Only Month Chart
		 *  Use 2 for Only Week Chart
		 *  Use 3 for Only Day Chart
		 *  Use 4 for All Charts //Change resolution or drag screen (big chart)
		 */
		
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);
		bc.setTitle("Heartbeat Summary"); // Title
		xAxis.setLabel("Week"); // xAxis label
		yAxis.setLabel("Beats per Minute (BPM)"); // yAxis label

		// Data Information
		int[][] data = dataGen.heart.sendRandomData();

		// Chart Series
		XYChart.Series series1 = new XYChart.Series();
		series1.setName("CURRENT MONTH");
		XYChart.Series series2 = new XYChart.Series();
		series2.setName("CURRENT WEEK NUMBER");
		XYChart.Series series3 = new XYChart.Series();
		series3.setName("CURRENT HOUR");

		// Deposit Data
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (i == 0)  // Month data
					series1.getData().add(new XYChart.Data("WEEK#" + (j + 1), data[i][j]));
				if (i == 1) // Week data
					series2.getData().add(new XYChart.Data("DAY#" + (j + 1), data[i][j]));
				if (i == 2) // day data
					series3.getData().add(new XYChart.Data("HOUR#" + (j + 1), data[i][j]));
			} // end for
		} // end for

		// Add correct elements to chart
		if (opt == 1) bc.getData().addAll(series1);
		else if (opt == 2)bc.getData().addAll(series2);
		else if (opt == 3)bc.getData().addAll(series3);
		else if (opt == 4)bc.getData().addAll(series1, series2, series3);
		else throw new Error("");
		// Return chart
		return bc;
	}

	
	
	
	
	/****** In progress ******/
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
	
	/** Original Examples 
	 *  These 3 methods are required to use FX on Swing */
	/* Init and show GUI */
	 private static void ORIGINALinitAndShowGUI() {
	        // This method is invoked on the EDT thread
	        JFrame frame = new JFrame("Swing and JavaFX");
	        final JFXPanel fxPanel = new JFXPanel();
	        frame.add(fxPanel);
	        frame.setSize(300, 200);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        Platform.runLater(new Runnable() {
	            @Override
	            public void run() {
	                ORIGINALinitFX(fxPanel);
	            }
	       });
	    }
	/* InitFX*/
	 private static void ORIGINALinitFX(JFXPanel fxPanel) {
	        // This method is invoked on the JavaFX thread
	        Scene scene = ORIGINALcreateScene();
	        fxPanel.setScene(scene);
	    }
	/* Create a Scene */
	private static Scene ORIGINALcreateScene() {
        Group  root  =  new  Group();
        Scene  scene  =  new  Scene(root, Color.ALICEBLUE);
        Text  text  =  new  Text();
        
        text.setX(40);
        text.setY(100);
        text.setFont(new Font(25));
        text.setText("Welcome JavaFX!");

        root.getChildren().add(text);

        return (scene);
    }

}// end class
