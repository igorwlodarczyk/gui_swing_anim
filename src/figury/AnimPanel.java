package figury;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Figura> figList = new ArrayList<>();

	// bufor
	Image image;
	// wykreslacz ekranowy
	Graphics2D device;
	// wykreslacz bufora
	Graphics2D buffer;

	private int delay = 30;

	private Timer timer;

	private static int numer = 0;

	public AnimPanel() {
		super();
		setBackground(Color.WHITE);
		timer = new Timer(delay, this);
	}

	public void initialize() {
		int width = getWidth();
		int height = getHeight();

		image = createImage(width, height);
		buffer = (Graphics2D) image.getGraphics();
		buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		device = (Graphics2D) getGraphics();
		device.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	void addFig() {
		Figura fig = (numer++ % 2 == 0) ? new Kwadrat(buffer, delay, getWidth(), getHeight())
				: new Elipsa(buffer, delay, getWidth(), getHeight());
		timer.addActionListener(fig);
		figList.add(fig);
		Thread thread = new Thread(fig);
		thread.start();
	}

	void animate() {
		if (timer.isRunning()) {
			timer.stop();
			for (Figura fig : figList) {
				fig.getMove().set(0);
			}
		} else {
			timer.start();
			for (Figura fig : figList) {
				fig.getMove().set(1);
			}
		}
	}

	void speedUp() {
		delay -= 2;
		if(delay < 1){
			delay = 1;
		}
		for (Figura fig : figList) {
			fig.getDelay().set(delay);
		}
	}

	void slowDown() {
		delay += 2;
		for (Figura fig : figList) {
			fig.getDelay().set(delay);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		device.drawImage(image, 0, 0, null);
		buffer.clearRect(0, 0, getWidth(), getHeight());
	}

	public int getDelay(){
		return delay;
	}
}
