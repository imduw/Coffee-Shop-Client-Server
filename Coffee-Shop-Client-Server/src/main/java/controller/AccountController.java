package controller;

import java.util.Arrays;

import DAO.AccountDAO;
import model.AccountModel;
import view.forms.LoginView;
import view.forms.MainView;

public class AccountController {
	private AccountDAO accountDAO;
	
	private MainView mv;
    private LoginView lv;
	public AccountController(AccountDAO accountDAO, MainView mv, LoginView lv) {
		this.accountDAO = accountDAO;		
		this.mv = mv;
		this.lv = lv;
		
		lv.Blogin.addActionListener((e)->{
			checkLogin();			
		});		
		
		
		lv.BsignupSU.addActionListener((e)->{
			createAccount();
		});
	}
	
	public void createAccount() {
		AccountModel account = new AccountModel();
		char[] passwordSU = lv.IPpasswordSU.getPassword();
		char[] passwordSU2 = lv.IPpasswordSU2.getPassword();
		boolean test = !Arrays.equals(passwordSU, passwordSU2);
		if(lv.IPuserSU.getText().isEmpty() || lv.IPpasswordSU.getText().isEmpty() || lv.IPpasswordSU2.getText().isEmpty()) {
			lv.LBwarningSU.setText("Please complete all information");
			
		}else if(test) {
			lv.LBwarningSU.setText("Please fill in the information again");
						
		}else {
			String username = lv.IPuserSU.getText();
			String password = lv.IPpasswordSU.getText();
			if(accountDAO.isAccountExists(username)) {
				lv.LBwarningSU.setText("Username already exists");
			}else {
				account.setUsername(username);
				account.setPassword(password);
				
				accountDAO.addAccount(account);
				lv.LBwarningSU.setText("Sign up success");
			}
		}
	}
	
	public void checkLogin() {
		if(lv.IPusername.getText().isEmpty() || lv.IPpassword.getText().isEmpty()) {
			lv.LBwarning_login.setText("User account or password incorrect");
		}else {
			String username = lv.IPusername.getText();
			String password = lv.IPpassword.getText();			 			
			boolean isLoggedIn = accountDAO.checkLogin(username, password);			
			if(isLoggedIn != false) {
				mv.CardPanel.removeAll();
				mv.CardPanel.add(mv.HomePanel);
				mv.CardPanel.repaint();
				mv.CardPanel.revalidate();
				lv.setVisible(false);
				mv.setVisible(true);
				mv.LBnameclient.setText("Hello "+lv.IPusername.getText()+" !");
				mv.LBnameclient_1.setText(lv.IPusername.getText());
			}else {
				lv.IPusername.setText("");
				lv.IPpassword.setText("");
				lv.LBwarning_login.setText("User account or password incorrect");
			}
		}
	}
}	
