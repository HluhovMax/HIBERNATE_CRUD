package mvc.service;

import mvc.model.Skill;
import mvc.repository.SkillRepository;
import mvc.repository.impl.SkillRepoImpl;

import java.util.List;

public class SkillService {
    private SkillRepository skillRepository = new SkillRepoImpl();

    public void save(Skill skill) {
        skillRepository.save(skill);
    }

    public Skill getById(Integer id) {
        return skillRepository.getById(id);
    }

    public void update(Skill skill) {
        skillRepository.update(skill);
    }

    public List<Skill> getAll() {
        return skillRepository.getAll();
    }

    public void delete(Integer id) {
        skillRepository.delete(id);
    }
}
