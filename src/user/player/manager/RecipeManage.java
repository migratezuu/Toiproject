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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import user.player.common.dto.IngreDTO;
import user.player.common.dto.RecipeDTO;
import user.player.manager.controller.ManagerController;

public class RecipeManage extends JFrame {

	private JFrame myPage;
	private ManagerController managerController = new ManagerController();

	private List<IngreDTO> ingre;

	private List<RecipeDTO> recipe;
	private List<JLabel> recipeNameShadow;

	private List<JButton> recipeList;
	private int recipeListIndex = 0;

	private List<JCheckBox> ingreList;

	private List<IngreDTO> recipeIngreList;

	private Map<String, Integer> recipePage = new HashMap<>();
	private int recipePageIndex = 0;

	private JLabel infoLabel;
	private JLabel infoTitle;

	private JLabel nameLabel;
	private JTextField name;
	private JLabel recipePriceLabel;
	private JTextField recipePrice;
	private JLabel foodPriceLabel;
	private JTextField foodPrice;
	private JLabel expLabel;
	private JTextField exp;

	private JLabel msgText;

	private JButton addBtn;
	private JButton createBtn;
	private JButton closeBtn;
	private JButton modifyBtn;
	private JButton deleteBtn;

	private Image recipeImage;
	private String tempNo, tempName, tempRecipePrice, tempFoodPrice, tempExp;
	private boolean isInfoPage = false;

	public RecipeManage() {

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

		// 재료 정보 배경
		ImageIcon info = new ImageIcon("images/board.png");

		// 레시피 정보
		recipeImage = new ImageIcon("images/recipe1.png").getImage().getScaledInstance(100, 100, 0);

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

		JLabel titleText = new JLabel("레시피 관리");
		titleText.setSize(titleImg.getIconWidth(), titleImg.getIconHeight());
		titleText.setLocation((myPage.getWidth() - titleLabel.getWidth()) / 2, 0);
		titleText.setFont(titleFont);
		titleText.setForeground(fontColor);
		titleText.setHorizontalAlignment(JLabel.CENTER);

		// 레시피 화면
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

		recipeList = new ArrayList<>();
		recipeNameShadow = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 5; k++) {
				JButton recipe = new JButton();
				recipe.setBorderPainted(false);
				recipe.setContentAreaFilled(false);
				recipe.setFocusPainted(false);
				recipe.setHorizontalTextPosition(JButton.CENTER);
				recipe.setFont(labelFont);
				recipe.setSize(130, 100);
				recipe.setLocation(lblX + (recipe.getWidth() + 10) * k + 5, lblY + (recipe.getHeight() + 20) * i + 20);

				JLabel name = new JLabel();
				name.setFont(labelFont);
				name.setForeground(Color.yellow);
				name.setHorizontalAlignment(JLabel.CENTER);
				name.setSize(recipe.getWidth(), recipe.getHeight());
				name.setLocation(recipe.getX() - 2, recipe.getY() - 2);

				recipeList.add(recipe);
				recipeNameShadow.add(name);
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

		// 레시피 정보 배경
		infoLabel = new JLabel(info);
		infoLabel.setSize(info.getIconWidth(), info.getIconHeight());
		infoLabel.setLocation((myPage.getWidth() - info.getIconWidth()) / 2,
				((myPage.getHeight() - 25) - info.getIconHeight()) / 2);
		infoLabel.setVisible(false);

		// 재료 정보 타이틀
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

		Map<String, Integer> ingrePage = new HashMap<>();
		ingrePage.put("first", 1);
		ingrePage.put("second", 100);

		ingre = managerController.findAllIngre(ingrePage);
		ingreList = new ArrayList<>();

		for (int i = 0; i < ingre.size() / 4 + 1; i++) {
			for (int k = 0; k < 4; k++) {
				JCheckBox ingreBox = new JCheckBox();
				ingreBox.setBorderPainted(false);
				ingreBox.setContentAreaFilled(false);
				ingreBox.setFocusPainted(false);
				ingreBox.setSize(120, labelFont.getSize());
				ingreBox.setFont(labelFont);
				ingreBox.setLocation(infoX + (ingreBox.getWidth() + 10) * k - 15,
						infoY + (ingreBox.getHeight() + 10) * i);
				ingreBox.setVisible(false);

				ingreList.add(ingreBox);
			}
		}

		for (int i = 0; i < ingre.size(); i++) {

			ingreList.get(i).setText(ingre.get(i).getName());

		}

		// 요리 이름
		nameLabel = new JLabel("이름 : ");
		nameLabel.setFont(labelFont);
		nameLabel.setSize(infoW, infoH);
		nameLabel.setLocation(infoX, infoY);
		nameLabel.setVisible(false);

		name = new JTextField();
		name.setSize(250, infoH);
		name.setLocation(nameLabel.getX() + nameLabel.getWidth(), nameLabel.getY());
		name.setVisible(false);

		// 레시피 구입 가격
		recipePriceLabel = new JLabel("레시피 가격 : ");
		recipePriceLabel.setFont(labelFont);
		recipePriceLabel.setSize(infoW, infoH);
		recipePriceLabel.setLocation(infoX, name.getY() + name.getHeight() + fix);
		recipePriceLabel.setVisible(false);

		recipePrice = new JTextField();
		recipePrice.setSize(250, infoH);
		recipePrice.setLocation(recipePriceLabel.getX() + recipePriceLabel.getWidth(), recipePriceLabel.getY());
		recipePrice.setVisible(false);

		// 요리 판매 가격
		foodPriceLabel = new JLabel("요리 가격 : ");
		foodPriceLabel.setFont(labelFont);
		foodPriceLabel.setSize(infoW, infoH);
		foodPriceLabel.setLocation(infoX, recipePriceLabel.getY() + recipePriceLabel.getHeight() + fix);
		foodPriceLabel.setVisible(false);

		foodPrice = new JTextField();
		foodPrice.setSize(250, infoH);
		foodPrice.setLocation(foodPriceLabel.getX() + foodPriceLabel.getWidth(), foodPriceLabel.getY());
		foodPrice.setVisible(false);

		// 요리 판매시 획득 경험치
		expLabel = new JLabel("경험치 : ");
		expLabel.setFont(labelFont);
		expLabel.setSize(infoW, infoH);
		expLabel.setLocation(infoX, foodPriceLabel.getY() + foodPriceLabel.getHeight() + fix);
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

		// 취소/닫기 버튼
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
		panel.add(nameLabel);
		panel.add(name);
		panel.add(recipePriceLabel);
		panel.add(recipePrice);
		panel.add(foodPriceLabel);
		panel.add(foodPrice);
		panel.add(expLabel);
		panel.add(exp);
		panel.add(msgText);

		panel.add(deleteBtn);
		panel.add(createBtn);
		panel.add(modifyBtn);
		panel.add(closeBtn);

		for (JCheckBox ingre : ingreList) {
			panel.add(ingre);
		}

		panel.add(infoTitle);
		panel.add(infoLabel);

		panel.add(addBtn);

		for (JLabel label : recipeNameShadow) {
			panel.add(label);
		}

		for (JButton label : recipeList) {
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

				if (isInfoPage) {
					elementsVisible("check");
				} else {

					if (recipeListIndex < 15) {
						return;
					} else {
						recipePageIndex++;
						paging();
					}

				}
			}
		});

		previousPageBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (isInfoPage) {
					if (modifyBtn.isVisible()) {
						elementsVisible("info");
					} else {
						elementsVisible("add");
					}
				} else {

					if (recipePageIndex == 0) {
						return;
					} else {
						recipePageIndex--;
						paging();
					}
				}
			}
		});

		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				elementsVisible("add");
				infoTitle.setText("레시피 등록");
				isInfoPage = true;

			}
		});

		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				elementsVisible("close");
				paging();
				isInfoPage = false;
			}
		});

		createBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				msgText.setText("");

				String message;
				if (name.getText().isEmpty() || recipePrice.getText().isEmpty() || foodPrice.getText().isEmpty()
						|| exp.getText().isEmpty()) {
					message = "미입력된 정보가 있습니다.";

				} else {

					Map<String, String> map = new HashMap<>();
					map.put("name", name.getText());
					map.put("recipePrice", recipePrice.getText());
					map.put("foodPrice", foodPrice.getText());
					map.put("exp", exp.getText());

					message = managerController.createNewRecipe(map);

				}

				Map<String, String> recipeIngre = new HashMap<>();
				recipeIngre.put("recipe", name.getText());
				for (int i = 0; i < ingreList.size(); i++) {

					if (ingreList.get(i).isSelected()) {
						recipeIngre.put("ingre", ingreList.get(i).getText());
						managerController.createRecipeIngre(recipeIngre);
					}
				}

				msgText.setText(message);
				elementsVisible("add");

				paging();

			}
		});

		modifyBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String messge;

				if (tempName.equals(name.getText()) && tempRecipePrice.equals(recipePrice.getText())
						&& tempFoodPrice.equals(foodPrice.getText()) && tempExp.equals(exp.getText())) {
					messge = "바뀐 정보가 없습니다.";
				} else {

					Map<String, String> map = new HashMap<>();

					map.put("no", tempNo);

					if (!name.getText().isEmpty() && !tempName.equals(name.getText()))
						map.put("name", name.getText());

					if (!recipePrice.getText().isEmpty() && !tempRecipePrice.equals(recipePrice.getText()))
						map.put("recipePrice", recipePrice.getText());

					if (!foodPrice.getText().isEmpty() && !tempFoodPrice.equals(foodPrice.getText()))
						map.put("foodPrice", foodPrice.getText());

					if (!exp.getText().isEmpty() && !tempExp.equals(exp.getText()))
						map.put("exp", exp.getText());

					messge = managerController.modifyRecipe(map);
				}

				Map<String, String> recipeIngre = new HashMap<>();
				recipeIngre.put("recipe", name.getText());

				for (int i = 0; i < ingreList.size(); i++) {
					int isBe = 0;
					if (ingreList.get(i).isSelected()) {
						for (int k = 0; k < recipeIngreList.size(); k++) {
							if (!ingreList.get(i).getText().equals(recipeIngreList.get(k).getName())) {
								isBe += 0;
							} else {
								isBe += 1;
							}
						}
						if (isBe == 0) {
							recipeIngre.put("ingre", ingreList.get(i).getText());
							managerController.createRecipeIngre(recipeIngre);
							messge = "재료를 변경했습니다.";
						}
					} else {
						for (int k = 0; k < recipeIngreList.size(); k++) {
							if (ingreList.get(i).getText().equals(recipeIngreList.get(k).getName())) {
								isBe = 0;
								break;
							} else {
								isBe += 1;
							}
						}
						if (isBe == 0) {
							recipeIngre.put("ingre", ingreList.get(i).getText());
							managerController.deleteRecipeIngre(recipeIngre);
							messge = "재료를 변경했습니다.";
						}
					}
				}
				msgText.setText(messge);

			}
		});

		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Map<String, String> map = new HashMap<>();

				map.put("no", tempNo);

				String messge = managerController.deleteRecipe(map);

				msgText.setText(messge);
			}
		});

		recipeList.get(0).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (0 > recipeListIndex) {
					return;
				}

				elementsVisible("info");
				recipeInfo(0);
			}
		});

		recipeList.get(1).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (1 > recipeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(1);
			}
		});

		recipeList.get(2).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (2 > recipeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(2);
			}
		});

		recipeList.get(3).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (3 > recipeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(3);
			}
		});

		recipeList.get(4).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (4 > recipeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(4);
			}
		});

		recipeList.get(5).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (5 > recipeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(5);
			}
		});

		recipeList.get(6).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (6 > recipeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(6);
			}
		});

		recipeList.get(7).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (7 > recipeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(7);
			}
		});

		recipeList.get(8).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (8 > recipeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(8);
			}
		});

		recipeList.get(9).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (9 > recipeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(9);
			}
		});

		recipeList.get(10).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (10 > recipeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(10);
			}
		});

		recipeList.get(11).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (11 > recipeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(11);
			}
		});

		recipeList.get(12).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (12 > recipeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(12);
			}
		});

		recipeList.get(13).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (13 > recipeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(13);
			}
		});

		recipeList.get(14).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (14 > recipeListIndex) {
					return;
				}
				elementsVisible("info");
				recipeInfo(14);
			}
		});
	}

	public void recipeInfo(int infoIndex) {

		tempNo = recipe.get(infoIndex).getNo() + "";
		tempName = recipe.get(infoIndex).getName();
		tempRecipePrice = recipe.get(infoIndex).getRecipePrice() + "";
		tempFoodPrice = recipe.get(infoIndex).getFoodPrice() + "";
		tempExp = recipe.get(infoIndex).getExp() + "";

		infoTitle.setText("NO." + tempNo);
		name.setText(tempName);
		recipePrice.setText(tempRecipePrice);
		foodPrice.setText(tempFoodPrice);
		exp.setText(tempExp);

		Map<String, String> map = new HashMap<>();
		map.put("no", tempNo);

		recipeIngreList = managerController.findRecipeIngre(map);

		for (int i = 0; i < ingreList.size(); i++) {
			for (int k = 0; k < recipeIngreList.size(); k++) {
				if (ingreList.get(i).getText().equals(recipeIngreList.get(k).getName())) {
					ingreList.get(i).setSelected(true);
				}
			}
		}

		isInfoPage = true;
	}

	public void paging() {
		recipePage.put("first", 1 + 15 * recipePageIndex);
		recipePage.put("second", 15 + 15 * recipePageIndex);

		recipe = managerController.findAllRecipe(recipePage);

		for (int i = 0; i < recipeListIndex; i++) {
			recipeList.get(i).setIcon(new ImageIcon());
			recipeList.get(i).setText("");
			recipeNameShadow.get(i).setText("");
		}
		recipeListIndex = 0;

		while (recipeListIndex < recipe.size() && recipeListIndex < recipeList.size()) {

			recipeList.get(recipeListIndex).setIcon(new ImageIcon(recipeImage));
			recipeList.get(recipeListIndex).setText(recipe.get(recipeListIndex).getName());
			recipeNameShadow.get(recipeListIndex).setText(recipe.get(recipeListIndex).getName());
			recipeListIndex++;
		}

		if (recipeListIndex < recipeList.size()) {
			addBtn.setVisible(true);
			addBtn.setLocation(
					recipeList.get(recipeListIndex).getX()
							+ (recipeList.get(recipeListIndex).getWidth() - addBtn.getWidth()) / 2,
					recipeList.get(recipeListIndex).getY()
							+ (recipeList.get(recipeListIndex).getHeight() - addBtn.getHeight()) / 2);

		} else {
			addBtn.setLocation(recipeList.get(0).getX() + (recipeList.get(0).getWidth() - addBtn.getWidth()) / 2,
					recipeList.get(0).getY() + (recipeList.get(0).getHeight() - addBtn.getHeight()) / 2);
			addBtn.setVisible(false);
		}
	}

	public void elementsVisible(String btn) {

		boolean isTrue = btn.equals("close") ? false : btn.equals("check") ? false : true;

		nameLabel.setVisible(isTrue);
		name.setVisible(isTrue);

		recipePriceLabel.setVisible(isTrue);
		recipePrice.setVisible(isTrue);

		foodPriceLabel.setVisible(isTrue);
		foodPrice.setVisible(isTrue);

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
			for (int i = 0; i < ingreList.size(); i++) {
				ingreList.get(i).setSelected(isTrue);
				if (!ingreList.get(i).getText().isEmpty()) {
					ingreList.get(i).setVisible(isTrue);
				}
			}
			break;

		case "add":
			name.setText("");
			recipePrice.setText("");
			foodPrice.setText("");
			exp.setText("");
			msgText.setText("");
			createBtn.setVisible(isTrue);
			closeBtn.setVisible(isTrue);
			for (int i = 0; i < ingreList.size(); i++) {
				if (!ingreList.get(i).getText().isEmpty()) {
					ingreList.get(i).setVisible(!isTrue);
				}
			}
			break;

		case "info":
			msgText.setText("");
			modifyBtn.setVisible(isTrue);
			deleteBtn.setVisible(isTrue);
			closeBtn.setVisible(isTrue);
			for (int i = 0; i < ingreList.size(); i++) {
				if (!ingreList.get(i).getText().isEmpty()) {
					ingreList.get(i).setVisible(!isTrue);
				}
			}
			break;

		case "check":
			msgText.setVisible(!isTrue);

			infoTitle.setVisible(!isTrue);
			infoLabel.setVisible(!isTrue);
			for (int i = 0; i < ingreList.size(); i++) {
				if (!ingreList.get(i).getText().isEmpty()) {
					ingreList.get(i).setVisible(!isTrue);
				}
			}
		}

	}

}