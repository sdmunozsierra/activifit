package action_package;

import generator_package.*;
import user_package.User;

public class DataGenerator {
	// Private variables
	private Generator gen; //Generator must kept as private for sensitive data
	// Individual Generators are public
	public Generator_Steps steps;
	public Generator_Temperature temp;
	public Generator_Heartbeat heart;
	public Generator_Sleep sleep;
	
	//Constructor 
	public DataGenerator(Generator g){
		//Takes a generator as a parameter
		this.gen = new Generator(new User(g.getUser().getName(),
				g.getUser().getAge(),g.getUser().getWeight(),g.getUser().getHeight(),
				g.getUser().getActId(), g.getUser().getEmail()));
		createData(); //Generate Generators lolololo
	}
	
	/* Call each generator */
	public void createData(){
		//Create a Steps Generator
		this.steps = new Generator_Steps(gen.getUser());
		//Temperature Generator
		this.temp = new Generator_Temperature(gen.getUser());
		//Heartbeat Generator
		this.heart = new Generator_Heartbeat(gen.getUser());
		//Sleep Quality Generator
		this.sleep = new Generator_Sleep(gen.getUser());
	}

	/* Prints ALL the details for the current user */
	public void printAllDetails(){
		//Prints the whole generated data
		String[] labels = {"HEARTBEAT GENERATOR","STEPS GENERATOR","TEMPERATURE GENERATOR","SLEEP GENERATOR"};
		
		System.out.println(""); //Force empty line
		formatLine(30);
		System.out.println("GENERATED DATA FOR: "+gen.getUser().getName());
		formatLine(30);
		for (int i = 0; i < labels.length; i++) {
			System.out.println(labels[i]);
			formatLine(30);
			if(i == 0) heart.printDetailHeartbeat();
			else if( i == 1) steps.printDetailDistance();
			else if (i == 2) temp.printDetailTemperature();
			else sleep.printDetailSleep();
			formatLine(30);
		}//end for
		System.out.println("END GENERATOR DATA");
		formatLine(30);
	}
	
	/* Format for a dashed line */
	public void formatLine(int numberOfDashes){
		for (int i = 0; i < numberOfDashes ; i++) {
			System.out.print("-");
		}
		System.out.print("\n");
	}
	
	
	
}//end class
