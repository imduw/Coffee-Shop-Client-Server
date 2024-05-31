package controller;

import java.util.Date;
import java.util.List;

import DAO.OrderDAO;
import model.OrderModel;
import view.forms.LoginView;
import view.forms.MainView;



public class OrderController {
	private OrderDAO orderDAO;
	private OrderModel orderModel;
	private MainView mv;
    private LoginView lv;
	
    
    
	public OrderController(OrderDAO orderDAO, OrderModel orderModel, MainView mv, LoginView lv) {
		super();
		this.orderDAO = orderDAO;
		this.orderModel = orderModel;
		this.mv = mv;
		this.lv = lv;
		
//		mv.Bpayment.addActionListener((e)->{
//			addOrder();
//		});
		
		
	}


	public void addOrder() {
		Date date = new Date();
		OrderModel order = new OrderModel();
		order.setCreator(lv.IPusername.getText());
		order.setDate(date);
		order.setTotal(Integer.parseInt(mv.LBtotal.getText()));
		
		orderDAO.addOrder(order);
	}
	
	
	
	public List<OrderModel> getAllOrders() {
        return orderDAO.getAllOrders();
    }
}
