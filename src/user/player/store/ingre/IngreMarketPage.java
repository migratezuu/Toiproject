package user.player.store.ingre;

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

import user.player.common.dto.IngreDTO;
import user.player.common.dto.PlayerDTO;
import user.player.manager.controller.ManagerController;
import user.player.store.StoreMainPage;

public class IngreMarketPage extends JFrame {
	
	private JLabel payText;
	private JFrame myPage;
	private int gold;
	private List<JButton> ingre;
	private List<IngreDTO> ingreList;
	private JLabel[] orderList = new JLabel[4];
	private Map<String, Integer> ingrePage = new HashMap<>();

	public IngreMarketPage(PlayerDTO player) {

		Font labelFont = new Font("DungGeunMo", Font.PLAIN, 25);
		Font textFont = new Font("DungGeunMo", Font.PLAIN, 20);
		Font nonvisibleFont = new Font("DungGeunMo", Font.PLAIN, 0);
		

		this.myPage = this;
		myPage.setSize(800, 500);
		myPage.setLocationRelativeTo(null);
		myPage.setResizable(false);

		JPanel panel = new JPanel();

		// 배경
		ImageIcon backgroundImg = new ImageIcon("images/Market.png");
		Image backImg = new ImageIcon("images/back.png").getImage().getScaledInstance(50, 35, 0);
		ImageIcon back = new ImageIcon(backImg);
		ImageIcon panelImg = new ImageIcon("images/panelFrame.png");
		Image btn = new ImageIcon("images/buttonFrame.png").getImage().getScaledInstance(146, 40, 0);
		ImageIcon btnImg = new ImageIcon(btn);

		// 이전 화면 이동
		JLabel backLabel = new JLabel(back);
		backLabel.setSize(back.getIconWidth(), back.getIconHeight());
		backLabel.setLocation(30, 10);
		
		JLabel background = new JLabel(backgroundImg);
		background.setSize(backgroundImg.getIconWidth(), backgroundImg.getIconHeight());
		background.setLocation(0, 0);
		
		JButton backBtn = new JButton();
		backBtn.setBorderPainted(false);
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
		backBtn.setSize(70, 49);
		backBtn.setLocation(30, 10);

		// 재료 화면
		Color labelColor = new Color(250, 220, 120);
		Color fontColor = new Color(255, 255, 140);

		int lblX = 25;
		int lblY = 60;

		// 재료 목록
		JLabel ingreLabel = new JLabel();
		ingreLabel.setSize(500, 390);
		ingreLabel.setLocation(lblX, lblY);
		ingreLabel.setOpaque(true);
		ingreLabel.setBackground(labelColor);

		JLabel ingrePanel = new JLabel(panelImg);
		ingrePanel.setSize(panelImg.getIconWidth(), panelImg.getIconHeight());
		ingrePanel.setLocation((ingreLabel.getWidth() - ingrePanel.getWidth()) / 2 + 20, 10);

		JLabel ingreText = new JLabel("재료 구매");
		ingreText.setSize(ingrePanel.getWidth(), ingrePanel.getHeight());
		ingreText.setLocation(ingrePanel.getX(), ingrePanel.getY());
		ingreText.setFont(labelFont);
		ingreText.setForeground(fontColor);
		ingreText.setHorizontalAlignment(JLabel.CENTER);

		// 주문 목록
		JLabel orderLabel = new JLabel();
		orderLabel.setSize(220, 280);
		orderLabel.setLocation(lblX + ingreLabel.getWidth() + 20, lblY);
		orderLabel.setOpaque(true);
		orderLabel.setBackground(labelColor);

		JLabel orderPanel = new JLabel(panelImg);
		orderPanel.setSize(panelImg.getIconWidth(), panelImg.getIconHeight());
		orderPanel.setLocation(orderLabel.getX(), 10);

		JLabel orderText = new JLabel("구매 목록");
		orderText.setSize(orderPanel.getWidth(), orderPanel.getHeight());
		orderText.setLocation(orderPanel.getX(), orderPanel.getY());
		orderText.setFont(labelFont);
		orderText.setForeground(fontColor);
		orderText.setHorizontalAlignment(JLabel.CENTER);



		
		// 총 금액 및 결재
		JLabel payLabel = new JLabel();
		payLabel.setSize(orderLabel.getWidth(), ingreLabel.getHeight() - (orderLabel.getHeight() + 10));
		payLabel.setLocation(orderLabel.getX(), lblY + orderLabel.getHeight() + 10);
		payLabel.setOpaque(true);
		payLabel.setBackground(labelColor);

		payText = new JLabel("총 : ");
		payText.setSize(payLabel.getWidth(), 30);
		payText.setLocation(payLabel.getX(), payLabel.getY());
		payText.setFont(labelFont);
		payText.setHorizontalAlignment(JLabel.CENTER);

		JButton payBtn = new JButton("결제하기");
		payBtn.setBorderPainted(false);
		payBtn.setContentAreaFilled(false);
		payBtn.setFocusPainted(false);
		payBtn.setSize(payLabel.getWidth(), 30);
		payBtn.setLocation(payLabel.getX(), payLabel.getY() + payLabel.getHeight() - payBtn.getHeight());
		payBtn.setFont(labelFont);

		// 자금
		JLabel goldLabel = new JLabel(btnImg);
		goldLabel.setSize(btnImg.getIconWidth(), btnImg.getIconHeight());
		goldLabel.setLocation(ingreLabel.getX() + ingreLabel.getWidth() - btnImg.getIconWidth(),
				(ingreLabel.getY() - btnImg.getIconHeight()) / 2);

		gold = player.getGold();
		JLabel goldText = new JLabel("자금 : " + gold + "원");
		goldText.setSize(goldLabel.getWidth(), goldLabel.getHeight());
		goldText.setLocation(goldLabel.getX(), goldLabel.getY());
		goldText.setFont(textFont);
		goldText.setHorizontalAlignment(JLabel.CENTER);

		ImageIcon boardIcon = new ImageIcon("images/board2.png");
		JLabel board = new JLabel(boardIcon);
		board.setSize(boardIcon.getIconWidth(), boardIcon.getIconHeight());
		board.setLocation((myPage.getWidth() - board.getWidth()) / 2, (myPage.getHeight() - board.getHeight()) / 2);
		board.setVisible(false);

		JButton closeBtn = new JButton("닫기");
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		closeBtn.setSize(board.getWidth(), 30);
		closeBtn.setLocation(board.getX(), board.getY() + board.getHeight() - closeBtn.getHeight() * 2);
		closeBtn.setFont(labelFont);
		closeBtn.setVisible(false);

		JLabel msglbl = new JLabel();
		msglbl.setSize(board.getWidth(), 30);
		msglbl.setLocation(board.getX(), board.getY() + (board.getHeight() - msglbl.getHeight()) / 2);
		msglbl.setFont(labelFont);
		msglbl.setHorizontalAlignment(JLabel.CENTER);
		msglbl.setVisible(false);

		panel.add(msglbl);
		panel.add(closeBtn);
		panel.add(board);
		
		// 재료 변수 들
		int ingreW = 65;
		int ingreH = ingreW;
		int ingreX = lblX + 15;
		int ingreY = lblY + 35;

		JLabel[][] ingrePriceList = new JLabel[3][4]; // 재료 가격 리스트

		ingre = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 4; k++) {
				JButton ingreBtn = new JButton();
				ingreBtn.setBorderPainted(false);
				ingreBtn.setContentAreaFilled(false);
				ingreBtn.setFocusPainted(false);
				ingreBtn.setFont(textFont);
				ingreBtn.setHorizontalTextPosition(JButton.CENTER);
				ingreBtn.setVerticalTextPosition(JButton.BOTTOM);
				ingreBtn.setSize(95, 120);
				ingreBtn.setLocation(lblX + (ingreBtn.getWidth() + 25) * k + 25,
									lblY + (ingreBtn.getHeight() + 20) * i + 0);
				ingre.add(ingreBtn);

				ingrePriceList[i][k] = new JLabel();
				ingrePriceList[i][k].setSize(ingreW, 30);
				ingrePriceList[i][k].setLocation(ingreBtn.getX(), ingreBtn.getY() + ingreH);
				ingrePriceList[i][k].setFont(textFont);
				ingrePriceList[i][k].setHorizontalAlignment(JLabel.CENTER);
				panel.add(ingrePriceList[i][k]);
			}
		}

		int orderW = 50;
		int orderH = orderW;
		
		for (int i = 0; i < orderList.length; i++) {
			orderList[i] = new JLabel();
			orderList[i].setSize(orderW +100, orderH);
			orderList[i].setHorizontalTextPosition(JLabel.RIGHT);
			orderList[i].setLocation(orderLabel.getX() + 10, ingreY + (orderList[i].getHeight() + 10) * i);
			panel.add(orderList[i]);
		}
		
		Paging();
		// 패녈에 추가

		panel.setLayout(null);
		
		panel.add(goldText);
		panel.add(goldLabel);

		panel.add(payText);
		panel.add(payBtn);
		panel.add(payLabel);

		for (JButton btn2: ingre) {
			panel.add(btn2);
		}
		
		panel.add(orderText);
		panel.add(orderPanel);
		panel.add(orderLabel);

		panel.add(ingreText);
		panel.add(ingrePanel);
		panel.add(ingreLabel);

		panel.add(backBtn);
		panel.add(backLabel);
		panel.add(background);

		myPage.add(panel);

		myPage.setVisible(true);
		myPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				myPage.dispose();
				new StoreMainPage(player);

			}
		});

		payBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String message;
				if (paySum > gold) {
					message = "자금이 부족합니다.";
				} else {
					message = "성공적으로 구매하셨습니다.";
					gold -= paySum;
					for(int i = 0; i < orderList.length; i++ ) {
						orderList[i].setIcon(new ImageIcon());
						orderList[i].setText("");	
					}
					payText.setText("총 : ");
					paySum = 0;
				}
				
				player.setGold(gold);
				System.out.println(message);
				msglbl.setText(message);

				board.setVisible(true);
				closeBtn.setVisible(true);
				msglbl.setVisible(true);
				cartCnt = 0;
			}
		});

		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				board.setVisible(false);
				closeBtn.setVisible(false);
				msglbl.setVisible(false);

				goldText.setText("자금 : " + gold + "원");

			}
		});
		// 재료 구매 내역 장바구니 이동
		ingre.get(0).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Cart(0);

			}
		});

		ingre.get(1).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Cart(1);
			}
		});

		ingre.get(2).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Cart(2);

			}
		});

		ingre.get(3).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Cart(3);

			}
		});

		ingre.get(4).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Cart(4);

			}
		});

		ingre.get(5).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Cart(5);

			}
		});

		ingre.get(6).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Cart(6);

			}
		});

		ingre.get(7).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Cart(7);

			}
		});

		ingre.get(8).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Cart(8);

			}
		});

		ingre.get(9).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Cart(9);

			}
		});

		ingre.get(10).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Cart(10);

			}
		});

		ingre.get(11).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Cart(11);

			}
		});
		
	}
	private int cartCnt = 0;
	private int paySum = 0;
	
	public void Cart(int index) {
		if(cartCnt >= orderList.length) {
			System.out.println("더 이상 구매할 수 없습니다.");
			return;
		}
		Image ingreImg = new ImageIcon(ingreList.get(index).getImg()).getImage().getScaledInstance(orderList[0].getHeight(),orderList[0].getHeight(), 0);
		orderList[cartCnt].setIcon(new ImageIcon(ingreImg));
		orderList[cartCnt].setText(ingreList.get(index).getPrice()+"원");
		paySum += ingreList.get(index).getPrice();
		payText.setText("총 : " + paySum );
		
		cartCnt++;
	}
	
	public void Paging() {
		int index = 0;
		ingrePage.put("first", 1);
		ingrePage.put("second", 12);
		ManagerController managerController = new ManagerController();
		ingreList = managerController.findAllIngre(ingrePage);
		
		for(JButton btn: ingre) {
			if(index >= ingreList.size()) {
				break;
			}
			Image ingreImg = new ImageIcon(ingreList.get(index).getImg()).getImage().getScaledInstance(65, 65, 0);
			btn.setIcon(new ImageIcon(ingreImg));
			btn.setText(ingreList.get(index).getPrice()+"원");
			System.out.println(ingreList.get(index).getPrice());
			index++;
			
		}
	}
	
}