import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLayeredPane;

public class StopWatchDial extends JPanel{
	private StopWatchFace face;//face of the stop watch
	private ClockHand hand;//hand of the stop watch
	private JLayeredPane lp;//layerd pane to contain the face and hand
	private int m_x;
	private int m_y;
	private int m_width;
	/**
	 * Creates a stop watch dial with a hand
	 * @param x - Integer of the x position
	 * @param y - Integer of the y position
	 * @param width - Integer of the diameter of the dial
	 */
	public StopWatchDial(int x, int y, int width)
	{
		setOpaque(false);//don't fill in the background
		m_x = x;
		m_y = y;
		m_width = width;
		lp = new JLayeredPane();//Initialize a layered pane to hold everything in
		lp.setPreferredSize(new Dimension(width, width));//set the preferred size
		
		/*
		 * Below, we create the stop watch dial face and hand and use
		 * set bounds to set their position and size. setBounds is necessary
		 * because layered pane has a null layout
		 */
		face = new StopWatchFace(x, y, width);
			face.setBounds(x, y, width, width);
		hand = ClockHand.getSecondHand(x, y, width);
			hand.setBounds(x, y, width, width);
		
		/*
		 * Add each element to the layered pane and the correct layer
		 */
		lp.add(face, Integer.valueOf(1));
		lp.add(hand, Integer.valueOf(2));
		add(lp);//add the layerd pane to this jpanel
	}
	/**
	 * Set the angle of the hand on this dial 
	 * @param angle - Double of the angle
	 */
	public void setAng(double angle)
	{
		hand.setAngle(angle);//set the angle of the hand
	}

}
