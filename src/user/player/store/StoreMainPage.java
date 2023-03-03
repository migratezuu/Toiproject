package user.player.store;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import user.player.common.dto.PlayerDTO;
import user.player.gamemain.GameMain;
import user.player.store.ingre.IngreMarketPage;
import user.player.store.receip.StoreReceipPage;
import user.player.store.update.StoreChoiceUpdate;

public class StoreMainPage extends JFrame {

	private JFrame myPage;

	public StoreMainPage(PlayerDTO player) {
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setAutoRequestFocus(false);

		this.myPage = this;

		ImageIcon img = new ImageIcon("images/StoreMain.png");

		JPanel panel = new JPanel();

		panel.setLayout(null);

		JLabel background = new JLabel(img);
		background.setLocation(0, 0);
		background.setSize(800, 500);

		JButton btnIngre = new JButton();
		btnIngre.setLocation(500, 125);
		btnIngre.setSize(220, 50);
		btnIngre.setContentAreaFilled(false);
		btnIngre.setBorderPainted(false);
		btnIngre.setFocusPainted(false);

		JButton btnRecep = new JButton();
		btnRecep.setLocation(500, 215);
		btnRecep.setSize(225, 50);
		btnRecep.setContentAreaFilled(false);
		btnRecep.setBorderPainted(false);
		btnRecep.setFocusPainted(false);

		JButton btnUpdate = new JButton();
		btnUpdate.setLocation(500, 315);
		btnUpdate.setSize(225, 50);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setFocusPainted(false);

		JButton btnBack = new JButton();
		btnBack.setLocation(5, 5);
		btnBack.setSize(70, 40);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);

		btnIngre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new IngreMarketPage(player);
			}
		});

		btnRecep.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new StoreReceipPage(player);
			}
		});

		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new StoreChoiceUpdate(player);
			}
		});

		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new GameMain(player);

			}
		});

		panel.add(btnIngre);
		panel.add(btnRecep);
		panel.add(btnUpdate);
		panel.add(btnBack);
		panel.add(background);

		this.add(panel);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}