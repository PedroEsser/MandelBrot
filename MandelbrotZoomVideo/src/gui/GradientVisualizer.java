package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import gpuColorGradients.ColorGradient;
import gradient.Gradient;
import guiUtils.ImagePanel;

public class GradientVisualizer extends ImagePanel{

	private ColorGradient gradient;
	
	public GradientVisualizer(ColorGradient gradient) {
		this.gradient = gradient;
	}

	@Override
	protected void myResize() {
		this.img = new BufferedImage(this.getPanelWidth(), this.getPanelHeight(), BufferedImage.TYPE_3BYTE_BGR);
		Graphics g = this.img.getGraphics();
		
		int x = 0;
		for(Color c : gradient.toGradient().toDiscrete(this.img.getWidth())) {
			g.setColor(c);
			g.drawLine(x, 0, x++, this.img.getHeight());
		}
		repaint();
	}
	
}
