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

import user.player.signup.LoginPage;

public class UserDeletePage extends JFrame {
	private JFrame myPage;

	public UserDeletePage() {

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

		String message = "탈퇴 되었습니다.";
		JLabel checkText = new JLabel(message);
		checkText.setHorizontalAlignment(JLabel.CENTER);
		checkText.setFont(labelfont);
		checkText.setForeground(new Color(255, 0, 0));
		checkText.setSize(300, 30);
		checkText.setLocation(260, 235);

		panel.add(checkText);

		// 닫기 버튼
		JButton closeBtn = new JButton("닫기");
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		closeBtn.setFont(labelfont);
		closeBtn.setForeground(btnColor);
		closeBtn.setSize(90, 30);
		closeBtn.setLocation(540, 370);

		JLabel closeBtnShadow = new JLabel(closeBtn.getText());
		closeBtnShadow.setHorizontalAlignment(JLabel.CENTER);
		closeBtnShadow.setFont(labelfont);
		closeBtnShadow.setSize(closeBtn.getWidth(), closeBtn.getHeight());
		closeBtnShadow.setLocation(closeBtn.getX() + 2, closeBtn.getY() + 2);

		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new LoginPage();

			}
		});

		// 패널에 추가

		panel.add(infoText);
		panel.add(infoTextShadow);
		panel.add(infoLabel);

		panel.add(closeBtn);
		panel.add(closeBtnShadow);

		panel.add(boardLabel);
		panel.add(backgroundLabel);

		myPage.add(panel);

		myPage.setVisible(true);
		myPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
