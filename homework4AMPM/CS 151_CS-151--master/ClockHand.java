import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ClockHand extends JPanel implements MoveableShape {
	private double m_angle;//angle in degrees of this clock hand
	private double m_length;//length of the clock hand
	private int m_x;
	private int m_y;
	private int m_width;//width of the container of the hand
	private Color m_color;//color of the hand
	private int m_thickness;//thickness of the hand
	
	/**
	 * Basic constructor of a clock hand object
	 * @param x - Integer of x position
	 * @param y - Integer of y position
	 * @param width - Integer of diameter of the clock which will be using this hand
	 */
	public ClockHand(int x, int y, int width) {
		//almost identical to clockFace, since these will likely be used in close conjunction
		m_x = x;
		m_y = y;
		m_width = width;//make the size of the JPanel the same as the clockface below it
		setOpaque(false);//don't fill this in, we're just drawing a line
		setPreferredSize(new Dimension(m_width,m_width));//set the preferred size of the face
		m_angle=0;//angle should be 0 by default
		m_length=width/4;//default length will be half the radius of the clock
		m_thickness = 1;//default thickness will be 1
		m_color = Color.BLACK;//default color will be black
	}
	/**
	 * Constructor for clockHand object
	 * @param x - Integer of x position
	 * @param y - Integer of y position
	 * @param width - Integer of diameter of clock face
	 * @param thickness - Integer representing the thickness of the hand
	 * @param color - Color of the clock hand
	 * @param length - Double from 1-0 representing the percentage of the radius of the clock face
	 */
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
	/**
	 * Returns a minute hand at a given position and size
	 * @param x - Integer of the x position
	 * @param y - Integer of the y position
	 * @param width - Integer of the diameter of the clock
	 * @return ClockHand of the minute hand
	 */
	public static ClockHand getMinuteHand(int x, int y, int width)
	{
		return new ClockHand(x, y, width, 5, Color.BLACK, 0.9);
	}
	/**
	 * Returns a hour hand at a given position and size
	 * @param x - Integer of the x position
	 * @param y - Integer of the y position
	 * @param width - Integer of the diameter of the clock
	 * @return ClockHand of the hour hand
	 */
	public static ClockHand getHourHand(int x, int y, int width)
	{
		return new ClockHand(x, y, width, 10, Color.BLACK, 0.7);
	}
	/**
	 * Returns a second hand at a given position and size
	 * @param x - Integer of the x position
	 * @param y - Integer of the y position
	 * @param width - Integer of the diameter of the clock
	 * @return ClockHand of the second hand
	 */
	public static ClockHand getSecondHand(int x, int y, int width)
	{
		return new ClockHand(x, y, width, 2, Color.RED, 0.95);
	}
	/**
	 * Sets the color of the clock hand
	 * @param c - Color the clock hand will be set to
	 */
	public void setColor(Color c)
	{
		m_color = c;
	}
	/**
	 * Sets the thickness of the clock hand
	 * @param thickness - Integer representing the thickness of the clock hand
	 */
	public void setThickness(int thickness)
	{
		m_thickness = thickness;
	}
	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D)g;//use graphics 2d
		super.paintComponent(g2);//call the default paint method for jpanel
		int centerX = m_x+(m_width/2);//calculate the x for the center of the clock face
		int centerY = m_y+(m_width/2);//calculate the y for the center of the clock face
		/*
		 * For the sake of convenience, set the angle such that if the angle is zero,
		 * the hand will be pointing to the top (-90 degs) of the clock
		 */
		double angleCorrected = m_angle-90;
		/*
		 * 1. Calculate the x of the terminal point for our clock hand line using trig
		 * 2. Calculate the y of the terminal point for our clock hand line using trig
		 */
		int endX = centerX+(int)(m_length*Math.cos(Math.toRadians(angleCorrected)));// 1
		int endY = centerY+(int)(m_length*Math.sin(Math.toRadians(angleCorrected)));// 2
		
		g2.setColor(m_color);//set the color the graphics will paint
		g2.setStroke(new BasicStroke(m_thickness));//create a basic stroke of the right thickness
		g2.drawLine(centerX, centerY, endX, endY);//draw a line from the center to the terminal point
	}
	/**
	 * Set the angle of the clock hand
	 * @param ang - Double representing an angle in degrees
	 */
	public void setAngle(double ang)
	{
		m_angle=ang;
		//repaint();
	}
	/**
	 * Set the position of the clock hand
	 * @param x - Integer of the x position
	 * @param y - Integer of the y position
	 */
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
