package mvc.controller;

import mvc.model.Skill;
import mvc.service.SkillService;

import java.util.List;

public class SkillController {
    private SkillService skillService =
            new SkillService();

    public void save(Skill skill) {
        skillService.save(skill);
    }

    public Skill getById(Integer id) {
        return skillService.getById(id);
    }

    public void update(Skill skill) {
        skillService.update(skill);
    }

    public List<Skill> getAll() {
        return skillService.getAll();
    }

    public void delete(Integer id) {
        skillService.delete(id);
    }
}
