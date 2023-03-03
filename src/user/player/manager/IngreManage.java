package user.player.manager;

import static user.player.run.Application.labelFont;

import java.awt.Color;
import java.awt.FileDialog;
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

import user.player.common.dto.IngreDTO;
import user.player.manager.controller.ManagerController;

public class IngreManage extends JFrame {

	private JFrame myPage;
	private ManagerController managerController = new ManagerController();

	private JButton addBtn;

	private List<IngreDTO> ingre; // 재료 정보 리스트

	private List<JButton> ingreList; // 목록에 보여지는 재료 라벨 리스트
	private int ingreListIndex = 0;

	private Map<String, Integer> ingrePage = new HashMap<>(); // 현재 페이지의 목록번호 15n+1~15n+15
	private int ingrePageIndex = 0;

	private JLabel infoLabel;
	private JLabel infoTitle;
	private JButton ingreImg;
	private JLabel nameLabel;
	private JTextField name;
	private JLabel priceLabel;
	private JTextField price;
	private JLabel msgText;
	private JButton createBtn;
	private JButton closeBtn;
	private JButton modifyBtn;
	private JButton deleteBtn;

	private String imgPath;
	private String tempNo, tempName, tempPrice, tempPath;

	public IngreManage() {

		this.myPage = this;
		myPage.setSize(800, 500);
		myPage.setLocationRelativeTo(null);
		myPage.setResizable(false);

		JPanel panel = new JPanel();

		panel.setLayout(null);

		Font titleFont = new Font("DungGeunMo", Font.PLAIN, 40);
		Font nonvisibleFont = new Font("DungGeunMo", Font.PLAIN, 0);

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
		titleLabel.setHorizontalTextPosition(JLabel.CENTER);
		titleLabel.setText("재료 관리");
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(fontColor);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);

		// 재료 화면
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

		ingreList = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 5; k++) {
				JButton ingre = new JButton();
				ingre.setBorderPainted(false);
				ingre.setContentAreaFilled(false);
				ingre.setFocusPainted(false);
				ingre.setFont(nonvisibleFont);
				ingre.setSize(100, 100);
				ingre.setLocation(lblX + (ingre.getWidth() + 30) * k + 40, lblY + (ingre.getHeight() + 20) * i + 20);

				ingreList.add(ingre);
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

		// 재료 정보 배경
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

		// 이미지 등록
		ingreImg = new JButton();
		ingreImg.setBorderPainted(false);
		ingreImg.setContentAreaFilled(false);
		ingreImg.setFocusPainted(false);
		ingreImg.setOpaque(true);
		ingreImg.setBackground(Color.WHITE);
		ingreImg.setSize(150, 150);
		ingreImg.setLocation(infoLabel.getX() + 70, infoLabel.getY() + 110);
		ingreImg.setVisible(false);

		// 재료 정보 입력
		int fix = 10;

		nameLabel = new JLabel("이름");
		nameLabel.setFont(labelFont);
		nameLabel.setSize(50, 30);
		nameLabel.setLocation(ingreImg.getX() + ingreImg.getWidth() + 50, ingreImg.getY());
		nameLabel.setVisible(false);

		name = new JTextField();
		name.setSize(250, 30);
		name.setLocation(nameLabel.getX(), nameLabel.getY() + nameLabel.getHeight() + fix);
		name.setVisible(false);

		priceLabel = new JLabel("가격");
		priceLabel.setFont(labelFont);
		priceLabel.setSize(50, 30);
		priceLabel.setLocation(nameLabel.getX(), name.getY() + name.getHeight() + fix);
		priceLabel.setVisible(false);

		price = new JTextField();
		price.setSize(250, 30);
		price.setLocation(nameLabel.getX(), priceLabel.getY() + priceLabel.getHeight() + fix);
		price.setVisible(false);

		// 메시지 라벨
		msgText = new JLabel();
		msgText.setSize(name.getX() + name.getWidth() - ingreImg.getX(), 30);
		msgText.setLocation(ingreImg.getX(), ingreImg.getY() + ingreImg.getHeight() + 20);
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
		panel.add(ingreImg);
		panel.add(nameLabel);
		panel.add(name);
		panel.add(priceLabel);
		panel.add(price);
		panel.add(msgText);

		panel.add(deleteBtn);
		panel.add(createBtn);
		panel.add(modifyBtn);
		panel.add(closeBtn);

		panel.add(infoTitle);
		panel.add(infoLabel);

		panel.add(addBtn);

		for (JButton label : ingreList) {
			panel.add(label);
		}

		panel.add(nextPageBtn);
		panel.add(previousPageBtn);

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

				if (ingreListIndex < 15) {
					return;
				}

				ingrePageIndex++;
				paging();

			}
		});

		previousPageBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (ingrePageIndex == 0) {
					return;
				}

				ingrePageIndex--;
				paging();
			}
		});

		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				elementsVisible("add");
				infoTitle.setText("재료 등록");

			}
		});

		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				elementsVisible("close");
				paging();
			}
		});

		ingreImg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				FileDialog fd = new FileDialog(myPage, "재료 찾기", FileDialog.LOAD);
				fd.setDirectory("images\\ingre");
				fd.setVisible(true);

				imgPath = "images\\ingre\\" + fd.getFile();

				Image ingreImage = new ImageIcon(imgPath).getImage().getScaledInstance(ingreImg.getWidth(),
						ingreImg.getHeight(), 0);

				ingreImg.setIcon(new ImageIcon(ingreImage));

			}
		});

		createBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				msgText.setText("");

				String message;
				if (name.getText().isEmpty() || price.getText().isEmpty()) {
					message = "미입력된 정보가 있습니다.";

				} else {

					Map<String, String> map = new HashMap<>();
					map.put("name", name.getText());
					map.put("price", price.getText());
					map.put("img", imgPath);

					message = managerController.createNewIngre(map);

				}

				msgText.setText(message);

				paging();

			}
		});

		modifyBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tempName.equals(name.getText()) && tempPrice.equals(price.getText()) && imgPath == null) {
					msgText.setText("바뀐 정보가 없습니다.");
					return;
				}

				Map<String, String> map = new HashMap<>();

				map.put("no", tempNo);

				if (!name.getText().isEmpty() && !tempName.equals(name.getText()))
					map.put("name", name.getText());

				if (!price.getText().isEmpty() && !tempPrice.equals(price.getText()))
					map.put("price", price.getText());

				if (imgPath != null)
					map.put("img", imgPath);

				String messge = managerController.modifyIngre(map);

				msgText.setText(messge);

			}
		});

		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Map<String, String> map = new HashMap<>();

				map.put("no", tempNo);

				String messge = managerController.deleteIngre(map);

				msgText.setText(messge);
			}
		});

		ingreList.get(0).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (0 > ingreListIndex) {
					return;
				}

				elementsVisible("info");
				ingreInfo(0);
			}
		});

		ingreList.get(1).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (1 > ingreListIndex) {
					return;
				}
				elementsVisible("info");
				ingreInfo(1);
			}
		});

		ingreList.get(2).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (2 > ingreListIndex) {
					return;
				}
				elementsVisible("info");
				ingreInfo(2);
			}
		});

		ingreList.get(3).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (3 > ingreListIndex) {
					return;
				}
				elementsVisible("info");
				ingreInfo(3);
			}
		});

		ingreList.get(4).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (4 > ingreListIndex) {
					return;
				}
				elementsVisible("info");
				ingreInfo(4);
			}
		});

		ingreList.get(5).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (5 > ingreListIndex) {
					return;
				}
				elementsVisible("info");
				ingreInfo(5);
			}
		});

		ingreList.get(6).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (6 > ingreListIndex) {
					return;
				}
				elementsVisible("info");
				ingreInfo(6);
			}
		});

		ingreList.get(7).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (7 > ingreListIndex) {
					return;
				}
				elementsVisible("info");
				ingreInfo(7);
			}
		});

		ingreList.get(8).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (8 > ingreListIndex) {
					return;
				}
				elementsVisible("info");
				ingreInfo(8);
			}
		});

		ingreList.get(9).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (9 > ingreListIndex) {
					return;
				}
				elementsVisible("info");
				ingreInfo(9);
			}
		});

		ingreList.get(10).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (10 > ingreListIndex) {
					return;
				}
				elementsVisible("info");
				ingreInfo(10);
			}
		});

		ingreList.get(11).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (11 > ingreListIndex) {
					return;
				}
				elementsVisible("info");
				ingreInfo(11);
			}
		});

		ingreList.get(12).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (12 > ingreListIndex) {
					return;
				}
				elementsVisible("info");
				ingreInfo(12);
			}
		});

		ingreList.get(13).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (13 > ingreListIndex) {
					return;
				}
				elementsVisible("info");
				ingreInfo(13);
			}
		});

		ingreList.get(14).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (14 > ingreListIndex) {
					return;
				}
				elementsVisible("info");
				ingreInfo(14);
			}
		});
	}

	public void ingreInfo(int infoIndex) {

		tempNo = ingre.get(infoIndex).getNo() + "";
		tempName = ingre.get(infoIndex).getName();
		tempPrice = ingre.get(infoIndex).getPrice() + "";
		tempPath = ingre.get(infoIndex).getImg();

		Image ingreImage = new ImageIcon(tempPath).getImage().getScaledInstance(ingreList.get(infoIndex).getWidth(),
				ingreList.get(infoIndex).getHeight(), 0);
		ingreImg.setIcon(new ImageIcon(ingreImage));

		name.setText(tempName);
		price.setText(tempPrice);
		infoTitle.setText("NO." + tempNo);
	}

	public void paging() {
		ingrePage.put("first", 1 + 15 * ingrePageIndex);
		ingrePage.put("second", 15 + 15 * ingrePageIndex);

		ingre = managerController.findAllIngre(ingrePage);

		for (int i = 0; i < ingreListIndex; i++) {
			ingreList.get(i).setIcon(new ImageIcon());
		}
		ingreListIndex = 0;

		while (ingreListIndex < ingre.size() && ingreListIndex < ingreList.size()) {

			Image ingreImage = new ImageIcon(ingre.get(ingreListIndex).getImg()).getImage().getScaledInstance(
			ingreList.get(ingreListIndex).getWidth(), ingreList.get(ingreListIndex).getHeight(), 0);
			ingreList.get(ingreListIndex).setIcon(new ImageIcon(ingreImage));

			ingreListIndex++;
		}

		if (ingreListIndex < ingreList.size()) {
			addBtn.setVisible(true);
			addBtn.setLocation(
					ingreList.get(ingreListIndex).getX()
							+ (ingreList.get(ingreListIndex).getWidth() - addBtn.getWidth()) / 2,
					ingreList.get(ingreListIndex).getY()
							+ (ingreList.get(ingreListIndex).getHeight() - addBtn.getHeight()) / 2);

		} else {
			addBtn.setLocation(ingreList.get(0).getX() + (ingreList.get(0).getWidth() - addBtn.getWidth()) / 2,
					ingreList.get(0).getY() + (ingreList.get(0).getHeight() - addBtn.getHeight()) / 2);
			addBtn.setVisible(false);
		}
	}

	public void elementsVisible(String btn) {

		boolean isTrue = btn.equals("close") ? false : true;
		ingreImg.setVisible(isTrue);

		nameLabel.setVisible(isTrue);
		name.setVisible(isTrue);

		priceLabel.setVisible(isTrue);
		price.setVisible(isTrue);

		msgText.setVisible(isTrue);

		infoTitle.setVisible(isTrue);
		infoLabel.setVisible(isTrue);

		switch (btn) {
		case "close":
			imgPath = null;
			createBtn.setVisible(isTrue);
			modifyBtn.setVisible(isTrue);
			deleteBtn.setVisible(isTrue);
			closeBtn.setVisible(isTrue);
			break;
		case "add":
			name.setText("");
			price.setText("");
			msgText.setText("");
			ingreImg.setIcon(null);
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