import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;




//this will need to be rotated
public class ClockHand extends JPanel implements MoveableShape {
	private double m_angle;//angle in degrees of this clock hand
	private double m_length;//length of the clock hand
	private int m_x;
	private int m_y;
	private int m_width;
	private Color m_color;
	private int m_thickness;
	public ClockHand(int x, int y, int width) {
		//almost identical to clockFace, since these will likely be used in close conjunction
		m_x = x;
		m_y = y;
		m_width = width;
		setOpaque(false);
		setPreferredSize(new Dimension(m_width,m_width));
		m_angle=0;
		m_length=width/4;
		m_thickness = 1;
		m_color = Color.BLACK;
	}
	public ClockHand(int x, int y, int width, int thickness, Color color, double length) {
		//almost identical to clockFace, since these will likely be used in close conjunction
		m_x = x;
		m_y = y;
		m_width = width;
		setOpaque(false);
		setPreferredSize(new Dimension(m_width,m_width));
		m_angle=0;
		m_length=width*length/2;
		m_thickness = thickness;
		m_color = color;
	}
	public static ClockHand getMinuteHand(int x, int y, int width)
	{
		return new ClockHand(x, y, width, 5, Color.BLACK, 0.9);
	}
	public static ClockHand getHourHand(int x, int y, int width)
	{
		return new ClockHand(x, y, width, 10, Color.BLACK, 0.7);
	}
	public static ClockHand getSecondHand(int x, int y, int width)
	{
		return new ClockHand(x, y, width, 2, Color.RED, 0.95);
	}
	public void setColor(Color c)
	{
		m_color = c;
	}
	public void setThickness(int thickness)
	{
		m_thickness = thickness;
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Draw a line to a given angle along the length of the line
		Graphics2D g2 = (Graphics2D)g;
		super.paintComponent(g2);
		int centerX = m_x+(m_width/2);
		int centerY = m_y+(m_width/2);
		double angleCorrected = m_angle-90;
		int endX = centerX+(int)(m_length*Math.cos(Math.toRadians(angleCorrected)));
		int endY = centerY+(int)(m_length*Math.sin(Math.toRadians(angleCorrected)));
		
		g2.setColor(m_color);
		g2.setStroke(new BasicStroke(m_thickness));
		g2.drawLine(centerX, centerY, endX, endY);
	}
	public void start()
	{
		
	}
	public void stop()
	{
		
	}
	public void setAngle(double ang)
	{
		m_angle=ang;
		//repaint();
	}
	public void setPos(int x, int y)
	{
		m_x = x;
		m_y = y;
	}
	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		paintComponent(g2);
	}

	@Override
	public void translate(int dx, int dy) {
		// TODO Auto-generated method stub
		m_x+=dx;
		m_y+=dy;
	}
	

}
