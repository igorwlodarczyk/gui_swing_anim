package figury;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnimatorApp extends JFrame {
	private static int numberOfFigures = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel label2 = new JLabel("0");
	JLabel label4 = new JLabel("30");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final AnimatorApp frame = new AnimatorApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AnimatorApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int ww = 800, wh = 550;
		setBounds((screen.width-ww)/2, (screen.height-wh)/2, ww, wh);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		AnimPanel kanwa = new AnimPanel();
		kanwa.setBounds(10, 11, 600, 450);
		contentPane.add(kanwa);
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				kanwa.initialize();
			}
		});

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.addFig();
				numberOfFigures += 1;
				label2.setText(String.valueOf(numberOfFigures));
			}
		});
		btnAdd.setBounds(10, 470, 80, 23);
		contentPane.add(btnAdd);
		
		JButton btnAnimate = new JButton("Animate");
		btnAnimate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.animate();
			}
		});
		btnAnimate.setBounds(100, 470, 120, 23);
		contentPane.add(btnAnimate);

		JButton btnSpeedUp = new JButton("Speed up");
		btnSpeedUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.speedUp();
				label4.setText(String.valueOf(kanwa.getDelay()));
			}
		});
		btnSpeedUp.setBounds(230, 470, 120, 23);
		contentPane.add(btnSpeedUp);

		JButton slowDown = new JButton("Slow down");
		slowDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kanwa.slowDown();
				label4.setText(String.valueOf(kanwa.getDelay()));
			}
		});
		slowDown.setBounds(360, 470, 120, 23);
		contentPane.add(slowDown);

		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(490, 470, 120, 23);
		contentPane.add(exitButton);

		JLabel label1 = new JLabel("Number of figures: ");
		label1.setBounds(620, 50, 200, 23);
		contentPane.add(label1);


		label2.setBounds(620, 73, 200, 23);
		contentPane.add(label2);

		JLabel label3 = new JLabel("Delay: ");
		label3.setBounds(620, 96, 200, 23);
		contentPane.add(label3);


		label4.setBounds(620, 119, 200, 23);
		contentPane.add(label4);

		JLabel label5 = new JLabel("Igor Wlodarczyk");
		label5.setBounds(620, 200, 200, 23);
		contentPane.add(label5);

		JLabel label6 = new JLabel("Wprowadzone zmiany: ");
		label6.setBounds(620, 230, 200, 23);
		contentPane.add(label6);

		JLabel label7 = new JLabel("- Poprawione odbicia");
		label7.setBounds(620, 260, 200, 23);
		contentPane.add(label7);

		JLabel label8 = new JLabel("- Opcja zastopowania");
		label8.setBounds(620, 290, 200, 23);
		contentPane.add(label8);

		JLabel label9 = new JLabel("- Przycisk speed up");
		label9.setBounds(620, 320, 200, 23);
		contentPane.add(label9);

		JLabel label10 = new JLabel("- Przycisk slow down");
		label10.setBounds(620, 350, 200, 23);
		contentPane.add(label10);

		JLabel label11 = new JLabel("- Licznik figur");
		label11.setBounds(620, 380, 200, 23);
		contentPane.add(label11);

		JLabel label12 = new JLabel("- Wyswietlanie delayu");
		label12.setBounds(620, 410, 200, 23);
		contentPane.add(label12);

		JLabel label13 = new JLabel("- Przycisk exit");
		label13.setBounds(620, 440, 200, 23);
		contentPane.add(label13);
	}

}
