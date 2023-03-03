package user.player.store.update;

import static user.player.run.Application.labelFont;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import user.player.common.dto.PlayerDTO;
import user.player.store.StoreMainPage;

public class StoreChoiceUpdate extends JFrame {

	private JFrame myPage;

	public StoreChoiceUpdate(PlayerDTO player) {
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setAutoRequestFocus(false);

		this.myPage = this;

		ImageIcon img = new ImageIcon("images/StoreUpdate.png");

		JPanel panel = new JPanel();

		panel.setLayout(null);

		JLabel background = new JLabel(img);
		background.setLocation(0, 0);
		background.setSize(800, 500);

		// 뒤로가기버튼
		JButton btnBack = new JButton();
		btnBack.setLocation(5, 12);
		btnBack.setSize(70, 40);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);

		// 아이디 라벨
		JLabel levelLabel = new JLabel("LEVEL");
		levelLabel.setFont(labelFont);
		levelLabel.setForeground(new Color(247, 243, 130));
		levelLabel.setSize(100, 50);
		levelLabel.setLocation(100, 120);

		// 아이디 그림자 효과
		JLabel levelShadow = new JLabel(levelLabel.getText());
		levelShadow.setFont(labelFont);
		levelShadow.setSize(100, 50);
		levelShadow.setLocation(102, 122);

		// 레시피 라벨
		JLabel receipLabel = new JLabel("레시피 제한");
		receipLabel.setFont(labelFont);
		receipLabel.setForeground(new Color(247, 243, 130));
		receipLabel.setSize(150, 30);
		receipLabel.setLocation(100, 170);

		// 레시피 그림자 효과
		JLabel receipShadow = new JLabel(receipLabel.getText());
		receipShadow.setFont(labelFont);
		receipShadow.setSize(150, 30);
		receipShadow.setLocation(102, 172);

		// 레벨 라벨
		JLabel levelLabel2 = new JLabel("LEVEL");
		levelLabel2.setFont(labelFont);
		levelLabel2.setForeground(new Color(247, 243, 130));
		levelLabel2.setSize(100, 50);
		levelLabel2.setLocation(500, 120);

		// 레벨 그림자 효과
		JLabel levelShadow2 = new JLabel(levelLabel2.getText());
		levelShadow2.setFont(labelFont);
		levelShadow2.setSize(100, 50);
		levelShadow2.setLocation(502, 122);

		// 레시피 라벨
		JLabel receipLabel2 = new JLabel("레시피 제한");
		receipLabel2.setFont(labelFont);
		receipLabel2.setForeground(new Color(247, 243, 130));
		receipLabel2.setSize(150, 30);
		receipLabel2.setLocation(500, 170);

		// 레시피 그림자 효과
		JLabel receipShadow2 = new JLabel(receipLabel2.getText());
		receipShadow2.setFont(labelFont);
		receipShadow2.setSize(150, 30);
		receipShadow2.setLocation(502, 172);

		// 구매버튼
		JButton btnBuy = new JButton();
		btnBuy.setLocation(560, 380);
		btnBuy.setSize(85, 40);
		btnBuy.setContentAreaFilled(false);
		// btnClose.setBorderPainted(false);
		// btnClose.setFocusPainted(false);

		panel.add(btnBack);
		panel.add(btnBuy);
		panel.add(background);
		panel.add(levelLabel);
		panel.add(levelShadow);
		panel.add(receipLabel);
		panel.add(receipShadow);
		panel.add(levelLabel2);
		panel.add(levelShadow2);
		panel.add(receipLabel2);
		panel.add(receipShadow2);

		panel.add(background);

		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new StoreMainPage(player);

			}
		});
	}

}