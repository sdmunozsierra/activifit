package user_package;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public class Generator_Steps extends Generator {

	//Constants
	private final int AMERICAN_STEPS_AVG = 5900; 	//in steps
	private final int DAY_START = 6; //in hours
	private final int DAY_END = 24; //in hours
	
	private double currentSteps;
	
	//Metric Variables
	private int stride; 		//in centimeters
	private int stepsPerKm;		//in steps
	private int dailyDistance;  //in kilometers
	private double pace;		//kilometer/hrs
	private int totalSteps; 	//in steps

	//Constructor
	public Generator_Steps(User user) {
		//The following are order sensitive -Do not change-
		super(user); //Pull user info
		this.stride = strideLength();
		this.stepsPerKm = (1000*100)/this.stride; //1km in cm = 1000m * 100cm
		this.dailyDistance = getDailyDistance();
		this.pace = (double) this.dailyDistance / (DAY_END-DAY_START); 
		this.totalSteps = this.stepsPerKm*this.dailyDistance;
	}

	/*
	 * Catrine Tudor-Locke, director of the Walking Behavior Laboratory at
	 * Pennington Biomedical Research Center. Last year, she told Live Science
	 * that your typical American takes about 5,900 steps a day.
	 * 
	 * 1km in steps avg 1450.
	 */
	
	/** Methods */
	
	/* Get Stride Length using Height */
	private int strideLength(){
		/*
		 * While this is not as accurate as some other methods, it can give you
		 * a close estimate of your stride length. In centimeters.
		 * For women multiply 0.413 by height. 
		 * Men  multiply 0.415 by their height.
		 */
		//Right now we don't have a genre distinction so we will use 0.0414
		//for the calculation which is in between male and female
		return (int) (this.user.getHeight() * 0.414);
	}
	
	/* Return daily distance according to the Active Id and some randomness */
	private int getDailyDistance(){
		//Mainly as a wrapper
		return ThreadLocalRandom.current().nextInt(getMinDistance(), getMaxDistance() + 1);
	}
	
	/* Returns max distance in km*/
	private int getMaxDistance(){
		switch (super.user.getActId()){
		case 9:
			return 42; 	//Marathon
		case 8: 
			return 32; 	//Training for marathon
		case 7: 
			return 21; 	//Half-Marathon
		case 6: 
			return 20; 	//Training for half-marathon
		case 5: 
			return 12; 	//High Training
		case 4: 
			return 8; 	//Regular Training
		case 3: 
			return 5; 	//Healthy Limit
		case 2: 
			return 3; 	//Risk Warning
		case 1: 
			return 3; 	//Sedentary
		}//end switch
		return -1; //default = error
	}//end getMaxDistance
	
	/* Returns min distance in km*/
	private int getMinDistance(){
		switch (super.user.getActId()){
		case 9:
			return 20; 	//Marathon
		case 8: 
			return 18; 	//Training for marathon
		case 7: 
			return 12; 	//Half-Marathon
		case 6: 
			return 12; 	//Training for half-marathon
		case 5: 
			return 8; 	//High Training
		case 4: 
			return 5; 	//Regular Training
		case 3: 
			return 3; 	//Healthy Limit
		case 2: 
			return 1; 	//Risk Warning
		case 1: 
			return 0; 	//Sedentary
		}//end switch
		return -1; //default = error
	}//end getMaxDistance
	
	/* Current Distance
	 * @param time -> not implemented yet
	 * Right now it only checks time per hour, no minutes allowed */
	private double getCurrentDistance(int currentTime){
		//@param time in military time ej: 22 hrs, 08 hrs
		//As right now the program will start the day at 06 and end at 24
		//TO-DO: check bounds for time (half implemented)
		//TO-DO: add minutes implementation
		int time = currentTime - DAY_START;
		if(time <= 0 ) return 0;
		else{
			return pace * time; 
		}
	}

	/* Returns the number of steps at the time */ 
	private double getCurrentSteps(double currDist){
		this.currentSteps = (double) currDist*this.stepsPerKm;
		return this.currentSteps;
	}
	
	
	/* Print Generator information */
	public void printGeneratorInfo(){
		DecimalFormat df = new DecimalFormat("#.##");
		double d = 0;
		
		System.out.println("STEPS GENERATOR GEEKY STATS\n");
		System.out.printf("User Height %dcm \n", super.user.getHeight());
		System.out.println("Stride Lenght: "+this.stride);
		System.out.println("Steps per Km: "+stepsPerKm);
		System.out.println("Activity Index: "+super.user.getActId());;
		System.out.println("DISTANCE STATS");
		System.out.println("---------------------------------------");
		System.out.printf("Random Daily Distance %dkm \n",this.dailyDistance);
		System.out.printf("DAY START: %d DAY END: %d \n",DAY_START, DAY_END);
		System.out.println("Pace: "+df.format(pace)+"km/h");
		
		d = getCurrentDistance(6);
		System.out.println("Distance at start of the day: "+df.format(d));
		System.out.println("Current steps: "+getCurrentSteps(d));
		d = getCurrentDistance(12);
		System.out.println("Distance at noon: "+df.format(getCurrentDistance(12)));
		System.out.println("Distance at 3 pm (midpoint): "+df.format(getCurrentDistance(15)));
		System.out.println("Distance at 8 pm: "+df.format(getCurrentDistance(20)));
		System.out.println("Distance at end of the day: "+df.format(getCurrentDistance(24)));
		System.out.println("Total Steps during the day: "+this.totalSteps);
	}

	public void printDetailDistance(){
		System.out.println("\nToday's Detail Activity Log ");
		System.out.println("TIME|Distance|Steps");
		System.out.println("-------------------");
		for (int i = 0; i <= DAY_END-DAY_START; i++) {
			int t = DAY_START+i;
			double d = (double) getCurrentDistance(t);
			if (t < 10)
				System.out.printf("0%dam| %.3fkm|%.0f\n", (t), d, getCurrentSteps(d));
			else if (t < 12)
				System.out.printf("%dam| %.3fkm|%.0f\n", (t), d, getCurrentSteps(d));
			else if (d >= 10)
				System.out.printf("%dpm|%.3fkm|%.0f\n", (t), d, getCurrentSteps(d));
			else
				System.out.printf("%dpm| %.3fkm|%.0f\n", (t), d, getCurrentSteps(d));
		}
		System.out.println("-------------------");
		System.out.println("Have a great day!");
	}
}
