package generator_package;

import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui_package.CustomJPanels;
import gui_package.Screen;

public class WeatherGenerator {
	//TODO JavaDocs
	// Height and Width of the icons
	private static int height = 50;
	private static int width = 50; 
	private static String status = "";

	public WeatherGenerator(){
		
	}
	
	
	//Get the status of the weather
	public static String getStatus() {
		return status;
	}

	//Generates the weather
	public static JLabel generateWeather(){
		//Case 1 currently unavailable
		int generator = ThreadLocalRandom.current().nextInt(2,7);
		//7 not inclusive
		switch (generator){
//		case 1:
//			return 1;
		case 2:
			status = "Cloudy";
			return cloudy();
		case 3:
			status = "Partly Cloudy";
			return partlyCloudy();
		case 4:
			status = "Rainy";
			return rainy();
		case 5:
			status = "Snowy";
			return snowy();
		case 6:
			status = "Thunder Storm";
			return thunderstorm();
		}
		return null; 
	}
	
	
	private static JPanel dayNight(){
		//depending on time will send day or night
		JPanel background = CustomJPanels.backgroundPanel("", 3);
		return background;
	}//end day or night panel
	
	private static JLabel cloudy(){
		//JPanel background = CustomJPanels.backgroundPanel("https://builder.impress.ly/api/image/43341a3c-3c37-11e5-80d0-00155d130a43", 3);
		JLabel cloudy = Screen.getWebIconScaledLabel("http://i.imgur.com/etQQpsS.png", height, width);
		return cloudy;
	}//end cloudy panel
	
	private static JLabel partlyCloudy(){
		//JPanel background = CustomJPanels.backgroundPanel("https://www.shareicon.net/data/128x128/2015/12/01/680819_cloud_512x512.png", 3);
		JLabel partCloudy = Screen.getWebIconScaledLabel("https://www.shareicon.net/data/128x128/2015/12/01/680819_cloud_512x512.png", height, width);
		return partCloudy;
	}//end partly cloudy panel
	
	private static JLabel rainy(){
		//JPanel background = CustomJPanels.backgroundPanel("http://iconshow.me/media/images/ui/ios7-icons/png/128/rainy-outline.png", 3);
		JLabel rainy = Screen.getWebIconScaledLabel("http://iconshow.me/media/images/ui/ios7-icons/png/128/rainy-outline.png", height, width);
		return rainy;
	}//end rainy panel
	
	private static JLabel snowy(){
		//JPanel background = CustomJPanels.backgroundPanel("https://www.shareicon.net/data/128x128/2015/12/01/680565_cloud_512x512.png", 3);
		JLabel rainy = Screen.getWebIconScaledLabel("https://www.shareicon.net/data/128x128/2015/12/01/680565_cloud_512x512.png", height, width);
		return rainy;
	}//end snowy panel
	
	private static JLabel thunderstorm(){
		//JPanel background = CustomJPanels.backgroundPanel("http://www.uidownload.com/files/640/502/468/bolt-cloud-forecast-lightning-storm-weather-icon.png", 3);
		JLabel thunder = Screen.getWebIconScaledLabel("http://www.uidownload.com/files/640/502/468/bolt-cloud-forecast-lightning-storm-weather-icon.png", height, width);
		return thunder;
	}//end thunderstorm panel
	
}
