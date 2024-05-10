package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.ProductModel;
import view.forms.AdminView;
import view.forms.LoginView;

public class AdminController implements ActionListener{
	private AdminView adminView;
	private LoginView loginView;
	private ProductModel productModel;
	
	
	

	public AdminController(AdminView adminView,LoginView loginView, ProductModel productModel) {
		this.adminView = adminView;
		this.loginView = loginView;
		this.productModel = productModel;
		this.adminView.addActionListener(this);
		this.loginView.addActionListener(this);
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		switchPanel(e);
		manageProduct(e);
		checkLogin(e);
		
	}
	
	private void manageProduct(ActionEvent e) {
		if(e.getSource()==adminView.Badd) {
			System.out.println("Add");
		}
		if(e.getSource()==adminView.Bremove) {
			System.out.println("Remove");
		}
		if(e.getSource()==adminView.Bupdate) {
			System.out.println("Update");
		}
		
	}
	
	
	private void switchPanel(ActionEvent e) {
		if(e.getSource()== adminView.BdashboardForm) {
			adminView.CardPanel.removeAll();
			adminView.CardPanel.add(adminView.DashboardPanel);
			adminView.CardPanel.repaint();
			adminView.CardPanel.revalidate();
		}
		if(e.getSource()== adminView.BproductForm) {
			adminView.CardPanel.removeAll();
			adminView.CardPanel.add(adminView.ProductPanel);
			adminView.CardPanel.repaint();
			adminView.CardPanel.revalidate();
		}
		if(e.getSource()== adminView.BsettingForm) {
			adminView.CardPanel.removeAll();
			adminView.CardPanel.add(adminView.SettingPanel);
			adminView.CardPanel.repaint();
			adminView.CardPanel.revalidate();
		}
		if(e.getSource()== adminView.BinvoiceForm) {
			adminView.CardPanel.removeAll();
			adminView.CardPanel.add(adminView.InvoicePanel);
			adminView.CardPanel.repaint();
			adminView.CardPanel.revalidate();
		}
		if(e.getSource()==adminView.Bsignout) {
			adminView.setVisible(false);
			loginView.setVisible(true);
		}
	}
	
	private void checkLogin(ActionEvent e) {
		if(e.getSource()==loginView.Blogin) {
			this.loginView.setVisible(false);
			this.adminView.setVisible(true);
			
		}
	}
	
	
	

}
