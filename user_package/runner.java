package user_package;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import chart_package.StepChart;
import chart_package.HeartChart;

public class runner {

	public static void main(String[] args) {

		
		Generator gen = new Generator(new User("Henry", 24, 70, 164, 5, "henry@hotmail.com"));
		Generator gen1 = new Generator(new User("Monica", 36, 52, 152, 3, "monicaLeal@hotmail.com"));
		Generator gen2 = new Generator(new User("Usain", 30, 95, 195, 7, "usainbolt@hotmail.com"));
		
		gen.printGenerator();
		
		gen.user.printUser();
		Generator_Steps steps = new Generator_Steps(gen.getUser());
		//steps.printGeneratorInfo();
		//steps.printUser();
		steps.printDetailDistance();
		
		Generator_Steps steps1 = new Generator_Steps(gen1.getUser());
		Generator_Steps steps2 = new Generator_Steps(gen2.getUser());
		gen1.user.printUser();
		steps1.printDetailDistance();
		gen2.user.printUser();
		steps2.printDetailDistance();
		
		Generator_Heartbeat love = new Generator_Heartbeat(gen.getUser());
		
		/** Test Graphs down below */
		JFrame F = new JFrame("Logout");
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		JPanel graph = new JPanel();
		//graph = heartChart.drawChart(4, love); //Test HeartChart with local data
		graph = StepChart.drawChart(4, steps1); //Test Steps chart
		container.add(graph);
		
		F.add(container, BorderLayout.CENTER);
		//F.setSize(rx, ry);
		F.setVisible(true);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//end main

}//end class
