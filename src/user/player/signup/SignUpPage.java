package user.player.signup;

import static user.player.run.Application.labelFont;
import static user.player.run.Application.littlebigFont;
import static user.player.run.Application.titleFont;

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

import user.player.signup.controller.PlayerController;

public class SignUpPage extends JFrame {

	private JFrame myPage;
	private PlayerController signController = new PlayerController();

	private String tempId, tempPwd, tempName;
	private boolean isCreate;

	public SignUpPage() {

		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setAutoRequestFocus(false);

		this.myPage = this;

		ImageIcon img = new ImageIcon("images/background.png"); // 배경 이미지

		// 뒤로가기
		ImageIcon back = new ImageIcon("images/back.png");

		Color labelColor = new Color(247, 243, 130);

		Font textFont = new Font("DungGeunMo", Font.BOLD, 20);

		JPanel panel = new JPanel();

		panel.setLayout(null);

		// 배경화면
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

		// 회원가입 타이틀
		JLabel titleLabel = new JLabel("회원가입");
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(new Color(207, 161, 255));
		titleLabel.setSize(380, 90);
		titleLabel.setLocation((myPage.getWidth() - titleLabel.getWidth()) / 2, 0);

		JLabel titleShadow = new JLabel(titleLabel.getText());
		titleShadow.setFont(titleFont);
		titleShadow.setSize(titleLabel.getWidth(), titleLabel.getHeight());
		titleShadow.setLocation(titleLabel.getX() + 3, titleLabel.getY() + 3);

		int labelW = 200;
		int labelH = 30;
		int labelX = 100;
		int labelY = 115;

		int fix = labelH + 25;
		int i = 0;

		int textW = 300;
		int textH = labelH;
		int textX = labelX + labelW;

		// 아이디 라벨
		JLabel idLabel = new JLabel("아이디 ");
		idLabel.setFont(labelFont);
		idLabel.setForeground(labelColor);
		idLabel.setSize(labelW, labelH);
		idLabel.setLocation(labelX, labelY + fix * i++);

		// 아이디 그림자 효과
		JLabel idShadow = new JLabel(idLabel.getText());
		idShadow.setFont(labelFont);
		idShadow.setSize(idLabel.getWidth(), idLabel.getHeight());
		idShadow.setLocation(idLabel.getX() + 2, idLabel.getY() + 2);

		// 아이디 텍스트
		JTextField idText = new JTextField();
		idText.setSize(textW, textH);
		idText.setLocation(textX, idLabel.getY());

		// 중복 확인 결과 메시지
		JLabel idCheckLabel = new JLabel();
		idCheckLabel.setFont(textFont);
		idCheckLabel.setSize(textW, textH);
		idCheckLabel.setLocation(textX, idLabel.getY() + textH);

		// 아이디 중복 확인 버튼
		JButton idCheckBtn = new JButton("중복확인");
		idCheckBtn.setBorderPainted(false);
		idCheckBtn.setContentAreaFilled(false);
		idCheckBtn.setFocusPainted(false);
		idCheckBtn.setSize(labelW, labelH);
		idCheckBtn.setLocation(textX + textW, idLabel.getY());
		idCheckBtn.setFont(labelFont);

		// 비밀번호 라벨
		JLabel pwdLabel = new JLabel("비밀번호 ");
		pwdLabel.setFont(labelFont);
		pwdLabel.setForeground(labelColor);
		pwdLabel.setSize(labelW, labelH);
		pwdLabel.setLocation(labelX, labelY + fix * i++);

		// 비밀번호 그림자 효과
		JLabel pwdShadow = new JLabel(pwdLabel.getText());
		pwdShadow.setFont(labelFont);
		pwdShadow.setSize(pwdLabel.getWidth(), pwdLabel.getHeight());
		pwdShadow.setLocation(pwdLabel.getX() + 2, pwdLabel.getY() + 2);

		// 비밀번호 텍스트
		JPasswordField pwdText = new JPasswordField();
		pwdText.setSize(textW, textH);
		pwdText.setLocation(textX, pwdLabel.getY());

		// 비밀번호 확인 라벨
		JLabel pwdLabel2 = new JLabel("비밀번호 확인 ");
		pwdLabel2.setFont(labelFont);
		pwdLabel2.setForeground(labelColor);
		pwdLabel2.setSize(labelW, labelH);
		pwdLabel2.setLocation(labelX, labelY + fix * i++);

		// 비밀번호 확인 그림자 효과
		JLabel pwdShadow2 = new JLabel(pwdLabel2.getText());
		pwdShadow2.setFont(labelFont);
		pwdShadow2.setSize(pwdLabel2.getWidth(), pwdLabel2.getHeight());
		pwdShadow2.setLocation(pwdLabel2.getX() + 2, pwdLabel2.getY() + 2);

		// 비밀번호 확인 텍스트
		JPasswordField pwdText2 = new JPasswordField();
		pwdText2.setSize(textW, textH);
		pwdText2.setLocation(textX, pwdLabel2.getY());

		// 일치 확인 결과 메시지
		JLabel pwdCheckLabel = new JLabel();
		pwdCheckLabel.setFont(textFont);
		pwdCheckLabel.setSize(textW, textH);
		pwdCheckLabel.setLocation(textX, pwdLabel2.getY() + textH);

		// 비밀번호 확인 버튼
		JButton pwdCheckBtn = new JButton("비밀번호확인");
		pwdCheckBtn.setBorderPainted(false);
		pwdCheckBtn.setContentAreaFilled(false);
		pwdCheckBtn.setFocusPainted(false);
		pwdCheckBtn.setSize(labelW, labelH);
		pwdCheckBtn.setLocation(textX + textW, pwdLabel2.getY());
		pwdCheckBtn.setFont(labelFont);

		// 닉네임 라벨
		JLabel nameLabel = new JLabel("닉네임 ");
		nameLabel.setFont(labelFont);
		nameLabel.setForeground(labelColor);
		nameLabel.setSize(labelW, labelH);
		nameLabel.setLocation(labelX, labelY + fix * i++);

		// 닉네임 그림자 효과
		JLabel nameShadow = new JLabel(nameLabel.getText());
		nameShadow.setFont(labelFont);
		nameShadow.setSize(nameLabel.getWidth(), nameLabel.getHeight());
		nameShadow.setLocation(nameLabel.getX() + 2, nameLabel.getY() + 2);

		// 닉네임 텍스트
		JTextField nameText = new JTextField();
		nameText.setSize(textW, textH);
		nameText.setLocation(textX, nameLabel.getY());

		// 중복 확인 결과 메시지
		JLabel nameCheckLabel = new JLabel();
		nameCheckLabel.setFont(textFont);
		nameCheckLabel.setSize(textW, textH);
		nameCheckLabel.setLocation(textX, nameText.getY() + textH);

		// 닉네인 중복 확인 버튼
		JButton nameCheckBtn = new JButton("중복확인");
		nameCheckBtn.setBorderPainted(false);
		nameCheckBtn.setContentAreaFilled(false);
		nameCheckBtn.setFocusPainted(false);
		nameCheckBtn.setSize(labelW, labelH);
		nameCheckBtn.setLocation(textX + textW, nameLabel.getY());
		nameCheckBtn.setFont(labelFont);

		// 이메일 라벨
		JLabel emailLabel = new JLabel("이메일 ");
		emailLabel.setFont(labelFont);
		emailLabel.setForeground(labelColor);
		emailLabel.setSize(labelW, labelH);
		emailLabel.setLocation(labelX, labelY + fix * i++);

		// 이메일 그림자 효과
		JLabel emailShadow = new JLabel(emailLabel.getText());
		emailShadow.setFont(labelFont);
		emailShadow.setSize(emailLabel.getWidth(), emailLabel.getHeight());
		emailShadow.setLocation(emailLabel.getX() + 2, emailLabel.getY() + 2);

		// 이메일 텍스트
		JTextField emailText = new JTextField();
		emailText.setSize(textW, textH);
		emailText.setLocation(textX, emailLabel.getY());

		// // 회원가입완료 버튼
		JButton signUp = new JButton("회원가입완료");
		signUp.setBorderPainted(false);
		signUp.setContentAreaFilled(false);
		signUp.setFocusPainted(false);
		signUp.setFont(littlebigFont);
		signUp.setForeground(labelColor);
		signUp.setSize(380, 60);
		signUp.setLocation((myPage.getWidth() - signUp.getWidth()) / 2, labelY + fix * i++);

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

		panel.add(titleLabel);
		panel.add(titleShadow);

		panel.add(idLabel);
		panel.add(idShadow);
		panel.add(idText);
		panel.add(idCheckLabel);
		panel.add(idCheckBtn);

		panel.add(pwdLabel);
		panel.add(pwdShadow);
		panel.add(pwdText);

		panel.add(pwdLabel2);
		panel.add(pwdShadow2);
		panel.add(pwdText2);
		panel.add(pwdCheckLabel);
		panel.add(pwdCheckBtn);

		panel.add(nameLabel);
		panel.add(nameShadow);
		panel.add(nameText);
		panel.add(nameCheckLabel);
		panel.add(nameCheckBtn);

		panel.add(emailLabel);
		panel.add(emailText);
		panel.add(emailShadow);

		panel.add(signUp);
		panel.add(backBtn);
		panel.add(background);

		this.add(panel);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		idCheckBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Map<String, String> map = new HashMap<>();
				map.put("id", idText.getText());

				boolean isFind = signController.findPlayer(map);

				if (isFind) {
					idCheckLabel.setText("사용 가능한 아이디입니다.");
					idCheckLabel.setForeground(Color.BLACK);
					tempId = idText.getText();
				} else {
					idCheckLabel.setText("이미 사용 중인 아이디입니다.");
					idCheckLabel.setForeground(Color.RED);
				}

			}
		});

		pwdCheckBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String pass1 = new String(pwdText.getPassword());
				String pass2 = new String(pwdText2.getPassword());

				if (pass1.isEmpty()) {
					pwdCheckLabel.setText("비밀번호를 입력해주세요.");
					pwdCheckLabel.setForeground(Color.RED);
				} else {
					if (pass1.equals(pass2)) {
						pwdCheckLabel.setText("비밀번호가 일치합니다.");
						pwdCheckLabel.setForeground(Color.BLACK);
						tempPwd = pass1;
					} else {
						pwdCheckLabel.setText("비밀번호가 일치하지 않습니다.");
						pwdCheckLabel.setForeground(Color.RED);
					}
				}

			}
		});

		nameCheckBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Map<String, String> map = new HashMap<>();
				map.put("name", nameText.getText());

				boolean isFind = signController.findPlayer(map);
				if (isFind) {
					nameCheckLabel.setText("사용 가능한 닉네임입니다.");
					nameCheckLabel.setForeground(Color.BLACK);
					tempName = nameText.getText();
				} else {
					nameCheckLabel.setText("이미 사용 중인 닉네임입니다.");
					nameCheckLabel.setForeground(Color.RED);
				}
			}
		});

		signUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resultLabel.setVisible(true);
				resultText.setVisible(true);
				closeBtn.setVisible(true);

				String pass1 = new String(pwdText.getPassword());

				if (idText.getText().equals(tempId) && pass1.equals(tempPwd) && nameText.getText().equals(tempName)
						&& !emailText.getText().isEmpty()) {

					Map<String, String> map = new HashMap<>();
					map.put("id", tempId);
					map.put("pwd", tempPwd);
					map.put("name", tempName);
					map.put("email", emailText.getText());

					isCreate = signController.insertNewPlayer(map);
					if (isCreate) {
						resultText.setText("회원가입이 되었습니다.");
					} else {
						resultText.setText("회원가입에 실패하셨습니다.");
					}

				} else {
					resultText.setText("미입력된 정보가 있습니다.");
				}
			}
		});

		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				resultLabel.setVisible(false);
				resultText.setVisible(false);
				closeBtn.setVisible(false);

				if (isCreate) {
					myPage.dispose();
					new LoginPage();
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