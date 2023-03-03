package user.player.signup;

import static user.player.run.Application.labelFont;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import user.player.signup.controller.PlayerController;

public class FindPasswordPage extends JFrame {

	private JFrame myPage;
	private boolean isFind;

	public FindPasswordPage() {

		this.myPage = this;

		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setAutoRequestFocus(false);
		myPage.setTitle("비밀번호 찾기");

		// 배경
		ImageIcon img = new ImageIcon("images/FindPasswordMain.png");

		// 결과창
		ImageIcon pwdResult = new ImageIcon("images/pwdResult.png");

		// 뒤로가기
		ImageIcon back = new ImageIcon("images/back.png");

		JPanel panel = new JPanel();

		panel.setLayout(null);

		// 배경
		JLabel background = new JLabel(img);
		background.setLocation(0, 0);
		background.setSize(800, 500);

		// 이전 화면 이동
		JButton backBtn = new JButton();
		backBtn.setIcon(back);
		backBtn.setBorderPainted(false);
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
		backBtn.setSize(back.getIconWidth(), back.getIconHeight());
		backBtn.setLocation(0, 0);

		// 결과창
		JLabel pwdCheck = new JLabel(pwdResult);
		pwdCheck.setSize(pwdResult.getIconWidth(), pwdResult.getIconHeight());
		pwdCheck.setLocation(400 - pwdCheck.getWidth() / 2, 250 - pwdCheck.getHeight() / 2);
		pwdCheck.setVisible(false);

		JLabel msgPwd = new JLabel();
		msgPwd.setSize(pwdCheck.getWidth(), 30);
		msgPwd.setLocation(pwdCheck.getX(), pwdCheck.getY() + pwdCheck.getHeight() / 2);
		msgPwd.setFont(labelFont);
		msgPwd.setHorizontalAlignment(JLabel.CENTER);
		msgPwd.setVisible(false);

		// 닫기
		JButton closeBtn = new JButton();
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		closeBtn.setSize(100, 50);
		closeBtn.setLocation(pwdCheck.getX() + (pwdCheck.getWidth() - closeBtn.getWidth()) / 2,
				pwdCheck.getY() + pwdCheck.getHeight() - closeBtn.getHeight());
		closeBtn.setVisible(false);

		// 아이디 입력
		JTextField id = new JTextField();
		id.setSize(360, 30);
		id.setLocation(210, 230);

		// 이메일 입력
		JTextField email = new JTextField();
		email.setSize(360, 30);
		email.setLocation(210, 300);

		// 검색 버튼
		JButton btn = new JButton();
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		btn.setSize(120, 100);
		btn.setLocation(640, 220);

		// 패널로 화면에 노출
		panel.add(msgPwd);
		panel.add(closeBtn);
		panel.add(pwdCheck);

		panel.add(id);
		panel.add(email);
		panel.add(btn);
		panel.add(backBtn);
		panel.add(background);

		myPage.add(panel);

		myPage.setVisible(true);
		myPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				pwdCheck.setVisible(true);
				closeBtn.setVisible(true);
				msgPwd.setVisible(true);

				if (id.getText().isEmpty()) {
					msgPwd.setText("아이디를 입력하세요.");
					isFind = false;
				} else if (email.getText().isEmpty()) {
					msgPwd.setText("이메일을 입력하세요.");
					isFind = false;
				} else {

					Map<String, String> map = new HashMap<>();

					map.put("id", id.getText());
					map.put("email", email.getText());

					PlayerController signController = new PlayerController();

					String message = signController.findPwdByIdAndEmail(map);

					msgPwd.setText(message);

					if (message.equals("일치하는 비밀번호가 없습니다.")) {
						isFind = false;
					} else {
						isFind = true;
					}
				}
			}
		});

		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (isFind) {
					myPage.dispose();
					new LoginPage();
				} else {
					pwdCheck.setVisible(false);
					closeBtn.setVisible(false);
					msgPwd.setVisible(false);

					id.setText("");
					email.setText("");
				}

			}
		});

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				myPage.dispose();
				new LoginPage();
			}
		});

	}
}