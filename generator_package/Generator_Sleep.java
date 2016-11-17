package generator_package;

import java.util.concurrent.ThreadLocalRandom;

import user_package.User;

/**
 * Sleep will give random results that are not linked to any other generator
 * For example steps and temperature will assume the user sleeps everyday at
 * a certain time for the same amount of time each day
 * @author JSSP Engineers
 * @version 1.0
 *
 */
public class Generator_Sleep extends StatisticsForIntegers{
	/*
	 * Sleep quality measurements are not standardized because there is not a
	 * “correct” way in how to measure it, therefore in this project we will
	 * measure sleep quality with three key states: REM, light and deep sleep.
	 * Monitoring the heart rate and body temperature, the product will be able
	 * to determinate in which state the user is. An algorithm will determine
	 * the quality.
	 */
	//Constants
	private final int NIGHT_START = 22; //in hours

	//Phases Variables
	private int totalSleep; 	// in minutes
	private int lightSleep;		//N1 – Somnolence, drowsy sleep (5–10% of total sleep in adults)
	private int normalSleep; 	//N2 - (45–55% of total sleep in adults)
	private int totalREM; 		// REM - Rapid Eye Movement (20 - 25% of total sleep)
	private int deepSleep; 		//N3 - deep sleep, slow-wave sleep (15–25% of total sleep in adults)
	private double totalCycles; // 90 Minutes each;
	
	
	// Local variables
	private static User user;
	
	/**
	 * Constructor 
	 * @param usr passes the user to set at the generator
	 */
	public Generator_Sleep(User usr) {
		this.user = usr;
		setSleepPercents();
		setSleepTime();
	}
	
	/**
	 * Get random total sleep time
	 * @return int number of total sleep time
	 */
	private int getSleepTime(){
		//TODO use activity index as a variation
		//American gets 6.8 Hours or 408 minutes||540 = 9 hours
		int variation = ThreadLocalRandom.current().nextInt(408, 541);
		return this.totalSleep = variation;
	}
	
	/**
	 * NREM Stage 1 - Light sleep
	 * @return int percent of light sleep (stage 1)
	 */
	private int getN1Percent(){
		//From 5 to 10% of a night sleep
		int variation = ThreadLocalRandom.current().nextInt(5, 11);
		
		return variation;
	}

	/** 
	 * NREM Stage 2 - Normal Sleep 
	 * @return int percent of sleep for stage 2
	 */
	private int getN2Percent() {
		// From 45 to 55% of a night sleep
		int variation = ThreadLocalRandom.current().nextInt(45, 56);
		
		return variation;
	}
	
	/** 
	 * NREM Stage 3 - l Deep Sleep 
	 * @return int percent of sleep of stage 3
	 */
	private int getN3Percent() {
		// From 15 to 25% of a night sleep
		int variation = ThreadLocalRandom.current().nextInt(15, 26);
		
		return variation;
	}
	
	/** 
	 * Sets how much time the user will spend on each phase 
	 */
	private void setSleepPercents(){
		getSleepTime(); //Set the value to total Sleep
		this.lightSleep = getN1Percent();
		this.normalSleep = getN2Percent();
		this.deepSleep = getN3Percent();
		
		this.totalREM = 100 - (lightSleep + normalSleep + deepSleep);
		//Debugging purposes//
		 System.out.println("Sleep Percents:\nLight: "+lightSleep+"%"+
				"\nNormal: "+normalSleep+"%"+
				"\nDeep: "+deepSleep+"%"+
				"\nREM: "+totalREM+"%");
		
	}//end setSleepPercents
	
	/** 
	 * Set Random Sleep Time to each phase in minutes
	 */
	private void setSleepTime(){
		//Sets the time to each phase on minutes
		this.lightSleep = (this.totalSleep*this.lightSleep)/100;
		this.normalSleep = (this.totalSleep*this.normalSleep)/100;
		this.deepSleep = (this.totalSleep*this.deepSleep)/100;
		this.totalREM = (this.totalSleep*this.totalREM)/100;
		
		this.totalCycles = this.totalSleep/90;
		//Debugging purposes//
		 System.out.println("Sleep Time:\nLight: "+lightSleep+" mins"+
				"\nNormal: "+normalSleep+" mins"+
				"\nDeep: "+deepSleep+" mins"+
				"\nREM: "+totalREM+" mins"+
				"\nTOTAL: "+totalSleep+" mins"+
				"\nSleepCycles: "+totalCycles+" cycles");
		
	}
	
	/** Getters **/
	
	 /**
	 * Gets the total number of sleep
	 * @return int number of hours 
	 */
	public int getTotalSleep() {
		return totalSleep;
	}

	/**
	 * Gets total number of hours in REM
	 * @return int number of hours in REM
	 */
	public int getTotalREM() {
		return totalREM;
	}

	/**
	 * Gets total number of hours in light sleep
	 * @return int number of hours in light sleep
	 */
	public int getLightSleep() {
		return lightSleep;
	}

	/**
	 * Gets total number of hours in normal sleep
	 * @return int number of hours in normal sleep
	 */
	public int getNormalSleep() {
		return normalSleep;
	}

	/**
	 * Gets total number of hours in deep sleep
	 * @return int number of hours in deep sleep
	 */
	public int getDeepSleep() {
		return deepSleep;
	}

	/**
	 * Gets total number of cycles
	 * @return int total number of cycles
	 */
	public double getTotalCycles() {
		return totalCycles;
	}

	/**
	 * TODO Get random sleep depending on the time
	 * @param time the time of the day
	 * @return int random current sleeping
	 */
	private int getRandomCurrentSleep(int time) {
		//@param time in military time
		//NIGHT TIME: FROM 22PM TO END OF totalSleep
		if(time - NIGHT_START <= 0){
			return 0;
		}
		int[] sleepStats = new int[4];
		//sleepStats[1] = totalSleep
		return ThreadLocalRandom.current().nextInt();
	}
	
	/** <!-- Required for charts --> */
	
	/**
	 * Returns an array with a day's worth of information
	 * @return int[] an array of day's worth information
	 */
	protected int[] getDayStatistics() {
		int[] array = new int[24]; // 24 hours
		for (int i = 0; i < array.length; i++) {
			array[i] = getRandomCurrentSleep(i);
		}
		return array;
	}
	
	/**
	 * Returns and array with a week's worth of information that
	 * calls the day stats method
	 * @return int[] an array with a week's worth of info
	 */
	@Override
	protected int[] getWeekStatistics() {
		int[] array = new int[7]; // 7 days (boooo scaryyyy)
		for (int i = 0; i < array.length; i++) {
			array[i] = findAverage(getDayStatistics());
		}
		return array;
	}

	/**
	 * Returns an array with a month's worth of information that calls 
	 * the week method
	 * @return int[] an array with a month's worth of information
	 */
	@Override
	protected int[] getMonthlyStatistics() {
		int[] array = new int[4]; // 4 weeks
		for (int i = 0; i < array.length; i++) {
			array[i] = findAverage(getWeekStatistics());
		}
		return array;
	}

	/**
	 * Returns the random sleep times influenced by active ID
	 * @return int[][] integer array with different heart beats at rest
	 */
	@Override
	public int[][] getRandomData() {
		int[][] data = new int[1][0];
		data[0] = new int[4]; //Sleep Data for a Day
		//Hard-code the sleep values
		data[0][0] = lightSleep; 	//1
		data[0][1] = normalSleep;	//2
		data[0][2] = deepSleep; 	//3
		data[0][3] = totalREM; 		//4
		
		return data;
		
	}

	/**
	 * Returns the average of information
	 * @param intArray passes array of integers with sleep times
	 * @return int average of the integer array of sleep times
	 */
	@Override
	protected int findAverage(int[] a) {
		int avg = 0;
		for (int i = 0; i < a.length; i++) {
			avg += a[i];
		}
		return avg / a.length;
	}

	
	/** <!-- Debugging Purposes --> */

	/**
	 * prints the 2D array 
	 * (DEBBUGGING)
	 * @param data passed heart rates to print
	 */
	public void print2d(int[][] data) {
		//int[][] data = getRandomData();
//		int[] month = getMonthlyStatistics();
//		int[] week = getWeekStatistics();
//		int[] day = getDayStatistics();
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.println("GLOBAL I AND J: i = " + (i) + " j = " + (j));
				if (j == 0) {
					System.out.println("Light Sleep: " + data[i][j] + " mins");
				} // end if
				else if (j == 1) {
					System.out.println("Normal Sleep: " + data[i][j]+ " mins");
				} // end if
				else if (j == 2) {
					System.out.println("Deep: " + data[i][j] + " mins");
				} // end if
				else{
					System.out.println("REM: " + data[i][j] + " mins");
				}
			}//end 1st for
		} // end for
	}//end method

	/**
	 * Print details information about today's sleep times
	 */
	public void printDetailSleep() {
		System.out.println("Today's Detail Activity Log ");
		System.out.println("Time|Sleep|Status");
		System.out.println("---------------------");

		System.out.println("-----------------------");
		System.out.println("End of Sleep report");
	}

//	@Override
//	public int[][] getRandomData() {
//		int[][] data = new int[3][];
//		data[0] = new int[4]; // Monthly Data
//		data[1] = new int[7]; // Weekly Data
//		data[2] = new int[24]; // Daily Data
//		int[] month = getMonthlyStatistics();
//		int[] week = getWeekStatistics();
//		int[] day = getDayStatistics();
//
//		for (int i = 0; i < data.length; i++) {
//			for (int j = 0; j < data[i].length; j++) {
//				if (i == 0) // Month data
//					data[i][j] = month[j];
//				if (i == 1) // Week data
//					data[i][j] = week[j];
//				else // day data
//					data[i][j] = day[j];
//			} // end for
//		} // end for
//		return data;
//	}
	
}// end class
