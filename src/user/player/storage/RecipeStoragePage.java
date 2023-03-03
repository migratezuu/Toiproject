package user.player.storage;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import user.player.common.dto.PlayerDTO;
import user.player.common.dto.PlayerRecipeDTO;
import user.player.common.dto.RecipeDTO;
import user.player.ingreup.controller.IngreController;


public class RecipeStoragePage extends JFrame {

	private JFrame myPage;
	private int gold = 0;

	public RecipeStoragePage(PlayerDTO player) {
		Font labelFont = new Font("DungGeunMo", Font.PLAIN, 25);
		Font ingreLabelFont = new Font("DungGeunMo", Font.PLAIN, 20);
		IngreController recipeController = new IngreController();

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
		ImageIcon ingreboard = new ImageIcon("images/storageingreboard.png");

		// 배경
		JLabel background = new JLabel(backgrond);
		background.setSize(800, 500);
		background.setLocation(0, 0);

		// 이전 페이지
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

		JLabel ingreText = new JLabel("레시피 확인");
		ingreText.setFont(labelFont);
		ingreText.setHorizontalAlignment(JLabel.CENTER);
		ingreText.setSize(btnW, btnH);
		ingreText.setLocation(btnX, btnY);

		int recipeW = 90;
		int recipeH = recipeW;
		int recipeX = 135;
		int recipeY = 55;

		Map < String , String > map = new HashMap<>();
		map.put("name", player.getName());
		List<RecipeDTO> recipeList = recipeController.findAllrecipe(map);

		int index = 0;
		Image recipe = new ImageIcon("images/recipe1.png").getImage().getScaledInstance(recipeW, recipeH, 0);

		// JLabel[][] ingreLabels = new JLabel[3][4];
		JButton[][] ingreLabelsBtn = new JButton[3][4];
		JLabel[][] ingreCntLabels = new JLabel[3][4];

		label: for (int i = 0; i < ingreLabelsBtn.length; i++) {
			for (int k = 0; k < ingreLabelsBtn[i].length; k++) {
				if (index >= recipeList.size())
					break label;

				ingreLabelsBtn[i][k] = new JButton(new ImageIcon(recipe));

				ingreLabelsBtn[i][k].setSize(recipeW, recipeH);
				ingreLabelsBtn[i][k].setLocation(recipeX + 150 * k, recipeY + 145 * i);
				ingreLabelsBtn[i][k].setBorderPainted(false);
				ingreLabelsBtn[i][k].setContentAreaFilled(false);
				ingreLabelsBtn[i][k].setFocusPainted(false);

				panel.add(ingreLabelsBtn[i][k]);

				ingreCntLabels[i][k] = new JLabel(recipeList.get(index).getName() + "");
				ingreCntLabels[i][k].setFont(ingreLabelFont);
				ingreCntLabels[i][k].setHorizontalAlignment(JLabel.CENTER);
				ingreCntLabels[i][k].setSize(recipeW, recipeH);
				// ingreCntLabels[i][k].setLocation(recipeX + 150 * k, recipeY + 145 * i); 원래 위치
				ingreCntLabels[i][k].setLocation(recipeX + 150 * k, (recipeY + 55) + 145 * i);
				panel.add(ingreCntLabels[i][k]);
				index++;
				gold++;

//				ingreLabelsBtn[i][k].addActionListener(new ActionListener() {
//
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						Map<String, String> map = new HashMap<>();
//						map.put("name", recipeList.get(gold).getName());
//						myPage.dispose();
//						new RecipeIngreStoragePage(map, player);
//						System.out.println("gold=" + (gold));
//
//					}
//				});

			}
		}

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new StoragePage(player);

			}
		});

		// recipeLabelBtn.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// myPage.dispose();
		// new RecipeIngreStoragePage();
		//
		// }
		// });

		// 패녈에 추가
		panel.add(backBtn);
		panel.add(backLabel);
		panel.add(ingreText);
		panel.add(panelLabel);
		panel.add(background);
		// panel.add(recipeLabelBtn);
		// panel.add(recipeLabel);

		myPage.add(panel);

		myPage.setVisible(true);
		myPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}