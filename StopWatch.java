import java.awt.BorderLayout;
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
	private StopWatchDial inner;//inner stop watch
	private StopWatchDial outer;//outer stop watch
	private Timer runT;//timer to update the stop watch
	private JLayeredPane lp;//layered pane to hold everything
	private int m_x;
	private int m_y;
	private int m_width;
	private int m_numSecs;//number of mili seconds that have passed so far
	private int m_numMin;//number of minutes that have passed so far
	private JButton startT;//start button
	private JButton stopT;//stop button
	private JButton resetT;//reset button
	
	
	private static final int TICK_DELAY = 10;//the delay between refreshes
	/**
	 * Start the stop watch
	 */
	public void start()
	{
		runT.start();//start the timer
	}
	/**
	 * Stop the stop watch
	 */
	public void stop()
	{
		runT.stop();//stop the timer
	}
	/**
	 * Reset the stop watch
	 */
	public void reset()
	{
		stop();//stop the timer
		/*
		 * Reset the seconds and minutes to zero
		 */
		m_numSecs=0;
		m_numMin=0;
		updateWatch();//update the watch to reflect the changes
		
	}
	/**
	 * Constructor for the stop watch
	 * @param x - Integer of the x position
	 * @param y - Integer of the y position
	 * @param width - Integer of the diameter of the stop watch
	 */
	public StopWatch(int x, int y, int width)
	{
		/*
		 * Set the member variables, make minute and seconds zero
		 */
		m_x = x;
		m_y = y;
		m_width = width;
		m_numSecs = 0;
		m_numMin = 0;
		
		lp = new JLayeredPane();//initialize the layerd pane
		lp.setPreferredSize(new Dimension(width,width));//set preferred size
		
		/*
		 * below, we create the inner and outer stop watch dial, calculating
		 * the correct position of the inner dial, and calling set bounds for both
		 * because layerd panes have a null layout
		 */
		outer = new StopWatchDial(x, y, width);
			outer.setBounds(x, y, width, width);
		
		int innerWidth = (int)(width*0.5);//the diameter should be half that of the outer dial
		int innerX=(width-innerWidth)/2;//put it at the center along x
		int innerY=(int)(width*0.1);//put it slightly below the top of the outer dial
		
		inner = new StopWatchDial(0,0,innerWidth);
			inner.setBounds(innerX, innerY, innerWidth, innerWidth);
		/*
		 * add both dials to the correct layer
		 */
		lp.add(outer, Integer.valueOf(1));
		lp.add(inner, Integer.valueOf(2));
		JPanel buttonPanel = new JPanel();//create a panel to hold the buttons
		/*
		 * Below we create buttons to control the stop watch,
		 * and assign them the correct action to perform
		 */
		JButton startB = new JButton("start");
		startB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				start();
			}
		});
		JButton stopB = new JButton("stop");
		stopB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stop();
			}
		});
		JButton resetB = new JButton("reset");
		resetB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reset();
			}
		});
		/*
		 * add all the butons to the button panel
		 */
		buttonPanel.add(startB);
		buttonPanel.add(stopB);
		buttonPanel.add(resetB);
		
		setLayout(new BorderLayout());//use a border layout because it looks nice
		add(buttonPanel, BorderLayout.NORTH);//put the button panel at the top
		add(lp,BorderLayout.CENTER);//put the stop watch at the center
		
		/*
		 * create a timer which updates the watch every tick
		 */
		runT = new Timer(TICK_DELAY, new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
				updateWatch();
			}
		});
	}
	/**
	 * Perform tick operations, such as increasing the number of mili seconds
	 * and minutes which have passed
	 */
	private void tick()
	{
		m_numSecs+=TICK_DELAY;//add the time since last call to the number of seconds
		if (m_numSecs>=60_000)//if it has been 60 seconds
		{
			
			m_numMin++;//add one minute to the timer
			m_numSecs=0;//reset the mili seconds
		}
		
	}
	private void updateWatch()
	{
		tick();//do tick operations
		double secAng = ((double)m_numSecs/(1000.0))*6;//convert the number of miliseconds to an angle
		double minAng = (((double)m_numSecs/(60000.0))+(m_numMin))*6;//convert the minutes to an angle
		
		/*
		 * Set the angles of the corresponding stop watch dials
		 */
		outer.setAng(secAng);
		inner.setAng(minAng);
		repaint();//repaint the dial
		
	}
}
