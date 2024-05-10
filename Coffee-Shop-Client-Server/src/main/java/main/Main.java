package main;

import java.awt.EventQueue;

import javax.swing.UIManager;

import controller.AdminController;
import model.ProductModel;
import view.forms.LoginView;
import view.forms.AdminView;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					LoginView loginview = new LoginView();
					loginview.setVisible(true);
					AdminView adminView = new AdminView();
			        ProductModel productModel = new ProductModel();
			        AdminController adminController = new AdminController(adminView,loginview, productModel);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
