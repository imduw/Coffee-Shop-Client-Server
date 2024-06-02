package DAO;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    
	public List<OrderModel> getByNameOrder(String keyword) {
		List<OrderModel> orders = null;
		try {
			SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
			if (sessionFactory != null) {
				try {
					Session session = sessionFactory.openSession();
//				    Transaction tx = session.beginTransaction(); 
					String hql = "FROM OrderModel p WHERE LOWER(p.Creator) LIKE :keyword ORDER BY date DESC";
					Query<OrderModel> query = session.createQuery(hql, OrderModel.class);
					query.setParameter("keyword", "%" + keyword.toLowerCase() + "%");
//				    tx.commit();
					orders = query.list();
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return orders;
	}
	
	
    
    public  List<OrderModel> getAllOrders() {
		List<OrderModel> orders = null;
		try {
			SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					// Transaction tx = session.beginTransaction();
					Query<OrderModel> query = session.createQuery("FROM OrderModel ORDER BY date DESC", OrderModel.class);
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
    
    
    public List<OrderModel> getByDateOrder(int year, int month, int day) {
        List<OrderModel> orders = null;
        try {
            SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
            if (sessionFactory != null) {
                try {
                    Session session = sessionFactory.openSession();
                    String hql = "FROM OrderModel p WHERE YEAR(p.Date) = :year AND MONTH(p.Date) = :month AND DAY(p.Date) = :day ORDER BY Date DESC";
                    Query<OrderModel> query = session.createQuery(hql, OrderModel.class);
                    query.setParameter("year", year);
                    query.setParameter("month", month);
                    query.setParameter("day", day);
                    orders = query.list();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }
    
    
}
