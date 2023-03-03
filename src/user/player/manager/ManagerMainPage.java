package user.player.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import user.player.signup.GameStart;

public class ManagerMainPage extends JFrame {

	private JFrame myPage;

	public ManagerMainPage() {

		this.myPage = this;
		myPage.setSize(800, 500);
		myPage.setLocationRelativeTo(null);
		myPage.setResizable(false);

		JPanel panel = new JPanel();

		panel.setLayout(null);

		Font labelFont = new Font("DungGeunMo", Font.PLAIN, 40);

		// 배경
		ImageIcon backgrond = new ImageIcon("images/Market.png");

		// 뒤로가기
		ImageIcon back = new ImageIcon("images/back.png");

		// 목차
		// Image btn = new
		// ImageIcon("images/panelFrame.png").getImage().getScaledInstance(146, 40, 0);
		// ImageIcon btnImg = new ImageIcon(btn);

		// 배경
		JLabel background = new JLabel(backgrond);
		background.setSize(800, 500);
		background.setLocation(0, 0);

		// 이전 화면 이동
		JButton backBtn = new JButton();
		backBtn.setIcon(back);
		backBtn.setBorderPainted(false);
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
		backBtn.setSize(back.getIconWidth(), back.getIconHeight());
		backBtn.setLocation(0, 0);

		// 재료 화면
		Color labelColor = new Color(250, 220, 120);
		Color fontColor = new Color(50, 50, 250);

		int lblW = 300;
		int lblH = 390;

		int lblX = 70;
		int lblY = 50;

		// 관리 목록 배경
		JLabel ingreLabel1 = new JLabel();
		ingreLabel1.setSize(lblW, lblH);
		ingreLabel1.setLocation(lblX, lblY);
		ingreLabel1.setOpaque(true);
		ingreLabel1.setBackground(labelColor);

		JLabel ingreLabel2 = new JLabel();
		ingreLabel2.setSize(lblW, lblH);
		ingreLabel2.setLocation(lblX + lblW + 60, lblY);
		ingreLabel2.setOpaque(true);
		ingreLabel2.setBackground(labelColor);

		// 관리 목록 버튼
		int btnW = lblW;
		int btnH = 60;

		int btnY = lblY + 45;

		int i = 0;

		JButton ingreBtn = new JButton("재료 관리");
		ingreBtn.setBorderPainted(false);
		ingreBtn.setContentAreaFilled(false);
		ingreBtn.setFocusPainted(false);
		ingreBtn.setFont(labelFont);
		ingreBtn.setForeground(fontColor);
		ingreBtn.setSize(btnW, btnH);
		ingreBtn.setLocation(ingreLabel2.getX(), btnY + btnH * i++);

		JButton playerBtn = new JButton("회원 관리");
		playerBtn.setBorderPainted(false);
		playerBtn.setContentAreaFilled(false);
		playerBtn.setFocusPainted(false);
		playerBtn.setFont(labelFont);
		playerBtn.setForeground(fontColor);
		playerBtn.setSize(btnW, btnH);
		playerBtn.setLocation(ingreLabel1.getX(), btnY + btnH * i++);

		JButton recipeBtn = new JButton("레시피 관리");
		recipeBtn.setBorderPainted(false);
		recipeBtn.setContentAreaFilled(false);
		recipeBtn.setFocusPainted(false);
		recipeBtn.setFont(labelFont);
		recipeBtn.setForeground(fontColor);
		recipeBtn.setSize(btnW, btnH);
		recipeBtn.setLocation(ingreLabel2.getX(), btnY + btnH * i++);

		JButton rankBtn = new JButton("랭킹 관리");
		rankBtn.setBorderPainted(false);
		rankBtn.setContentAreaFilled(false);
		rankBtn.setFocusPainted(false);
		rankBtn.setFont(labelFont);
		rankBtn.setForeground(fontColor);
		rankBtn.setSize(btnW, btnH);
		rankBtn.setLocation(ingreLabel1.getX(), btnY + btnH * i++);

		JButton storeBtn = new JButton("가게 관리");
		storeBtn.setBorderPainted(false);
		storeBtn.setContentAreaFilled(false);
		storeBtn.setFocusPainted(false);
		storeBtn.setFont(labelFont);
		storeBtn.setForeground(fontColor);
		storeBtn.setSize(btnW, btnH);
		storeBtn.setLocation(ingreLabel2.getX(), btnY + btnH * i++);

		// 패녈에 추가
		panel.add(ingreBtn);
		panel.add(recipeBtn);
		panel.add(storeBtn);
		panel.add(playerBtn);
		panel.add(rankBtn);

		panel.add(ingreLabel1);
		panel.add(ingreLabel2);

		panel.add(backBtn);
		panel.add(background);

		myPage.add(panel);

		myPage.setVisible(true);
		myPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new GameStart();
			}
		});

		ingreBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new IngreManage();
			}
		});

		recipeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new RecipeManage();
			}
		});

		storeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new StoreManage();
			}
		});

	}
}
