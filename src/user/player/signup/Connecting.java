package user.player.signup;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Connecting extends JFrame {

	private JFrame myPage;

	public Connecting() {

		this.myPage = this;
		myPage.setSize(800, 500);
		myPage.setLocationRelativeTo(null);
		myPage.setResizable(false);

		JPanel panel = new JPanel();

		panel.setLayout(null);

		Image backImg = new ImageIcon("images/connecting.png").getImage().getScaledInstance(800, 500, 0);
		ImageIcon back = new ImageIcon(backImg); // 이전화면

		JLabel backLabel = new JLabel(back);
		backLabel.setSize(back.getIconWidth(), back.getIconHeight());
		backLabel.setLocation(0, -30);

		panel.add(backLabel);

		myPage.add(panel);
		myPage.setVisible(true);
		myPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myPage.dispose();
				// new GameMain();

			}
		});
	}
}
