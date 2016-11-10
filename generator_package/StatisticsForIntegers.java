package generator_package;

public abstract class StatisticsForIntegers {
	
	/* Returns an array with a day's worth of information */
	protected abstract int[] getDayStatistics();
	
	/* Returns an array with a week's worth of information */
	protected abstract int[] getWeekStatistics();
	
	/* Returns an array with a months' worth of information */
	protected abstract int[] getMonthlyStatistics();
	
	/* Returns the Random Data */
	public abstract int[][] getRandomData();
	
	/* Returns the average of information */
	protected abstract int findAverage(int[] a);

}
