package generator_package;
/** Abstract Class that has the methods to be implemented
 * in each specialized generator to export the data.
 * @author JSSP Engineers
 * @version 1.0
 */
public abstract class StatisticsForIntegers {
	/** Returns an array with a day's worth of information 
	 * @return integer array with day's data.
	 * */
	protected abstract int[] getDayStatistics();
	/** Returns an array with a week's worth of information 
	 * @return integer array with week's data. 
	 * */
	protected abstract int[] getWeekStatistics();
	/** Returns an array with a months' worth of information 
	 * @return integer array with month's data. 
	 * */
	protected abstract int[] getMonthlyStatistics();
	/** Returns the Random Data 
	 * @return integer 2D array with generated data. 
	 * */
	public abstract int[][] getRandomData();
	/** Returns the average of an integer array
	 * @param int[] array.
	 * @return average value of the array.
	 * */
	protected abstract int findAverage(int[] array);

}
