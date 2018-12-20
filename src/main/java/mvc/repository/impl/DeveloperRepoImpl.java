package mvc.repository.impl;

import mvc.model.Developer;
import mvc.repository.DeveloperRepository;
import mvc.util.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DeveloperRepoImpl implements DeveloperRepository {

    @Override
    public void save(Developer developer) {
        Transaction transaction = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(developer);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Developer getById(Integer id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Developer developer = session.get(Developer.class, id);
            return developer;
        }
    }

    @Override
    public void update(Developer developer) {
        Transaction transaction = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Developer tempDeveloper = session.get(Developer.class, developer.getId());
            tempDeveloper.setFirstName(developer.getFirstName());
            tempDeveloper.setLastName(developer.getLastName());
            tempDeveloper.setSpecialty(developer.getSpecialty());
            tempDeveloper.setSkillSet(developer.getSkillSet());
            tempDeveloper.setAccount(developer.getAccount());
            session.update(tempDeveloper);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Developer> getAll() {
        Transaction transaction = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List<Developer> developers = session.createQuery("FROM Developer ").list();
            transaction.commit();
            return developers;
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
            Developer developer = session.get(Developer.class, id);
            session.delete(developer);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
