package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import model.ProductModel;

import view.forms.MainView;
import view.forms.LoginView;

public class AdminController implements ActionListener {
	private MainView mv;
	private LoginView lv;
	private ProductModel productModel;
	
	

	
	
	public AdminController(MainView mv,LoginView lv,ProductModel productModel) {
			
			this.mv = mv;
			this.lv = lv;
			this.productModel = productModel;

			
			lv.Bsignup.addActionListener((e)->{
				lv.CardPanel_login.removeAll();
				lv.CardPanel_login.add(lv.Psignup);
				lv.CardPanel_login.repaint();
				lv.CardPanel_login.revalidate();
			});
			lv.BloginSU.addActionListener((e)->{
				lv.CardPanel_login.removeAll();
				lv.CardPanel_login.add(lv.Plogin);
				lv.CardPanel_login.repaint();
				lv.CardPanel_login.revalidate();
			});
			
			mv.BdashboardForm.addActionListener((e)->{
				mv.CardPanel.removeAll();
				mv.CardPanel.add(mv.DashboardPanel);
				mv.CardPanel.repaint();
				mv.CardPanel.revalidate();
			});
			mv.BproductForm.addActionListener((e)->{
				mv.CardPanel.removeAll();
				mv.CardPanel.add(mv.ProductPanel);
				mv.CardPanel.repaint();
				mv.CardPanel.revalidate();
			});

			mv.BhomeForm.addActionListener((e)->{
				mv.CardPanel.removeAll();
				mv.CardPanel.add(mv.HomePanel);
				mv.CardPanel.repaint();
				mv.CardPanel.revalidate();
			});
			
			mv.BsalesOrder.addActionListener((e)->{
				mv.CardPanel.removeAll();
				mv.CardPanel.add(mv.SalesOrderPanel);
				mv.CardPanel.repaint();
				mv.CardPanel.revalidate();
			});
			
			mv.Bsignout.addActionListener((e)->{
				lv.IPpassword.setText("");
				mv.setVisible(false);
				lv.setVisible(true);
				
			
			});
			
	
		}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	
	

	
	
	
	

	
	

	
	
	

}
