package chart_package;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/** This is the schematic to use to create a chart with any information */
public abstract class Charts extends Application{
	
	// COLORS
	public static String green_emerland = "#2ecc71";
	public static String yellow_sunflower = "#f1c40f";
	public static String red_alizarin = "#e74c3c";
	public static String red_pomegranate = "#c0392b";
	public static String red_900 = "#b71c1c";
	public static String orange_carrot = "#e67e22";
	public static String blue_peterriver = "#3498db";
		
	/** General Initialization, Scene, Chart and JPanel */
	/** Create a General FX Panel */
	/*** 2 ***/
	private static void initFXPanel(JFXPanel fxPanel, int opt, int[][] intData, double[][] doubleData, String title, 
			String aTitle, int[] intColor, double[] doubleColor) {
        // This method is invoked on the JavaFX thread
        Scene scene = initScene(opt, intData, doubleData, title, aTitle, intColor, doubleColor);
        fxPanel.setScene(scene);
    }
	
	/** Create a General Scene */
	/*** 3 ***/
	private static Scene initScene(int opt, int [][] i, double[][] d, String t, String aT, int[] ic, double[] dc){
		BarChart chart = createChart(opt, i, d, t, aT, ic, dc);
		Scene scene = new Scene(chart);
		//scene.getStylesheets().add(Chart.class.getResource("heartChart.css").toExternalForm());
		
		return (scene);
		
	}
	
	
	/** Create a General Chart Chart */
	/*** 4 ***/

	public static BarChart createChart(int opt, int[][] intData, double[][] doubleData, String title, String yAxis,
			int[] intColor, double[] doubleColor) {
		/*
		 * OPT => Use 1 for Only Month Chart Use 
		 * 2 for Only Week Chart Use 
		 * 3 for Only Day Chart Use 
		 * 4 for All Charts //Change resolution or drag screen (big chart)
		 */
		boolean isInt = intData != null;

		final CategoryAxis xA = new CategoryAxis();
		final NumberAxis yA = new NumberAxis();
		final BarChart<String, Number> bc = new BarChart<>(xA, yA);
		bc.setTitle(title); // Title
		yA.setLabel(yAxis); // yAxis label

		// Chart Labels

		String[] label = { "WEEK - ", "DAY - ", "HOUR - " };

		// Chart Series
		XYChart.Series series1 = new XYChart.Series(); // Month Data
		XYChart.Series series2 = new XYChart.Series(); // Week Data
		XYChart.Series series3 = new XYChart.Series(); // Day Data

		// Deposit Data
		// I bet there is a way to have this as a single for loop but right now
		// this will work...
		if (isInt) {
			// Use integer data for charts
			int[][] data = intData; // Parse the data
			int[] color = intColor;
			for (int i = 0; i < data.length; i++) { 
				/* Cycle through array, i = Time measure (days, weeks)*/
				for (int j = 0; j < data[i].length; j++) { 
					/* j = actual data(hours for days, days for weeks) */
					
					// Add different colors to the data
					final XYChart.Data<String, Number> value = new XYChart.Data(label[i] + j, data[i][j]);
					// new XYChart.Data ( NAME, DATA ITSELF -> STEPS, TEMP, IN NUMBERS )
					value.nodeProperty().addListener(new ChangeListener<Node>() {
						@Override
						public void changed(ObservableValue<? extends Node> ov, Node oldNode, Node newNode) {
							if (newNode != null) {
								if (value.getYValue().intValue() > color[3]) // Greatest Value
									newNode.setStyle("-fx-bar-fill: " + red_alizarin + ";");
								else if (value.getYValue().intValue() > color[2]) // Above
									newNode.setStyle("-fx-bar-fill: " + green_emerland + ";");
								else if (value.getYValue().intValue() > color[1]) // Average
									newNode.setStyle("-fx-bar-fill: " + yellow_sunflower + ";");
								else if (value.getYValue().intValue() > color[0]) { // Least Value
									newNode.setStyle("-fx-bar-fill: " + blue_peterriver + ";");
								}
							} // end if
						}// end changed
					});// end add listener

					// Select to which series send data
					if (i == 0) // Month data
						series1.getData().add(value);
					if (i == 1) // Week data
						series2.getData().add(value);
					if (i == 2) // day data
						series3.getData().add(value);
				} // end for
			} // end for
		} else {
			// Use double data for charts
			double[][] data = doubleData;
			double[] color = doubleColor;
			
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[i].length; j++) {

					// Add different colors to the data
					final XYChart.Data<String, Number> value = new XYChart.Data(label[i] + j, data[i][j]);
					value.nodeProperty().addListener(new ChangeListener<Node>() {
						@Override
						public void changed(ObservableValue<? extends Node> ov, Node oldNode, Node newNode) {
							if (newNode != null) {
								if (value.getYValue().doubleValue() > color[3]) // Greatest Value
									newNode.setStyle("-fx-bar-fill: " + red_alizarin + ";");
								else if (value.getYValue().doubleValue() > color[2]) // Above
									newNode.setStyle("-fx-bar-fill: " + green_emerland + ";");
								else if (value.getYValue().doubleValue() > color[1]) // Average
									newNode.setStyle("-fx-bar-fill: " + yellow_sunflower + ";");
								else if (value.getYValue().doubleValue() > color[0]) { // Least Value
									newNode.setStyle("-fx-bar-fill: " + blue_peterriver + ";");
								}
							} // end if
						}// end changed
					});// end add listener

					// Select to which series send data
					if (i == 0) // Month data
						series1.getData().add(value);
					if (i == 1) // Week data
						series2.getData().add(value);
					if (i == 2) // day data
						series3.getData().add(value);
				} // end for
			} // end for
		}//end else

		// Add correct series to chart
		if (opt == 1)
			bc.getData().addAll(series1); // month
		else if (opt == 2)
			bc.getData().addAll(series2); // week
		else if (opt == 3)
			bc.getData().addAll(series3); // day
		else if (opt == 4)
			bc.getData().addAll(series1, series2, series3); // all
		else
			throw new Error("");
		// Add Style
		bc.setLegendVisible(false);
		bc.setVerticalGridLinesVisible(false);
		bc.setBarGap(0.5);
		bc.setCategoryGap(0.7);

		return bc;
	}

	/** Returns a JPanel to be used anywhere <3 
	 *  This is like the main method .. .. .. .. */
	/*** 1 ***/
	public static JPanel jPanelChart(int opt, int[][] intData, double[][] doubleData, String title, 
			String yAxisTitle, int[] intColorParams, double[] doubleColorParams){
		/*	OPT =>
		 *  Use 1 for Only Month Chart
		 *  Use 2 for Only Week Chart
		 *  Use 3 for Only Day Chart
		 *  Use 4 for All Charts //Change resolution or drag screen (big chart)
		 */
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
				initFXPanel(fxPanel, opt, intData, doubleData, title, yAxisTitle, intColorParams, doubleColorParams);
			}
		});
		return panel;
	}//end jPanelChart

}// end class
