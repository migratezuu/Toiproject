package user.player.store.receip;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import user.player.common.dto.PlayerDTO;
import user.player.common.dto.RecipeDTO;
import user.player.manager.controller.ManagerController;
import user.player.store.StoreMainPage;

public class StoreReceipPage extends JFrame {

	Font labelFont = new Font("DungGeunMo", Font.PLAIN, 25);
	Font textFont = new Font("DungGeunMo", Font.PLAIN, 20);

	private int Recipeindex;
	private List<JButton> Recipe;
	private List<RecipeDTO> RecipeList;
	private JFrame myPage;
	private Map<String, Integer> RecipePage = new HashMap<>();

	public StoreReceipPage(PlayerDTO player) {

		Font nonvisibleFont = new Font("DungGeunMo", Font.PLAIN, 20);

		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setAutoRequestFocus(false);

		this.myPage = this;

		ImageIcon img = new ImageIcon("images/StoreReceip.png");
		Image btn = new ImageIcon("images/buttonFrame.png").getImage().getScaledInstance(146, 40, 0);
		ImageIcon btnImg = new ImageIcon(btn);

		JLabel background = new JLabel(img);
		background.setSize(800, 500);
		background.setLocation(0, 0);

		JPanel panel = new JPanel();

		panel.setLayout(null);

		ImageIcon boardIcon = new ImageIcon("images/board2.png");
		JLabel board = new JLabel(boardIcon);
		board.setSize(boardIcon.getIconWidth(), boardIcon.getIconHeight());
		board.setLocation((myPage.getWidth() - board.getWidth()) / 2, (myPage.getHeight() - board.getHeight()) / 2);
		board.setVisible(false);

		JButton payBtn = new JButton("구매");
		payBtn.setBorderPainted(false);
		payBtn.setContentAreaFilled(false);
		payBtn.setFocusPainted(false);
		payBtn.setSize(100, 40);
		payBtn.setLocation(board.getX() + 30, board.getY() + board.getHeight() - payBtn.getHeight() * 2);
		payBtn.setFont(labelFont);
		payBtn.setVisible(false);

		JButton closeBtn = new JButton("닫기");
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		closeBtn.setSize(100, 40);
		closeBtn.setLocation(board.getX() + 250, board.getY() + board.getHeight() - closeBtn.getHeight() * 2);
		closeBtn.setFont(labelFont);
		closeBtn.setVisible(false);

		JLabel msglbl = new JLabel();
		msglbl.setSize(board.getWidth(), 30);
		msglbl.setLocation(board.getX(), board.getY() + (board.getHeight() - msglbl.getHeight()) / 2);
		msglbl.setFont(labelFont);
		msglbl.setHorizontalAlignment(JLabel.CENTER);
		msglbl.setVisible(false);

		Color labelColor = new Color(250, 220, 120);

		int lblX = 25;
		int lblY = 60;


		JLabel ingreLabel = new JLabel();
		ingreLabel.setSize(500, 390);
		ingreLabel.setLocation(lblX, lblY);
		ingreLabel.setOpaque(true);
		ingreLabel.setBackground(labelColor);

		JLabel goldLabel = new JLabel(btnImg);
		goldLabel.setSize(btnImg.getIconWidth(), btnImg.getIconHeight());
		goldLabel.setLocation(170 + ingreLabel.getWidth() - btnImg.getIconWidth(),
				(30 + ingreLabel.getY() - btnImg.getIconHeight()) / 2);

		player.getGold();
		JLabel goldText = new JLabel("자금 : " + player.getGold() + "원");
		goldText.setSize(goldLabel.getWidth(), goldLabel.getHeight());
		goldText.setLocation(goldLabel.getX(), goldLabel.getY());
		goldText.setFont(textFont);
		goldText.setHorizontalAlignment(JLabel.CENTER);

		panel.add(goldText);
		panel.add(goldLabel);
		panel.add(payBtn);
		panel.add(msglbl);
		panel.add(closeBtn);
		panel.add(board);

		JLabel payLabel = new JLabel();
		payLabel.setSize(220, 280);
		payLabel.setLocation(25, 70);

		// 뒤로가기 버튼
		JButton btnBack = new JButton();
		btnBack.setLocation(5, 5);
		btnBack.setSize(70, 40);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);

		// 왼쪽 페이지 넘기기 버튼
		JButton btnLeft = new JButton();
		btnLeft.setLocation(360, 380);
		btnLeft.setSize(35, 35);
		btnLeft.setContentAreaFilled(false);
		btnLeft.setBorderPainted(false);
		btnLeft.setFocusPainted(false);

		// 오른쪽 페이지 넘기기 버튼
		JButton btnRight = new JButton();
		btnRight.setLocation(420, 380);
		btnRight.setSize(35, 35);
		btnRight.setContentAreaFilled(false);
		btnRight.setBorderPainted(false);
		btnRight.setFocusPainted(false);

		Image recipe = new ImageIcon("images/recipe1.png").getImage().getScaledInstance(80, 80, 0);

		Recipe = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			for(int k = 0; k < 5; k++) {
				JButton RecipeBtn = new JButton();
				RecipeBtn.setBorderPainted(false);
				RecipeBtn.setContentAreaFilled(false);
				RecipeBtn.setFocusPainted(false);
				RecipeBtn.setFont(nonvisibleFont);
				RecipeBtn.setForeground(Color.BLACK);
				RecipeBtn.setIcon(new ImageIcon(recipe));
				RecipeBtn.setSize(115, 90);		
				//				RecipeBtn.setVerticalTextPosition(JButton.BOTTOM);
				RecipeBtn.setHorizontalTextPosition(JButton.CENTER);
				RecipeBtn.setLocation(80 +(RecipeBtn.getWidth() + 20) * k ,
						80 + (RecipeBtn.getHeight() + 20) * i + 0);

				Recipe.add(RecipeBtn);

			}

		}

		Paging();

		for (JButton btn2: Recipe) {
			panel.add(btn2);
		}
		panel.add(btnBack);
		panel.add(btnLeft);
		panel.add(btnRight);
		panel.add(background);

		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.dispose();
				new StoreMainPage(player);

			}
		});

		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				board.setVisible(false);
				closeBtn.setVisible(false);
				msglbl.setVisible(false);
				payBtn.setVisible(false);
			}
		});

		Recipe.get(0).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Recipeindex = 0;
				board.setVisible(true);
				closeBtn.setVisible(true);
				msglbl.setVisible(true);
				payBtn.setVisible(true);
				msglbl.setText(RecipeList.get(Recipeindex).getName() + " : " + RecipeList.get(Recipeindex).getRecipePrice() + " 원 ");

			}
		});

		Recipe.get(1).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Recipeindex = 1;
				board.setVisible(true);
				closeBtn.setVisible(true);
				msglbl.setVisible(true);
				payBtn.setVisible(true);
				msglbl.setText(RecipeList.get(Recipeindex).getName() + " : " + RecipeList.get(Recipeindex).getRecipePrice() + " 원 ");
			}
		});

		Recipe.get(2).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Recipeindex = 2;
				board.setVisible(true);
				closeBtn.setVisible(true);
				msglbl.setVisible(true);
				payBtn.setVisible(true);
				msglbl.setText(RecipeList.get(Recipeindex).getName() + " : " + RecipeList.get(Recipeindex).getRecipePrice() + " 원 ");
			}
		});

		Recipe.get(3).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Recipeindex = 3;
				board.setVisible(true);
				closeBtn.setVisible(true);
				msglbl.setVisible(true);
				payBtn.setVisible(true);
				msglbl.setText(RecipeList.get(Recipeindex).getName() + " : " + RecipeList.get(Recipeindex).getRecipePrice() + " 원 ");
			}
		});

		Recipe.get(4).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Recipeindex = 4;
				board.setVisible(true);
				closeBtn.setVisible(true);
				msglbl.setVisible(true);
				payBtn.setVisible(true);
				msglbl.setText(RecipeList.get(Recipeindex).getName() + " : " + RecipeList.get(Recipeindex).getRecipePrice() + " 원 ");
			}
		});

		Recipe.get(5).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Recipeindex = 5;
				board.setVisible(true);
				closeBtn.setVisible(true);
				msglbl.setVisible(true);
				payBtn.setVisible(true);
				msglbl.setText(RecipeList.get(Recipeindex).getName() + " : " + RecipeList.get(Recipeindex).getRecipePrice() + " 원 ");
			}
		});

		Recipe.get(6).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Recipeindex = 6;
				board.setVisible(true);
				closeBtn.setVisible(true);
				msglbl.setVisible(true);
				payBtn.setVisible(true);
				msglbl.setText(RecipeList.get(Recipeindex).getName() + " : " + RecipeList.get(Recipeindex).getRecipePrice() + " 원 ");
			}
		});

		Recipe.get(7).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Recipeindex = 7;
				board.setVisible(true);
				closeBtn.setVisible(true);
				msglbl.setVisible(true);
				payBtn.setVisible(true);
				msglbl.setText(RecipeList.get(Recipeindex).getName() + " : " + RecipeList.get(Recipeindex).getRecipePrice() + " 원 ");
			}
		});

		Recipe.get(8).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Recipeindex = 8;
				board.setVisible(true);
				closeBtn.setVisible(true);
				msglbl.setVisible(true);
				payBtn.setVisible(true);
				msglbl.setText(RecipeList.get(Recipeindex).getName() + " : " + RecipeList.get(Recipeindex).getRecipePrice() + " 원 ");
			}
		});

		Recipe.get(9).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Recipeindex = 9;
				board.setVisible(true);
				closeBtn.setVisible(true);
				msglbl.setVisible(true);
				payBtn.setVisible(true);
				msglbl.setText(RecipeList.get(Recipeindex).getName() + " : " + RecipeList.get(Recipeindex).getRecipePrice() + " 원 ");
			}
		});

		Recipe.get(10).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Recipeindex = 10;
				board.setVisible(true);
				closeBtn.setVisible(true);
				msglbl.setVisible(true);
				payBtn.setVisible(true);
				msglbl.setText(RecipeList.get(Recipeindex).getName() + " : " + RecipeList.get(Recipeindex).getRecipePrice() + " 원 ");
			}
		});

		Recipe.get(11).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Recipeindex = 11;
				board.setVisible(true);
				closeBtn.setVisible(true);
				msglbl.setVisible(true);
				payBtn.setVisible(true);
				msglbl.setText(RecipeList.get(Recipeindex).getName() + " : " + RecipeList.get(Recipeindex).getRecipePrice() + " 원 ");
			}
		});

		Recipe.get(12).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Recipeindex = 12;
				board.setVisible(true);
				closeBtn.setVisible(true);
				msglbl.setVisible(true);
				payBtn.setVisible(true);
				msglbl.setText(RecipeList.get(Recipeindex).getName() + " : " + RecipeList.get(Recipeindex).getRecipePrice() + " 원 ");
			}
		});

		Recipe.get(13).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Recipeindex = 13;
				board.setVisible(true);
				closeBtn.setVisible(true);
				msglbl.setVisible(true);
				payBtn.setVisible(true);
				msglbl.setText(RecipeList.get(Recipeindex).getName() + " : " + RecipeList.get(Recipeindex).getRecipePrice() + " 원 ");
			}
		});

		Recipe.get(14).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Recipeindex = 14;
				board.setVisible(true);
				closeBtn.setVisible(true);
				msglbl.setVisible(true);
				payBtn.setVisible(true);
				msglbl.setText(RecipeList.get(Recipeindex).getName() + " : " + RecipeList.get(Recipeindex).getRecipePrice() + " 원 ");
			}
		});

		payBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String message;
				if ( RecipeList.get(Recipeindex).getRecipePrice() > player.getGold()) {
					message = "자금이 부족합니다";
				} else {

					message = "성공적으로 구매하셨습니다.";
					player.setGold(player.getGold() - RecipeList.get(Recipeindex).getRecipePrice());		
					Recipe.get(Recipeindex).setEnabled(false);
					payBtn.setVisible(false);
				}
				msglbl.setText(message);
				goldText.setText("자금 : " + player.getGold() + "원");
			}
		});


	}




	public void Paging() {
		int index = 0;
		RecipePage.put("first", 1);
		RecipePage.put("second", 15);
		ManagerController managerController = new ManagerController();
		RecipeList = managerController.findAllRecipe(RecipePage);

		for(JButton btn: Recipe) {
			if(index >= RecipeList.size()) {
				break;
			}
			btn.setText(RecipeList.get(index).getName());
			index++;
		}

	}

}