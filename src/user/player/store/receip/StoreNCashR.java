package user.player.store.receip;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StoreNCashR extends JFrame {
	
	private JFrame myPage;

	public StoreNCashR() {
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setAutoRequestFocus(false);
		
		this.myPage = this;
		
		ImageIcon img = new ImageIcon("images/StoreNCash.png");
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel background = new JLabel(img);
		background.setLocation(0, 0);
		background.setSize(800, 500);


		JButton btnBack = new JButton();
		btnBack.setLocation(5, 7);
		btnBack.setSize(70, 50);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);
		
		JButton btnClose = new JButton();
		btnClose.setLocation(360,330);
		btnClose.setSize(90, 50);
		btnClose.setContentAreaFilled(false);
		btnClose.setBorderPainted(false);
		btnClose.setFocusPainted(false);
		

		panel.add(btnBack);
		panel.add(btnClose);

		panel.add(background);

		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}