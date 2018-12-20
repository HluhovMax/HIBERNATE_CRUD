package mvc.repository.impl;

import mvc.model.Account;
import mvc.repository.AccountRepository;
import mvc.util.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AccountRepoImpl implements AccountRepository {

    @Override
    public void save(Account account) {
        Transaction transaction = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(account);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Account getById(Integer id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Account account = session.get(Account.class, id);
            return account;
        }
    }

    @Override
    public void update(Account account) {
        Transaction transaction = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Account tempAccount;
            tempAccount = session.get(Account.class, account.getId());
            tempAccount.setAccountData(account.getAccountData());
            session.update(tempAccount);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Account> getAll() {
        Transaction transaction = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List<Account> accounts = session.createQuery("FROM Account ").list();
            transaction.commit();
            return accounts;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        Transaction transaction = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Account account = session.get(Account.class, id);
            session.delete(account);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
