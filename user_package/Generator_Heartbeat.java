package user_package;


public class Generator_Heartbeat extends Generator {

	// Pseudo code

	// "Normal" and Healthy heart beat 50-90

	final int NormalMin = 50;
	
	private int maxHR;
	final int NormalMax = maxHR;
	
	
	private int age;
	private int actId;

	private int currentBPM; // Do getters
	
	//Constructor
	public Generator_Heartbeat(int age, int actId){
		this.age = age;
		this.actId = actId;
		this.maxHR = getHRmax(age);
	}

	/**
	 * Implement the following as a method:
	 * 
	 * For healthy people, the Target Heart Rate or Training Heart Rate (THR) is
	 * a desired range of heart rate reached during aerobic exercise which
	 * enables one's heart and lungs to receive the most benefit from a workout.
	 * This theoretical range varies based mostly on age; however, a person's
	 * physical condition, sex, and previous training also are used in the
	 * calculation. Below are two ways to calculate one's THR. In each of these
	 * methods, there is an element called "intensity" which is expressed as a
	 * percentage. The THR can be calculated as a range of 65–85% intensity.
	 * However, it is crucial to derive an accurate HRmax to ensure these
	 * calculations are meaningful.[citation needed]
	 * 
	 * Example for someone with a HRmax of 180 (age 40, estimating HRmax As 220 minus age):
	 * 
	 * 65% Intensity: (220 minus (age = 40)) times 0.65 arrow 117 bpm 85% Intensity: (220 minus
	 * (age = 40)) times 0.85 arrow 153 bpm
	 */

	/**
	 * Implement this method. 
	 * HRmax = 211 minus (0.64 times age)	 * 
	 * This relationship was found to hold substantially regardless of gender,
	 * physical activity status, maximal oxygen uptake, smoking, or body mass
	 * index. However, a standard error of the estimate of 10.8 beats/min must
	 * be accounted for when applying the formula to clinical settings, and the
	 * researchers concluded that actual measurement via a maximal test may be
	 * preferable whenever possible.
	 */
	private int getHRmax(int age){
		int max = (int) (211 - (0.64 * age));
		return max;
	}//end method
	

}
