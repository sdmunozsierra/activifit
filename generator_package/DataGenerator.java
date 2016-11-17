package generator_package;

import user_package.User;
/**
 * Class calls generators from {@link #generator.package} and creates the
 * data for the current user.
 * @author JSSP Engineers
 * @version 1.0
 *
 */
public class DataGenerator {
	// Private variables
	private Generator gen; //Generator must kept as private for sensitive data
	// Individual Generators are public
	public Generator_Steps steps;
	public Generator_Temperature temp;
	public Generator_Heartbeat heart;
	public Generator_Sleep sleep;
	
	/**
	 * Constructor
	 * @param g is passed through to set all the user information and then calls {@link #createData()}
	 */
	public DataGenerator(Generator g){
		//Takes a generator as a parameter
		this.gen = new Generator(new User(g.getUser().getName(),
				g.getUser().getAge(),g.getUser().getWeight(),g.getUser().getHeight(),
				g.getUser().getActId(), g.getUser().getEmail()));
		createData(); //Generate Generators 
	}

	/**
	 * Calls all the generators for steps, temperature, heart, and sleep 
	 * to create the data for the current generator g.
	 */
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

	/**
	 * Method prints all of the user's data on the console.
	 */
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
	
	/**
	 * Method helps format the printing in {@link #printAllDetails()} 
	 * for nicer view on console.
	 * @param numberOfDashes passes the number of dashes that need to be printed on the console.
	 */
	public void formatLine(int numberOfDashes){
		for (int i = 0; i < numberOfDashes ; i++) {
			System.out.print("-");
		}
		System.out.print("\n");
	}
	
	
	
}//end class
