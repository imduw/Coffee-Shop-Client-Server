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
	private JTextField IPuser;
	private JPasswordField IPpassword;
	private JTextField IPuserSU;
	private JPasswordField IPpasswordSU;
	private JPasswordField IPpasswordSU2;
	private JTextField IPemailSU;
	public JButton Blogin;
	public LoginView() {
		setBounds(new Rectangle(100, 100, 1080, 630));
		//------------------------------------------------------------//
		
		setTitle("Coffee Shop");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//------------------------------------------------------------//
		getContentPane().setLayout(new CardLayout(0, 0));
		
		
		
		JPanel Plogin = new JPanel();
		Plogin.setLayout(null);
		
		JLabel LBimage = new JLabel("");
		LBimage.setBounds(-81, 0, 712, 583);
		LBimage.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/bg_login.jpg"))));
		Plogin.add(LBimage);
		
		JPanel PloginArea = new JPanel();
		PloginArea.setBackground(new Color(39, 61, 97));
		PloginArea.setBounds(629, -1, 435, 583);
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
		
		IPuser = new JTextField();
		IPuser.setCaretColor(new Color(255, 255, 255));
		IPuser.setHorizontalAlignment(SwingConstants.LEFT);
		IPuser.setFont(new Font("Visby Round CF", Font.PLAIN, 15));
		IPuser.setForeground(new Color(255, 255, 255));
		IPuser.setColumns(10);
		IPuser.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		IPuser.setBackground(new Color(39, 61, 97));
		IPuser.setBounds(86, 210, 276, 36);
		
		PloginArea.add(IPuser);
		
		IPpassword = new JPasswordField();
		IPpassword.setCaretColor(new Color(255, 255, 255));
		IPpassword.setForeground(new Color(255, 255, 255));
		IPpassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		IPpassword.setBackground(new Color(39, 61, 97));
		IPpassword.setBounds(86, 286, 276, 42);
		PloginArea.add(IPpassword);
		
		JLabel lblDontHaveAn = new JLabel("Don't have an account ?");
		lblDontHaveAn.setForeground(Color.WHITE);
		lblDontHaveAn.setFont(new Font("Visby Round CF DemiBold", Font.PLAIN, 13));
		lblDontHaveAn.setBounds(35, 515, 154, 14);
		PloginArea.add(lblDontHaveAn);
		
		 Blogin = new JButton("Login");
		Blogin.setForeground(new Color(39, 61, 97));
		Blogin.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 19));
		Blogin.setBackground(new Color(39, 61, 97));
		Blogin.setBounds(137, 405, 177, 39);
		Blogin.setFocusable(false);
		PloginArea.add(Blogin);
		
		JButton Bsignup = new JButton("Sign up");
		Bsignup.setForeground(new Color(39, 61, 97));
		Bsignup.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 13));
		Bsignup.setBackground(new Color(39, 61, 97));
		Bsignup.setBounds(190, 509, 84, 22);
		Bsignup.setFocusable(false);
		PloginArea.add(Bsignup);
		
		JLabel lblUserAccountOr_1 = new JLabel("User account or password incorrect");
		lblUserAccountOr_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserAccountOr_1.setForeground(new Color(255, 255, 255));
		lblUserAccountOr_1.setFont(new Font("Visby Round CF DemiBold", Font.PLAIN, 13));
		lblUserAccountOr_1.setBounds(20, 339, 383, 14);
		PloginArea.add(lblUserAccountOr_1);
		Plogin.add(LBimage);
		
		JPanel CardLayout = new JPanel();
		CardLayout.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		getContentPane().add(CardLayout, "name_7433944997300");
		CardLayout.setLayout(new CardLayout(0, 0));
		CardLayout.add(Plogin);		
		
		JPanel PSignup = new JPanel();
		CardLayout.add(PSignup, "name_10636029098600");
		PSignup.setLayout(null);
		
		JLabel imagesignup = new JLabel("");
		imagesignup.setBounds(-83, 1, 712, 583);
		PSignup.add(imagesignup);
		imagesignup.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/bg_login.jpg"))));
		
		JPanel Psignup = new JPanel();
		Psignup.setBackground(new Color(39, 61, 97));
		Psignup.setBounds(629, -1, 429, 587);
		PSignup.add(Psignup);
		Psignup.setLayout(null);
		
		JLabel LBsignup = new JLabel("Sign up");
		LBsignup.setHorizontalAlignment(SwingConstants.CENTER);
		LBsignup.setFont(new Font("Visby Round CF ExtraBold", Font.PLAIN, 60));
		LBsignup.setForeground(new Color(255, 255, 255));
		LBsignup.setBounds(10, 42, 409, 85);
		Psignup.add(LBsignup);
		
		JLabel LBusersignup = new JLabel("");
		LBusersignup.setBounds(55, 211, 37, 40);
		Psignup.add(LBusersignup);
		LBusersignup.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/user.png"))));
		Plogin.add(LBimage);
		
		JLabel LBpasswordsignup = new JLabel("");
		LBpasswordsignup.setBounds(58, 277, 28, 40);
		Psignup.add(LBpasswordsignup);
		LBpasswordsignup.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/password.png"))));
		
		JLabel LBpasswordsignup_1 = new JLabel("");
		LBpasswordsignup_1.setBounds(59, 357, 28, 40);
		Psignup.add(LBpasswordsignup_1);
		LBpasswordsignup_1.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/password.png"))));
		
		IPuserSU = new JTextField();
		IPuserSU.setCaretColor(new Color(255, 255, 255));
		IPuserSU.setForeground(new Color(255, 255, 255));
		IPuserSU.setFont(new Font("Visby Round CF", Font.PLAIN, 15));
		IPuserSU.setText("admin");
		IPuserSU.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		IPuserSU.setBackground(new Color(39, 61, 97));
		IPuserSU.setBounds(100, 208, 275, 41);
		Psignup.add(IPuserSU);
		IPuserSU.setColumns(10);
		
		JButton BsignupSU = new JButton("Signup\r\n");
		BsignupSU.setForeground(new Color(39, 61, 97));
		BsignupSU.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 19));
		BsignupSU.setBackground(new Color(39, 61, 97));
		BsignupSU.setBounds(148, 435, 152, 40);
		BsignupSU.setFocusable(false);
		Psignup.add(BsignupSU);
		
		IPpasswordSU = new JPasswordField();
		IPpasswordSU.setForeground(new Color(255, 255, 255));
		IPpasswordSU.setText("1231231");
		IPpasswordSU.setCaretColor(new Color(255, 255, 255));
		IPpasswordSU.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		IPpasswordSU.setBackground(new Color(39, 61, 97));
		IPpasswordSU.setBounds(100, 277, 275, 40);
		Psignup.add(IPpasswordSU);
		
		IPpasswordSU2 = new JPasswordField();
		IPpasswordSU2.setForeground(new Color(255, 255, 255));
		IPpasswordSU2.setText("12312313");
		IPpasswordSU2.setCaretColor(Color.WHITE);
		IPpasswordSU2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		IPpasswordSU2.setBackground(new Color(39, 61, 97));
		IPpasswordSU2.setBounds(100, 352, 275, 40);
		Psignup.add(IPpasswordSU2);
		
		JLabel lblNewLabel = new JLabel("Already have an account ?");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Visby Round CF DemiBold", Font.PLAIN, 13));
		lblNewLabel.setBounds(55, 542, 172, 21);
		Psignup.add(lblNewLabel);
		
		JButton BloginSU = new JButton("Login");
		BloginSU.setBackground(new Color(39, 61, 97));
		BloginSU.setForeground(new Color(39, 61, 97));
		BloginSU.setFont(new Font("Visby Round CF Heavy", Font.BOLD, 13));
		BloginSU.setBounds(227, 541, 67, 21);
		BloginSU.setFocusable(false);
		Psignup.add(BloginSU);
		
		JLabel LBusersignup_2 = new JLabel("");
		LBusersignup_2.setBounds(60, 141, 28, 40);
		LBusersignup_2.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("/image/email.png"))));
		Psignup.add(LBusersignup_2);
		
		IPemailSU = new JTextField();
		IPemailSU.setText("admin");
		IPemailSU.setForeground(Color.WHITE);
		IPemailSU.setFont(new Font("Visby Round CF", Font.PLAIN, 15));
		IPemailSU.setColumns(10);
		IPemailSU.setCaretColor(Color.WHITE);
		IPemailSU.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		IPemailSU.setBackground(new Color(39, 61, 97));
		IPemailSU.setBounds(100, 135, 275, 41);
		Psignup.add(IPemailSU);
		
		JLabel lblUserAccountOr = new JLabel("User account or password incorrect");
		lblUserAccountOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserAccountOr.setForeground(new Color(255, 255, 255));
		lblUserAccountOr.setFont(new Font("Visby Round CF DemiBold", Font.PLAIN, 13));
		lblUserAccountOr.setBounds(19, 403, 399, 21);
		Psignup.add(lblUserAccountOr);
		Plogin.add(LBimage);
		
		
		
	}
	
	public void addActionListener(ActionListener listener) {
			Blogin.addActionListener(listener);
	        
	}
}
