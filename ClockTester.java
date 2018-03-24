import java.awt.*;
import java.awt.event.*;

import javax.naming.spi.InitialContextFactoryBuilder;
import javax.swing.*;


public class ClockTester {
	private JFrame frame;
	private JButton stopWatchB;
	private JButton clockB;
	private JPanel topNav;
	private NormalClock clock;
	private StopWatch stopwatch;
	/**
	 * Show the clock view
	 */
	public void displayClock()
	{
		frame.getContentPane().removeAll();//clear the window
		frame.add(clock, BorderLayout.CENTER);//put the clock at the center of the window
		frame.add(topNav, BorderLayout.NORTH);//put the buttons at the top of the window
		frame.pack();//pack everything
		frame.setVisible(true);//set the window to visible

	}
	/**
	 * Show the stop watch view
	 */
	public void displayStopWatch()
	{
		frame.getContentPane().removeAll();//clear window
		frame.add(stopwatch, BorderLayout.CENTER);//put the stop watch at the center of the window
		frame.add(topNav, BorderLayout.NORTH);//put the buttons at the top of the window
		frame.pack();//pack everything
		frame.setVisible(true);//set the window to visible
	}
	/**
	 * Default constructor for clock tester object
	 */
	public ClockTester()
	{
		frame = new JFrame();//Create a jFrame which will be our main window
		clock = new NormalClock(0, 0, CLOCK_RADIUS);//create a clock with the clock radius defined above
		stopwatch = new StopWatch(0, 0, CLOCK_RADIUS);//create a stop watch with the radius defined above
		
		frame.setLayout(new BorderLayout());//set the layout of the window to a boarder layout

		topNav = new JPanel(new FlowLayout());//set the layout of our button panel to flow
		
		clockB = new JButton("clock");//create a button to switch to the clock
		stopWatchB = new JButton("stopwatch");//create a button to switch to the stop watch

		/*
		 * Create an action listner for the clock button
		 */
		clockB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayClock();//switch to the clock view using the method defined above
				frame.repaint();//repaint the frame
			}
		});
		/*
		 * Create an action listner for the stopwatch button
		 */
		stopWatchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayStopWatch();//switch to the stopwatch view using the method defined above
				frame.repaint();//repaint the frame
			}
		});
		topNav.add(clockB);//add the clock button to the button panel
		topNav.add(stopWatchB);//add the stopwatch button to the panel
		
		displayClock();//show the clock first

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//this is the main window, it should exit when closed
	}
	public static void main(String[] args) {

		ClockTester c = new ClockTester();
	}

	private static final int CLOCK_RADIUS = 500;
}
