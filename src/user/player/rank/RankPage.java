//package user.player.rank;
//
//import static user.player.run.Application.labelFont;
//
//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//public class RankPage extends JFrame {
//
//	private JFrame myPage;
//
//	public RankPage() {
//
//		// Font signUpFont = new Font("DungGeunMo", Font.BOLD, 70);
//		this.setSize(800, 500);
//		this.setLocationRelativeTo(null);
//		this.setAutoRequestFocus(false);
//
//		this.myPage = this;
//
//		ImageIcon img = new ImageIcon("images/rankPage.png");
//
//		JPanel panel = new JPanel();
//
//		panel.setLayout(null);
//
//		JLabel background = new JLabel(img);
//		background.setLocation(0, 0);
//		background.setSize(800, 500);
//
//		// // 닫기 버튼
//		JButton close = new JButton("닫기");
//		close.setFont(labelFont);
//		close.setForeground(new Color(164, 219, 255));
//		close.setSize(100, 40);
//		close.setLocation(700, 10);
//		close.setBorderPainted(false);
//		close.setContentAreaFilled(false); // 버튼 투명
//		close.setFocusPainted(false);
//
//		// 회원가입완료 그림자 효과
//		// JLabel signUpShadow = new JLabel(signUp.getText());
//		// signUpShadow.setFont(littlebigFont);
//		// signUpShadow.setSize(350, 150);
//		// signUpShadow.setLocation(250, 380);
//
//		// JButton btn = new JButton();
//		// btn.setLocation(250, 375);
//		// btn.setSize(315, 65);
//		// btn.setContentAreaFilled(false);
//
//		// 패녈에 추가
//
//		panel.add(close);
//
//		panel.add(background);
//		this.add(panel);
//		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		close.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				myPage.dispose();
//				// new UserInfoPage();
//
//			}
//		});
//	}
//
//}