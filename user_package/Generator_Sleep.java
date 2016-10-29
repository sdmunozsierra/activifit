package user_package;

import java.util.concurrent.ThreadLocalRandom;

public class Generator_Sleep extends StatisticsForIntegers {

	// Local variables
	private static User user;
	// Import Global Database
	//private static UserDatabase localDatabase = Screen.globalDatabase;

	public static void main(String args[]) {
		
		
	}// main method

	// Constructor
	public Generator_Sleep(User usr) {
		this.user = usr;
	}

	/* Get random sleep depending on the active id */
	private int getRandomCurrentSleep() {
		// HECHALE MAS MATES
		
		return ThreadLocalRandom.current().nextInt();
	}

	@Override
	protected int[] getDayStatistics() {
		int[] array = new int[24]; // 24 hours
		for (int i = 0; i < array.length; i++) {
			array[i] = getRandomCurrentSleep();
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

	@Override
	public int[][] getRandomData() {
		int[][] data = new int[3][];
		data[0] = new int[4]; // Monthly Data
		data[1] = new int[7]; // Weekly Data
		data[2] = new int[24]; // Daily Data
		int[] month = getMonthlyStatistics();
		int[] week = getWeekStatistics();
		int[] day = getDayStatistics();

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (i == 0) // Month data
					data[i][j] = month[j];
				if (i == 1) // Week data
					data[i][j] = week[j];
				else // day data
					data[i][j] = day[j];
			} // end for
		} // end for
		return data;
	}

	@Override
	protected int findAverage(int[] a) {
		int avg = 0;
		for (int i = 0; i < a.length; i++) {
			avg += a[i];
		}
		return avg/a.length; 
	}
	
	/* Print the 2dArray [Debugging]*/
	public void print2d(int[][] data) {
		//int[][] data = sendRandomData();
		int[] month = getMonthlyStatistics();
		int[] week = getWeekStatistics();
		int[] day = getDayStatistics();

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.println("GLOBAL I AND J: i = "+(i)+" j = "+(j));
				if (i == 0){ // Month data
					System.out.println("Month Data");
					System.out.println("month J ->"+j)
					;data[i][j] = month[j];
				}
				if (i == 1) {// Week data
					System.out.println("week Data");
					System.out.println("week J ->"+j);
					data[i][j] = week[j];
				}
				if (i == 2){// day data
					System.out.println("day Data");
					System.out.println("day J ->"+j);
					data[i][j] = day[j];
				}
			} // end for
		} // end for
	}
	
	/* Print detail information about today's temperature */
	public void printDetailSleep(){
		System.out.println("Today's Detail Activity Log ");
		System.out.println("Time|Sleep|Status");
		System.out.println("---------------------");
		
		System.out.println("-----------------------");
		System.out.println("End of Heartbeat report");
	}
	
	

}// end class
