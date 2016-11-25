package fonts;

import javafx.scene.text.Font;

public class LoadCustomFonts {

	private static LoadCustomFonts instance = new LoadCustomFonts();
	
	private LoadCustomFonts(){
		loadFonts();
	}
	
	public static LoadCustomFonts getInstance(){
		return instance;
	}
	
	public static void loadFonts(){
		//Qontra -> FONT FAMILY:qontra
		Font.loadFont(LoadCustomFonts.class.getResourceAsStream("Qontra.otf"), 14);
		//System.out.println("FONT FAMILY:"+Font.loadFont(LoadCustomFonts.class.getResourceAsStream("Qontra.otf"), 14).getName());
		
		//PrimeRegular -> FONT FAMILY:Prime-Regular
		Font.loadFont(LoadCustomFonts.class.getResourceAsStream("PrimeRegular.otf"), 14);
		//System.out.println("FONT FAMILY:"+Font.loadFont(LoadCustomFonts.class.getResourceAsStream("PrimeRegular.otf"), 14).getName());
		
		//OrkneyReg -> FONT FAMILY:Orkney-Regular
		Font.loadFont(LoadCustomFonts.class.getResourceAsStream("OrkneyReg.otf"), 14);
		//System.out.println("FONT FAMILY:"+Font.loadFont(LoadCustomFonts.class.getResourceAsStream("OrkneyReg.otf"), 14).getName());
	}
}
