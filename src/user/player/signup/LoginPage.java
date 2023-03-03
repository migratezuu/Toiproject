package user.player.signup;

import static user.player.run.Application.labelFont;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import user.player.common.dto.PlayerDTO;
import user.player.gamemain.GameMain;
import user.player.manager.ManagerMainPage;
import user.player.signup.controller.PlayerController;

public class LoginPage extends JFrame {

	private JFrame myPage;
	private boolean isLogin;

	public LoginPage() {

		this.myPage = this;

		myPage.setSize(800, 500);
		myPage.setLocationRelativeTo(null);
		myPage.setResizable(false);

		Font labelfont = new Font("DungGeunMo", Font.PLAIN, 25);
		Font titleFont = new Font("DungGeunMo", Font.PLAIN, 90);
		Color fontColor = new Color(255, 255, 140);

		JPanel panel = new JPanel();

		panel.setLayout(null);

		int labelWidth = 200;
		int labelHeight = 30;
		int textWidth = 350;
		int textHeight = 30;

		int X = 60;
		int Y = 300;

		int idX = X;
		int idY = Y;
		int pwdX = idX;
		int pwdY = idY + labelHeight + 30;

		ImageIcon back = new ImageIcon("images/background.png");

		JLabel backgroundLabel = new JLabel(back);
		backgroundLabel.setSize(800, 500);
		backgroundLabel.setLocation(0, 0);

		// 제목 라벨
		JLabel titleLabel1 = new JLabel("자바");
		titleLabel1.setFont(titleFont);
		titleLabel1.setForeground(fontColor);
		titleLabel1.setSize(labelWidth, 120);
		titleLabel1.setLocation(X + 50, 100);

		JLabel titleLabel2 = new JLabel("골목식당");
		titleLabel2.setFont(titleFont);
		titleLabel2.setForeground(new Color(207, 161, 255));
		titleLabel2.setSize(labelWidth * 2, 120);
		titleLabel2.setLocation(X + labelWidth + 50, 100);

		// 그림자 효과
		JLabel titleShadow1 = new JLabel(titleLabel1.getText());
		titleShadow1.setFont(titleFont);
		titleShadow1.setSize(labelWidth, 120);
		titleShadow1.setLocation(X + 50 + 5, 100 + 5);

		JLabel titleShadow2 = new JLabel(titleLabel2.getText());
		titleShadow2.setFont(titleFont);
		titleShadow2.setSize(labelWidth * 2, 120);
		titleShadow2.setLocation(X + labelWidth + 50 + 5, 100 + 5);

		// 아이디 라벨
		JLabel idLabel = new JLabel("아이디 : ");
		idLabel.setFont(labelfont);
		idLabel.setForeground(fontColor);
		idLabel.setSize(labelWidth, labelHeight);
		idLabel.setLocation(idX, idY);

		// 아이디 그림자 효과
		JLabel idShadow = new JLabel(idLabel.getText());
		idShadow.setFont(labelfont);
		idShadow.setSize(labelWidth, labelHeight);
		idShadow.setLocation(idX + 2, idY + 2);

		// 아이디 텍스트
		JTextField idText = new JTextField(20);
		idText.setSize(textWidth, textHeight);
		idText.setLocation(idX + labelWidth - 50, idY);

		// 비밀번호 라벨
		JLabel pwdLabel = new JLabel("비밀번호 : ");
		pwdLabel.setFont(labelfont);
		pwdLabel.setForeground(fontColor);
		pwdLabel.setSize(labelWidth, labelHeight);
		pwdLabel.setLocation(pwdX, pwdY);

		// 비밀번호 그림자 효과
		JLabel pwdShadow = new JLabel(pwdLabel.getText());
		pwdShadow.setFont(labelfont);
		pwdShadow.setSize(labelWidth, labelHeight);
		pwdShadow.setLocation(pwdX + 2, pwdY + 2);

		// 비밀번호 텍스트
		JPasswordField pwdText = new JPasswordField(20);
		pwdText.setSize(textWidth, textHeight);
		pwdText.setLocation(pwdX + labelWidth - 50, pwdY);

		// 로그인 버튼
		JButton loginBtn = new JButton("Login");
		loginBtn.setFont(labelfont);
		loginBtn.setBorderPainted(false);
		loginBtn.setContentAreaFilled(false);
		loginBtn.setFocusPainted(false);
		loginBtn.setForeground(fontColor);
		loginBtn.setSize(100, 100);
		loginBtn.setLocation(X + labelWidth + textWidth, idY - 10);

		// 로그인 그림자 효과
		JLabel loginShadow = new JLabel(loginBtn.getText());
		loginShadow.setFont(labelfont);
		loginShadow.setHorizontalAlignment(JLabel.CENTER);
		loginShadow.setSize(100, 100);
		loginShadow.setLocation(X + labelWidth + textWidth + 2, idY - 10 + 2);

		// 회원가입
		JButton signUpBtn = new JButton("회원가입하기");
		signUpBtn.setFont(labelfont);
		signUpBtn.setBorderPainted(false);
		signUpBtn.setContentAreaFilled(false);
		signUpBtn.setFocusPainted(false);
		signUpBtn.setForeground(fontColor);
		signUpBtn.setSize(200, 30);
		signUpBtn.setLocation(X + 50, pwdY + labelHeight + 20);

		// 회원가입 그림자 효과
		JLabel signUpShadow = new JLabel(signUpBtn.getText());
		signUpShadow.setFont(labelfont);
		signUpShadow.setHorizontalAlignment(JLabel.CENTER);
		signUpShadow.setSize(200, 30);
		signUpShadow.setLocation(X + 50 + 2, pwdY + labelHeight + 20 + 2);

		// 비밀번호 찾기
		JButton findPwdBtn = new JButton("비밀번호찾기");
		findPwdBtn.setFont(labelfont);
		findPwdBtn.setBorderPainted(false);
		findPwdBtn.setContentAreaFilled(false);
		findPwdBtn.setFocusPainted(false);
		findPwdBtn.setForeground(fontColor);
		findPwdBtn.setSize(200, 30);
		findPwdBtn.setLocation(X + 400, pwdY + labelHeight + 20);

		// 비밀번호 찾기 그림자 효과
		JLabel findPwdShadow = new JLabel(findPwdBtn.getText());
		findPwdShadow.setFont(labelfont);
		findPwdShadow.setHorizontalAlignment(JLabel.CENTER);
		findPwdShadow.setSize(200, 30);
		findPwdShadow.setLocation(X + 400 + 2, pwdY + labelHeight + 20 + 2);

		// 결과 확인 라벨
		JLabel resultLabel = new JLabel();
		resultLabel.setSize(600, 300);
		resultLabel.setLocation(100, 100);
		resultLabel.setOpaque(true);
		resultLabel.setBackground(new Color(250, 220, 120));

		// 결과 확인 텍스트
		JLabel resultText = new JLabel();
		resultText.setSize(resultLabel.getWidth(), 30);
		resultText.setLocation(resultLabel.getX(), resultLabel.getY() + resultLabel.getHeight() / 2);
		resultText.setHorizontalAlignment(JLabel.CENTER);
		resultText.setFont(labelFont);

		// 결과확인 창 닫기
		JButton closeBtn = new JButton("닫기");
		closeBtn.setSize(100, 50);
		closeBtn.setLocation(resultLabel.getX() + (resultLabel.getWidth() - closeBtn.getWidth()) / 2,
				resultLabel.getY() + resultLabel.getHeight() - closeBtn.getHeight());
		resultLabel.setVisible(false);
		resultText.setVisible(false);
		closeBtn.setVisible(false);

		// 패널에 추가

		panel.add(closeBtn);
		panel.add(resultText);
		panel.add(resultLabel);

		panel.add(titleLabel1);
		panel.add(titleLabel2);
		panel.add(titleShadow1);
		panel.add(titleShadow2);
		panel.add(idLabel);
		panel.add(idShadow);
		panel.add(idText);
		panel.add(pwdLabel);
		panel.add(pwdShadow);
		panel.add(pwdText);
		panel.add(loginBtn);
		panel.add(loginShadow);
		panel.add(signUpBtn);
		panel.add(signUpShadow);
		panel.add(findPwdBtn);
		panel.add(findPwdShadow);
		panel.add(backgroundLabel);

		myPage.add(panel);

		myPage.setVisible(true);
		myPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resultLabel.setVisible(true);
				resultText.setVisible(true);
				closeBtn.setVisible(true);

				String pass1 = new String(pwdText.getPassword());

				if (idText.getText().isEmpty() || pass1.isEmpty()) {
					resultText.setText("미입력된 정보가 있습니다.");
				} else {

					Map<String, String> map = new HashMap<>();
					map.put("id", idText.getText());
					map.put("pass", pass1);

					PlayerController signController = new PlayerController();

					PlayerDTO player = signController.loginPlayer(map);
					if (player != null) {
						myPage.dispose();
						if (player.getName().equals("관리자")) {
							new ManagerMainPage();
						} else {
							new GameMain(player);
						}
					} else {
						resultText.setText("로그인 정보가 틀렸습니다.");
					}
				}

			}
		});

		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resultLabel.setVisible(false);
				resultText.setVisible(false);
				closeBtn.setVisible(false);

				if (isLogin) {
					myPage.dispose();
					new Connecting();
				}
			}
		});

		signUpBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new SignUpPage();

			}
		});

		findPwdBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new FindPasswordPage();

			}
		});
	}

}
