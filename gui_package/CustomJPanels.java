package gui_package;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

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
	 * Creates the the activity banner panel
	 * @param activity takes in the activity, either heart, steps, sleep, or temperature
	 * @param color takes in the color
	 * @return JPanel
	 */
	public static JPanel activityBannerPanel(String activity, Color color) {
		/* Panel containing a custom banner for an activity. */
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JLabel banner = new JLabel(activity); // Banner
		panel.add(banner);
		banner.setFont(new Font(null, 0, 25));
		banner.setForeground(color);
		panel.setOpaque(false);

		// MIGHT NEED TO ADJUST BANNER MAX SIZE
		panel.setMaximumSize(new Dimension(Screen.rx, 50));

		return panel;
	}
	
	/**
	 * Creates the bottom navigation panel
	 * @param F JFrame to create the panel
	 * @return JPanel with the frame
	 */
	public static JPanel navPanel(JFrame F) {
		/*
		 * Add to the as-> Frame.add(navPanel(), BorderLayout.SOUTH) Panel
		 * containing back and share.
		 */
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		// Create Buttons
		JButton button_back = new JButton("BACK");
		JButton button_share_this = new JButton("[SHARE_T]");
		// Add to panel with glue between two buttons
		panel.add(button_back);
		panel.add(Box.createHorizontalGlue());
		panel.add(button_share_this);
		
		//Action
		NavPanelBackActionListener action = new NavPanelBackActionListener(F);
		button_back.addActionListener(action);
		NavPanelShareActionListener action2 = new NavPanelShareActionListener(F);
		button_share_this.addActionListener(action2);
		
		// Return panel
		panel.setBackground(Color.WHITE); // Sets the 'glue' color
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
	
}//end class
