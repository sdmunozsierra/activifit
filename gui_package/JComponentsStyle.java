package gui_package;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class JComponentsStyle {
	
	/** Colors */
	/* Material UI */
	public static Color red_alizarin = new Color(231, 76, 60);
	public static Color green_emerald = new Color(46, 204, 113);
	public static Color blue_peterriver = new Color(52, 152, 219); //vivid blue
	public static Color blue_belizehole = new Color(41, 128, 185); //darker blue
	public static Color purple_amethyst = new Color(155, 89, 182);
	public static Color gray_concrete = new Color(149, 165, 166);
	public static Color black_midnight = new Color(44, 62, 80);
	public static Color white_clouds = new Color(236, 240, 241); //Whitest
	public static Color white_silver = new Color(189,195,199); //White almost gray
	
	/* Pallete1 */
	public static Color blue_yankeesblue = new Color(37,40,61); //Almost purple
	public static Color black_eerie = new Color(22,25,37); 
	public static Color gray_space = new Color(70,73,76);
	public JComponentsStyle() {
	}

	/** Gray-Black Theme */
	public static void setToolTipStyle1() {
		UIManager.put("ToolTip.background", gray_space); 
		Border border = BorderFactory.createLineBorder(black_eerie);
		UIManager.put("ToolTip.border", border);
		UIManager.put("ToolTip.foreground", white_clouds);
		ToolTipManager.sharedInstance().setDismissDelay(8000); // 15 second
																// delay
		// setToolTipText("invalid email account"); // Message to display
	}

	private void custom_font(){
		try {
		    //create the font to use. Specify the size!
		    Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts\\custom_font.ttf")).deriveFont(12f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Fonts\\custom_font.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}

	}
}
