package generator_package;
/** Abstract Class that has the methods to be implemented
 * in each specialized generator to export the data.
 * @author JSSP Engineers
 * @version 1.0
 */
public abstract class StatisticsForDoubles {
	
	/** Returns an array with a day's worth of information 
	 * @return double array with day's data.
	 * */
	protected abstract double[] getDayStatistics();
	/** Returns an array with a week's worth of information 
	 * @return double array with week's data.
	 * */
	protected abstract double[] getWeekStatistics();
	/** Returns an array with a months' worth of information 
	 * @return double array with month's data. 
	 * */
	protected abstract double[] getMonthlyStatistics();
	/** Returns the Random Data 
	 * @return double 2D array with generated data. 
	 * */
	protected abstract double[][] getRandomData();
	/** Returns the average of a double array 
	 * @param double[] array
	 * @return double average value.
	 * */
	protected abstract double findAverage(double[] array);
}//end class