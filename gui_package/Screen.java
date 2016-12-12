package gui_package;

import javax.swing.*;
import javax.swing.border.Border;

import action_package.*;
import chart_package.HeartChart;
import chart_package.StepChart;
import chart_package.TempChart;
import generator_package.DataGenerator;
import user_package.Database;
import generator_package.WeatherGenerator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * The class that contains all the individual methods of every screen.
 * 
 * @author JSSP Engineers
 * @version 1.0
 */
public class Screen {

	/* Resources */
	/* Resolutions */
	// Resolution taken from an iPhone5 320x568 pixels
	public final static int rx = 340; // horizontal resolution
	public final static int ry = 600; // vertical resolution

	/* Colors */
	// TODO remove colors from here
	public static Color red_alizarin = new Color(231, 76, 60);
	public static Color green_emerald = new Color(46, 204, 113);
	public static Color blue_peterriver = new Color(52, 152, 219);
	public static Color blue_belizehole = new Color(41, 128, 185);
	public static Color purple_amethyst = new Color(155, 89, 182);
	public static Color gray_concrete = new Color(149, 165, 166);
	public static Color black_midnight = new Color(44, 62, 80);
	public static Color white_clouds = new Color(236, 240, 241);

	/* Global Variables */
	public static Database database = Database.getInstance(); // Import
																// Singleton
																// Database
	public static DataGenerator globalGen = null; // empty until called
	
	
	/* Time Variables */
	static Calendar rightNow = Calendar.getInstance();
	static int hour = rightNow.get(Calendar.HOUR_OF_DAY);
	public static int CURRENT_TIME = hour;

	/**
	 * Main method for screen
	 */
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

	/**
	 * Constructor
	 */
	public Screen() {
		JComponentStyle.setCustomFonts(); // Load custom fonts

		screen_login();
		//screen_menu();
	}

	/**
	 * Setting all the variables for the login screen
	 */
	public static void screen_login() {
		Border border_default = BorderFactory.createLineBorder(Color.BLACK);
		JFrame F = new JFrame("Log-In");

		// Panel (BOX LAYOUT)
		JPanel listP = new JPanel();
		listP.setLayout(new BoxLayout(listP, BoxLayout.PAGE_AXIS));

		// Panel bottom about us (BOX LAYOUT) ----Method?----
		JPanel BottomP = new JPanel();
		BottomP.setLayout(new BoxLayout(BottomP, BoxLayout.X_AXIS));
		// Create Buttons
		JButton button_about = JComponentStyle.JButtonFlat("ABOUT US");
		JButton button_help = JComponentStyle.JButtonFlat("HELP");
		// Add to panel with glue between two buttons
		BottomP.add(Box.createRigidArea(new Dimension(0, 40)));
		BottomP.add(button_about);
		BottomP.add(Box.createHorizontalGlue());
		BottomP.add(button_help);
		BottomP.setOpaque(false);
		// ----Method?---- Panel bottom about us (BOX LAYOUT)

		// Login Text Field
		JTextField t_login = new JTextField(20);
		t_login.setBorder(border_default); // login text field
		t_login.setMaximumSize(new Dimension(200, 20)); // login dimension

		// Labels
		JLabel l_sign = new JLabel("Sign In");
		l_sign.setFont(new Font("Orkney-Regular", Font.PLAIN, 26));
		l_sign.setForeground(black_midnight);

		JLabel l_enter = new JLabel("(Enter your e-mail)");
		l_enter.setFont(JComponentStyle.oarkney_reg.deriveFont(14f));
		l_enter.setForeground(gray_concrete);

		// Buttons
		JButton button_accept = JComponentStyle.JButtonFlat("DONE");

		// Add components and span.
		listP.add(Box.createRigidArea(new Dimension(0, ry / 4)));
		listP.add(l_sign); // Sign in label
		listP.add(Box.createRigidArea(new Dimension(0, 20)));
		listP.add(t_login); // Text Field
		listP.add(Box.createRigidArea(new Dimension(0, 6)));
		listP.add(l_enter); // Enter your email
		listP.add(Box.createRigidArea(new Dimension(0, 40)));
		listP.add(button_accept);

		// Align every component (-.-)
		l_sign.setAlignmentX(Component.CENTER_ALIGNMENT);
		t_login.setAlignmentX(Component.CENTER_ALIGNMENT);
		l_enter.setAlignmentX(Component.CENTER_ALIGNMENT);
		button_accept.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Actions
		LoginActionListener action = new LoginActionListener(t_login, F);
		button_accept.addActionListener(action);
		// TODO Create an key listener for enter (Harder than it seems!)
		button_about.addActionListener(new LoginAboutUsActionListener(F));
		button_help.addActionListener(new LoginHelpActionListener(F));
		// Change Color Action
		t_login.addMouseListener(new LoginMouseAdapter(t_login));

		// Frames
		F.add(CustomJPanels.bannerPanel(), BorderLayout.NORTH);
		F.add(listP); // First row
		F.add(BottomP, BorderLayout.SOUTH);
		viewFrame(F);
	}// End sign-in screen

	/**
	 * Setting all the variables for the register screen
	 */
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
			// JLabel l = JComponentStyle.JLabelFormStyle(labels[i]);

			springP.add(l);
			t_array[i] = new JTextField(20); // new field
			l.setLabelFor(t_array[i]);
			l.setFont(JComponentStyle.oarkney_reg.deriveFont(12f));
			springP.add(t_array[i]);
			t_array[i].setBorder(border_default); // Border color
			t_array[i].setMaximumSize(new Dimension(280, 8)); // Max border
			t_array[i].addMouseListener(new LoginMouseAdapter(t_array[i])); // Action
			if (i == numPairs - 1) { // Change email label
				t_array[i].setText(LoginActionListener.returnValidEmail());
			}
		}

		// makeGrid(panel, nCols, nRows, init x, init y, xpad, ypad)
		SpringUtilities.makeGrid(springP, numPairs, 2, 6, 6, 6, 30);

		// Bottom panels
		JPanel bottomP = new JPanel(); // Will use 2 rows
		bottomP.setLayout(new BoxLayout(bottomP, BoxLayout.Y_AXIS)); // Vertical

		// Create buttons
		JButton button_accept = JComponentStyle.JButtonFlat("ACCEPT");
		JButton button_back = JComponentStyle.JButtonFlat("BACK");
		JButton button_help = JComponentStyle.JButtonFlat("HELP");

		// Navigation panel for last row
		JPanel navP = new JPanel(); // Will have back and help buttons
		navP.setLayout(new BoxLayout(navP, BoxLayout.X_AXIS)); // Horizontal

		// Add springP to ContainerP (for spacing options)
		containerP.add(Box.createRigidArea(new Dimension(0, 35))); // Add space
		containerP.add(springP); // Add form panel

		// Add buttons, properties and spaces to Bottom panel
		bottomP.add(button_accept);
		button_accept.setAlignmentX(Component.CENTER_ALIGNMENT);
		bottomP.add(Box.createRigidArea(new Dimension(0, 100))); // Raise Accept
																	// Button
		// Add NavPanel
		navP.add(button_back);
		navP.add(Box.createHorizontalGlue());
		navP.add(button_help);
		navP.add(Box.createRigidArea(new Dimension(0, 40))); // rigid area to
																// raise buttons
		// Add last row panel to bottom panel
		bottomP.add(navP);

		// Actions
		RegisterAcceptActionListener action = new RegisterAcceptActionListener(t_array, F);
		button_accept.addActionListener(action);
		button_back.addActionListener(new RegisterBackActionListener(F));
		button_help.addActionListener(new RegisterHelpActionListener(F));

		// Set panels to the Frame
		F.add(CustomJPanels.bannerPanel(), BorderLayout.NORTH);
		F.add(containerP, BorderLayout.EAST);
		F.add(bottomP, BorderLayout.SOUTH);
		viewFrame(F);
	}// end screen_register

	/**
	 * Setting all the variables for the home screen
	 */
	public static void screen_home() {
		JFrame FH = new JFrame("Homepage");
//		JPanel background = weather;
		// Panel for information (BOX LAYOUT)
		JPanel P = new JPanel();
		P.setLayout(new BoxLayout(P, BoxLayout.PAGE_AXIS));
		P.add(Box.createRigidArea(JComponentStyle.dimension_margin_banner));
		// Panel for Buttons (FLOW LAYOUT)
		JPanel buttonP = new JPanel();
		buttonP.setLayout(new FlowLayout());

		// Personal Information (Fetch from database)
		Database db = Database.getInstance();
		String name = db.getCurrentUser().getName();

		// Strings for Labels
		String welcome = name + "'s Daily Feed";
		String time = fixedTime();

		// Weather Label
		WeatherGenerator weather = new WeatherGenerator();
		JLabel weatherIcon = weather.generateWeather();
		JLabel label_weather = JComponentStyle.JLabelStyle(weather.getStatus());
		weatherIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_weather.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Graph Image
		JLabel graph = new JLabel();
		graph.setIcon(insertWebIconScaled("http://i.imgur.com/i6svYaH.png", 230, 230));
		graph.setAlignmentX(Component.CENTER_ALIGNMENT);
		P.add(graph);

		// Labels
		JLabel label_welcome = JComponentStyle.JLabelStyle(welcome);
		label_welcome.setFont(new Font(null, 0, 18));
		label_welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel label_time = JComponentStyle.JLabelStyle(time);
		label_time.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Disabled because it bugs the whole APP
		// Real Graph (Box Layout)
		// JPanel graph = new JPanel();
		// graph = HomeChart.drawChart();

		// Add Components 
		P.add(label_welcome);
		P.add(Box.createRigidArea(JComponentStyle.dimension_component_small));
		P.add(weatherIcon);
		P.add(label_weather);
		P.add(Box.createRigidArea(JComponentStyle.dimension_component_medium));
		P.add(graph); // Add graph
		P.add(Box.createRigidArea(JComponentStyle.dimension_component_huge));
		P.add(label_time); // Time label at the bottom

		// Actions
		ShowMenuActionListener action = new ShowMenuActionListener(FH);

		// Menu Panel (Contains Menu Button)
		JPanel menuP = CustomJPanels.menuButtonPanel("Menu", action, gray_concrete);

		// Add panels to frame
		FH.add(P, BorderLayout.CENTER);
		FH.add(CustomJPanels.bannerPanel(), BorderLayout.NORTH);
		// Button panel
		FH.add(menuP, BorderLayout.SOUTH);
		viewFrame(FH);
	}

	/**
	 * Setting all the variables for the menu screen
	 */
	public static void screen_menu() {
		// TODO Delete personal info:
		// Personal Information (Fetch from database)
		// Database db = Database.getInstance();
		// String un = db.getCurrentUser().getName();
		// String msg = (un+"'s Home");

		JFrame F = new JFrame("Menu");
		// Panel for information (BOX LAYOUT)
		JPanel P_margin = new JPanel();
		P_margin.setLayout(new BoxLayout(P_margin, BoxLayout.PAGE_AXIS));

		// Create JPanels that contains the menu buttons 1panel = 1button
		JPanel heart = CustomJPanels.menuButtonPanel("Heart", new HomeMenuActionListener(F, 0), red_alizarin);
		JPanel steps = CustomJPanels.menuButtonPanel("Steps", new HomeMenuActionListener(F, 1), green_emerald);
		JPanel temp = CustomJPanels.menuButtonPanel("Temperature", new HomeMenuActionListener(F, 2),
				JComponentStyle.orange_carrot);
		JPanel sleep = CustomJPanels.menuButtonPanel("Sleep", new HomeMenuActionListener(F, 3), purple_amethyst);
		JPanel logout = CustomJPanels.menuButtonPanel("Log Out", new HomeMenuActionListener(F, 4), gray_concrete);

		// ADD BUTTONS
		P_margin.add(Box.createRigidArea(new Dimension(0, 70))); // up
		P_margin.add(heart);
		P_margin.add(Box.createRigidArea(new Dimension(0, 10)));
		P_margin.add(steps);
		P_margin.add(Box.createRigidArea(new Dimension(0, 10)));
		P_margin.add(temp);
		P_margin.add(Box.createRigidArea(new Dimension(0, 10)));
		P_margin.add(sleep);
		P_margin.add(Box.createRigidArea(new Dimension(0, 100))); // bottom
		P_margin.add(logout);

		// TODO change temp to one from database
		F.add(CustomJPanels.HomeMenuBannerPanel("Main Menu"), BorderLayout.NORTH);
		F.add(P_margin, BorderLayout.CENTER);
		viewFrame(F);

	}

	/**
	 * Setting all the variables for the heart rate screen
	 */
	public static void screen_heart() {
		JFrame F = new JFrame("Heartbeat");
		JPanel background = CustomJPanels.backgroundPanel("http://i.imgur.com/lfO5NWd.jpg", 3);

		// Activity Panel
		JPanel banner = CustomJPanels.activityBannerPanel2("Heart Rate", red_alizarin, white_clouds);
		
		// Display Panel
		JPanel displayP = new JPanel();
		displayP.setLayout(new BoxLayout(displayP, BoxLayout.X_AXIS));
		JButton button_week = new JButton("Change to Week");
		JButton button_month = new JButton("Change to Month");
		displayP.add(button_week);
		displayP.add(Box.createHorizontalGlue());
		displayP.add(button_month);
		displayP.setOpaque(false);

		// Local Variables from global generator
		int restHB = globalGen.heart.getRestHR();
		String status = globalGen.heart.getRestHeartStatus(restHB);

		// Strings and Labels
		String s1 = ("<html>Current Rate:<br>" + restHB+" BPM");
		String s2 = ("<html>Health State:<br>" + status);
		
		//Create Centered Text Panels
		JPanel c1 = CustomJPanels.centeredTextPanel(s1, 110, white_clouds);
		JPanel c2 = CustomJPanels.centeredTextPanel(s2, 110, white_clouds);

		//Add components to background
		background.add(banner);
		background.add(Box.createRigidArea(new Dimension(0, 50))); //After banner
		background.add(c1);		//Text Panel
		background.add(Box.createRigidArea(new Dimension(0, 30)));  //Set 30 between Components
		background.add(c2);		//Text2 Panel
		background.add(Box.createRigidArea(new Dimension(0, 250)));
		background.add(displayP);	//Display Panel

		// Actions
		WeekHeartActionListener action = new WeekHeartActionListener(F);
		button_week.addActionListener(action);
		MonthHeartActionListener action2 = new MonthHeartActionListener(F);
		button_month.addActionListener(action2);

		F.add(background, BorderLayout.CENTER);
		F.add(CustomJPanels.navPanel(F, red_alizarin), BorderLayout.SOUTH);
		viewFrame(F);
	}

	/**
	 * Setting all the variables for the temperature screen
	 */
	public static void screen_temperature() {
		JFrame F = new JFrame("Temperature");
		JPanel background = CustomJPanels.backgroundPanel("http://i.imgur.com/NsNNMH9.jpg", 3);

		// Activity Banner
		JPanel banner = CustomJPanels.activityBannerPanel2("Body Temperature", JComponentStyle.orange_carrot,
				Color.WHITE);
		// Display Panel
		JPanel displayP = new JPanel();
		displayP.setLayout(new BoxLayout(displayP, BoxLayout.X_AXIS));
		JButton button_week = new JButton("Change to Week");
		JButton button_month = new JButton("Change to Month");
		displayP.add(button_week);
		displayP.add(Box.createHorizontalGlue());
		displayP.add(button_month);
		displayP.setOpaque(false);

		// Local Variables from global generator
		double currentTemp = globalGen.temp.getCurrentTemperature(CURRENT_TIME);
		String status = globalGen.temp.getTempStatus(currentTemp);

		// Strings
		String s1 = String.format("<html>Current Temperature:<br>%.1fC</html>", currentTemp);
		String s2 = String.format("<html>Body Temperature State:<br>" + status + "</html>");
		
		//Create Centered Text Panels
		JPanel c1 = CustomJPanels.centeredTextPanel(s1, 80 , Color.BLACK);
		JPanel c2 = CustomJPanels.centeredTextPanel(s2, 75, Color.BLACK);
		
		//Add components to background
		background.add(banner);
		background.add(Box.createRigidArea(new Dimension(0, 50))); //After banner
		background.add(c1);		//Text Panel
		background.add(Box.createRigidArea(new Dimension(0, 30)));  //Set 30 between Components
		background.add(c2);		//Text2 Panel
		background.add(Box.createRigidArea(new Dimension(0, 250)));
		background.add(displayP);	//Display Panel

		// Actions
		WeekTempActionListener action = new WeekTempActionListener(F);
		button_week.addActionListener(action);
		MonthTempActionListener action2 = new MonthTempActionListener(F);
		button_month.addActionListener(action2);

		F.add(background, BorderLayout.CENTER);
		F.add(CustomJPanels.navPanel(F, JComponentStyle.orange_carrot), BorderLayout.SOUTH);
		viewFrame(F);
	}

	/**
	 * Setting all the variables for the steps screen
	 */
	public static void screen_steps() {
		JFrame F = new JFrame("Steps");
		JPanel background = CustomJPanels.backgroundPanel("http://i.imgur.com/WE42U3p.jpg", 3);

		// Activity Banner Panel
		JPanel banner = CustomJPanels.activityBannerPanel2("Steps", green_emerald, white_clouds);
		
		// Change Display Panel
		JPanel displayP = new JPanel();
		displayP.setLayout(new BoxLayout(displayP, BoxLayout.X_AXIS));
		JButton button_week = new JButton("Change to Week");
		JButton button_month = new JButton("Change to Month");
		displayP.add(button_week);
		displayP.add(Box.createHorizontalGlue());
		displayP.add(button_month);
		displayP.setOpaque(false);

		// Local Variables from global generator
		DecimalFormat df = new DecimalFormat("#.##");
		double currentDistance = globalGen.steps.getCurrentDistance(CURRENT_TIME);
		int currentSteps = (int) globalGen.steps.getCurrentSteps(currentDistance);

		// Strings
		String s1 = ("<html>Current Number of Steps: <br>" + currentSteps + "</html>");
		String s2 = ("<html>Current Distance Traveled:<br>" + df.format(currentDistance) + " Km</html>");

		//Create Centered Text Panels
		JPanel c1 = CustomJPanels.centeredTextPanel(s1, 60, Color.BLACK);
		JPanel c2 = CustomJPanels.centeredTextPanel(s2, 60, Color.BLACK);
				
		//Add components to background
		background.add(banner);
		background.add(Box.createRigidArea(new Dimension(0, 30))); //After banner
		background.add(c1);		//Text Panel
		background.add(Box.createRigidArea(new Dimension(0, 10)));  //Set 30 between Components
		background.add(c2);		//Text2 Panel
		background.add(Box.createRigidArea(new Dimension(0, 290)));
		background.add(displayP);	//Display Panel

		// Actions
		WeekStepsActionListener action = new WeekStepsActionListener(F);
		button_week.addActionListener(action);
		MonthStepsActionListener action2 = new MonthStepsActionListener(F);
		button_month.addActionListener(action2);

		F.add(background, BorderLayout.CENTER);
		F.add(CustomJPanels.navPanel(F,green_emerald), BorderLayout.SOUTH);
		viewFrame(F);
	}

	/**
	 * Setting all the variables for the sleep screen
	 */
	public static void screen_sleep() {
		JFrame F = new JFrame("Sleep");

		JPanel background = CustomJPanels.backgroundPanel("http://i.imgur.com/mX0ybeL.jpg", 3);

		// Local Variables from global generator
		int totalSleep = globalGen.sleep.getTotalSleep();
		double cycles = globalGen.sleep.getTotalCycles();
		int light = globalGen.sleep.getLightSleep();
		int normal = globalGen.sleep.getNormalSleep();
		int deep = globalGen.sleep.getDeepSleep();

		// Strings
		String s1 = ("<html>Total Time:<br>" + totalSleep+" Min");
		String s2 = ("<html>Total Cycles:<br>" + cycles+" Blocks");
		String s3 = ("<html>Total Light Sleep:<br>" + light+" Min");
		String s4 = ("<html>Total Normal Sleep:<br>" + normal+" Min");
		String s5 = ("<html>Total Deep Sleep:<br>" + deep+" Min");
		

		//Create Centered Text Panels
		JPanel c1 = CustomJPanels.centeredTextPanel(s1, 120, white_clouds);
		JPanel c2 = CustomJPanels.centeredTextPanel(s2, 120, white_clouds);
		JPanel c3 = CustomJPanels.centeredTextPanel(s3, 80, white_clouds);
		JPanel c4 = CustomJPanels.centeredTextPanel(s4, 75, white_clouds);
		JPanel c5 = CustomJPanels.centeredTextPanel(s5, 80, white_clouds);
		
		// Activity Banner Panel
		JPanel banner = CustomJPanels.activityBannerPanel2("Sleep", purple_amethyst, white_clouds);
		
		// Display Panel NO CHARTS FOR SLEEP QUALITY 

		//Add components to background
		background.add(banner);
		background.add(Box.createRigidArea(new Dimension(0, 40))); //After banner
		background.add(c1);		//Text Panel
		background.add(Box.createRigidArea(new Dimension(0, 30)));  //Set 30 between Components
		background.add(c2);		//Text2 Panel
		background.add(Box.createRigidArea(new Dimension(0, 90)));
		background.add(c3);		//Light
		background.add(Box.createRigidArea(new Dimension(0, 10)));
		background.add(c4);		//Normal
		background.add(Box.createRigidArea(new Dimension(0, 10)));
		background.add(c5);		//Deep
		
		// Action NO ACTIONS FOR SLEEP QUALITY 

		F.add(background, BorderLayout.CENTER);
		F.add(CustomJPanels.navPanel(F, purple_amethyst), BorderLayout.SOUTH);
		viewFrame(F);
	}

	/**
	 * Setting variables for the customView screen
	 * 
	 * @param opt
	 *            integer that changes the chooses which graph is being shown
	 */
	public static void screen_customView(int opt) {
		JFrame F = new JFrame("Custom View");

		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		// Buttons
		JButton button_back = new JButton("BACK");

		// Graph Panel
		/**
		 * OPT => Heart Day Week Month 0,1,2 Steps Week Month 3,4 Temp Week
		 * Month 5,6 Sleep Week Month 7,8 Extras: Heart All xx
		 */

		JPanel graph = new JPanel();

		switch (opt) {
		case 0: // Day Graph Heart
			graph = HeartChart.drawChart(4);
			break;
		case 1: // Weekly Graph Heart
			graph = HeartChart.drawChart(2);
			break;
		case 2: // Monthly Graph Heart
			graph = HeartChart.drawChart(1);
			break;
		case 3: // Weekly Graph Steps
			graph = StepChart.drawChart(2);
			break;
		case 4: // Monthly Graph Steps
			graph = StepChart.drawChart(4); // <- intentionally
			break;
		case 5: // Weekly Graph Temperature
			graph = TempChart.drawChart(2);
			break; // <-Never forger a break OK? THANKS
		case 6: // Month
			graph = TempChart.drawChart(1);
			break;
		case 7: // Week Sleep (2)
			break;
		case 8: // Month Sleep (1)
		}// end switch

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Chart.heartChart(4); //run something, ask the professor why
				HeartChart.drawChart(4);
			}
		});

		// Add Components to container
		container.add(graph);
		container.add(Box.createVerticalGlue()); // add glue
		container.add(button_back);
		button_back.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Actions
		HomeMenuActionListener action = new HomeMenuActionListener(F, 0);
		;
		if (opt <= 2)
			action = new HomeMenuActionListener(F, 0); // hb
		else if (opt == 3 || opt == 4)
			action = new HomeMenuActionListener(F, 1);
		else if (opt == 5 || opt == 6)
			action = new HomeMenuActionListener(F, 2);
		else if (opt == 7 || opt == 8)
			action = new HomeMenuActionListener(F, 3);
		button_back.addActionListener(action);

		F.add(container, BorderLayout.CENTER);
		viewFrame(F);
	}

	/**
	 * Setting all the variables for the share screen
	 */
	public static void screen_share() {
		// Icons URLs
		String url_f = ("http://i.imgur.com/XwSlom6.png"); // Facebook
		String url_s = ("http://imavex.vo.llnwd.net/o18/clients/imavex/images/Services-ClubWorksite/service-icon-share.png"); // share
		String url_twitter = "http://i.imgur.com/Di4pUXg.png";
		String url_blogger = ("http://i.imgur.com/a1YIx9G.png");

		JFrame F = new JFrame("Share");
		// Banner Panel
		JPanel banner = CustomJPanels.activityBannerPanel2("Share", Color.BLACK, white_clouds);
		// Panels (I'm getting good at this) r
		JPanel container = new JPanel(); // Container
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

		JPanel iconsP = new JPanel(); // First row of icons
		iconsP.setLayout(new BoxLayout(iconsP, BoxLayout.X_AXIS));

		JPanel sharing_iconP = new JPanel(); // Sharing row
		sharing_iconP.setLayout(new FlowLayout(FlowLayout.CENTER));

		// Icons from web
		JLabel icon_f = getWebIconScaledLabel(url_f, 50, 50);
		JLabel icon_t = getWebIconScaledLabel(url_twitter, 50, 50);
		JLabel icon_blog = getWebIconScaledLabel(url_blogger, 50, 50);
		JLabel icon_share = getWebIconScaledLabel(url_s, 50, 50);

		// Add icons to panel
		iconsP.add(icon_f);
		iconsP.add(Box.createRigidArea(new Dimension(40, 0)));
		iconsP.add(icon_t);
		iconsP.add(Box.createRigidArea(new Dimension(40, 0)));
		iconsP.add(icon_blog);

		// Add sharing icons to icons panel
		JLabel sharing = new JLabel("  Now Sharing...");
		sharing.setFont(new Font("Heebo-Medium", Font.PLAIN, 16));
		sharing_iconP.add(icon_share);
		sharing_iconP.add(sharing);

		// Add Panels to container
		container.add(Box.createRigidArea(new Dimension(0, 100))); // Top
		container.add(iconsP);// add icons panel
		iconsP.add(Box.createVerticalGlue()); // add glue
		container.add(sharing_iconP);// add sharing icon

		// Actions
		NavPanelBackActionListener action = new NavPanelBackActionListener(F);
		JPanel backP = CustomJPanels.menuButtonPanel("Home", action, Color.BLACK);

		F.add(banner, BorderLayout.NORTH);
		F.add(container, BorderLayout.CENTER);
		F.add(backP, BorderLayout.SOUTH);

		viewFrame(F);
	}// end screen_share

	/**
	 * Setting all the variables for the about us screen
	 */
	public static void screen_about() {
		JFrame F = new JFrame("About Us");
		// Banner Panel
		JPanel banner = CustomJPanels.activityBannerPanel2("About Us", Color.BLACK, white_clouds);
		// Panels 
		JPanel container = new JPanel(); // Container
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		
		//Labels general
		String s_intro = "<html>This program was developed by three future software engineers:</html>";
		String s_general = ("<html>And together we are:<br> JSSP Engeineers!<br><br>"
				+ "You might be wondering why is there a 'P' at the end, and that stands up for PIZZA, "
				+ "which is the most magical element that you can add to any team to make it fabulous!<br></html>");
		JLabel intro = JComponentStyle.JLabelStyle("<html><div style='text-align: center;'>" + s_intro + "</div></html>");
		JLabel general = JComponentStyle.JLabelStyle("<html><div style='text-align: center;'>" + s_general + "</div></html>");
		
		JLabel general2 = JComponentStyle.JLabelStyle("<html>After finishing this project made on Java, we plan on porting"
				+ "It to Android, so we can start getting involved in Mobile Apps<br><br>"
				+ "Here are some random facts about us:</html>");
		//Labels for names
		JLabel javi = JComponentStyle.JLabelStyle("Javier: ");
		JLabel javi2 = JComponentStyle.JLabelStyle("<html>I build<br>cars!</html>");
		JLabel stef = JComponentStyle.JLabelStyle("Stefany: ");
		JLabel stef2 = JComponentStyle.JLabelStyle("<html>I sing at <br>coffe<br>shops!");
		JLabel serg = JComponentStyle.JLabelStyle("Sergio: ");
		JLabel serg2 = JComponentStyle.JLabelStyle("<html>I am a<br>Pokemon<br> master!");
		
		//JPanel for names
		JPanel namesP = new JPanel(); // First row of icons
		namesP.setLayout(new BoxLayout(namesP, BoxLayout.X_AXIS));
		//Add names to panel
		namesP.add(javi);
		namesP.add(Box.createHorizontalGlue());
		namesP.add(stef);
		namesP.add(Box.createHorizontalGlue());
		namesP.add(serg);
		
		//JPanel for photos
		JPanel factsP = new JPanel(); // First row of icons
		factsP.setLayout(new BoxLayout(factsP, BoxLayout.X_AXIS));
		factsP.add(javi2);
		factsP.add(Box.createRigidArea(new Dimension(20, 0)));
		factsP.add(Box.createHorizontalGlue());
		factsP.add(stef2);
		factsP.add(Box.createHorizontalGlue());
		factsP.add(Box.createRigidArea(new Dimension(20, 0)));
		factsP.add(serg2);

		// Panel pictures (Box Layout) --Method?--
		JPanel picturesP = new JPanel();
		picturesP.setLayout(new BoxLayout(picturesP, BoxLayout.X_AXIS)); // Horizontal
		String[] pics = { "PICTURE1", "PICTURE1", "PICTURE1" };
		for (int i = 0; i < pics.length; i++) {
			JLabel l = new JLabel(pics[i]);
			picturesP.add(l);
			picturesP.add(Box.createHorizontalGlue());
			l.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		picturesP.setOpaque(false);
		
		//Add components to container
		container.add(Box.createRigidArea(new Dimension(0, 20))); //Top
		container.add(intro);
		intro.setAlignmentX(Component.CENTER_ALIGNMENT);
		container.add(Box.createRigidArea(new Dimension(0, 15))); //Before Photos
		container.add(namesP);	//Names Panel
		container.add(picturesP); //Pictures Panel
		container.add(factsP);	//Random Facts Panel
		//container.add(general2);
		container.add(Box.createRigidArea(new Dimension(0, 20))); //Between
		container.add(general);
		
		
		//Center everything..
		general.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//general2.setAlignmentX(Component.CENTER_ALIGNMENT);
		

		// Actions
		AboutUsActionListener action = new AboutUsActionListener(F);
		JPanel backP = CustomJPanels.menuButtonPanel("Okay", action, JComponentStyle.gray_space);
		
		F.add(banner, BorderLayout.NORTH);
		F.add(container, BorderLayout.CENTER);
		F.add(backP, BorderLayout.SOUTH);
		
		viewFrame(F);
	}

	// HELP TOO
	/**
	 * Setting all the variables for the help screen
	 */
	public static void screen_help() {
		JFrame F = new JFrame("Help");
		//Banner
		JPanel banner = CustomJPanels.activityBannerPanel2("HELP", Color.BLACK, white_clouds);
		// Panels 
		JPanel container = new JPanel(); // Container
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		

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

		
		// Actions
		HelpActionListener action = new HelpActionListener(F);
		JPanel backP = CustomJPanels.menuButtonPanel("Thanks", action, JComponentStyle.gray_space);
		
		// Add to frame
		F.add(banner, BorderLayout.NORTH);
		F.add(container, BorderLayout.CENTER);
		F.add(backP, BorderLayout.SOUTH);
		
		viewFrame(F);
	}

	/**
	 * Setting all the variables for the logout screen
	 */
	public static void screen_logout() {
		JFrame F = new JFrame("Logout");

		// Banner Panel
		JPanel banner = CustomJPanels.activityBannerPanel2("Sign out", JComponentStyle.gray_space, white_clouds);

		// Cuttest Dog
		String cuteDogUrl = "http://i.imgur.com/jqUFXld.png";

		JPanel container = new JPanel(); // Container
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

		JLabel dialog = new JLabel("Thank You!");
		dialog.setFont(new Font("Orkney-Regular", Font.PLAIN, 26));
		JLabel dialog2 = new JLabel("See you soon!");
		dialog2.setFont(new Font("Orkney-Regular", Font.PLAIN, 26));
		JLabel cuteDog = getWebIconScaledLabel(cuteDogUrl, 262, 135);
		
		container.add(Box.createRigidArea(new Dimension(0, 50))); // Top
		container.add(dialog);
		dialog.setAlignmentX(Component.CENTER_ALIGNMENT);
		container.add(Box.createRigidArea(new Dimension(0, 50))); 
		dialog2.setAlignmentX(Component.CENTER_ALIGNMENT);
		container.add(dialog2);
		container.add(Box.createVerticalGlue());
		container.add(cuteDog);
		cuteDog.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Actions
		LogoutAcceptActionListener action = new LogoutAcceptActionListener(F);
		JPanel button_ok = CustomJPanels.menuButtonPanel("Accept", action, JComponentStyle.gray_space);

		F.add(banner, BorderLayout.NORTH);
		F.add(container, BorderLayout.CENTER);
		F.add(button_ok, BorderLayout.SOUTH);
		viewFrame(F);
	}

	/* --Frame Properties-- */

	/**
	 * Method to show the frame on the display
	 * 
	 * @param F
	 *            sets what frame will be shown
	 */
	public static void viewFrame(JFrame F) {
		F.setSize(rx, ry);
		F.setVisible(true);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	/* --Custom JLabels-- */

	/**
	 * Setting all the variables for the icons in the panels
	 * 
	 * @param web_address
	 *            link for the icon
	 * @param width
	 *            setting width
	 * @param height
	 *            setting height
	 * @return JLabel icon
	 */
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
	/**
	 * Inserts and scales image from local path
	 * 
	 * @param path
	 *            passes the local path
	 * @param x
	 *            sets width
	 * @param y
	 *            sets height
	 * @return ImageIcon image of icon
	 */
	public static ImageIcon insertIconScaled(String path, int x, int y) {
		ImageUtilities img = new ImageUtilities();
		img.readFromSource(path);
		img.setImage(img.getScaledImage(img.getImage(), x, y));
		ImageIcon icon = new ImageIcon(img.getImage());
		return icon;
	}

	/**
	 * Inserts and scales image from web
	 * 
	 * @param web_address
	 *            path passes from web site link
	 * @param x
	 *            sets width
	 * @param y
	 *            sets height
	 * @return ImageIcon image of icon
	 */
	public static ImageIcon insertWebIconScaled(String web_address, int x, int y) {
		ImageUtilities img = new ImageUtilities(); // create instance
		img.readImgFromWeb(web_address); // read from url
		img.setImage(img.getScaledImage(img.getImage(), x, y));
		ImageIcon icon = new ImageIcon(img.getImage());
		return icon;
	}

	/* --Extra Methods-- */
	/**
	 * Method checks that the email address has the right format as an email
	 * 
	 * @param email
	 *            passes the email to be checked
	 * @return boolean; true is email is valid, false is otherwise
	 */
	public static boolean isValidEmailAddress(String email) {
		// From
		// http://stackoverflow.com/questions/624581/what-is-the-best-java-email-address-validation-method
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	/** Fix Time
	 * @return Time in a String format */
	public static String fixedTime(){
		Calendar cal = Calendar.getInstance();
		int hour = rightNow.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		if(minute<10){
			String fixed = hour +":0"+minute;
			return fixed;
		}
		return hour +":"+minute;
	}
}
