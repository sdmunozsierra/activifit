package generator_package;

import javax.swing.JPanel;

import gui_package.CustomJPanels;

public class WeatherGenerator {
	
	public static JPanel generateWeather(){
		//int generator = ((int)Math.random() * 6 + 1);
		int generator = 5;
		
		if(generator == 1)
			return dayNight();
		
		if(generator == 2)
			return cloudy();
		
		if(generator == 3)
			return partlyCloudy();
		
		if(generator == 4)
			return rainy();
		
		if(generator == 5)
			return snowy();
		
		if(generator == 6)
			return thunderstorm();
		
		return null;
	}
	
	public static JPanel dayNight(){
		//depending on time will send day or night
		JPanel background = CustomJPanels.backgroundPanel("", 3);
		return background;
	}//end day or night panel
	
	public static JPanel cloudy(){
		JPanel background = CustomJPanels.backgroundPanel("https://builder.impress.ly/api/image/43341a3c-3c37-11e5-80d0-00155d130a43", 3);
		return background;
	}//end cloudy panel
	
	public static JPanel partlyCloudy(){
		JPanel background = CustomJPanels.backgroundPanel("https://www.shareicon.net/data/128x128/2015/12/01/680819_cloud_512x512.png", 3);
		return background;
	}//end partly cloudy panel
	
	public static JPanel rainy(){
		JPanel background = CustomJPanels.backgroundPanel("http://iconshow.me/media/images/ui/ios7-icons/png/128/rainy-outline.png", 3);
		return background;
	}//end rainy panel
	
	public static JPanel snowy(){
		JPanel background = CustomJPanels.backgroundPanel("https://www.shareicon.net/data/128x128/2015/12/01/680565_cloud_512x512.png", 3);
		return background;
	}//end snowy panel
	
	public static JPanel thunderstorm(){
		JPanel background = CustomJPanels.backgroundPanel("http://www.uidownload.com/files/640/502/468/bolt-cloud-forecast-lightning-storm-weather-icon.png", 3);
		return background;
	}//end thunderstorm panel
	
}
