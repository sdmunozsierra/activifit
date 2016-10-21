package action_package;

import user_package.Generator;
import user_package.Generator_Heartbeat;
import user_package.Generator_Steps;
import user_package.Generator_Temperature;
import user_package.User;

public class DataGenerator {
	//Private variables
	private Generator gen;
	private Generator_Steps steps;
	private Generator_Temperature temp;
	private Generator_Heartbeat heart;
	
	
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
		//TODO Missing
	}

	/* Prints ALL the details for the current user */
	public void printAllDetails(){
		//Prints the whole generated data
		String[] labels = {"HEARTBEAT GENERATOR","STEPS GENERATOR","TEMPERATURE GENERATOR"};
		
		System.out.println(""); //Force empty line
		formatLine(30);
		System.out.println("GENERATED DATA FOR: "+gen.getUser().getName());
		formatLine(30);
		for (int i = 0; i < labels.length; i++) {
			System.out.println(labels[i]);
			formatLine(30);
			if(i == 0) heart.printDetailHeartbeat();
			else if( i == 1) steps.printDetailDistance();
			else temp.printDetailTemperature();
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
