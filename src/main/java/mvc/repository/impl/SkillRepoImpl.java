package mvc.repository.impl;


import mvc.model.Skill;
import mvc.repository.SkillRepository;
import mvc.util.SessionFactoryUtil;
import org.hibernate.Session;

import java.util.List;

public class SkillRepoImpl implements SkillRepository {

    @Override
    public void save(Skill skill) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(skill);
            session.getTransaction().commit();
        }
    }

    @Override
    public Skill getById(Integer id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Skill skill = session.load(Skill.class, id);
            return skill;
        }
    }

    @Override
    public void update(Skill skill) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Skill tempSkill = session.load(Skill.class, skill.getId());
            tempSkill.setName(skill.getName());
            session.update(tempSkill);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Skill> getAll() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Skill> skills = session.createQuery("FROM Skill ").getResultList();
            session.getTransaction().commit();
            return skills;
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Skill skill = session.load(Skill.class, id);
            session.delete(skill);
            session.getTransaction().commit();
        }
    }
}
