package user.player.manager;

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
import javax.swing.JTextField;

import user.player.common.dto.StoreDTO;
import user.player.manager.controller.ManagerController;

public class StoreManage extends JFrame {

	private JFrame myPage;
	private ManagerController managerController = new ManagerController();

	private List<StoreDTO> store;
	private List<JLabel> storeNameShadow;

	private List<JButton> storeList;
	private int storeListIndex = 0;

	private Map<String, Integer> storePage = new HashMap<>();
	private int storePageIndex = 0;

	private JLabel infoLabel;
	private JLabel infoTitle;

	private JLabel levelLabel;
	private JTextField level;
	private JLabel nameLabel;
	private JTextField name;
	private JLabel priceLabel;
	private JTextField price;
	private JLabel maxRecipeLabel;
	private JTextField maxRecipe;
	private JLabel expLabel;
	private JTextField exp;

	private JLabel msgText;

	private JButton addBtn;
	private JButton createBtn;
	private JButton closeBtn;
	private JButton modifyBtn;
	private JButton deleteBtn;

	private Image storeImage;
	private String tempLevel, tempName, tempPrice, tempMaxRecipe, tempExp;

	public StoreManage() {

		this.myPage = this;
		myPage.setSize(800, 500);
		myPage.setLocationRelativeTo(null);
		myPage.setResizable(false);

		JPanel panel = new JPanel();

		panel.setLayout(null);

		Font titleFont = new Font("DungGeunMo", Font.PLAIN, 30);
		Font labelFont = new Font("DungGeunMo", Font.PLAIN, 20);

		Color labelColor = new Color(250, 220, 120);
		Color fontColor = new Color(50, 50, 250);

		// 배경
		ImageIcon backgrond = new ImageIcon("images/Market.png");

		// 뒤로가기
		ImageIcon back = new ImageIcon("images/back.png");

		// 목차
		ImageIcon titleImg = new ImageIcon("images/buttonFrame.png");

		// 이전 페이지/ 다음 페이지 버튼
		ImageIcon nextImg = new ImageIcon("images/nextPage.png");
		ImageIcon previousImg = new ImageIcon("images/previousPage.png");

		// 등록
		Image plusImg = new ImageIcon("images/plusButton.png").getImage().getScaledInstance(30, 30, 0);
		ImageIcon plus = new ImageIcon(plusImg);

		// 가게 정보 배경
		ImageIcon info = new ImageIcon("images/board.png");

		// 가게 정보
		storeImage = new ImageIcon("images/recipe1.png").getImage().getScaledInstance(100, 100, 0);

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

		// 타이틀
		JLabel titleLabel = new JLabel(titleImg);
		titleLabel.setSize(titleImg.getIconWidth(), titleImg.getIconHeight());
		titleLabel.setLocation((myPage.getWidth() - titleLabel.getWidth()) / 2, 0);

		JLabel titleText = new JLabel("가게 관리");
		titleText.setSize(titleImg.getIconWidth(), titleImg.getIconHeight());
		titleText.setLocation((myPage.getWidth() - titleLabel.getWidth()) / 2, 0);
		titleText.setFont(titleFont);
		titleText.setForeground(fontColor);
		titleText.setHorizontalAlignment(JLabel.CENTER);

		// 가게정보 화면
		int lblW = 700;
		int lblH = 380;

		int lblX = 45;
		int lblY = 70;

		// 관리 목록 배경
		JLabel backLabel = new JLabel();
		backLabel.setSize(lblW, lblH);
		backLabel.setLocation(lblX, lblY);
		backLabel.setOpaque(true);
		backLabel.setBackground(labelColor);

		// 이전 페이지, 다음 페이지
		JButton nextPageBtn = new JButton();
		nextPageBtn.setIcon(nextImg);
		nextPageBtn.setBorderPainted(false);
		nextPageBtn.setContentAreaFilled(false);
		nextPageBtn.setFocusPainted(false);
		nextPageBtn.setSize(nextImg.getIconWidth(), nextImg.getIconHeight());
		nextPageBtn.setLocation(lblX + lblW + 10, lblY + 150);

		JButton previousPageBtn = new JButton();
		previousPageBtn.setIcon(previousImg);
		previousPageBtn.setBorderPainted(false);
		previousPageBtn.setContentAreaFilled(false);
		previousPageBtn.setFocusPainted(false);
		previousPageBtn.setSize(previousImg.getIconWidth(), previousImg.getIconHeight());
		previousPageBtn.setLocation(lblX - previousImg.getIconWidth() - 10, lblY + 150);

		storeList = new ArrayList<>();
		storeNameShadow = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 5; k++) {
				JButton store = new JButton();
				store.setBorderPainted(false);
				store.setContentAreaFilled(false);
				store.setFocusPainted(false);
				store.setHorizontalTextPosition(JButton.CENTER);
				store.setFont(labelFont);
				store.setSize(130, 100);
				store.setLocation(lblX + (store.getWidth() + 10) * k + 5, lblY + (store.getHeight() + 20) * i + 20);

				JLabel name = new JLabel();
				name.setFont(labelFont);
				name.setForeground(Color.yellow);
				name.setHorizontalAlignment(JLabel.CENTER);
				name.setSize(store.getWidth(), store.getHeight());
				name.setLocation(store.getX() - 2, store.getY() - 2);

				storeList.add(store);
				storeNameShadow.add(name);
			}
		}

		// 등록 버튼
		addBtn = new JButton();
		addBtn.setIcon(plus);
		addBtn.setBorderPainted(false);
		addBtn.setContentAreaFilled(false);
		addBtn.setFocusPainted(false);
		addBtn.setSize(100, 100);

		paging();

		// 가게 정보 배경
		infoLabel = new JLabel(info);
		infoLabel.setSize(info.getIconWidth(), info.getIconHeight());
		infoLabel.setLocation((myPage.getWidth() - info.getIconWidth()) / 2,
				((myPage.getHeight() - 25) - info.getIconHeight()) / 2);
		infoLabel.setVisible(false);

		// 가게 정보 타이틀
		infoTitle = new JLabel(titleImg);
		infoTitle.setSize(titleImg.getIconWidth(), titleImg.getIconHeight());
		infoTitle.setLocation(infoLabel.getX() + (infoLabel.getWidth() - titleImg.getIconWidth()) / 2,
				infoLabel.getY() + titleImg.getIconHeight() / 4);
		infoTitle.setHorizontalTextPosition(JLabel.CENTER);
		infoTitle.setHorizontalAlignment(JLabel.CENTER);
		infoTitle.setFont(titleFont);
		infoTitle.setForeground(fontColor);
		infoTitle.setVisible(false);

		// 재료 정보 입력
		int fix = 20;

		int infoW = 200;
		int infoH = labelFont.getSize();

		int infoX = infoLabel.getX() + 70;
		int infoY = infoLabel.getY() + 110;

		// 가게 레벨
		levelLabel = new JLabel("레벨 : ");
		levelLabel.setFont(labelFont);
		levelLabel.setSize(infoW, infoH);
		levelLabel.setLocation(infoX, infoY);
		levelLabel.setVisible(false);

		level = new JTextField();
		level.setSize(250, infoH);
		level.setLocation(levelLabel.getX() + levelLabel.getWidth(), levelLabel.getY());
		level.setVisible(false);

		// 가게 이름
		nameLabel = new JLabel("이름 : ");
		nameLabel.setFont(labelFont);
		nameLabel.setSize(infoW, infoH);
		nameLabel.setLocation(infoX, levelLabel.getY() + levelLabel.getHeight() + fix);
		nameLabel.setVisible(false);

		name = new JTextField();
		name.setSize(250, infoH);
		name.setLocation(nameLabel.getX() + nameLabel.getWidth(), nameLabel.getY());
		name.setVisible(false);

		// 가게 구입 가격
		priceLabel = new JLabel("가게 가격 : ");
		priceLabel.setFont(labelFont);
		priceLabel.setSize(infoW, infoH);
		priceLabel.setLocation(infoX, nameLabel.getY() + nameLabel.getHeight() + fix);
		priceLabel.setVisible(false);

		price = new JTextField();
		price.setSize(250, infoH);
		price.setLocation(priceLabel.getX() + priceLabel.getWidth(), priceLabel.getY());
		price.setVisible(false);

		// 최대 보유 레시피 수
		maxRecipeLabel = new JLabel("최대 레시피 수 : ");
		maxRecipeLabel.setFont(labelFont);
		maxRecipeLabel.setSize(infoW, infoH);
		maxRecipeLabel.setLocation(infoX, priceLabel.getY() + priceLabel.getHeight() + fix);
		maxRecipeLabel.setVisible(false);

		maxRecipe = new JTextField();
		maxRecipe.setSize(250, infoH);
		maxRecipe.setLocation(maxRecipeLabel.getX() + maxRecipeLabel.getWidth(), maxRecipeLabel.getY());
		maxRecipe.setVisible(false);

		// 가게 구매시 획득 경험치
		expLabel = new JLabel("경험치 : ");
		expLabel.setFont(labelFont);
		expLabel.setSize(infoW, infoH);
		expLabel.setLocation(infoX, maxRecipeLabel.getY() + maxRecipeLabel.getHeight() + fix);
		expLabel.setVisible(false);

		exp = new JTextField();
		exp.setSize(250, infoH);
		exp.setLocation(expLabel.getX() + expLabel.getWidth(), expLabel.getY());
		exp.setVisible(false);

		// 메시지 라벨
		msgText = new JLabel();
		msgText.setSize(name.getX() + name.getWidth() - infoX, 30);
		msgText.setLocation(infoX, expLabel.getY() + expLabel.getHeight() + fix);
		msgText.setFont(labelFont);
		msgText.setHorizontalAlignment(JLabel.RIGHT);
		msgText.setVisible(false);

		int btnW = 120;
		int btnH = 40;
		int btnX = infoLabel.getX() + 70;
		int btnY = msgText.getY() + msgText.getHeight() + 20;

		int btnFix = 170;

		// 등록 버튼
		createBtn = new JButton("등록");
		createBtn.setIcon(new ImageIcon("images/greenBtn.png"));
		createBtn.setBorderPainted(false);
		createBtn.setContentAreaFilled(false);
		createBtn.setFocusPainted(false);
		createBtn.setHorizontalTextPosition(JButton.CENTER);
		createBtn.setFont(labelFont);
		createBtn.setForeground(Color.WHITE);
		createBtn.setSize(btnW, btnH);
		createBtn.setLocation(btnX + btnFix * 2, btnY);
		createBtn.setVisible(false);

		// 닫기 버튼
		closeBtn = new JButton("닫기");
		closeBtn.setIcon(new ImageIcon("images/cyanBtn.png"));
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		closeBtn.setHorizontalTextPosition(JButton.CENTER);
		closeBtn.setFont(labelFont);
		closeBtn.setForeground(Color.WHITE);
		closeBtn.setSize(btnW, btnH);
		closeBtn.setLocation(btnX + btnFix, btnY);
		closeBtn.setVisible(false);

		// 수정 버튼
		modifyBtn = new JButton("수정");
		modifyBtn.setIcon(new ImageIcon("images/yellowBtn.png"));
		modifyBtn.setBorderPainted(false);
		modifyBtn.setContentAreaFilled(false);
		modifyBtn.setFocusPainted(false);
		modifyBtn.setHorizontalTextPosition(JButton.CENTER);
		modifyBtn.setFont(labelFont);
		modifyBtn.setForeground(Color.WHITE);
		modifyBtn.setSize(btnW, btnH);
		modifyBtn.setLocation(btnX, btnY);
		modifyBtn.setVisible(false);

		// 삭제 버튼
		deleteBtn = new JButton("삭제");
		deleteBtn.setIcon(new ImageIcon("images/redBtn.png"));
		deleteBtn.setBorderPainted(false);
		deleteBtn.setContentAreaFilled(false);
		deleteBtn.setFocusPainted(false);
		deleteBtn.setHorizontalTextPosition(JButton.CENTER);
		deleteBtn.setFont(labelFont);
		deleteBtn.setForeground(Color.WHITE);
		deleteBtn.setSize(btnW, btnH);
		deleteBtn.setLocation(btnX + btnFix * 2, btnY);
		deleteBtn.setVisible(false);

		// 패널에 추가
		panel.add(levelLabel);
		panel.add(level);
		panel.add(nameLabel);
		panel.add(name);
		panel.add(priceLabel);
		panel.add(price);
		panel.add(maxRecipeLabel);
		panel.add(maxRecipe);
		panel.add(expLabel);
		panel.add(exp);
		panel.add(msgText);

		panel.add(deleteBtn);
		panel.add(createBtn);
		panel.add(modifyBtn);
		panel.add(closeBtn);

		panel.add(infoTitle);
		panel.add(infoLabel);

		panel.add(addBtn);

		for (JLabel label : storeNameShadow) {
			panel.add(label);
		}

		for (JButton label : storeList) {
			panel.add(label);
		}

		panel.add(nextPageBtn);
		panel.add(previousPageBtn);

		panel.add(titleText);
		panel.add(titleLabel);
		panel.add(backLabel);

		panel.add(backBtn);
		panel.add(background);

		myPage.add(panel);

		myPage.setVisible(true);
		myPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				myPage.dispose();
				new ManagerMainPage();
			}
		});

		nextPageBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (storeListIndex < 15) {
					return;
				}

				storePageIndex++;
				paging();

			}
		});

		previousPageBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (storePageIndex == 0) {
					return;
				}

				storePageIndex--;
				paging();
			}
		});

		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				elementsVisible("add");
				infoTitle.setText("가게 등록");

			}
		});

		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				elementsVisible("close");
				paging();
			}
		});

		createBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				msgText.setText("");

				String message;
				if (name.getText().isEmpty() || price.getText().isEmpty() || maxRecipe.getText().isEmpty()
						|| exp.getText().isEmpty()) {
					message = "미입력된 정보가 있습니다.";

				} else {

					Map<String, String> map = new HashMap<>();
					map.put("level", level.getText());
					map.put("name", name.getText());
					map.put("price", price.getText());
					map.put("maxRecipe", maxRecipe.getText());
					map.put("exp", exp.getText());

					message = managerController.createNewStore(map);
				}

				msgText.setText(message);

				paging();

			}
		});

		modifyBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (tempLevel.equals(level.getText()) && tempName.equals(name.getText())
						&& tempPrice.equals(price.getText()) && tempMaxRecipe.equals(maxRecipe.getText())
						&& tempExp.equals(exp.getText())) {
					msgText.setText("바뀐 정보가 없습니다.");
					return;
				}

				Map<String, String> map = new HashMap<>();

				map.put("tempLevel", tempLevel);

				if (!level.getText().isEmpty() && !tempLevel.equals(level.getText()))
					map.put("level", level.getText());

				if (!name.getText().isEmpty() && !tempName.equals(name.getText()))
					map.put("name", name.getText());

				if (!price.getText().isEmpty() && !tempPrice.equals(price.getText()))
					map.put("price", price.getText());

				if (!maxRecipe.getText().isEmpty() && !tempMaxRecipe.equals(maxRecipe.getText()))
					map.put("maxRecipe", maxRecipe.getText());

				if (!exp.getText().isEmpty() && !tempExp.equals(exp.getText()))
					map.put("exp", exp.getText());

				String messge = managerController.modifyStore(map);

				msgText.setText(messge);

			}
		});

		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Map<String, String> map = new HashMap<>();

				map.put("level", tempLevel);

				String messge = managerController.deleteStore(map);

				msgText.setText(messge);
			}
		});

		storeList.get(0).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (0 > storeListIndex) {
					return;
				}

				elementsVisible("info");
				recipeInfo(0);
			}
		});

		storeList.get(1).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (1 > storeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(1);
			}
		});

		storeList.get(2).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (2 > storeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(2);
			}
		});

		storeList.get(3).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (3 > storeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(3);
			}
		});

		storeList.get(4).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (4 > storeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(4);
			}
		});

		storeList.get(5).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (5 > storeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(5);
			}
		});

		storeList.get(6).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (6 > storeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(6);
			}
		});

		storeList.get(7).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (7 > storeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(7);
			}
		});

		storeList.get(8).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (8 > storeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(8);
			}
		});

		storeList.get(9).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (9 > storeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(9);
			}
		});

		storeList.get(10).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (10 > storeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(10);
			}
		});

		storeList.get(11).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (11 > storeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(11);
			}
		});

		storeList.get(12).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (12 > storeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(12);
			}
		});

		storeList.get(13).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (13 > storeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(13);
			}
		});

		storeList.get(14).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (14 > storeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(14);
			}
		});
	}

	public void recipeInfo(int infoIndex) {

		tempLevel = store.get(infoIndex).getLevel() + "";
		tempName = store.get(infoIndex).getName();
		tempPrice = store.get(infoIndex).getPrice() + "";
		tempMaxRecipe = store.get(infoIndex).getMaxRecipe() + "";
		tempExp = store.get(infoIndex).getExp() + "";

		infoTitle.setText("NO." + tempLevel);
		level.setText(tempLevel);
		name.setText(tempName);
		price.setText(tempPrice);
		maxRecipe.setText(tempMaxRecipe);
		exp.setText(tempExp);
	}

	public void paging() {
		storePage.put("first", 1 + 15 * storePageIndex);
		storePage.put("second", 15 + 15 * storePageIndex);

		store = managerController.findAllStore(storePage);

		for (int i = 0; i < storeListIndex; i++) {
			storeList.get(i).setIcon(new ImageIcon());
			storeList.get(i).setText("");
			storeNameShadow.get(i).setText("");
		}
		storeListIndex = 0;

		while (storeListIndex < store.size() && storeListIndex < storeList.size()) {

			storeList.get(storeListIndex).setIcon(new ImageIcon(storeImage));
			storeList.get(storeListIndex).setText(store.get(storeListIndex).getName());
			storeNameShadow.get(storeListIndex).setText(store.get(storeListIndex).getName());
			storeListIndex++;
		}

		if (storeListIndex < storeList.size()) {
			addBtn.setVisible(true);
			addBtn.setLocation(
					storeList.get(storeListIndex).getX()
							+ (storeList.get(storeListIndex).getWidth() - addBtn.getWidth()) / 2,
					storeList.get(storeListIndex).getY()
							+ (storeList.get(storeListIndex).getHeight() - addBtn.getHeight()) / 2);

		} else {
			addBtn.setLocation(storeList.get(0).getX() + (storeList.get(0).getWidth() - addBtn.getWidth()) / 2,
					storeList.get(0).getY() + (storeList.get(0).getHeight() - addBtn.getHeight()) / 2);
			addBtn.setVisible(false);
		}
	}

	public void elementsVisible(String btn) {

		boolean isTrue = btn.equals("close") ? false : true;

		levelLabel.setVisible(isTrue);
		level.setVisible(isTrue);

		nameLabel.setVisible(isTrue);
		name.setVisible(isTrue);

		priceLabel.setVisible(isTrue);
		price.setVisible(isTrue);

		maxRecipeLabel.setVisible(isTrue);
		maxRecipe.setVisible(isTrue);

		expLabel.setVisible(isTrue);
		exp.setVisible(isTrue);

		msgText.setVisible(isTrue);

		infoTitle.setVisible(isTrue);
		infoLabel.setVisible(isTrue);

		switch (btn) {
		case "close":
			createBtn.setVisible(isTrue);
			modifyBtn.setVisible(isTrue);
			deleteBtn.setVisible(isTrue);
			closeBtn.setVisible(isTrue);
			break;
		case "add":
			level.setText("");
			name.setText("");
			price.setText("");
			maxRecipe.setText("");
			exp.setText("");
			msgText.setText("");
			createBtn.setVisible(isTrue);
			closeBtn.setVisible(isTrue);
			break;
		case "info":
			msgText.setText("");
			modifyBtn.setVisible(isTrue);
			deleteBtn.setVisible(isTrue);
			closeBtn.setVisible(isTrue);
			break;
		}

	}

}