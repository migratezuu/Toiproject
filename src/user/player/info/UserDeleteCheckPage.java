package user.player.info;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import user.player.common.dto.PlayerDTO;
import user.player.signup.controller.PlayerController;

public class UserDeleteCheckPage extends JFrame {
	private JFrame myPage;

	public UserDeleteCheckPage(PlayerDTO player) {

		this.myPage = this;

		myPage.setSize(800, 500);
		myPage.setLocationRelativeTo(null);
		myPage.setResizable(false);

		Font labelfont = new Font("DungGeunMo", Font.PLAIN, 25);
		Color fontColor = new Color(255, 155, 200);
		Color btnColor = new Color(90, 190, 255);

		JPanel panel = new JPanel();

		panel.setLayout(null);

		ImageIcon back = new ImageIcon("images/MainBackground.png");
		ImageIcon board = new ImageIcon("images/board.png");
		ImageIcon panelImg = new ImageIcon("images/buttonFrame.png");

		// 배경
		JLabel backgroundLabel = new JLabel(back);
		backgroundLabel.setSize(myPage.getWidth(), myPage.getHeight());
		backgroundLabel.setLocation(0, -30);

		JLabel boardLabel = new JLabel(board);
		boardLabel.setSize(myPage.getWidth(), myPage.getHeight());
		boardLabel.setLocation(0, -10);

		// 라벨
		JLabel infoLabel = new JLabel(panelImg);
		infoLabel.setSize(220, 60);
		infoLabel.setLocation(295, 30);

		JLabel infoText = new JLabel("회원 탈퇴");
		infoText.setHorizontalAlignment(JLabel.CENTER);
		infoText.setFont(labelfont);
		infoText.setForeground(fontColor);
		infoText.setSize(infoLabel.getWidth(), infoLabel.getHeight());
		infoText.setLocation(infoLabel.getX(), infoLabel.getY());

		JLabel infoTextShadow = new JLabel(infoText.getText());
		infoTextShadow.setHorizontalAlignment(JLabel.CENTER);
		infoTextShadow.setFont(labelfont);
		infoTextShadow.setSize(infoText.getWidth(), infoText.getHeight());
		infoTextShadow.setLocation(infoText.getX() + 2, infoText.getY() + 2);

		String message = "정말로 탈퇴 하시겠습니까?";
		JLabel checkText = new JLabel(message);
		checkText.setHorizontalAlignment(JLabel.CENTER);
		checkText.setFont(labelfont);
		checkText.setForeground(new Color(255, 0, 0));
		checkText.setSize(400, 30);
		checkText.setLocation(210, 235);

		panel.add(checkText);

		int btnW = 90;
		int btnH = 30;
		int fix = btnW + 70;
		int btnX = 160 + btnW + 100;
		int btnY = 130 + (30 + 30) * 4;

		// 닫기 버튼
		JButton closeBtn = new JButton("닫기");
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		closeBtn.setFont(labelfont);
		closeBtn.setForeground(btnColor);
		closeBtn.setSize(90, btnH);
		closeBtn.setLocation(btnX - fix, btnY);

		JLabel closeBtnShadow = new JLabel(closeBtn.getText());
		closeBtnShadow.setHorizontalAlignment(JLabel.CENTER);
		closeBtnShadow.setFont(labelfont);
		closeBtnShadow.setSize(closeBtn.getWidth(), closeBtn.getHeight());
		closeBtnShadow.setLocation(closeBtn.getX() + 2, closeBtn.getY() + 2);

		// 회원탈퇴 버튼
		JButton signOutBtn = new JButton("회원탈퇴");
		signOutBtn.setBorderPainted(false);
		signOutBtn.setContentAreaFilled(false);
		signOutBtn.setFocusPainted(false);
		signOutBtn.setFont(labelfont);
		signOutBtn.setForeground(fontColor);
		signOutBtn.setSize(150, btnH);
		signOutBtn.setLocation(btnX + fix, btnY);

		JLabel signOutBtnShadow = new JLabel(signOutBtn.getText());
		signOutBtnShadow.setHorizontalAlignment(JLabel.CENTER);
		signOutBtnShadow.setFont(labelfont);
		signOutBtnShadow.setSize(signOutBtn.getWidth(), signOutBtn.getHeight());
		signOutBtnShadow.setLocation(signOutBtn.getX() + 2, signOutBtn.getY() + 2);

		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new UserInfoPage(player);

			}
		});

		signOutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				PlayerController pc = new PlayerController();
				pc.deletePlayer(player, myPage);
			}
		});

		// 패널에 추가

		panel.add(infoText);
		panel.add(infoTextShadow);
		panel.add(infoLabel);

		panel.add(closeBtn);
		panel.add(closeBtnShadow);

		panel.add(signOutBtn);
		panel.add(signOutBtnShadow);

		panel.add(boardLabel);
		panel.add(backgroundLabel);

		myPage.add(panel);

		myPage.setVisible(true);
		myPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
