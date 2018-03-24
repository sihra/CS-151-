import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import javax.swing.Timer;

public class NormalClock extends JPanel {
	private ClockFace face;//face of the clock
	private ClockHand minute,second,hour;//hands
	private JLayeredPane lp;//layerd pane which will contain everything
	private Timer runT;//timer which will be used to update the time
	/**
	 * Contstructor for a normal clock
	 * @param x - Integer of x
	 * @param y - Integer of y
	 * @param width - Integer of the diameter of the clock
	 */
	public NormalClock(int x, int y, int width) {
		setOpaque(false);//only show the clock, don't fill in back ground
		lp = new JLayeredPane();//initialize the layered pane
		lp.setPreferredSize(new Dimension(width, width));//set the preferred size
		
		/*
		 * Below, we create and set the bounds of every object in the clock
		 * the setBounds call is necessary because we are putting them into a layered
		 * pane, which has a null layout
		 */
		face = new ClockFace(x, y, width);
			face.setBounds(x, y, width, width);
		hour = ClockHand.getHourHand(x, y, width);
			hour.setBounds(x, y, width, width);
		minute = ClockHand.getMinuteHand(x, y, width);
			minute.setBounds(x, y, width, width);
		second = ClockHand.getSecondHand(x, y, width);
			second.setBounds(x, y, width, width);
		
		lp.add(face, Integer.valueOf(1));//add the face to the bottom layer
		lp.add(hour, Integer.valueOf(2));//add the hour hand to the second layer
		lp.add(minute, Integer.valueOf(3));//add the minute hand to the third layer
		lp.add(second, Integer.valueOf(4));//add the second hand to the fourth layer
		add(lp);//add the layered pane to this panel
		/*
		 * Create a timer which updates the clock every
		 * second
		 */
		runT = new Timer(1000, new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{	
						updateClock();//update the clock
					}
				}
				);
		updateClock();//update the clock when it's created
		runT.start();//start the timer
	}
	/**
	 * Updates the clock to show the current time
	 */
	public void updateClock()
	{
		/*
		 * Below, we use a calendar object to update the clock to the correct time
		 */
		Calendar converter = new GregorianCalendar();//create a calendar with the current time
		int nMinute = converter.get(Calendar.MINUTE);//get the minutes into the hour
		int nHour = converter.get(Calendar.HOUR);//get the hours into the day
		int nSecond = converter.get(Calendar.SECOND);//get the seconds into the minute
		double minAng = nMinute*6;//convert the number of minutes into an angle 60*6=360
		double hrAng = nHour*30;//convert the number of hours into an angle 12*30=360
		double scdAng = nSecond*6;//conver the number seconds into an angle 60*6=360;
		/*
		 * Set the angles for each corresponding hand
		 */
		hour.setAngle(hrAng);
		minute.setAngle(minAng);
		second.setAngle(scdAng);
		repaint();//repaint the clock
	}
}
