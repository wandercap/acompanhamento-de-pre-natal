package view;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class FontsProj {
	public Font unDinaruB;
	public Font unDinaruBM;
	public Font unDinaru;
	public Font RalewayB;
	public Font Raleway;
	public GraphicsEnvironment ge;

	public FontsProj () {
		File und = new File("./fonts/UnDinaru.ttf");
		File undb = new File("./fonts/UnDinaruBold.ttf");
		File ral = new File("./fonts/Raleway-Regular.ttf");
		File ralb = new File("./fonts/Raleway-Bold.ttf");
		try {
			unDinaruB = Font.createFont(Font.TRUETYPE_FONT, undb);
			unDinaru = Font.createFont(Font.TRUETYPE_FONT, und);
			Raleway = Font.createFont(Font.TRUETYPE_FONT, ral);
			RalewayB = Font.createFont(Font.TRUETYPE_FONT, ralb);
		} catch (FontFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		unDinaruBM = unDinaruB.deriveFont(Font.BOLD, 50);
		unDinaruB = unDinaruB.deriveFont(Font.BOLD, 40);
		unDinaru = unDinaru.deriveFont(Font.PLAIN, 15);
		Raleway = Raleway.deriveFont(Font.PLAIN, 20);
		//unDinaruB = unDinaruB.deriveFont(Font.BOLD, 50);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(unDinaruBM);
	    ge.registerFont(unDinaruB);
	    ge.registerFont(unDinaru);
	    ge.registerFont(Raleway);
	}
}
