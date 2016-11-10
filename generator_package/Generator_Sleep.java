package generator_package;

import java.util.concurrent.ThreadLocalRandom;

import user_package.User;

//Sleep will give random results that are not linked to any other generator.
//For example steps and temperature will assume the user sleeps everyday
//at a certain time for the same amount of time each day.
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
	

	public Generator_Sleep(User usr) {
		this.user = usr;
		setSleepPercents();
		setSleepTime();
	}
	
	/** Get Random Total Sleep Time */
	private int getSleepTime(){
		//TODO use activity index as a variation
		//American gets 6.8 Hours or 408 minutes||540 = 9 hours
		int variation = ThreadLocalRandom.current().nextInt(408, 541);
		return this.totalSleep = variation;
	}
	
	/** NREM Stage 1 - Light Sleep */
	private int getN1Percent(){
		//From 5 to 10% of a night sleep
		int variation = ThreadLocalRandom.current().nextInt(5, 11);
		
		return variation;
	}

	/** NREM Stage 2 - Normal Sleep */
	private int getN2Percent() {
		// From 45 to 55% of a night sleep
		int variation = ThreadLocalRandom.current().nextInt(45, 56);
		
		return variation;
	}
	
	/** NREM Stage 3 - l Deep Sleep */
	private int getN3Percent() {
		// From 15 to 25% of a night sleep
		int variation = ThreadLocalRandom.current().nextInt(15, 26);
		
		return variation;
	}
	
	/** Sets how much time the user will spend on each phase */
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
	
	/** Set Random Sleep Time to each phase in minutes */
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
	
	
	/** Getters */
	public int getTotalSleep() {
		return totalSleep;
	}

	public int getTotalREM() {
		return totalREM;
	}

	public int getLightSleep() {
		return lightSleep;
	}

	public int getNormalSleep() {
		return normalSleep;
	}

	public int getDeepSleep() {
		return deepSleep;
	}

	public double getTotalCycles() {
		return totalCycles;
	}

	/* TODO Get random sleep depending on the time */
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
	/* Returns an array with a day's worth of information */
	protected int[] getDayStatistics() {
		int[] array = new int[24]; // 24 hours
		for (int i = 0; i < array.length; i++) {
			array[i] = getRandomCurrentSleep(i);
		}
		return array;
	}
	

	@Override
	protected int[] getWeekStatistics() {
		int[] array = new int[7]; // 7 days (boooo scaryyyy)
		for (int i = 0; i < array.length; i++) {
			array[i] = findAverage(getDayStatistics());
		}
		return array;
	}

	@Override
	protected int[] getMonthlyStatistics() {
		int[] array = new int[4]; // 4 weeks
		for (int i = 0; i < array.length; i++) {
			array[i] = findAverage(getWeekStatistics());
		}
		return array;
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

	@Override
	protected int findAverage(int[] a) {
		int avg = 0;
		for (int i = 0; i < a.length; i++) {
			avg += a[i];
		}
		return avg / a.length;
	}

	
	/** <!-- Debugging Purposes --> */
	/* Print the 2dArray [Debugging] */
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

	/* Print detail information about today's sleep */
	public void printDetailSleep() {
		System.out.println("Today's Detail Activity Log ");
		System.out.println("Time|Sleep|Status");
		System.out.println("---------------------");

		System.out.println("-----------------------");
		System.out.println("End of Sleep report");
	}

	
	

}// end class
