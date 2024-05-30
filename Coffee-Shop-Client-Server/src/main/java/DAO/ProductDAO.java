package DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import model.ProductModel;
import util.HibernateAPI;

import java.util.List;

import model.ProductModel;

public class ProductDAO {
    private SessionFactory sessionFactory;



    public void addProduct(ProductModel product) {
    	try {
        	SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
        	if(sessionFactory != null) {
        		Session session = sessionFactory.openSession();	
    			try {
        			Transaction tx = session.beginTransaction();        			
        			session.save(product);
        			tx.commit();
				} finally {
					session.close();					
				}
        	}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
    }

    public void updateProduct(ProductModel product) {
    	
    	try {
        	SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
        	if(sessionFactory != null) {
        		Session session = sessionFactory.openSession();	
    			try {
        			Transaction tx = session.beginTransaction();        			
        			session.saveOrUpdate(product);
        			tx.commit();
				} finally {
					session.close();					
				}
        	}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
    }

    public void deleteProduct(ProductModel product) {
        try {
        	SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
        	if(sessionFactory != null) {
        		Session session = sessionFactory.openSession();	
    			try {
        			Transaction tx = session.beginTransaction();        			
        			session.delete(product);
        			tx.commit();
				} finally {
					session.close();					
				}
        	}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
    }
    
    

    public ProductModel getProductById(Integer productId) {
        ProductModel product = null;
        try {
        	SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
        	if(sessionFactory != null) {
        		Session session = sessionFactory.openSession();	
    			try {
        			Transaction tx = session.beginTransaction();        			
        			product = session.get(ProductModel.class, productId);
        			tx.commit();
				} finally {
					session.close();					
				}
        	}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
        return product;
    }
    
    public Integer getProductIDByName(String productName) {
        Integer productID = null;
        Session session = HibernateAPI.getSessionFactory().openSession();
        try {
        	Transaction tx = session.beginTransaction();   
            String hql = "SELECT p.productID FROM ProductModel p WHERE p.productName = :productName";
            Query<Integer> query = session.createQuery(hql, Integer.class);
            query.setParameter("productName", productName);
            productID = query.uniqueResult();            
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return productID;
    }

    
    public boolean isProductNameExists(String productName) {
        Session session = HibernateAPI.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("SELECT COUNT(*) FROM ProductModel WHERE productName = :name");
            query.setParameter("name", productName);
            long count = (long) query.uniqueResult();
            transaction.commit();
            return count > 0;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }
    


	public List<ProductModel> getAllProducts() {
		List<ProductModel> products = null;
		try {
			SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					// Transaction tx = session.beginTransaction();
					Query<ProductModel> query = session.createQuery("FROM ProductModel", ProductModel.class);
					products = query.list();
					// tx.commit();
				} finally {
					session.close();
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return products;
	}
    
	public List<ProductModel> getByNameProduct(String keyword) {
		List<ProductModel> products = null;
		try {
			SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
			if (sessionFactory != null) {
				try {
					Session session = sessionFactory.openSession();
//				    Transaction tx = session.beginTransaction(); 
					String hql = "FROM ProductModel p WHERE LOWER(p.productName) LIKE :keyword";
					Query<ProductModel> query = session.createQuery(hql, ProductModel.class);
					query.setParameter("keyword", "%" + keyword.toLowerCase() + "%");
//				    tx.commit();
					products = query.list();
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return products;
	}
}
