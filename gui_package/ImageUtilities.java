package gui_package;

import java.awt.Graphics;

/* Has multiple utilities for image manipulation.
 * Class will be used for pulling images from Internet and creating icons.
 * Using this method it is easier to develop from different machines without
 * the need of having the images at the physical location. Note that pulling
 * images from internet is "slower" than running it from a local drive.
 */

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ImageUtilities {
	Image img;

	public ImageUtilities() {
		this.img = null;
	}

	// Reads an image from the web
	public void readImgFromWeb(String url) {
		try {
			URL url_1 = new URL(url);
			this.img = ImageIO.read(url_1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Reads an image from a local path C\Users\blah
	public void readFromSource(String path) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(path)); 				
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.img = img;
	}

	// Pulls the image once loaded from web
	public Image getImage() {
		return this.img;
	}
	
	//Sets the image
	public void setImage(Image img){
		this.img = img;
	}

	// Resizes any image
	public Image getScaledImage(Image srcImg, int w, int h) {
		/* Method from:
		 * http://stackoverflow.com/questions/6714045/how-to-resize-jlabel-
		 * imageicon
		 */
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}// end getScaledImage

	//Creates a backgroundPanel
	public JPanel setBackgroundPanelImage(Image backgound_image) {
		this.img = backgound_image;
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img, 0, 0, null);
			}// end @override paintComponent
		};// end new JPanel
		return panel;
	}

}// end class
