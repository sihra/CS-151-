import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import javax.swing.Timer;

public class StopWatch extends JPanel {
	private StopWatchDial inner;
	private StopWatchDial outer;
	private Timer runT;
	private JLayeredPane lp;
	private int m_x;
	private int m_y;
	private int m_width;
	private int m_numSecs;
	private int m_numMin;
	private JButton startT;
	private JButton stopT;
	private JButton resetT;
	
	
	private static final int TICK_DELAY = 10;
	public void start()
	{
		runT.start();
	}
	public void stop()
	{
		runT.stop();
	}
	public void reset()
	{
		stop();
		m_numSecs=0;
		m_numMin=0;
		updateWatch();
		
	}
	public StopWatch(int x, int y, int width)
	{
		m_x = x;
		m_y = y;
		m_width = width;
		m_numSecs = 0;
		m_numMin = 0;
		
		lp = new JLayeredPane();
		lp.setPreferredSize(new Dimension(width,width));
		
		outer = new StopWatchDial(x, y, width);
			outer.setBounds(x, y, width, width);
		
		int innerWidth = (int)(width*0.5);
		int innerX=(width-innerWidth)/2;
		int innerY=(int)(width*0.1);
		
		inner = new StopWatchDial(0,0,innerWidth);
			inner.setBounds(innerX, innerY, innerWidth, innerWidth);
		
		lp.add(outer, Integer.valueOf(1));
		lp.add(inner, Integer.valueOf(2));
		
		add(lp);
		runT = new Timer(TICK_DELAY, new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
				updateWatch();
			}
		});
	}
	//sfs
	private void tick()
	{
		m_numSecs+=TICK_DELAY;
		System.out.println(m_numSecs);
		
		if (m_numSecs>=60_000)
		{
			
			m_numMin++;
			m_numSecs=0;
		}
		
	}
	private void updateWatch()
	{
		tick();
		double secAng = (m_numSecs*0.06/TICK_DELAY);
		double minAng = ((double)m_numSecs/(1000*TICK_DELAY))+(m_numMin)*6;
		//double minAng = (m_numMin*5);
		
		outer.setAng(secAng);
		inner.setAng(minAng);
		repaint();
		
	}
}
