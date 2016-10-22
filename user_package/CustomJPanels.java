package user_package;

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
import action_package.WeekActionListener;
import gui_package.ImageUtilities;
import gui_package.Screen;

//Put here all the custom panels in the gui_package
public class CustomJPanels {
	
	/** Banner Panel */
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

	/** Activity Banner Panel */
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
	
	/** Banner navPanel */
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
		
		// Return panel
		panel.setBackground(Color.WHITE); // Sets the 'glue' color
		return panel;
	}// end navPanel
	
	/** Change Display Panel  */
	public static JPanel changeDisplayPanel(JFrame F) {
		/* Panel that has two buttons to change views of infomation */
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		JButton button_week = new JButton("Change to Week");
		JButton button_month = new JButton("Change to Month");
		panel.add(button_week);
		panel.add(Box.createHorizontalGlue());
		panel.add(button_month);
		panel.setOpaque(false); // THIS IS FUCKING GOLD!!!!!!
		
		//Action
		WeekActionListener action = new WeekActionListener(F);
		button_week.addActionListener(action);

		return panel;
	}
	
	/** Set Background Panel */
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
	
}
