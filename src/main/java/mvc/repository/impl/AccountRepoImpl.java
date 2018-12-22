package mvc.repository.impl;

import mvc.model.Account;
import mvc.repository.AccountRepository;
import mvc.util.SessionFactoryUtil;
import org.hibernate.Session;

import java.util.List;

public class AccountRepoImpl implements AccountRepository {

    @Override
    public void save(Account account) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(account);
            session.getTransaction().commit();
        }
    }

    @Override
    public Account getById(Integer id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Account account = session.load(Account.class, id);
            return account;
        }
    }

    @Override
    public void update(Account account) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Account tempAccount = session.get(Account.class, account.getId());
            tempAccount.setAccountData(account.getAccountData());
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Account> getAll() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Account> accounts = session.createQuery("FROM Account ").getResultList();
            session.getTransaction().commit();
            return accounts;
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Account account = session.load(Account.class, id);
            session.delete(account);
            session.getTransaction().commit();
        }
    }
}
