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
	//TODO: fix this so the buttons work
	public void displayClock()
	{
		frame.getContentPane().removeAll();
		frame.add(clock, BorderLayout.CENTER);
		frame.add(topNav, BorderLayout.NORTH);
		frame.pack();
		frame.setVisible(true);

	}
	public void displayStopWatch()
	{
		frame.getContentPane().removeAll();
		stopwatch.start();
		frame.add(stopwatch, BorderLayout.CENTER);
		frame.add(topNav, BorderLayout.NORTH);
		frame.pack();
		frame.setVisible(true);
	}
	
	public ClockTester()
	{
		frame = new JFrame();
		clock = new NormalClock(0, 0, CLOCK_RADIUS);
		stopwatch = new StopWatch(0, 0, CLOCK_RADIUS);
		
		frame.setLayout(new BorderLayout());

		topNav = new JPanel(new FlowLayout());
		
		clockB = new JButton("clock");
		stopWatchB = new JButton("stopwatch");


		clockB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayClock();
				frame.repaint();
			}
		});
		stopWatchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayStopWatch();
				frame.repaint();
			}
		});
		topNav.add(clockB);
		topNav.add(stopWatchB);
		
		displayClock();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {

		ClockTester c = new ClockTester();
	}

	private static final int CLOCK_RADIUS = 500;
}
