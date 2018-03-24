import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

/**
 * This class is almost identical to the ClockFace class provided in the assignment.
 * The only difference is that it is numbered from 5-60 instead of 1-12
 */
public class StopWatchFace extends ClockFace {
	private int m_x;
	private int m_y;
	private int m_width;
	StopWatchFace(int x, int y, int width) {
		super(x, y, width);
		m_x = x;
		m_y = y;
		m_width = width;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		// draw the ticks
		int tickLen = 10;
		int medTickLen = 15;
		int longTickLen = 20;

		int r = m_width / 2; // radius of clock
		int cX = m_x + (m_width) / 2;
		int cY = m_y + (m_width) / 2;
		Stroke tickStroke = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1f);

		GeneralPath ticksPath = new GeneralPath();
		Ellipse2D.Double clockFace = new Ellipse2D.Double(m_x, m_y, m_width, m_width);
		g2.setColor(Color.WHITE);
		g2.fill(clockFace);

		for (int i = 1; i <= 60; i++) {
			// default tick length is short
			int len = tickLen;
			if (i % 15 == 0) {
				// Longest tick on quarters (every 15 ticks)
				len = longTickLen;
			} else if (i % 5 == 0) {
				// Medium ticks on the '5's (every 5 ticks)
				len = medTickLen;
			}

			double di = (double) i; // tick num as double for easier math

			// Get the angle from 12 O'Clock to this tick (radians)
			double angleFrom12 = di / 60.0 * 2.0 * Math.PI;

			// Get the angle from 3 O'Clock to this tick
			// Note: 3 O'Clock corresponds with zero angle in unit circle
			// Makes it easier to do the math.
			double angleFrom3 = Math.PI / 2.0 - angleFrom12;

			// Move to the outer edge of the circle at correct position
			// for this tick.
			ticksPath.moveTo((float) (cX + Math.cos(angleFrom3) * r), (float) (cY - Math.sin(angleFrom3) * r));

			// Draw line inward along radius for length of tick mark

			ticksPath.lineTo((float) (cX + Math.cos(angleFrom3) * (r - len)),
					(float) (cY - Math.sin(angleFrom3) * (r - len)));

		}

		// Draw the full shape onto the graphics context.
		g2.setColor(Color.BLACK);
		g2.setStroke(tickStroke);
		g2.draw(ticksPath);
		g2.setColor(Color.RED);

		for (int i = 1; i <= 12; i++) {
			String numStr = "" + i*5;//this is ridiculous: i know, *5 is literally the only modification from the clock face code
			FontMetrics fm = g2.getFontMetrics(g2.getFont());
			int charWidth = fm.stringWidth(numStr);
			int charHeight = fm.getHeight();

			double di = (double) i;
			double angleFrom12 = di / 12.0 * 2.0 * Math.PI;
			double angleFrom3 = Math.PI / 2.0 - angleFrom12;

			int tx = (int) (Math.cos(angleFrom3) * (r - longTickLen - charWidth));
			int ty = (int) (-Math.sin(angleFrom3) * (r - longTickLen - charHeight));

			g2.drawString(numStr, (int) cX + tx, (int) cY + ty);

		}
	}

}
