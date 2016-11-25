package chart_package;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import gui_package.JComponentStyle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;

public class HomeChart {
	
	public static JPanel drawChart(){
		
		JPanel pieChart = jPanelChart();
		return pieChart;
	}

	/**
	 * This is the general initialization, scene, chart, and JPanel.
	 * It creates a General FX Panel
	 * @param fxPanel the panel being initialized
	 */
	private static void initFXPanel(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = initScene();
        fxPanel.setScene(scene);
    }
	
	/** Method creates a general scene.
	 * @return Scene with new chart/
	 */
	private static Scene initScene(){
		PieChart chart = createChart();
		Scene scene = new Scene(chart);
		//The following is the path to the CSS file
		String cssPath = HomeChart.class.getResource("pieChart.css").toExternalForm();
		//System.out.println(cssPath);
		scene.getStylesheets().add(cssPath);
		return (scene);	
	}
	
	/** Create a Pie Chart */
	public static PieChart createChart(){
		
		ObservableList<PieChart.Data> pieChartData = 
				FXCollections.observableArrayList(
						new PieChart.Data("Heart", 25),
						new PieChart.Data("Steps", 25),
						new PieChart.Data("Temp", 25),
						new PieChart.Data("Sleep", 25));
		final PieChart chart = new PieChart(pieChartData);
		//Any opts here
		chart.setLegendVisible(false);
		
		JComponentStyle.setCustomFonts();
		
		return chart;
	}
	
	/**
	 * Returns a JPanel to be used anywhere resembling a main method
	 */
	public static JPanel jPanelChart(){
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
				initFXPanel(fxPanel);
			}
		});
		return panel;
	}//end jPanelChart
}
