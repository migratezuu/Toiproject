package user.player.store.receip;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StoreChoiceReceip extends JFrame {

	private JFrame myPage;

	public StoreChoiceReceip() {
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setAutoRequestFocus(false);

		this.myPage = this;

		ImageIcon img = new ImageIcon("images/StoreRBuy.png");
		JPanel panel = new JPanel();
		panel.setLayout(null);

		JLabel background = new JLabel(img);
		background.setLocation(0, 0);
		background.setSize(800, 500);

		//뒤로가기버튼
		JButton btnBack = new JButton();
		btnBack.setLocation(5, 7);
		btnBack.setSize(70, 50);
		btnBack.setContentAreaFilled(false);
		//btnBack.setBorderPainted(false);
		//btnBack.setFocusPainted(false);

		//구매버튼
		JButton btnBuy = new JButton();
		btnBuy.setLocation(250,340);
		btnBuy.setSize(100, 60);
		btnBuy.setContentAreaFilled(false);
		//btnClose.setBorderPainted(false);
		//btnClose.setFocusPainted(false);

		//구매취소
		JButton btnClose = new JButton();
		btnClose.setLocation(435,340);
		btnClose.setSize(100, 60);
		btnClose.setContentAreaFilled(false);
		//btnClose.setBorderPainted(false);
		//btnClose.setFocusPainted(false);


		panel.add(btnBack);
		panel.add(btnClose);
		panel.add(btnBuy);

		panel.add(background);

		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}