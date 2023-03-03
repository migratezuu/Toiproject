package user.player.gamemain;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import user.player.common.dto.PlayerDTO;
import user.player.info.UserInfoPage;
import user.player.realplay.PlayMain;
import user.player.signup.GameStart;
import user.player.storage.StoragePage;
import user.player.store.StoreMainPage;

public class GameMain extends JFrame {

	private JFrame myPage;

	public GameMain(PlayerDTO player) {
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setAutoRequestFocus(false);

		this.myPage = this;

		ImageIcon img = new ImageIcon("images/GameMain.png");

		JPanel panel = new JPanel();

		panel.setLayout(null);

		JLabel background = new JLabel(img);
		background.setLocation(0, -15);
		background.setSize(800, 500);

		JButton play = new JButton();
		play.setFocusPainted(false);
		play.setBorderPainted(false);
		play.setContentAreaFilled(false);
		play.setSize(137, 45);
		play.setLocation(68, 220);

		play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new PlayMain(player);
			}
		});

		JButton store = new JButton();
		store.setFocusPainted(false);
		store.setBorderPainted(false);
		store.setContentAreaFilled(false);
		store.setSize(137, 45);
		store.setLocation(511, 87);

		store.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new StoreMainPage(player);
			}
		});

		JButton storage = new JButton();
		storage.setFocusPainted(false);
		storage.setBorderPainted(false);
		storage.setContentAreaFilled(false);
		storage.setSize(125, 45);
		storage.setLocation(279, 102);

		storage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new StoragePage(player);
			}
		});

		JButton mypage = new JButton();
		mypage.setFocusPainted(false);
		mypage.setBorderPainted(false);
		mypage.setContentAreaFilled(false);
		mypage.setSize(137, 45);
		mypage.setLocation(402, 346);

		mypage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new UserInfoPage(player);
			}
		});

		JButton gameout = new JButton();
		gameout.setFocusPainted(false);
		gameout.setBorderPainted(false);
		gameout.setContentAreaFilled(false);
		gameout.setSize(137, 45);
		gameout.setLocation(645, 427);

		gameout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new GameStart();
			}
		});

		Font labelFont = new Font("DungGeunMo", Font.PLAIN, 25);

		JLabel playerStore = new JLabel();
		playerStore.setSize(myPage.getWidth() / 6, 45);
		playerStore.setLocation(20, 0);
		playerStore.setFont(labelFont);
		playerStore.setText("포장마차");

		JLabel playerGold = new JLabel();
		playerGold.setSize(myPage.getWidth() / 4, 45);
		playerGold.setLocation(playerStore.getWidth() * 2 + 50, 0);
		playerGold.setFont(labelFont);
		playerGold.setText("자금 : " + player.getGold());

		JLabel playerExp = new JLabel();
		playerExp.setSize(myPage.getWidth() / 3, 45);
		playerExp.setLocation(playerGold.getX() + playerGold.getWidth(), 0);
		playerExp.setFont(labelFont);
		playerExp.setText("경험치 : " + player.getExp());

		panel.setLayout(null);
		panel.add(playerGold);
		panel.add(playerExp);
		panel.add(playerStore);
		panel.add(play);
		panel.add(store);
		panel.add(storage);
		panel.add(mypage);
		panel.add(gameout);
		panel.add(background);

		myPage.add(panel);

		myPage.setVisible(true);
		myPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
