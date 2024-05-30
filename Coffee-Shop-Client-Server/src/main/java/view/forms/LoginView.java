package view.forms;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import controller.AdminController;

import java.awt.Insets;
import javax.swing.JPasswordField;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class LoginView extends JFrame {
	public JTextField IPusername;
	public JPasswordField IPpassword;
	public JTextField IPuserSU;
	public JPasswordField IPpasswordSU;
	public JPasswordField IPpasswordSU2;
	public JTextField IPemailSU;
	public JButton Blogin;
	public JButton BsignupSU;
	public JButton Bsignup;
	public JPanel Psignup;
	public JPanel Plogin;
	public JPanel CardPanel_login;
	public JButton BloginSU;
	public JLabel LBwarning_login;
	public JLabel LBwarningSU;
	public LoginView() {
		
		
		setBounds(new Rectangle(100, 100, 1080, 630));
		//------------------------------------------------------------//
		
		setTitle("Coffee Shop");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 getContentPane().setLayout(null);
		
		 Plogin = new JPanel();
		Plogin.setLayout(null);
		
		JLabel LBimage = new JLabel("");
		LBimage.setBounds(-680, -1, 1309, 588);
		LBimage.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/banner.png"))));
		Plogin.add(LBimage);
		
		JPanel PloginArea = new JPanel();
		PloginArea.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(248, 248, 248)));
		PloginArea.setBackground(new Color(30, 39, 49));
		PloginArea.setBounds(629, -1, 435, 588);
		Plogin.add(PloginArea);
		PloginArea.setLayout(null);
		
		JLabel LBlogin = new JLabel("Login");
		LBlogin.setFont(new Font("Visby Round CF ExtraBold", Font.BOLD, 60));
		LBlogin.setForeground(new Color(255, 255, 255));
		LBlogin.setBounds(137, 53, 166, 80);
		PloginArea.add(LBlogin);
		
		JLabel LBuser = new JLabel("");
		LBuser.setBounds(38, 214, 39, 33);
		PloginArea.add(LBuser);
		LBuser.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/user.png"))));
		Plogin.add(LBimage);
		
		JLabel LBpassword = new JLabel("");
		LBpassword.setBounds(43, 296, 29, 39);
		PloginArea.add(LBpassword);
		LBpassword.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/password.png"))));
		
		IPusername = new JTextField();
		IPusername.setCaretColor(new Color(255, 255, 255));
		IPusername.setHorizontalAlignment(SwingConstants.LEFT);
		IPusername.setFont(new Font("Visby Round CF", Font.PLAIN, 15));
		IPusername.setForeground(new Color(255, 255, 255));
		IPusername.setColumns(10);
		IPusername.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		IPusername.setBackground(new Color(30, 39, 49));
		IPusername.setBounds(86, 210, 276, 36);
		
		PloginArea.add(IPusername);
		
		IPpassword = new JPasswordField();
		IPpassword.setCaretColor(new Color(255, 255, 255));
		IPpassword.setForeground(new Color(255, 255, 255));
		IPpassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		IPpassword.setBackground(new Color(30, 39, 49));
		IPpassword.setBounds(86, 286, 276, 42);
		PloginArea.add(IPpassword);
		
		JLabel lblDontHaveAn = new JLabel("Don't have an account ?");
		lblDontHaveAn.setForeground(Color.WHITE);
		lblDontHaveAn.setFont(new Font("Visby Round CF DemiBold", Font.PLAIN, 13));
		lblDontHaveAn.setBounds(59, 535, 154, 14);
		PloginArea.add(lblDontHaveAn);
		
		 Blogin = new JButton("Login");
		
		Blogin.setForeground(new Color(30, 39, 49));
		Blogin.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 19));
		Blogin.setBackground(new Color(30, 39, 49));
		Blogin.setBounds(137, 405, 177, 39);
		Blogin.setFocusable(false);
		PloginArea.add(Blogin);
		
		Bsignup = new JButton("Sign up");
		Bsignup.setForeground(new Color(30, 39, 49));
		Bsignup.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 13));
		Bsignup.setBackground(new Color(30, 39, 49));
		Bsignup.setBounds(214, 529, 84, 22);
		Bsignup.setFocusable(false);
		PloginArea.add(Bsignup);
		
		LBwarning_login = new JLabel("");
		LBwarning_login.setHorizontalAlignment(SwingConstants.CENTER);
		LBwarning_login.setForeground(new Color(236, 15, 20));
		LBwarning_login.setFont(new Font("Visby Round CF DemiBold", Font.PLAIN, 13));
		LBwarning_login.setBounds(20, 339, 383, 14);
		PloginArea.add(LBwarning_login);
		Plogin.add(LBimage);
		
		CardPanel_login = new JPanel();
		CardPanel_login.setBounds(0, 0, 1064, 591);
		CardPanel_login.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		getContentPane().add(CardPanel_login);
		CardPanel_login.setLayout(new CardLayout(0, 0));
		CardPanel_login.add(Plogin);		
		
		 Psignup = new JPanel();
		CardPanel_login.add(Psignup, "name_10636029098600");
		Psignup.setLayout(null);
		
		JLabel imagesignup = new JLabel("");
		imagesignup.setBounds(-680, -1, 1309, 588);
		Psignup.add(imagesignup);
		imagesignup.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/banner.png"))));
		
		JPanel Psu = new JPanel();
		Psu.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(248, 248, 248)));
		Psu.setBackground(new Color(30, 39, 49));
		Psu.setBounds(629, -1, 435, 588);
		Psignup.add(Psu);
		Psu.setLayout(null);
		
		JLabel LBsignup = new JLabel("Sign up");
		LBsignup.setHorizontalAlignment(SwingConstants.CENTER);
		LBsignup.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 60));
		LBsignup.setForeground(new Color(255, 255, 255));
		LBsignup.setBounds(10, 42, 409, 85);
		Psu.add(LBsignup);
		
		JLabel LBusersignup = new JLabel("");
		LBusersignup.setBounds(55, 211, 37, 40);
		Psu.add(LBusersignup);
		LBusersignup.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/user.png"))));
		Plogin.add(LBimage);
		
		JLabel LBpasswordsignup = new JLabel("");
		LBpasswordsignup.setBounds(58, 277, 28, 40);
		Psu.add(LBpasswordsignup);
		LBpasswordsignup.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/password.png"))));
		
		JLabel LBpasswordsignup_1 = new JLabel("");
		LBpasswordsignup_1.setBounds(59, 357, 28, 40);
		Psu.add(LBpasswordsignup_1);
		LBpasswordsignup_1.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/password.png"))));
		
		IPuserSU = new JTextField();
		IPuserSU.setCaretColor(new Color(255, 255, 255));
		IPuserSU.setForeground(new Color(255, 255, 255));
		IPuserSU.setFont(new Font("Visby Round CF", Font.PLAIN, 15));
		IPuserSU.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		IPuserSU.setBackground(new Color(30, 39, 49));
		IPuserSU.setBounds(100, 208, 275, 41);
		Psu.add(IPuserSU);
		IPuserSU.setColumns(10);
		
		 BsignupSU = new JButton("Signup\r\n");
		BsignupSU.setForeground(new Color(30, 39, 49));
		BsignupSU.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 19));
		BsignupSU.setBackground(new Color(30, 39, 49));
		BsignupSU.setBounds(148, 435, 152, 40);
		BsignupSU.setFocusable(false);
		Psu.add(BsignupSU);
		
		IPpasswordSU = new JPasswordField();
		IPpasswordSU.setForeground(new Color(255, 255, 255));
		IPpasswordSU.setCaretColor(new Color(255, 255, 255));
		IPpasswordSU.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		IPpasswordSU.setBackground(new Color(30, 39, 49));
		IPpasswordSU.setBounds(100, 277, 275, 40);
		Psu.add(IPpasswordSU);
		
		IPpasswordSU2 = new JPasswordField();
		IPpasswordSU2.setForeground(new Color(255, 255, 255));
		IPpasswordSU2.setText("");
		IPpasswordSU2.setCaretColor(Color.WHITE);
		IPpasswordSU2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		IPpasswordSU2.setBackground(new Color(30, 39, 49));
		IPpasswordSU2.setBounds(100, 352, 275, 40);
		Psu.add(IPpasswordSU2);
		
		JLabel lblNewLabel = new JLabel("Already have an account ?");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Visby Round CF DemiBold", Font.PLAIN, 13));
		lblNewLabel.setBounds(53, 530, 172, 21);
		Psu.add(lblNewLabel);
		
		 BloginSU = new JButton("Login");
		BloginSU.setBackground(new Color(30, 39, 49));
		BloginSU.setForeground(new Color(30, 39, 49));
		BloginSU.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 13));
		BloginSU.setBounds(225, 529, 75, 21);
		BloginSU.setFocusable(false);
		Psu.add(BloginSU);
		
		JLabel LBusersignup_2 = new JLabel("");
		LBusersignup_2.setBounds(60, 141, 28, 40);
		LBusersignup_2.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/email.png"))));
		Psu.add(LBusersignup_2);
		
		IPemailSU = new JTextField();
		IPemailSU.setForeground(Color.WHITE);
		IPemailSU.setFont(new Font("Visby Round CF", Font.PLAIN, 15));
		IPemailSU.setColumns(10);
		IPemailSU.setCaretColor(Color.WHITE);
		IPemailSU.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		IPemailSU.setBackground(new Color(30, 39, 49));
		IPemailSU.setBounds(100, 135, 275, 41);
		Psu.add(IPemailSU);
		
		LBwarningSU = new JLabel("User account or password incorrect");
		LBwarningSU.setHorizontalAlignment(SwingConstants.CENTER);
		LBwarningSU.setForeground(new Color(236, 15, 20));
		LBwarningSU.setFont(new Font("Visby Round CF DemiBold", Font.PLAIN, 13));
		LBwarningSU.setBounds(19, 403, 399, 21);
		Psu.add(LBwarningSU);
		Plogin.add(LBimage);
		
		
		
		
	}
	
	public void addActionListener(ActionListener listener) {
			Blogin.addActionListener(listener);
	        
	}
}
