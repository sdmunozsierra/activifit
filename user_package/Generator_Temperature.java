package user_package;
/*
	 * Temperature will be affected mainly on how active is the user, and
	 * depending on the time of the day, a normal person varies in temperature
	 * about 0.5 celsius, being lower on the mornings and higher on the
	 * afternoon. This feature can identify if the user has any anomalies in the
	 * temperature such as (hypothermia, fever or hyperthermia). Information can
	 * be represented in celsius or fahrenheit degrees.
	 * 
	 */

public class Generator_Temperature extends Generator {
	

	private final int DAY_START = 0; // in hours
	private final int DAY_END = 24; // in hours

	private double currentTemperature;

	/* Constructor */
	public Generator_Temperature(User user) {
		super(user);
		// TODO Auto-generated constructor stub
	}

}// end class
