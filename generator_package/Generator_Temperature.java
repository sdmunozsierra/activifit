package generator_package;
/*
	 * Temperature will be affected mainly on how active is the user, and
	 * depending on the time of the day, a normal person varies in temperature
	 * about 0.5 celsius, being lower on the mornings and higher on the
	 * afternoon. This feature can identify if the user has any anomalies in the
	 * temperature such as (hypothermia, fever or hyperthermia). Information can
	 * be represented in celsius or fahrenheit degrees.
	 * 
	 */

import java.util.concurrent.ThreadLocalRandom;

import user_package.User;

public class Generator_Temperature extends StatisticsForDoubles{

	private final int DAY_START = 0; // in hours
	private final int DAY_END = 24; // in hours
	
	//Temperature States 
	private final double HYPOTHERMIA = 35; //<35.0 °C
	private final double NORMAL = 36.5; //36.5–37.5 °C
	private final double FEVER = 37.5; //37.5 or 38.3 °C
	private final double HYPERPYREXIA =  38.3; // <38.3 °C
	
	//User Variables
	User user;
	private static double currentTemperature;
	
	/* Constructor */
	public Generator_Temperature(User usr) {
		this.user = usr;
		
	}

	/* Returns the current temperature according to the time of the day 
	 * This method is for a normal temperature, change to do more complex
	 * stuff like, change according to the activity index*/
	public double getCurrentTemperature(int currentTime){
		//First get the variation according to time
		double var = getVariation(currentTime);
		currentTemperature = NORMAL + var;
		return currentTemperature;
	}
	
	/* Returns the condition of the current temperature
	 * @Param in celcius degrees */
	public String getTempStatus(double celcius){
		if(celcius<= HYPOTHERMIA) 
			return "Hypothermia"; //<35.0 °C
		else if(celcius> HYPOTHERMIA && celcius < NORMAL)
			return "Normal Cold";  //35.1- 36.4 °C
		else if(celcius >= NORMAL && celcius < FEVER)
			return "Normal"; //36.5–37.5 °C
		else if(celcius >= FEVER && celcius < HYPERPYREXIA)
			return "Fever"; //37.5 or 38.3 °C
		else
			return "Hyperpyrexia"; // <38.3 °C
	}
	
	/* Returns Day and Night temperature variations 
	 * @Param time in military time*/
	private double getVariation(int time){
		if(time>5 && time <23) //Day-Variation 0.5 °C
			return ThreadLocalRandom.current().nextDouble(0, 0.5);
		else //Night-Variation -1 °C
			return ThreadLocalRandom.current().nextDouble(-1, 0);
	}
	
	/* Print detail information about today's temperature */
	public void printDetailTemperature(){
		System.out.println("Today's Detail Activity Log ");
		System.out.println("Time|Temperature|Status");
		System.out.println("-----------------------");
		for (int i = 0; i <= DAY_END-DAY_START; i++) {
			int t = DAY_START+i;
			double temp = (double) getCurrentTemperature(t);
			String s = getTempStatus(temp);
			if (t < 10)
				System.out.printf("0%dam|    %.3f°C|%s\n", (t), temp, s);
			else if (t < 12)
				System.out.printf("%dam|     %.3f°C|%s\n", (t), temp, s);
			else
				System.out.printf("%dpm|     %.3f°C|%s\n", (t), temp, s);
		}
		System.out.println("-----------------------");
		System.out.println("End of temperature report");
	}
	
	/* See how 'random' random really is */
	public void testRandomness(){
		int i = 0;
		while(i<20){
			System.out.println("DAY: "+getVariation(10));
			System.out.println("NIGHT: "+getVariation(0));
			i++;
		}
		
	}

	protected double[] getDayStatistics() {
		double [] dayArray = new double[24]; //24 hours
		for (int i = 0; i < dayArray.length; i++)
			dayArray[i] = getCurrentTemperature(i);
		return dayArray;
	}
	
	/* Returns an array with a day's worth of information */
	protected double[] getWeekStatistics(){
		double [] a = new double[7]; //7 days
		for (int i = 0; i < a.length; i++) 
			a[i] = findAverage(getDayStatistics()); 
		return a;
	}

	/* Returns an array with a week's worth of information */
	protected double[] getMonthlyStatistics() {
		double [] a = new double[4]; //4 weeks
		for (int i = 0; i < a.length; i++) 
			a[i] = findAverage(getWeekStatistics());
		return a;
		
	}

	/* Returns an array with a months' worth of information */
	protected double findAverage(double[] arr) {
		double avg = 0;
		for (int i = 0; i < arr.length; i++) {
			avg += arr[i];
		}
		return avg/arr.length; 
	}

	/* Returns the Random Data */
	public double[][] getRandomData() {
		double[][] data = new double[3][];
		data[0] = new double[4]; //Monthly Data
		data[1] = new double[7]; //Weekly Data
		data[2] = new double[24]; //Daily Data
		double[] month = getMonthlyStatistics();
		double[] week = getWeekStatistics();
		double[] day = getDayStatistics();
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if(i == 0) //Month data
					data[i][j] = month[j];
				if(i == 1) //Week data
					data[i][j] = week[j];
				else //day data
					data[i][j] = day[j];
			}//end for
		}//end for
		return data;
	}

	
	/* Print the 2dArray [Debugging]*/
	public void print2d(int[][] data) {
		//int[][] data = sendRandomData();
		double[] month = getMonthlyStatistics();
		double[] week = getWeekStatistics();
		double[] day = getDayStatistics();

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.println("GLOBAL I AND J: i = "+(i)+" j = "+(j));
				if (i == 0){ // Month data
					System.out.println("Month Data");
					System.out.println("month J ->"+j)
					;data[i][j] = (int) month[j];
				}
				if (i == 1) {// Week data
					System.out.println("week Data");
					System.out.println("week J ->"+j);
					data[i][j] = (int) week[j];
				}
				if (i == 2){// day data
					System.out.println("day Data");
					System.out.println("day J ->"+j);
					data[i][j] = (int) day[j];
				}
			} // end for
		} // end for
	}
	
	/** Useful information that describes what the user is feeling at certain temperature */
	private void getSymptom(){
		/**
		 * 
		 *     HOT:
	44 °C (111.2 °F) or more – Almost certainly death will occur; however, people have been known to survive up to 46.5 °C (115.7 °F).
    43 °C (109.4 °F) – Normally death, or there may be serious brain damage, continuous convulsions and shock. Cardio-respiratory collapse will likely occur.
    42 °C (107.6 °F) – Subject may turn pale or remain flushed and red. They may become comatose, be in severe delirium, vomiting, and convulsions can occur. Blood pressure may be high or low and heart rate will be very fast.
    41 °C (105.8 °F) – (Medical emergency) – Fainting, vomiting, severe headache, dizziness, confusion, hallucinations, delirium and drowsiness can occur. There may also be palpitations and breathlessness.
    40 °C (104.0 °F) – Fainting, dehydration, weakness, vomiting, headache, breathlessness and dizziness may occur as well as profuse sweating. Starts to be life-threatening.
    39 °C (102.2 °F) – Severe sweating, flushed and red. Fast heart rate and breathlessness. There may be exhaustion accompanying this. Children and people with epilepsy may be very likely to get convulsions at this point.
    38 °C (100.4 °F) – (this is classed as hyperthermia if not caused by a fever) Feeling hot, sweating, feeling thirsty, feeling very uncomfortable, slightly hungry. If this is caused by fever, there may also be chills.
Normal

    37 °C (98.6 °F) – Normal internal body temperature (which varies between about 36.12–37.8 °C (97.02–100.04 °F))

Cold

    36 °C (97 °F) – Feeling cold, mild to moderate shivering (body temperature may drop this low during sleep). May be a normal body temperature.
    35 °C (95 °F) – (Hypothermia is less than 35 °C (95 °F)) – Intense shivering, numbness and bluish/grayness of the skin. There is the possibility of heart irritability.
    34 °C (93 °F) – Severe shivering, loss of movement of fingers, blueness and confusion. Some behavioural changes may take place.
    33 °C (91 °F) – Moderate to severe confusion, sleepiness, depressed reflexes, progressive loss of shivering, slow heart beat, shallow breathing. Shivering may stop. Subject may be unresponsive to certain stimuli.
    32 °C (90 °F) – (Medical emergency) Hallucinations, delirium, complete confusion, extreme sleepiness that is progressively becoming comatose. Shivering is absent (subject may even think they are hot). Reflex may be absent or very slight.
    31 °C (88 °F) – Comatose, very rarely conscious. No or slight reflexes. Very shallow breathing and slow heart rate. Possibility of serious heart rhythm problems.
    28 °C (82 °F) – Severe heart rhythm disturbances are likely and breathing may stop at any time. Patient may appear to be dead.
    24–26 °C (75–79 °F) or less – Death usually occurs due to irregular heart beat or respiratory arrest; however, some patients have been known to survive with body temperatures as low as 14.2 °C (57.6 °F).[17]
		 * 
		 * */
	}//End symptoms
	
}// end class
