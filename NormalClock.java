import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import javax.swing.Timer;

public class NormalClock extends JPanel {
	private ClockFace face;
	private ClockHand minute,second,hour;
	private JLayeredPane lp;
	private Timer runT;
	public NormalClock(int x, int y, int width) {
		setOpaque(false);
		lp = new JLayeredPane();
		lp.setPreferredSize(new Dimension(width, width));
		
		face = new ClockFace(x, y, width);
			face.setBounds(x, y, width, width);
		hour = ClockHand.getHourHand(x, y, width);
			hour.setBounds(x, y, width, width);
		minute = ClockHand.getMinuteHand(x, y, width);
			minute.setBounds(x, y, width, width);
		second = ClockHand.getSecondHand(x, y, width);
			second.setBounds(x, y, width, width);
		
		lp.add(face, Integer.valueOf(1));
		lp.add(hour, Integer.valueOf(2));
		lp.add(minute, Integer.valueOf(3));
		lp.add(second, Integer.valueOf(4));
		add(lp);
		runT = new Timer(1000, new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{	
						updateClock();
					}
				}
				);
		updateClock();
		runT.start();
	}
	public void updateClock()
	{
		Calendar converter = new GregorianCalendar(); 
		int nMinute = converter.get(Calendar.MINUTE);
		int nHour = converter.get(Calendar.HOUR);
		int nSecond = converter.get(Calendar.SECOND);
		double minAng = nMinute*6;//60*6=360
		double hrAng = nHour*30;//12*30=360
		double scdAng = nSecond*6;//60*6=360;
		hour.setAngle(hrAng);
		minute.setAngle(minAng);
		second.setAngle(scdAng);
		repaint();
	}
}
