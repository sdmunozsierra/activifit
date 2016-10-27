package gui_package;

import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import action_package.DataGenerator;
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
	//COLORS 
	public static String green_emerland ="#2ecc71";
	public static String yellow_sunflower = "#f1c40f";
	public static String red_alizarin =  "#e74c3c";
	public static String red_pomegranate = "#c0392b";
	public static String red_900 = "#b71c1c";
	public static String orange_carrot = "#e67e22";
	public static String blue_peterriver = "#3498db";
	
	
	// Main method
	// Must figure out how to send that to another class
	// OPT 1: Make another runnable()
	public static void main(String[] args) {
	
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                personalGUI();
            }
        });
		
	}//end main
		
		 
	/** Returns a JPanel to be used anywhere <3 */
	public static JPanel heartChart(){
		//Create a FXPanel
		final JFXPanel fxPanel = new JFXPanel();
		
		//Panel Create panel
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(fxPanel);
		
		// Run latter
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// initFX(fxPanel);
				initFXHeart(fxPanel, 3);
			}
		});
		return panel;
	}
	
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
		scene.getStylesheets().add(Chart.class.getResource("heartChart.css").toExternalForm());
		
		return (scene);
		
	}
	
	/** Create a Heart Chart */
	@SuppressWarnings("rawtypes")
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
		
		// Chart Labels
		
		String[] label = {"DAY ","WEEK ","HOUR - "};
		
		// Chart Series
		XYChart.Series series1 = new XYChart.Series();
		XYChart.Series series2 = new XYChart.Series();
		XYChart.Series series3 = new XYChart.Series();
		
		// Deposit Data
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				
				//Add different colors to the data
				final XYChart.Data<String, Number> value = new XYChart.Data(label[i] + j , data[i][j]);
				value.nodeProperty().addListener(new ChangeListener<Node>() {
				  @Override public void changed(ObservableValue<? extends Node> ov, Node oldNode, Node newNode) {
				    if (newNode != null) {
				      if (value.getYValue().intValue() > 100 )  //Tachycardia
				        newNode.setStyle("-fx-bar-fill: " +red_alizarin+";");
				      else if (value.getYValue().intValue() > 90 ) //Above average
					        newNode.setStyle("-fx-bar-fill: " +green_emerland+";");
				      else if (value.getYValue().intValue() > 60 ) //Average
					        newNode.setStyle("-fx-bar-fill: " +yellow_sunflower+";");
				      else if (value.getYValue().intValue() > 0 ) { //Bradychardia
				        newNode.setStyle("-fx-bar-fill: " +blue_peterriver+";");
				      }  
				    }//end if
				  }//end changed
				});//end add listener
				
				//Select which data to use
				if (i == 0){  // Month data
					series1.getData().add(new XYChart.Data("WEEK#" + (j + 1), data[i][j]));
				}
				if (i == 1) // Week data
					series2.getData().add(new XYChart.Data("DAY#" + (j + 1), data[i][j]));
				if (i == 2){ // day data
					series3.getData().add(value);
				}
			} // end for
		} // end for

		// Add correct elements to chart
		if (opt == 1) bc.getData().addAll(series1);
		else if (opt == 2)bc.getData().addAll(series2);
		else if (opt == 3)bc.getData().addAll(series3);
		else if (opt == 4)bc.getData().addAll(series1, series2, series3);
		else throw new Error("");
		// Add Style
		bc.setLegendVisible(false);
		bc.setVerticalGridLinesVisible(false);
		bc.setBarGap(0.5);
		bc.setCategoryGap(0);
		
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
