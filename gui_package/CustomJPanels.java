package gui_package;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import action_package.NavPanelBackActionListener;
import action_package.NavPanelShareActionListener;

//Put here all the custom panels in the gui_package
/**
 * Here are all the custom panels in the gui_package
 * @author JSSP Engineers
 * @version 1.0
 */
public class CustomJPanels {
	
	/**
	 * Creates the is to create the banner panel
	 * @return JPanel the banner
	 */
	public static JPanel bannerPanel() {
		/*
		 * Add to the as-> Frame.add(bannerPanel(), BorderLayout.NORTH) Panel
		 * containing banner.
		 */
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JLabel banner = new JLabel("Activifit"); // Banner
		panel.add(banner);
		banner.setFont(new Font(null, 0, 25));
		banner.setForeground(Screen.black_midnight);
		panel.setBackground(Screen.blue_peterriver);

		return panel;
	}

	
	
	/**
	 * Creates the activity banner panel
	 * @param activity takes in the activity, either heart, steps, sleep, temperature or share
	 * @param bg Background color for the panel
	 * @param fg Foreground color for the panel's letters
	 */
	public static JPanel activityBannerPanel2(String activity, Color bg, Color fg) {
		/* Panel containing a custom banner for an activity. */
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JLabel label = new JLabel(activity); // Banner
		panel.add(label);
		//label.setFont(new Font(null, 0, 25));
		//label.setFont(JComponentStyle.heebo_med.deriveFont(25f));
		label.setFont(new Font(null, Font.PLAIN, 25));
		label.setForeground(fg);
		panel.setOpaque(true);
		panel.setBackground(bg);
		
		// MIGHT NEED TO ADJUST BANNER MAX SIZE
		panel.setMaximumSize(new Dimension(Screen.rx, 50));

		return panel;
	}
	
	/** Creates the Home Menu banner panel
	 * @param activity takes in the activity, either heart, steps, sleep, or temperature
	 * @param color takes in the color
	 * @return JPanel
	 */
	public static JPanel HomeMenuBannerPanel(String username) {
		/* Panel containing a custom banner for an activity. */
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JLabel banner = new JLabel(username); // Banner
		panel.add(banner);
		banner.setFont(new Font(null, 0, 24));
		//banner.setForeground(JComponentStyle.white_clouds);
		banner.setForeground(Color.white);
		//panel.setBackground(Color.BLACK);
		panel.setBackground(JComponentStyle.gray_concrete);
		//panel.setOpaque(true);

		// MIGHT NEED TO ADJUST BANNER MAX SIZE
		panel.setMaximumSize(new Dimension(Screen.rx, 50));

		return panel;
	}
	
	/**
	 * Creates the bottom navigation panel
	 * @param F JFrame to create the panel
	 * @param bColor Changes the color of the back button
	 * @return JPanel with the frame
	 */
	public static JPanel navPanel(JFrame F, Color bColor) {
		/*
		 * Add to the as-> Frame.add(navPanel(), BorderLayout.SOUTH) Panel
		 * containing back and share.
		 */
		
		JPanel panel = new JPanel(); 
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JButton b_back = JComponentStyle.JButtonHome("Back", bColor);
		JButton b_share =  JComponentStyle.JButtonHome("Share", Color.BLACK);
		// Add to panel with glue between two buttons
		panel.add(b_back);
		b_back.setPreferredSize(new Dimension(Screen.rx , 30));
		b_back.setFont(new Font("Heebo-Medium", Font.PLAIN, 18));
		panel.add(Box.createHorizontalGlue());
		panel.add(b_share);
		b_share.setPreferredSize(new Dimension(Screen.rx-1 , 30));
		b_share.setFont(new Font("Heebo-Medium", Font.PLAIN, 18));
		panel.setOpaque(false);
		
		//Action
		NavPanelBackActionListener action = new NavPanelBackActionListener(F);
		b_back.addActionListener(action);
		
		NavPanelShareActionListener action2 = new NavPanelShareActionListener(F);
		b_share.addActionListener(action2);
		
		// Return panel
		//panel.setBackground(Color.WHITE); // Sets the 'glue' color
		
		
		// MIGHT NEED TO ADJUST BANNER MAX SIZE
		panel.setMaximumSize(new Dimension(Screen.rx, 30)); //
		
		return panel;
	}// end navPanel
	
	/**
	 * Method sets the background panel
	 * @param path String to read for panel
	 * @param opt numbers 1-3 for either local path, web path, or web path with no scaling
	 * @return JPanel
	 */
	public static JPanel backgroundPanel(String path, int opt) {
		/*	OPT =>
		 *  Use 1 for Local Path 
		 *  Use 2 for Web Path
		 *  Use 3 for Web path with no scaling
		 */
		JPanel panel = new JPanel();
		ImageUtilities image = new ImageUtilities();

		if (opt == 1) {
			image.readFromSource(path);
			image.setImage(image.getScaledImage(image.getImage(), Screen.rx, Screen.ry));
		} else if (opt == 2) {
			image.readImgFromWeb(path);
			image.setImage(image.getScaledImage(image.getImage(), Screen.rx, Screen.ry));
		} else if (opt == 3){
			image.readImgFromWeb(path);
			image.setImage(image.getImage());
		}
		else {
			throw new Error("");
		}

		//image.setImage(image.getScaledImage(image.getImage(), rx, ry));
		panel = image.setBackgroundPanelImage(image.getImage());
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // vertical
		return panel;
	}
	
	/** Create a JPanel that contains a long button for the menu.
	 * Flat Style Buttons.
	 * @param text String to be placed inside the button 
	 * @param a Action listener that contains the action for the button 
	 * @param backgroundColor Choose the background color of the button 
	 * @return Big menu button
	 * */
	public static JPanel menuButtonPanel(String text, ActionListener a, Color backgroundColor){
		//Get resolutions
		int rx = JComponentStyle.rx;
		int ry = JComponentStyle.ry;
		
		JPanel pane = new JPanel();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JButton button = JComponentStyle.JButtonHome(text, backgroundColor);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 24;      //make this component tall 24 ok
		c.ipadx = rx-(rx/4)+10;
	
		button.addActionListener(a);
		pane.add(button, c); //Add the button with the contraints
		pane.setOpaque(false); //Transparent background
		return pane;
	}
	
	/** Create a JPanel that contains a centered text.
	 * Font and size is already modified. Transparent by default.
	 * need to override this method.
	 * @param text String to pass to the Panel. Preferably with HTML tags.
	 * @param xPos horizontal deviation.
	 * @param color Select the text Color.
	 * @return JPanel with centered text. 
	 * */
	public static JPanel centeredTextPanel(String text, int xPos, Color color){
		// Strings and Labels
		JLabel label = JComponentStyle.JLabelStyle("<html><div style='text-align: center;'>" + text + "</div></html>"); 
		label.setForeground(color);
		
		// Text Panel
		JPanel panel = new JPanel(); // Container
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setOpaque(false);
		panel.add(Box.createRigidArea(new Dimension(xPos, 0)));  //Set 30 between Components
		panel.add(label);
		
		return panel;
	}
	
	
	
	
	
	
}//end class
