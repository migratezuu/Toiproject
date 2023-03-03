package user.player.storage;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import user.player.common.dto.PlayerDTO;
import user.player.gamemain.GameMain;

public class StoragePage extends JFrame {

	private JFrame myPage;

	public StoragePage(PlayerDTO player) {
		Font labelFont = new Font("DungGeunMo", Font.PLAIN, 25);

		this.myPage = this;
		myPage.setSize(800, 500);
		myPage.setLocationRelativeTo(null);
		myPage.setResizable(false);

		JPanel panel = new JPanel();

		panel.setLayout(null);

		int btnW = 220;
		int btnH = 60;
		int btnX = 400 - btnW / 2;
		int btnY = 190;

		ImageIcon backgrond = new ImageIcon("images/storage.png");
		ImageIcon img = new ImageIcon("images/buttonFrame.png");
		ImageIcon back = new ImageIcon("images/back.png");

		// 배경
		JLabel background = new JLabel(backgrond);
		background.setSize(800, 500);
		background.setLocation(0, 0);

		JLabel backLabel = new JLabel(back);
		backLabel.setSize(70, 49);
		backLabel.setLocation(30, 10);

		JButton backBtn = new JButton();
		backBtn.setBorderPainted(false);
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
		backBtn.setSize(70, 49);
		backBtn.setLocation(30, 10);

		// 재료 라벨
		JLabel ingreLabel = new JLabel();
		ingreLabel.setIcon(img);
		ingreLabel.setSize(btnW, btnH);
		ingreLabel.setLocation(btnX, btnY);

		JButton ingreBtn = new JButton("재료확인"); // 재료확인
		ingreBtn.setBorderPainted(false);
		ingreBtn.setContentAreaFilled(false);
		ingreBtn.setFocusPainted(false);
		ingreBtn.setFont(labelFont);
		ingreBtn.setSize(btnW, btnH);
		ingreBtn.setLocation(btnX, btnY);

		// 레시피 라벨
		JLabel recipeLabel = new JLabel();
		recipeLabel.setIcon(img);
		recipeLabel.setSize(btnW, btnH);
		recipeLabel.setLocation(btnX, btnY + 150);

		JButton recipeBtn = new JButton("레시피 확인");
		recipeBtn.setBorderPainted(false);
		recipeBtn.setContentAreaFilled(false);
		recipeBtn.setFocusPainted(false);
		recipeBtn.setFont(labelFont);
		recipeBtn.setSize(btnW, btnH);
		recipeBtn.setLocation(btnX, btnY + 150);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new GameMain(player);

			}
		});

		ingreBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new IngreStoragePage(player);
			}
		});

		recipeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new RecipeStoragePage(player);
			}
		});

		// 패녈에 추가

		panel.add(backBtn);
		panel.add(backLabel);
		panel.add(ingreBtn);
		panel.add(recipeBtn);
		panel.add(ingreLabel);
		panel.add(recipeLabel);
		panel.add(background);

		myPage.add(panel);

		myPage.setVisible(true);
		myPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}