package core;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Start {

	public static Dimension gameDim = new Dimension(800, 600);

	public static void main(String[] args) {
		JFrame frame = new JFrame("Tiny Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GameCanvas gc = new GameCanvas();

		frame.setSize(gameDim);
		frame.setResizable(false);
		frame.getContentPane().add(gc);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		while (true) {
			gc.repaint();
			try {
				Thread.sleep(50L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
