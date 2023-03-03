package user.player.storage;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import user.player.common.dto.IngreDTO;
import user.player.common.dto.PlayerDTO;
import user.player.common.dto.StorageDTO;
import user.player.ingreup.controller.IngreController;

public class IngreStoragePage extends JFrame {

	private JFrame myPage;

	public IngreStoragePage(PlayerDTO player) {
		Font labelFont = new Font("DungGeunMo", Font.PLAIN, 25);
		Font ingreLabelFont = new Font("DungGeunMo", Font.PLAIN, 20);
		IngreController ingreController = new IngreController();

		this.myPage = this;
		myPage.setSize(800, 500);
		myPage.setLocationRelativeTo(null);
		myPage.setResizable(false);

		JPanel panel = new JPanel();

		panel.setLayout(null);

		int btnW = 220;
		int btnH = 60;
		int btnX = 400 - btnW / 2;
		int btnY = 0;

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
		JLabel panelLabel = new JLabel();
		panelLabel.setIcon(img);
		panelLabel.setSize(btnW, btnH);
		panelLabel.setLocation(btnX, btnY);

		JLabel ingreText = new JLabel("재료 확인");
		ingreText.setFont(labelFont);
		ingreText.setHorizontalAlignment(JLabel.CENTER);
		ingreText.setSize(btnW, btnH);
		ingreText.setLocation(btnX, btnY);

		int ingreW = 90;
		int ingreH = ingreW;
		int ingreX = 135;
		int ingreY = 55;

		List<StorageDTO> ingreList = ingreController.findAllingre(player);

		int index = 0;

		JLabel[][] ingreLabels = new JLabel[3][4];
		JLabel[][] ingreCntLabels = new JLabel[3][4];

		label: for (int i = 0; i < ingreLabels.length; i++) {
			for (int k = 0; k < ingreLabels[i].length; k++) {
				if (index >= ingreList.size())
					break label;

				Image IngreeImage = new ImageIcon(ingreList.get(index).getImg()).getImage().getScaledInstance(ingreW,
						ingreH, 0);
				ingreLabels[i][k] = new JLabel(new ImageIcon(IngreeImage));
				ingreLabels[i][k].setSize(ingreW, ingreH);
				ingreLabels[i][k].setLocation(ingreX + 150 * k, ingreY + 145 * i);
				panel.add(ingreLabels[i][k]);

				ingreCntLabels[i][k] = new JLabel("X"+ingreList.get(index).getIngreCnt());
				ingreCntLabels[i][k].setFont(ingreLabelFont);
				ingreCntLabels[i][k].setHorizontalAlignment(JLabel.CENTER);
				ingreCntLabels[i][k].setSize(ingreW, 25);
				ingreCntLabels[i][k].setLocation(ingreX + 150 * k, ingreY + ingreH + 145 * i);
				panel.add(ingreCntLabels[i][k]);
				index++;
			}
		}

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new StoragePage(player);

			}
		});

		// 패녈에 추가
		panel.add(backBtn);
		panel.add(backLabel);
		panel.add(ingreText);
		panel.add(panelLabel);
		panel.add(background);

		myPage.add(panel);

		myPage.setVisible(true);
		myPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}