package mvc.repository.impl;

import mvc.model.Developer;
import mvc.repository.DeveloperRepository;
import mvc.util.SessionFactoryUtil;
import org.hibernate.Session;

import javax.persistence.Query;
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
            Developer developer = session.createQuery("FROM Developer d LEFT JOIN FETCH " +
                    "d.skills" +
                    " WHERE d.id = :id ", Developer.class).setParameter("id", id).getSingleResult();
            return developer;
        }
    }

    @Override
    public void update(Developer developer) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Developer developerToSave = session.get(Developer.class, developer.getId());
            session.beginTransaction();
            developerToSave = developerToSave.builder()
                    .id(developer.getId())
                    .firstName(developer.getFirstName())
                    .lastName(developer.getLastName())
                    .specialty(developer.getSpecialty())
                    .skills(developer.getSkills())
                    .account(developer.getAccount())
                    .build();
            session.merge(developerToSave);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Developer> getAll() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Developer> developers = session.createQuery("FROM Developer d LEFT JOIN FETCH " +
                    "d.skills").getResultList();
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
