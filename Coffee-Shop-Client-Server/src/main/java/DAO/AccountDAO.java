package DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.AccountModel;
import model.ProductModel;
import model.UserModel;
import util.HibernateAPI;

public class AccountDAO {
	private SessionFactory sessionFactory;
	
	public void addAccount(AccountModel account) {
        Transaction transaction = null;
        try {
            SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                try {
                    transaction = session.beginTransaction();
                    session.saveOrUpdate(account.getUser());
                    session.saveOrUpdate(account);
                    transaction.commit();
                } catch (Exception e) {
                    if (transaction != null) {
                        transaction.rollback();
                    }
                    e.printStackTrace();
                } finally {
                    session.close();
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
	
	public boolean isAccountExists(String username) {
        Transaction transaction = null;
        boolean exists = false;
        try {
            SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                try {
                    transaction = session.beginTransaction();
                    Query<AccountModel> query = session.createQuery("FROM AccountModel WHERE username = :username", AccountModel.class);
                    query.setParameter("username", username);
                    exists = query.uniqueResult() != null;
                    transaction.commit();
                } catch (Exception e) {
                    if (transaction != null) {
                        transaction.rollback();
                    }
                    e.printStackTrace();
                } finally {
                    session.close();
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return exists;
    }
	
	public AccountModel getAccountByUsername(String username) {
        Transaction transaction = null;
        AccountModel account = null;
        try {
            SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                try {
                    transaction = session.beginTransaction();
                    Query<AccountModel> query = session.createQuery("FROM AccountModel WHERE username = :username", AccountModel.class);
                    query.setParameter("username", username);
                    account = query.uniqueResult();
                    transaction.commit();
                } catch (Exception e) {
                    if (transaction != null) {
                        transaction.rollback();
                    }
                    e.printStackTrace();
                } finally {
                    session.close();
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return account;
    }
	
	
	public boolean checkLogin(String username, String password) {
        boolean isLoggedIn = false;
        try {
            SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                try {
                    Transaction tx = session.beginTransaction();

                    // Query to check if account exists
                    Query<AccountModel> query = session.createQuery("FROM AccountModel WHERE username = :username AND password = :password", AccountModel.class);
                    query.setParameter("username", username);
                    query.setParameter("password", password);
                    
                    AccountModel account = query.uniqueResult();
                    isLoggedIn = (account != null);

                    tx.commit();
                } finally {
                    session.close();
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return isLoggedIn;
    }
	
	
	public boolean changePassword(String username, String oldPassword, String newPassword) {
        boolean isPasswordChanged = false;
        try {
            SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                try {
                    Transaction tx = session.beginTransaction();

                    // Query to find account
                    Query<AccountModel> query = session.createQuery("FROM AccountModel WHERE username = :username AND password = :oldPassword", AccountModel.class);
                    query.setParameter("username", username);
                    query.setParameter("oldPassword", oldPassword);

                    AccountModel account = query.uniqueResult();
                    if (account != null) {
                        account.setPassword(newPassword);
                        session.saveOrUpdate(account);
                        isPasswordChanged = true;
                    }

                    tx.commit();
                } finally {
                    session.close();
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return isPasswordChanged;
    }
	
	public UserModel getUserByAccountUsername(String username) {
        UserModel user = null;
        try {
            SessionFactory sessionFactory = HibernateAPI.getSessionFactory();
            if (sessionFactory != null) {
                try {
                    Session session = sessionFactory.openSession();
                    String hql = "FROM AccountModel a WHERE a.username = :username";
                    Query<AccountModel> query = session.createQuery(hql, AccountModel.class);
                    query.setParameter("username", username);
                    AccountModel account = query.uniqueResult();
                    if (account != null) {
                        user = account.getUser();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
	
}
