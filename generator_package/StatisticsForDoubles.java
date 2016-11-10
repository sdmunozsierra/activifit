package generator_package;

public abstract class StatisticsForDoubles {
	
	/* Returns an array with a day's worth of information */
	protected abstract double[] getDayStatistics();
	
	/* Returns an array with a week's worth of information */
	protected abstract double[] getWeekStatistics();
	
	/* Returns an array with a months' worth of information */
	protected abstract double[] getMonthlyStatistics();
	
	/* Returns the Random Data */
	protected abstract double[][] getRandomData();
	
	/* Returns the average of information */
	protected abstract double findAverage(double[] a);

}
