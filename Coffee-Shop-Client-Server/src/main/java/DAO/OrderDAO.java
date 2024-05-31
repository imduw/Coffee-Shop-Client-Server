package DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.OrderModel;
import model.ProductModel;
import util.HibernateAPI;

public class OrderDAO {
	private SessionFactory sessionFactory;



	public void addOrder(OrderModel order) {
	    try {
	        SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
	        if (sessionFactory != null) {
	            Session session = sessionFactory.openSession();
	            try {
	                Transaction tx = session.beginTransaction();
	                session.save(order);
	                tx.commit();
	            } finally {
	                session.close();
	            }
	        }
	    } catch (HibernateException e) {
	        e.printStackTrace();
	    }
	}
    
    
    public  List<OrderModel> getAllOrders() {
		List<OrderModel> orders = null;
		try {
			SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					// Transaction tx = session.beginTransaction();
					Query<OrderModel> query = session.createQuery("FROM OrderModel", OrderModel.class);
					orders = query.list();
					// tx.commit();
				} finally {
					session.close();
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return orders;
	}
}
