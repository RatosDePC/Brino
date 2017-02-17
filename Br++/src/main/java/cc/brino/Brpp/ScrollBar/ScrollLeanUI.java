package cc.brino.Brpp.ScrollBar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;


public class ScrollLeanUI extends BasicScrollBarUI {

	private static Border emptyBorder = BorderFactory.createEmptyBorder();

	@Override
	protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
		r.setSize(new Dimension(6, r.height));
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		Color color = null;
		c.setBorder(emptyBorder);
		if (isDragging) {
			color = new Color(46,46,46, 10);
		} else {
			color = new Color(30, 30, 30, 2);
		}
		g2.setStroke(new BasicStroke(0));
		g2.setPaint(color);
		g2.fillRoundRect(r.x, r.y, r.width, r.height, 10, 10);
		g2.dispose();
	}

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		Color color = null;
		JScrollBar sb = (JScrollBar) c;
		c.setBorder(emptyBorder);
		if (!sb.isEnabled() || r.width > r.height) {
			return;
		}
		color = Color.green;
		r.setSize(new Dimension(6, r.height));
		g2.setStroke(new BasicStroke(0));
		g2.setPaint(color);
		g2.fillRoundRect(r.x, r.y, r.width, r.height, 10, 10);
		g2.dispose();
	}

	@Override
	protected void setThumbBounds(int x, int y, int width, int height) {
		super.setThumbBounds(x, y, 6, height);
		scrollbar.repaint();
	}

	@Override
	protected JButton createDecreaseButton(int orientation) {
		return createZeroButton();
	}

	@Override
	protected JButton createIncreaseButton(int orientation) {
		return createZeroButton();
	}

	private JButton createZeroButton() {
		JButton jbutton = new JButton();
		jbutton.setPreferredSize(new Dimension(0, 0));
		jbutton.setMinimumSize(new Dimension(0, 0));
		jbutton.setMaximumSize(new Dimension(0, 0));
		return jbutton;
	}
}