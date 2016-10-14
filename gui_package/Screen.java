package gui_package;

import javax.swing.*;
import javax.swing.border.Border;

import action_package.*;
import user_package.UserDatabase;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

public class Screen {

	/* Resources 
	 * Many resources can be changed to private */
	// Resolution taken from an iPhone5 320x568 pixels
	final static int rx = 320; // horizontal resolution
	final static int ry = 568; // vertical resolution

	/* Colors */
	static Color red_alizarin = new Color(231, 76, 60);
	static Color green_emerald = new Color(46, 204, 113);
	static Color blue_peterriver = new Color(52, 152, 219);
	public static Color blue_belizehole = new Color(41, 128, 185);
	static Color purple_amethyst = new Color(155, 89, 182);
	static Color gray_concrete = new Color(149, 165, 166);
	static Color black_midnight = new Color(44, 62, 80);
	static Color white_clouds = new Color(236, 240, 241);
	
	/* Database */
	public final static UserDatabase globalDatabase = new UserDatabase();

	/** Main Method */
	public static void main(String args[]) {
		// Test each screen individually

		// screen_login();
		// screen_register();
		// screen_home();
		// screen_heart();
		// screen_temperature();
		// screen_steps();
		// screen_sleep();
		// screen_share();
		// screen_logout();
		// screen_about();
		// screen_help();
		
	}// end main

	/** Methods */
	/* --Screens-- */

	// constructor
	public Screen() {
		screen_login();
	}

	/* Login Screen */
	public static void screen_login() {
		Border border_default = BorderFactory.createLineBorder(Color.BLACK);
		JFrame F = new JFrame("Log-In");

		// Panel (BOX LAYOUT)
		JPanel listP = new JPanel();
		listP.setLayout(new BoxLayout(listP, BoxLayout.PAGE_AXIS));

		// Panel bottom about us (BOX LAYOUT) ----Method?----
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		// Create Buttons
		JButton button_about = new JButton("About Us");
		JButton button_help = new JButton("Help");
		// Add to panel with glue between two buttons
		panel.add(button_about);
		panel.add(Box.createHorizontalGlue());
		panel.add(button_help);
		panel.setOpaque(false);
		// ----Method?---- Panel bottom about us (BOX LAYOUT)

		// Login Text Field
		JTextField t_login = new JTextField(20);
		t_login.setBorder(border_default); // login text field
		t_login.setMaximumSize(new Dimension(200, 20)); // login dimension

		// Labels
		JLabel l_sign = new JLabel("Sign In");
		l_sign.setFont(new Font(null, Font.BOLD, 20));
		l_sign.setForeground(black_midnight);
		JLabel l_enter = new JLabel("(enter your email)");
		l_enter.setForeground(gray_concrete);

		// Buttons
		JButton button_accept = new JButton("DONE");

		// Add components and span.
		listP.add(Box.createRigidArea(new Dimension(0, ry / 4)));
		listP.add(l_sign); // Sign in label
		listP.add(Box.createRigidArea(new Dimension(0, 20)));
		listP.add(t_login); // Text Field
		listP.add(Box.createRigidArea(new Dimension(0, 6)));
		listP.add(l_enter); // Enter your email
		listP.add(Box.createRigidArea(new Dimension(0, 50)));
		listP.add(button_accept);

		// Align every component (-.-)
		l_sign.setAlignmentX(Component.CENTER_ALIGNMENT);
		t_login.setAlignmentX(Component.CENTER_ALIGNMENT);
		l_enter.setAlignmentX(Component.CENTER_ALIGNMENT);
		button_accept.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Actions
		LoginActionListener action = new LoginActionListener(t_login, F);
		button_accept.addActionListener(action);
		button_about.addActionListener(new LoginAboutUsActionListener(F));
		button_help.addActionListener(new LoginHelpActionListener(F));
		// Change Color Action
		t_login.addMouseListener(new LoginMouseAdapter(t_login));
		
		// Frames
		F.add(bannerPanel(), BorderLayout.NORTH);
		F.add(listP); // First row
		F.add(panel, BorderLayout.SOUTH);
		viewFrame(F);
	}// End sign-in screen

	/* Screen Register */
	public static void screen_register() {
		Border border_default = BorderFactory.createLineBorder(Color.BLACK);
		JFrame F = new JFrame("Register");

		String[] labels = { "Name: ", "Age: ", "Weight: ", "Height: ", "Active Id: ", "Email: " };
		int numPairs = labels.length;

		// Create an array of JTextFields 
		JTextField[] t_array = new JTextField[numPairs];
		
		// Container Panel (Box Layout)
		JPanel containerP = new JPanel();
		containerP.setLayout(new BoxLayout(containerP, BoxLayout.PAGE_AXIS));
				
		// Create form panel (Spring Layout)
		JPanel springP = new JPanel(new SpringLayout());
		for (int i = 0; i < numPairs; i++) {
			JLabel l = new JLabel(labels[i], JLabel.TRAILING);
			springP.add(l);
			t_array[i] = new JTextField(20); //new field
			l.setLabelFor(t_array[i]);
			springP.add(t_array[i]);
			t_array[i].setBorder(border_default); //Border color
 			t_array[i].setMaximumSize(new Dimension(300, 6)); //Max border
			t_array[i].addMouseListener(new LoginMouseAdapter(t_array[i])); //Action
			if(i == numPairs-1){ //Change email label
				t_array[i].setText(LoginActionListener.returnValidEmail() );
			}
		}
		// makeGrid(panel, nCols, nRows, init x, init y, xpad, ypad)
		SpringUtilities.makeGrid(springP, numPairs, 2, 6, 6, 6, 20);

		// Bottom panels
		JPanel bottomP = new JPanel(); // Will use 2 rows
		bottomP.setLayout(new BoxLayout(bottomP, BoxLayout.Y_AXIS)); // Vertical
		
		// Create buttons
		JButton button_accept = new JButton("Accept");
		JButton button_back = new JButton("BACK");
		JButton button_help = new JButton("HELP");

		// Navigation panel for last row
		JPanel navP = new JPanel(); // Will have back and help buttons
		navP.setLayout(new BoxLayout(navP, BoxLayout.X_AXIS)); // Horizontal

		// Add springP to ContainerP (for spacing options)
		containerP.add(Box.createRigidArea(new Dimension(0, 35))); //Add space
		containerP.add(springP); //Add form panel
		containerP.add(Box.createRigidArea(new Dimension(0, 35)));
		
		// Add buttons, properties and spaces to Bottom panel
		bottomP.add(button_accept);
		button_accept.setAlignmentX(Component.CENTER_ALIGNMENT);
		bottomP.add(Box.createRigidArea(new Dimension(0, 50))); // rigid area to
		// Add NavPanel 	
		navP.add(button_back);
		navP.add(Box.createHorizontalGlue());
		navP.add(button_help);
		// Add last row panel to bottom panel
		bottomP.add(navP); 
		
		// Actions
		RegisterAcceptActionListener action = new RegisterAcceptActionListener(t_array, F);
		button_accept.addActionListener(action);
		button_back.addActionListener(new RegisterBackActionListener(F));
		button_help.addActionListener(new RegisterHelpActionListener(F));
		
		// Set panels to the Frame
		F.add(bannerPanel(), BorderLayout.NORTH);
		F.add(containerP, BorderLayout.EAST);
		F.add(bottomP, BorderLayout.SOUTH);
		viewFrame(F);
	}// end screen_register

	/* HomePage screen */
	public static void screen_home() {
		JFrame F = new JFrame("Homepage");
		// Panel for information (BOX LAYOUT)
		JPanel P = new JPanel();
		P.setLayout(new BoxLayout(P, BoxLayout.PAGE_AXIS));
		P.add(Box.createRigidArea(new Dimension(0, 50)));
		// Panel for Buttons (FLOW LAYOUT)
		JPanel buttonP = new JPanel();
		buttonP.setLayout(new FlowLayout());
		
		// Fetch from database
		String currentUser = globalDatabase.getCurrentUser().getName();
		
		//Labels
		String[] labels = { "Hello "+currentUser, "Display Time", "Today's Daily Feed", "THIS WILL BE A GRAPH(hopefully)", };
		for (int i = 0; i < labels.length; i++) {
			JLabel l = new JLabel(labels[i], JLabel.TRAILING);
			P.add(l);
			l.setAlignmentX(Component.CENTER_ALIGNMENT);
			// if statement to span everything BUT last component
			if (i < labels.length - 1) {
				P.add(Box.createRigidArea(new Dimension(0, 33)));
			} else {
				P.add(Box.createRigidArea(new Dimension(0, 10)));
			}
		}
		// Actions
		HomeMenuActionListener action = new HomeMenuActionListener(F);
		
		// Buttons
		String[] buttons = { "HEART", "STEPS", "TEMP", "SLEEP", "SHARE" };
		for (int i = 0; i < buttons.length; i++) {
			JButton b = new JButton(buttons[i]);
			b.setMargin(new java.awt.Insets(1, 6, 1, 6)); // Format
			action = new HomeMenuActionListener(F, i);
			b.addActionListener(action);
			buttonP.add(b);
		}
		// Graph Image
		JLabel graph = new JLabel();
		graph.setIcon(insertWebIconScaled("http://i.imgur.com/i6svYaH.png", 200, 200));
		graph.setAlignmentX(Component.CENTER_ALIGNMENT);
		P.add(graph);

		// add panels to frame
		F.add(bannerPanel(), BorderLayout.NORTH);
		F.add(P, BorderLayout.CENTER);
		F.add(buttonP, BorderLayout.SOUTH);
		viewFrame(F); // displays the frame
	}// end Screen

	/* Heart Rate Screen */
	public static void screen_heart() {
		JFrame F = new JFrame("Heartbeat");

		JPanel banner = activityBannerPanel("Heart Rate", black_midnight);

		JPanel background = backgroundPanel("http://i.imgur.com/fMzXlWC.png", 3);

		JPanel displayP = changeDisplayPanel();

		// TEST LABELS
		JLabel c1 = new JLabel("Current Rate"); // Curr rate
		JLabel c2 = new JLabel("Health State"); // #variable for curr rate

		background.add(banner);
		background.add(Box.createRigidArea(new Dimension(0, ry / 6)));
		background.add(c1);
		c1.setAlignmentX(Component.CENTER_ALIGNMENT);
		background.add(Box.createRigidArea(new Dimension(0, 20)));
		c2.setAlignmentX(Component.CENTER_ALIGNMENT);
		background.add(c2);
		background.add(Box.createRigidArea(new Dimension(0, 200)));
		background.add(displayP);

		F.add(background, BorderLayout.CENTER);
		F.add(navPanel(F), BorderLayout.SOUTH);
		viewFrame(F);
	}

	/* Temperature Screen */
	public static void screen_temperature() {
		JFrame F = new JFrame("Temperature");

		JPanel background = backgroundPanel("http://i.imgur.com/vZ0rtrH.png", 3);

		// Labels
		JLabel current_temp = new JLabel("Current temp"); // This will be pulled
															// from TEMP.CLASS
		JLabel current_temp_state = new JLabel("Current body temp state"); // From
																			// TEMP.CLASS

		// Custom panels
		JPanel change_displayP = changeDisplayPanel();
		JPanel banner = activityBannerPanel("Body Temperature", red_alizarin);

		background.add(banner);
		background.add(Box.createRigidArea(new Dimension(0, 50)));
		background.add(current_temp);
		current_temp.setAlignmentX(Component.CENTER_ALIGNMENT);
		background.add(Box.createRigidArea(new Dimension(0, 75)));
		background.add(current_temp_state);
		current_temp_state.setAlignmentX(Component.CENTER_ALIGNMENT);
		background.add(Box.createRigidArea(new Dimension(0, 100)));
		background.add(change_displayP);

		F.add(background, BorderLayout.CENTER);
		F.add(navPanel(F), BorderLayout.SOUTH);
		viewFrame(F);
	}

	/* Steps Screen */
	public static void screen_steps() {
		JFrame F = new JFrame("Steps");

		JPanel background = backgroundPanel("http://i.imgur.com/rFeyEtS.png", 3);
		// Labels
		JLabel current_steps = new JLabel("Today Number of Steps"); // This will
																	// be pulled
																	// from
																	// TEMP.CLASS
		JLabel current_steps_state = new JLabel("Current fitness level"); // From
																			// TEMP.CLASS

		// Custom panels
		JPanel change_displayP = changeDisplayPanel();
		JPanel banner = activityBannerPanel("Steps", purple_amethyst);

		background.add(banner);
		background.add(Box.createRigidArea(new Dimension(0, 50)));
		background.add(current_steps);
		current_steps.setAlignmentX(Component.CENTER_ALIGNMENT);
		background.add(Box.createRigidArea(new Dimension(0, 75)));
		background.add(current_steps_state);
		current_steps_state.setAlignmentX(Component.CENTER_ALIGNMENT);
		background.add(Box.createRigidArea(new Dimension(0, 100)));
		background.add(change_displayP);

		F.add(background, BorderLayout.CENTER);
		F.add(navPanel(F), BorderLayout.SOUTH);
		viewFrame(F);
	}

	/* Sleep Screen */
	public static void screen_sleep() {
		JFrame F = new JFrame("Sleep");

		JPanel background = backgroundPanel("http://i.imgur.com/1BxhCZb.jpg", 2);

		// Labels
		JLabel current_sleep = new JLabel("Yesterday's Sleep Quality"); 
		JLabel rem = new JLabel("REM Time"); // From SLEEP.CLASS
		JLabel light = new JLabel("Light Sleep Time"); // From SLEEP.CLASS
		JLabel deep = new JLabel("Deep Sleep Time"); // From SLEEP.CLASS

		// Custom panels
		JPanel change_displayP = changeDisplayPanel();
		JPanel banner = activityBannerPanel("Sleep", white_clouds);

		background.add(banner);
		background.add(Box.createRigidArea(new Dimension(0, 50)));
		background.add(current_sleep);
		current_sleep.setAlignmentX(Component.CENTER_ALIGNMENT);
		background.add(Box.createRigidArea(new Dimension(0, 75)));

		background.add(rem);
		background.add(light);
		background.add(deep);
		// current_temp_state.setAlignmentX(Component.CENTER_ALIGNMENT);
		background.add(Box.createRigidArea(new Dimension(0, 100)));
		background.add(change_displayP);

		F.add(background, BorderLayout.CENTER);
		F.add(navPanel(F), BorderLayout.SOUTH);
		viewFrame(F);
	}

	/* Share Screen */
	public static void screen_share() {
		// Icons URLs
		String url_f = ("http://icons.iconarchive.com/icons/mysitemyway/blue-jeans-social-media/128/facebook-icon.png"); // Facebook
		String url_s = ("http://imavex.vo.llnwd.net/o18/clients/imavex/images/Services-ClubWorksite/service-icon-share.png"); // share

		JFrame F = new JFrame("Share");
		// Panels (I'm getting good at this)
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS)); // Vertical
																			// Container
		JPanel postP = new JPanel();
		postP.setLayout(new FlowLayout(FlowLayout.CENTER));
		JPanel iconsP = new JPanel();
		iconsP.setLayout(new BoxLayout(iconsP, BoxLayout.X_AXIS));
		JPanel sharing_iconP = new JPanel();
		sharing_iconP.setLayout(new FlowLayout(FlowLayout.CENTER));
		JPanel backP = new JPanel();
		backP.setLayout(new FlowLayout(FlowLayout.LEADING));

		// Labels and icons
		JLabel label1 = new JLabel("POST TO...");
		postP.add(label1);

		// Add icons to panel #FROM HERE
		JLabel icon_f = getWebIconScaledLabel(url_f, 50, 50);
		JLabel icon_t = getWebIconScaledLabel(url_f, 50, 45);
		JLabel icon_m = getWebIconScaledLabel(url_f, 50, 50);

		iconsP.add(icon_f);
		iconsP.add(icon_t);
		iconsP.add(icon_m);
		// #TO HERE. change to make a loop
		JLabel icon_s = getWebIconScaledLabel(url_s, 50, 50);
		JLabel sharing = new JLabel("Sharing...");
		sharing_iconP.add(icon_s);
		sharing_iconP.add(sharing);

		JButton button_back = new JButton("BACK");
		backP.add(button_back);

		// Add Panels to container
		container.add(postP); // add post panel
		container.add(iconsP);// add icons panel
		iconsP.add(Box.createVerticalGlue()); // add glue
		container.add(sharing_iconP);// add sharing icon
		
		// Actions
		NavPanelBackActionListener action = new NavPanelBackActionListener(F);
		button_back.addActionListener(action);

		F.add(container, BorderLayout.CENTER);
		F.add(backP, BorderLayout.SOUTH);
		viewFrame(F);
	}// end screen_share

	/* About US Screen */
	public static void screen_about() {
		JFrame F = new JFrame("About Us");

		// Panel (BOX LAYOUT)
		JPanel mainP = new JPanel();
		mainP.setLayout(new BoxLayout(mainP, BoxLayout.PAGE_AXIS));

		// Information Panel (BOX LAYOUT) //Can be changed to flow
		JPanel infoP = new JPanel();
		mainP.setLayout(new BoxLayout(mainP, BoxLayout.Y_AXIS));
		// Labels
		JLabel l_about = new JLabel("About US");
		l_about.setFont(new Font(null, Font.BOLD, 20));
		l_about.setForeground(black_midnight);
		JLabel l_info = new JLabel("Information about the company. We are cool guys. We like Pizza.");
		infoP.add(l_about); // Header
		infoP.add(Box.createRigidArea(new Dimension(0, 50)));
		infoP.add(l_info); // paragraph
		l_about.setAlignmentX(Component.CENTER_ALIGNMENT);
		l_info.setAlignmentX(Component.CENTER_ALIGNMENT);
		infoP.setMaximumSize(new Dimension(rx, ry / 3));
		infoP.setOpaque(false);

		// Panel pictures (Box Layout) --Method?--
		JPanel picturesP = new JPanel();
		picturesP.setLayout(new BoxLayout(picturesP, BoxLayout.X_AXIS)); // Horizontal
		String[] pics = { "Sergio", "Stef", "Javi" };
		for (int i = 0; i < pics.length; i++) {
			JLabel l = new JLabel(pics[i]);
			picturesP.add(l);
			picturesP.add(Box.createHorizontalGlue());
			l.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		picturesP.setOpaque(false);

		JPanel buttonP = new JPanel();
		buttonP.setLayout(new BoxLayout(buttonP, BoxLayout.X_AXIS));
		// Create Buttons
		JButton button_accept = new JButton("OK");
		buttonP.add(button_accept);
		button_accept.setAlignmentX(Component.CENTER_ALIGNMENT);

		mainP.add(infoP);
		mainP.add(picturesP);
		mainP.add(Box.createRigidArea(new Dimension(0, 250)));
		mainP.add(buttonP);
		
		// mainP.setBackground(gray_concrete);
		
		//Actions
		AboutUsActionListener action = new AboutUsActionListener(F);
		button_accept.addActionListener(action);

		F.add(mainP);
		viewFrame(F);
	}

	/* Help Screen */
	public static void screen_help() {
		JFrame F = new JFrame("Help");

		// Panel (BOX LAYOUT)
		JPanel mainP = new JPanel();
		mainP.setLayout(new BoxLayout(mainP, BoxLayout.PAGE_AXIS));

		// Information Panel (BOX LAYOUT) //Can be changed to flow
		JPanel infoP = new JPanel();
		mainP.setLayout(new BoxLayout(mainP, BoxLayout.Y_AXIS));
		// Labels
		JLabel l_about = new JLabel("Help");
		l_about.setFont(new Font(null, Font.BOLD, 20));
		l_about.setForeground(black_midnight);
		JLabel l_help = new JLabel("FAQ. HELP. OUI MON AMIE.");

		infoP.add(l_about); // Header
		infoP.add(Box.createRigidArea(new Dimension(0, 50)));
		infoP.add(l_help); // paragraph

		l_about.setAlignmentX(Component.CENTER_ALIGNMENT);
		l_help.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel buttonP = new JPanel();
		buttonP.setLayout(new BoxLayout(buttonP, BoxLayout.X_AXIS));
		// Create Buttons
		JButton button_accept = new JButton("Thank You");
		buttonP.add(button_accept);
		button_accept.setAlignmentX(Component.CENTER_ALIGNMENT);

		mainP.add(infoP);
		mainP.add(buttonP);

		// mainP.setBackground(gray_concrete);
		//Actions
		HelpActionListener action = new HelpActionListener(F);
		button_accept.addActionListener(action);
		
		F.add(mainP);
		viewFrame(F);
	}

	/* Logout Screen */
	public static void screen_logout() {
		JFrame F = new JFrame("Logout");

		JPanel thank_youP = new JPanel();
		thank_youP.setLayout(new FlowLayout(FlowLayout.CENTER));

		JLabel dialog = new JLabel("THANK YOU FOR \nUSING");
		thank_youP.add(dialog);
		// thank_youP.add(Box.createRigidArea(new Dimension(0, 200))); // rigid
		// area to last row

		JButton button_ok = new JButton("OK");

		F.add(thank_youP, BorderLayout.NORTH);
		F.add(bannerPanel(), BorderLayout.CENTER);
		F.add(button_ok, BorderLayout.SOUTH);
		viewFrame(F);
	}

	/* --Frame Properties-- */
	/* View Frame */
	public static void viewFrame(JFrame F) {
		F.setSize(rx, ry);
		F.setVisible(true);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/* --Custom Panels-- */
	/* Banner Panel */
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
		banner.setForeground(black_midnight);
		panel.setBackground(blue_peterriver);

		return panel;
	}

	/* Banner navPanel */
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

		// MIGHT NEED TO ADJUST BANNER MAX SIZE
		panel.setMaximumSize(new Dimension(rx, 50));

		return panel;
	}

	/* Change Display Panel */
	public static JPanel changeDisplayPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		JButton button_week = new JButton("Change to Week");
		JButton button_month = new JButton("Change to Month");
		panel.add(button_week);
		panel.add(Box.createHorizontalGlue());
		panel.add(button_month);
		panel.setOpaque(false); // THIS IS FUCKING GOLD!!!!!!
		return panel;
	}

	/* Set Background Panel */
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
			image.setImage(image.getScaledImage(image.getImage(), rx, ry));
		} else if (opt == 2) {
			image.readImgFromWeb(path);
			image.setImage(image.getScaledImage(image.getImage(), rx, ry));
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

	/* --Custom JLabels-- */
	/* Icon from web w/custom size */
	public static JLabel getWebIconScaledLabel(String web_address, int width, int height) {
		ImageUtilities buffer = new ImageUtilities(); // create instance
		buffer.readImgFromWeb(web_address); // read from url
		Image img = buffer.getImage(); // pull img
		// Create a Label
		img = buffer.getScaledImage(img, width, height);
		JLabel label = new JLabel(new ImageIcon(img));

		return label;
	}

	/* --Image Related-- */
	// Insert and scale image from local path
	public static ImageIcon insertIconScaled(String path, int x, int y) {
		ImageUtilities img = new ImageUtilities();
		img.readFromSource(path);
		img.setImage(img.getScaledImage(img.getImage(), x, y));
		ImageIcon icon = new ImageIcon(img.getImage());
		return icon;
	}

	// Insert and scale image from web (EITHER USE THIS OR
	// getWebIconScaledLabel)
	public static ImageIcon insertWebIconScaled(String web_address, int x, int y) {
		ImageUtilities img = new ImageUtilities(); // create instance
		img.readImgFromWeb(web_address); // read from url
		img.setImage(img.getScaledImage(img.getImage(), x, y));
		ImageIcon icon = new ImageIcon(img.getImage());
		return icon;
	}

	/* --Extra Methods-- */
	public static boolean isValidEmailAddress(String email) {
		// From
		// http://stackoverflow.com/questions/624581/what-is-the-best-java-email-address-validation-method
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}
