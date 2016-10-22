package user_package;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import action_package.DataGenerator;
import gui_package.Screen;


public class JChart {
	
	static User tempUsr = new User("UsainBolt", 15, 165, 165, 5, "gay@hotmail.com");
	static Generator tempGen = new Generator(tempUsr);
	static DataGenerator dataGen = new DataGenerator(tempGen);
	
	public static void main(String args[]){
		//Test Charts, colors, and well everything
		
		JFrame F = new JFrame("Custom View");
		JPanel container = new JPanel();
		
		container.add(chartMonthHeart() );
		
		F.add(container, BorderLayout.CENTER);
		Screen.viewFrame(F);
		
		
		
	}//end main

	
	/** Create a Chart Panel Monthly View Heartbeat */
	public static JPanel chartMonthHeart(){
		//Create a category set
		//int[][] data = Screen.globalGen.heart.sendRandomData();
		//temporal user
		int[][] data = dataGen.heart.sendRandomData();
		
		DefaultCategoryDataset dcd = new DefaultCategoryDataset();
		
		//Plot the data into dcd
		for (int i = 1; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++)
				dcd.addValue(data[i][j], "Heartbeat @ Rest", "Week#"+j);
		}//end for
		//Create the jChart
		JFreeChart jchart = ChartFactory.createBarChart("Monthly View", "Weeks", "Beats Per Minute (BPM)", dcd, PlotOrientation.VERTICAL,true, true, false);
		
		jchart.setBackgroundPaint(Screen.white_clouds);
		//jchart.setBorderPaint(Screen.green_emerald);
		
		CategoryPlot plot = jchart.getCategoryPlot();
		
		plot.setOutlinePaint(Screen.green_emerald); //Marco del chart
		//plot.setRangeGridlinePaint(Screen.blue_belizehole); //Rayas horizontales
		//plot.setRangeMinorGridlinePaint(Screen.purple_amethyst);
		//plot.setBackgroundPaint(Screen.green_emerald);
		//plot.setDomainCrosshairPaint(Screen.blue_peterriver);
		
		ChartFrame chartF = new ChartFrame("Monthly View Heart", jchart, true);
		
		chartF.setVisible(true);
		// rx = 320; // horizontal resolution
		// public final static int ry = 568
		chartF.setSize(300,568/3);
		ChartPanel chartPanel = new ChartPanel(jchart);
		return chartPanel;
	}
	
}//end class