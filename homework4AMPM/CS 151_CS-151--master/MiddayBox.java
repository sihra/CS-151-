import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.javafx.geom.Rectangle;

public class MiddayBox extends JPanel{
	int x;
	int y;
	private JLaybel textAM;
	private JPanel panelAM;
	
	private JLaybel textPM;
	private JPanel panelPM;
	
	public MiddayBox(int x, int y) {
		this.x = x;
		this.y = y;
		// Creates a panel for the AM box
		panelAM = new JPanel();
		//panelAM.setBounds(0, 0, 27, 25);
		
		textAM = new JLaybel("AM");
		//textAM.setBounds(0, 0, 26, 24);
		panelAM.add(textAM);
		
		// Creates a panel for the PM box
		panelPM = new JPanel();
		//panelPM.setBounds(0, 0, 54, 50);
		
		textPM = new JLaybel("PM");
		//textPM.setBounds(26, 0, 26, 24);
		panelPM.add(textPM);
		
		// Adds the two panels to this panel for a flow layout
		FlowLayout flow = new FlowLayout();
		this.setLayout(flow);
		this.add(panelAM);
		this.add(panelPM);
		this.setBounds(x,y,54,50);
	}
	
	/**
	 * Method that updates the AM/PM box with the color pink if AM or PM
	 * @param time - 24 hour time
	 */
	public void update(int time) {
		if(time > 12){
			panelAM.setBackground(Color.PINK);
			panelPM.setBackground(Color.WHITE);
		}else {
			panelPM.setBackground(Color.PINK);
			panelAM.setBackground(Color.WHITE);
		}
		repaint();
	}
	
	/**
	 * Paint method that paints the box
	 */
	  public void paint(Graphics g)
	   {
	      super.paint(g);
		  /*
	      Graphics2D g2 = (Graphics2D) g;
	      
	      Rectangle2D.Double boxAM = new Rectangle2D.Double(0, 0, 27, 25);
	      g2.setColor(Color.WHITE);
	      g2.fill(boxAM);
	      
	      Rectangle2D.Double boxPM = new Rectangle2D.Double(0, 0, 27, 25);
	      g2.setColor(Color.WHITE);
	      g2.fill(boxPM);
	      */

	   }


}
