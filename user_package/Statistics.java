package user_package;

public interface Statistics {
	
	/** Integers */
	/* Returns an array with a day's worth of information */
	abstract int[] getDayStatisticsInt();
	
	/* Returns an array with a week's worth of information */
	abstract int[] getWeekStatisticsInt();
	
	/* Returns an array with a months' worth of information */
	abstract double[] getMonthlyStatisticsInt();
	
	/* Returns the average of information */
	abstract int findAverageInt(int[] a);
	
	
	/** Doubles */
	/* Returns an array with a day's worth of information */
	abstract double[] getDayStatisticsDouble();
	
	/* Returns an array with a week's worth of information */
	abstract double[] getWeekStatisticsDouble();
	
	/* Returns an array with a months' worth of information */
	abstract double[] getMonthlyStatisticsDouble();
	
	/* Returns the average of information */
	abstract double findAverageDouble(double[] a);
	
	
	/** Send Data */
	/* Returns the Random data */
	abstract public int[][] sendRandomDataInt();
	
	/* Returns the Random data */
	abstract public double[][] sendRandomDataDouble();
	
	
	
	
	
}
