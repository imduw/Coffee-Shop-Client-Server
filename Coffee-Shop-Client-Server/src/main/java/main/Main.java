package main;

import java.awt.EventQueue;
import java.util.Date;

import javax.swing.UIManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import DAO.AccountDAO;
import DAO.OrderDAO;
import DAO.ProductDAO;
import controller.AccountController;
import controller.AdminController;
import controller.OrderController;
import controller.ProductController;
import controller.TableController;
import model.OrderModel;
import model.ProductModel;
import util.HibernateAPI;
import view.forms.LoginView;
import view.forms.MainView;

public class Main {
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					LoginView loginview = new LoginView();
					ProductDAO productDAO = new ProductDAO();
					ProductModel productModel = new ProductModel();  
					MainView mainView = new MainView();
					OrderDAO orderDAO = new OrderDAO();
					OrderModel orderModel = new OrderModel();
					OrderController orderController = new OrderController(orderDAO, orderModel, mainView, loginview);
					ProductController productController = new ProductController(productDAO, mainView, loginview, productModel);					
					TableController tableController = new TableController(productController, orderController, mainView, productDAO, orderDAO);
				    AdminController adminController = new AdminController(mainView,loginview,productModel);
				    AccountDAO accountDAO = new AccountDAO();
				    AccountController accountController =new AccountController(accountDAO, mainView, loginview);
					loginview.setVisible(true);
					
				    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
