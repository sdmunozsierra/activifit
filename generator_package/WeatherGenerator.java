package generator_package;

import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui_package.CustomJPanels;
import gui_package.Screen;
/**
 * Generator for weather home page information.
 * @author JSSP Engineers
 * @version 1.0
 * 
 */
public class WeatherGenerator {
	private static int height = 40;
	private static int width = 40; 
	private static String status = "";

	/**
	 * Empty constructor
	 */
	public WeatherGenerator(){}
	
	
	/**
	 * Method receives the status of the weather to print on the aoo's home page
	 * @return String status 
	 */
	public static String getStatus() {
		return status;
	}

	/**
	 * Method randomly chooses a weather to display on the app for aesthetic purposes
	 * @return JLabel with the picture of the weather
	 */
	public static JLabel generateWeather(){
		//Case 1 currently unavailable
		int generator = ThreadLocalRandom.current().nextInt(1,6);
		//7 not inclusive
		switch (generator){
		case 1:
			status = "Cloudy";
			return cloudy();
		case 2:
			status = "Partly Cloudy";
			return partlyCloudy();
		case 3:
			status = "Rainy";
			return rainy();
		case 4:
			status = "Snowy";
			return snowy();
		case 5:
			status = "Thunder Storm";
			return thunderstorm();
		}
		return null; 
	}
	
	/**
	 * Method creates the cloudy weather
	 * @return JLabel with picture
	 */
	private static JLabel cloudy(){
		//JPanel background = CustomJPanels.backgroundPanel("https://builder.impress.ly/api/image/43341a3c-3c37-11e5-80d0-00155d130a43", 3);
		JLabel cloudy = Screen.getWebIconScaledLabel("http://i.imgur.com/etQQpsS.png", height, width);
		return cloudy;
	}//end cloudy panel
	
	/**
	 * Method creates the partly cloudy weather
	 * @return JLabel with picture
	 */
	private static JLabel partlyCloudy(){
		//JPanel background = CustomJPanels.backgroundPanel("https://www.shareicon.net/data/128x128/2015/12/01/680819_cloud_512x512.png", 3);
		JLabel partCloudy = Screen.getWebIconScaledLabel("https://www.shareicon.net/data/128x128/2015/12/01/680819_cloud_512x512.png", height, width);
		return partCloudy;
	}//end partly cloudy panel
	
	/**
	 * Method creates the rainy weather
	 * @return JLabel with picture
	 */
	private static JLabel rainy(){
		//JPanel background = CustomJPanels.backgroundPanel("http://iconshow.me/media/images/ui/ios7-icons/png/128/rainy-outline.png", 3);
		JLabel rainy = Screen.getWebIconScaledLabel("http://iconshow.me/media/images/ui/ios7-icons/png/128/rainy-outline.png", height, width);
		return rainy;
	}//end rainy panel
	
	/**
	 * Method creates the snowy weather
	 * @return JLabel with picture
	 */
	private static JLabel snowy(){
		//JPanel background = CustomJPanels.backgroundPanel("https://www.shareicon.net/data/128x128/2015/12/01/680565_cloud_512x512.png", 3);
		JLabel rainy = Screen.getWebIconScaledLabel("https://www.shareicon.net/data/128x128/2015/12/01/680565_cloud_512x512.png", height, width);
		return rainy;
	}//end snowy panel
	
	/**
	 * Method creates the thunderstorm weather
	 * @return JLabel with picture
	 */
	private static JLabel thunderstorm(){
		//JPanel background = CustomJPanels.backgroundPanel("http://www.uidownload.com/files/640/502/468/bolt-cloud-forecast-lightning-storm-weather-icon.png", 3);
		JLabel thunder = Screen.getWebIconScaledLabel("http://www.uidownload.com/files/640/502/468/bolt-cloud-forecast-lightning-storm-weather-icon.png", height, width);
		return thunder;
	}//end thunderstorm panel
	
}
