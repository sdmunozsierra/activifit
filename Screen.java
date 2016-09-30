package activifit_gui;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
public class Screen {

	/** Resources */
	/* Maybe it would be a good idea to change remove as much resources as possible and
	 * leave everything inside it's own method. Colors, and Images can be in a
	 * different class if things get messy.
	 */
	/* Variables */
	//Resolution taken from an iPhone5 320x568 pixels
	final static int rx = 320; // horizontal resolution
	final static int ry = 568; // vertical resolution
	
	/* Colors */
	static Color red_alizarin = new Color(231,76,60);
	static Color green_emerald = new Color(46,204,113);
	static Color blue_peterriver = new Color(52,152,219);
	static Color purple_amethyst= new Color(155,89,182);
	static Color black_midnight = new Color(44,62,80);
	static Color white_clouds = new Color(236,240,241);
	

	/* Images */
	//static Image background_temp_green = new Image("/activifit/src/b_temp_g.png");
	
	/* Buttons */
	private JButton button_heart = new JButton("[HEART]");
	private JButton button_steps = new JButton("[STEPS]");
	private JButton button_temp = new JButton("[TEMP]");
	private JButton button_sleep = new JButton("[SLEEP]");
	private JButton button_share = new JButton("[SHARE]");

	/* Text Fields */
	// ERROR IN DESIGN - MUST NOT HAVE STATIC FIELDS (screen_sign_in bug)
	private static JTextField e_login = new JTextField(20); // limited to 30
															// chars

	/* Borders */
	private static Border border_default = BorderFactory.createLineBorder(Color.BLACK);
	private Border border_error = BorderFactory.createLineBorder(Color.RED);

	/** Main Method */
	public static void main(String args[]) {
		// For alpha stage, main will be developed here for simplicity

		//screen_sign_in(); // should not be a method, because of static
		//screen_register();
		//new Screen(); // Main calls home_page screen
		//screen_heart();
		//screen_temperature();
		//screen_steps();
		screen_sleep();
		//screen_share();
		//screen_logout();
	}// end main

	/** Methods */
	/* --Screens-- */
	
	/* HomePage screen */
	public Screen() {
		// Creates the frame for the screen
		JFrame F = new JFrame("Homepage");

		// JPANEL and layout
		JPanel P = new JPanel();
		P.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		// Activity Bar
		JPanel Pa = new JPanel();
		Pa.setLayout(new FlowLayout());
		Pa.add(button_heart); // add the heart rate button
		Pa.add(button_steps);
		Pa.add(button_temp);
		Pa.add(button_sleep);
		Pa.add(button_share);

		// ADD JPanels into JFrame
		F.add(P, BorderLayout.CENTER); // First row
		F.add(Pa, BorderLayout.SOUTH); // Bottom

		// Size and Visibility
		F.setSize(rx, ry);
		F.setVisible(true);
	}// end Screen

	public static void screen_sign_in() {
		// Create a JFrame
		JFrame F = new JFrame("Log-In");

		// Create a panel in a list order
		JPanel listPane = new JPanel();
		listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));

		// Labels
		// Banner
		JLabel banner = new JLabel("Activifit"); // Banner
		banner.setFont(new Font(null, 0, 25)); // latter on we could use fancier
												// fonts ;)
		// Login
		e_login.setBorder(border_default); // login text field
		e_login.setMaximumSize(new Dimension(200, 6)); // login dimension

		// Create more labels to test the layout
		JLabel thing1 = new JLabel("SIGN IN"); // RENAME
		JLabel thing2 = new JLabel("SECOND THING"); // RENAME
		JLabel thing3 = new JLabel("Third THING");// RENAME

		// Buttons
		// Accept
		JButton button_accept = new JButton("ACCEPT");

		// Add components to the Panel
		listPane.add(banner);
		listPane.add(Box.createRigidArea(new Dimension(0, 30)));
		listPane.add(thing1); // SING IN
		listPane.add(Box.createRigidArea(new Dimension(10, 0)));
		listPane.add(e_login); // login box
		listPane.add(Box.createRigidArea(new Dimension(0, 10)));
		listPane.add(button_accept); // accept
		listPane.add(Box.createVerticalGlue()); // GLUE STETCHES!!
		listPane.add(thing2);
		listPane.add(Box.createRigidArea(new Dimension(10, 0)));
		listPane.add(thing3);

		// Align every component (-.-)
		banner.setAlignmentX(Component.CENTER_ALIGNMENT);
		thing1.setAlignmentX(Component.CENTER_ALIGNMENT);
		thing2.setAlignmentX(Component.CENTER_ALIGNMENT);
		thing3.setAlignmentX(Component.CENTER_ALIGNMENT);
		button_accept.setAlignmentX(Component.CENTER_ALIGNMENT);
		e_login.setAlignmentX(Component.CENTER_ALIGNMENT);

		F.add(listPane); // First row

		F.setSize(rx, ry);
		F.setVisible(true);

	}// End sign-in screen
	
	/* Screen Register */
	public static void screen_register() {
		JFrame F = new JFrame("Register");

		String[] labels = { "Name: ", "Age: ", "Weight: ", "Height: ", "Active Idx: ", "Email: " };
		int numPairs = labels.length;

		// Create and populate the form panel.
		JPanel p = new JPanel(new SpringLayout());
		for (int i = 0; i < numPairs; i++) {
			JLabel l = new JLabel(labels[i], JLabel.TRAILING);
			p.add(l);
			JTextField textField = new JTextField(20);
			l.setLabelFor(textField);
			p.add(textField);
			textField.setMaximumSize(new Dimension(300, 6));// change text field size
		}
		// Make grid layout
		// makeGrid(panel, nCols, nRows, init x, init y, xpad, ypad)
		SpringUtilities.makeGrid(p, numPairs, 2, 6, 6, 6, 20); // #Change init x
																// to fit banner

		// Bottom panels
		JPanel boxPane = new JPanel(); // Will use 2 rows
		boxPane.setLayout(new BoxLayout(boxPane, BoxLayout.Y_AXIS)); // Vertical
		JButton button_accept = new JButton("Accept");
		JButton button_back = new JButton("BACK");
		JButton button_help = new JButton("HELP");
		// Bottom panel (panel-ception) last row
		JPanel p2 = new JPanel(); // Will have back and help buttons
		p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS)); // Horizontal 

		// Add buttons, properties and spaces
		boxPane.add(button_accept);
		button_accept.setAlignmentX(Component.CENTER_ALIGNMENT);
		boxPane.add(Box.createRigidArea(new Dimension(0, 50))); // rigid area to last row
		p2.add(button_back);
		p2.add(Box.createHorizontalGlue());
		p2.add(button_help);
		// add last row panel to bottom panel
		boxPane.add(p2);
		// Set panels to the Frame
		F.add(bannerPanel(), BorderLayout.NORTH);
		F.add(p, BorderLayout.EAST);
		F.add(boxPane, BorderLayout.SOUTH);
		// Global values
		F.setSize(rx, ry);
		F.setVisible(true);
	}// end screen_register
	
	/* Heart Rate Screen */
	public static void screen_heart() {
		JFrame F = new JFrame("Heartbeat");
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS)); // vertical
		JPanel p2 = new JPanel();
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));

		// TEST LABELS
		JLabel c1 = new JLabel("c1"); // Curr rate
		JLabel c2 = new JLabel("c2"); // #variable for curr rate
		JLabel c3 = new JLabel("c3"); // Weekly View
		JLabel c4 = new JLabel("c4"); // Avg rate
		JLabel c5 = new JLabel("c5"); // #variable for avg rate
		JLabel c6 = new JLabel("c6"); // Monthly View
		p1.add(c1);
		p1.add(c2);
		p1.add(c3);
		p2.add(c4);
		p2.add(c5);
		p2.add(c6);

		// TEST BACKGROUND IMG
		// F.add(background);
		F.add(p1, BorderLayout.WEST);
		F.add(p2, BorderLayout.EAST);
		F.add(navPanel(), BorderLayout.SOUTH);
		F.setSize(rx, ry);
		F.setVisible(true);
	}
	
	/* Temperature Screen */
	public static void screen_temperature() {
		JFrame F = new JFrame("Temperature");
		ImageUtilities backG = new ImageUtilities();
		
		//CHANGE FOLLOWING TO A METHOD UNTIL #
		backG.readFromSource("C:/Users/sdmunozsierra/Downloads/fennekin.png");
		backG.setImage(backG.getScaledImage(backG.img, rx, ry)); //rescale the background img (Horrible)
		JPanel background = backG.backgroundPanel(backG.getImage());
		background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS)); // vertical
		//# CHANGE TO A METHOD
		//Labels
		JLabel current_temp = new JLabel("Current temp"); //This will be pulled from TEMP.CLASS
		JLabel current_temp_state = new JLabel("Current body temp state"); //From TEMP.CLASS
		
		//Custom panels
		JPanel change_displayP = changeDisplayPanel();
		JPanel banner = activityBannerPanel("Body Temperature", red_alizarin);
		
		background.add(banner);
		background.add(Box.createRigidArea(new Dimension(0,50)));
		background.add(current_temp);
		current_temp.setAlignmentX(Component.CENTER_ALIGNMENT);
		background.add(Box.createRigidArea(new Dimension(0,75)));
		background.add(current_temp_state);
		current_temp_state.setAlignmentX(Component.CENTER_ALIGNMENT);
		background.add(Box.createRigidArea(new Dimension(0,100)));
		background.add(change_displayP);
		
		F.add(background, BorderLayout.CENTER);
		F.add(navPanel(), BorderLayout.SOUTH);
		F.setSize(rx, ry);
		F.setVisible(true);
	}
	
	/* Steps Screen */
	public static void screen_steps() {
		JFrame F = new JFrame("Steps");
		ImageUtilities backG = new ImageUtilities();
		
		//CHANGE FOLLOWING TO A METHOD UNTIL #
		backG.readFromSource("C:/Users/sdmunozsierra/Downloads/flareon.jpg");
		backG.setImage(backG.getScaledImage(backG.img, rx, ry)); //rescale the background img (Horrible)
		JPanel background = backG.backgroundPanel(backG.getImage());
		background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS)); // vertical
		//# CHANGE TO A METHOD
		//Labels
		JLabel current_steps = new JLabel("Today Number of Steps"); //This will be pulled from TEMP.CLASS
		JLabel current_steps_state = new JLabel("Current fitness level"); //From TEMP.CLASS
		
		//Custom panels
		JPanel change_displayP = changeDisplayPanel();
		JPanel banner = activityBannerPanel("Steps", purple_amethyst);
		
		background.add(banner);
		background.add(Box.createRigidArea(new Dimension(0,50)));
		background.add(current_steps);
		current_steps.setAlignmentX(Component.CENTER_ALIGNMENT);
		background.add(Box.createRigidArea(new Dimension(0,75)));
		background.add(current_steps_state);
		current_steps_state.setAlignmentX(Component.CENTER_ALIGNMENT);
		background.add(Box.createRigidArea(new Dimension(0,100)));
		background.add(change_displayP);
		
		F.add(background, BorderLayout.CENTER);
		F.add(navPanel(), BorderLayout.SOUTH);
		F.setSize(rx, ry);
		F.setVisible(true);
	}
	
	/* Sleep Screen */
	public static void screen_sleep() {
		JFrame F = new JFrame("Sleep");
		ImageUtilities backG = new ImageUtilities();
		
		//CHANGE FOLLOWING TO A METHOD UNTIL #
		backG.readFromSource("C:/Users/sdmunozsierra/Downloads/moon.jpg");
		backG.setImage(backG.getScaledImage(backG.img, rx, ry)); //rescale the background img (Horrible)
		JPanel background = backG.backgroundPanel(backG.getImage());
		background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS)); // vertical
		//# CHANGE TO A METHOD
		//Labels
		JLabel current_sleep = new JLabel("Yesterday's Sleep Quality"); //This will be pulled from//From SLEEP.CLASS
		JLabel rem = new JLabel("REM Time"); //From SLEEP.CLASS
		JLabel light = new JLabel("Light Sleep Time"); //From SLEEP.CLASS
		JLabel deep = new JLabel("Deep Sleep Time"); //From SLEEP.CLASS
		
		//Custom panels
		JPanel change_displayP = changeDisplayPanel();
		JPanel banner = activityBannerPanel("Sleep", white_clouds);
		
		background.add(banner);
		background.add(Box.createRigidArea(new Dimension(0,50)));
		background.add(current_sleep);
		current_sleep.setAlignmentX(Component.CENTER_ALIGNMENT);
		background.add(Box.createRigidArea(new Dimension(0,75)));
		
		background.add(rem);
		background.add(light);
		background.add(deep);
		//current_temp_state.setAlignmentX(Component.CENTER_ALIGNMENT);
		background.add(Box.createRigidArea(new Dimension(0,100)));
		background.add(change_displayP);
		
		F.add(background, BorderLayout.CENTER);
		F.add(navPanel(), BorderLayout.SOUTH);
		F.setSize(rx, ry);
		F.setVisible(true);
	}
	
	/* Share Screen */
	public static void screen_share(){
		//Icons URLs
		String url_f = ("http://icons.iconarchive.com/icons/mysitemyway/blue-jeans-social-media/128/facebook-icon.png"); //Facebook
		String url_s = ("http://imavex.vo.llnwd.net/o18/clients/imavex/images/Services-ClubWorksite/service-icon-share.png"); //share
		
		JFrame F = new JFrame("Share");
		//Panels (I'm getting good at this)
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS)); //Vertical Container
		JPanel postP = new JPanel();
		postP.setLayout(new FlowLayout(FlowLayout.CENTER));
		JPanel iconsP = new JPanel();
		iconsP.setLayout(new BoxLayout(iconsP, BoxLayout.X_AXIS));
		JPanel sharing_iconP = new JPanel();
		sharing_iconP.setLayout(new FlowLayout(FlowLayout.CENTER));
		JPanel backP = new JPanel();
		backP.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		//Labels and icons
		JLabel label1 = new JLabel("POST TO...");
		postP.add(label1);
		
		//Add icons to panel #FROM HERE
		JLabel icon_f = getWebIcon(url_f, 50,50);
		JLabel icon_t = getWebIcon(url_f, 50,45);
		JLabel icon_m = getWebIcon(url_f, 50,50);
		
		iconsP.add(icon_f);
		iconsP.add(icon_t);
		iconsP.add(icon_m);
		//#TO HERE. change to make a loop
		JLabel icon_s = getWebIcon(url_s, 50,50);
		JLabel sharing = new JLabel("Sharing...");
		sharing_iconP.add(icon_s);
		sharing_iconP.add(sharing);
		
		JButton button_back = new JButton("BACK");
		backP.add(button_back);
		
		//Add Panels to container
		container.add(postP); //add post panel
		container.add(iconsP);//add icons panel
		iconsP.add(Box.createVerticalGlue()); //add glue
		container.add(sharing_iconP);//add sharing icon
		
		F.add(container, BorderLayout.CENTER);
		F.add(backP, BorderLayout.SOUTH);
		F.setSize(rx, ry);
		F.setVisible(true);
		
	}//end screen_share
	public static void screen_logout(){
		JFrame F = new JFrame("Logout");
	
		JPanel thank_youP = new JPanel();
		thank_youP.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel dialog = new JLabel("THANK YOU FOR \nUSING");
		thank_youP.add(dialog);
		//thank_youP.add(Box.createRigidArea(new Dimension(0, 200))); // rigid area to last row
		
		JButton button_ok = new JButton("OK");
		
		F.add(thank_youP, BorderLayout.NORTH);
		F.add(bannerPanel(), BorderLayout.CENTER);
		F.add(button_ok, BorderLayout.SOUTH);
		F.setSize(rx, ry);
		F.setVisible(true);
	}
	
	/* Logout Screen */

	/* --Custom Panels-- */
	/* Banner Panel */
	public static JPanel bannerPanel() {
		/* Add to the as-> Frame.add(bannerPanel(), BorderLayout.NORTH) 
		 * Panel containing banner. */
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JLabel banner = new JLabel("Activifit"); // Banner
		panel.add(banner);
		banner.setFont(new Font(null, 0, 25)); 
		banner.setForeground(black_midnight);
		panel.setBackground(blue_peterriver);
		
		return panel;
	}
	/* Banner navPanel */
	public static JPanel navPanel() {
		/* Add to the as-> Frame.add(navPanel(), BorderLayout.SOUTH) 
		 * Panel containing back and share. */
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		// Create Buttons
		JButton button_back = new JButton("[BACK]");
		JButton button_share_this = new JButton("[SHARE_T]");
		// Add to panel with glue between two buttons
		panel.add(button_back);
		panel.add(Box.createHorizontalGlue());
		panel.add(button_share_this);
		// Return panel
		panel.setBackground(Color.WHITE); //Sets the 'glue' color
		return panel;
	}// end navPanel
	/* Activity Banner Panel */
	public static JPanel activityBannerPanel(String activity, Color color) {
		/* Panel containing a custom banner for an activity. */
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JLabel banner = new JLabel(activity); // Banner
		panel.add(banner);
		banner.setFont(new Font(null, 0, 25)); 
		banner.setForeground(color);
		panel.setOpaque(false);
		
		//MIGHT NEED TO ADJUST BANNER MAX SIZE
		panel.setMaximumSize(new Dimension(rx,50));
		
		return panel;
	}
	
	/* Change Display Panel */
	public static JPanel changeDisplayPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		JButton button_week = new JButton("Change to Week");
		JButton button_month = new JButton("Change to Month");
		panel.add(button_week);
		panel.add(Box.createHorizontalGlue());
		panel.add(button_month);
		panel.setOpaque(false); //THIS IS FUCKING GOLD!!!!!!
		return panel;
	}
	
	/* --Custom JLabels*/
	/* Icon from web w/custom size */
	public static JLabel getWebIcon(String web_address, int width, int height){
		ImageUtilities buffer = new ImageUtilities(); //create instance
		buffer.readImgFromWeb(web_address); //read from url
		Image img = buffer.getImage(); //pull img
		//Create a Label
		img = buffer.getScaledImage(img, width, height);
		JLabel label = new JLabel(new ImageIcon(img));

		return label;
	}
}// end Screen Class
