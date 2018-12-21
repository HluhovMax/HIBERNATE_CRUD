package mvc.repository.impl;

import mvc.model.Developer;
import mvc.repository.DeveloperRepository;
import mvc.util.SessionFactoryUtil;
import org.hibernate.Session;


import java.util.List;

public class DeveloperRepoImpl implements DeveloperRepository {

    @Override
    public void save(Developer developer) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(developer);
            session.getTransaction().commit();
        }
    }

    @Override
    public Developer getById(Integer id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Developer developer = session.load(Developer.class, id);
            return developer;
        }
    }

    @Override
    public void update(Developer developer) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Developer tempDeveloper = session.load(Developer.class, developer.getId());
            tempDeveloper.setFirstName(developer.getFirstName());
            tempDeveloper.setLastName(developer.getLastName());
            tempDeveloper.setSpecialty(developer.getSpecialty());
            tempDeveloper.setSkillSet(developer.getSkillSet());
            tempDeveloper.setAccount(developer.getAccount());
            session.update(tempDeveloper);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Developer> getAll() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Developer> developers = session.createQuery("FROM Developer ").getResultList();
            session.getTransaction().commit();
            return developers;
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Developer developer = session.load(Developer.class, id);
            session.delete(developer);
            session.getTransaction().commit();
        }
    }
}
