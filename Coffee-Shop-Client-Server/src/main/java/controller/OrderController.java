package controller;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;

import DAO.OrderDAO;
import model.OrderModel;
import view.forms.LoginView;
import view.forms.MainView;



public class OrderController {
	private OrderDAO orderDAO;
	private OrderModel orderModel;
	private TableController tableController;
	private MainView mv;
    private LoginView lv;
	
    
	public OrderController(OrderDAO orderDAO, OrderModel orderModel, MainView mv, LoginView lv) {
		this.orderDAO = orderDAO;
		this.orderModel = orderModel;
		
		this.mv = mv;
		this.lv = lv;
		
		mv.Bpayment.addActionListener((e)->{
			addOrder();
		});
		
		
	}


	public void addOrder() {
		Date date = new Date();
		OrderModel order = new OrderModel();
		if(!mv.LBtotal.getText().isEmpty()  ) {
			order.setCreator(mv.LBnameuser.getText());
			order.setDate(date);
			order.setTotal(Integer.parseInt(mv.LBtotal.getText()));
		}else {
			mv.LBwarning_invoice.setText("No product is selected");
		}
		
			
		int refund = 0;
		
		if(!mv.IPreceive.getText().isEmpty()) {
			try {
				refund = Integer.parseInt(mv.IPreceive.getText()) - Integer.parseInt(mv.LBtotal.getText());
			} catch (NumberFormatException e) {
				
			}
			orderDAO.addOrder(order);
			mv.LBrefund.setText(""+refund);  
			mv.LBwarning_invoice.setText("Complete payment");
		}else {
			mv.LBwarning_invoice.setText("please enter receive");
		}
		
		  
		
	}
	
	
	public List<OrderModel> getAllOrders() {
        return orderDAO.getAllOrders();
    }
}
