import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLayeredPane;

public class StopWatchDial extends JPanel{
	private StopWatchFace face;
	private ClockHand hand;
	private JLayeredPane lp;
	private int m_x;
	private int m_y;
	private int m_width;

	public StopWatchDial(int x, int y, int width)
	{
		setOpaque(false);
		m_x = x;
		m_y = y;
		m_width = width;
		lp = new JLayeredPane();
		lp.setPreferredSize(new Dimension(width, width));
		
		face = new StopWatchFace(x, y, width);
			face.setBounds(x, y, width, width);
		hand = ClockHand.getSecondHand(x, y, width);
			hand.setBounds(x, y, width, width);
			
		lp.add(face, Integer.valueOf(1));
		lp.add(hand, Integer.valueOf(2));
		add(lp);
	}
	public void setAng(double angle)
	{
		hand.setAngle(angle);
	}

}
