package mvc.view;

import mvc.controller.SkillController;
import mvc.model.Skill;

import java.util.List;
import java.util.Scanner;

public class SkillView {
    private SkillController skillController =
            new SkillController();
    private Scanner stringScanner = new Scanner(System.in);
    private Scanner intScanner = new Scanner(System.in);
    private Skill skill = new Skill();

    public void save() {
        System.out.println("enter skill:");
        skill.setName(stringScanner.nextLine());
        if (skill != null) {
            skillController.save(skill);
        }
    }

    public Skill getById() {
        System.out.println("enter id:");
        skill = skillController.getById(intScanner.nextInt());
        if (skill != null) {
            System.out.println(skill);
            return skill;
        }
        return null;
    }

    public void update() {
        System.out.println("enter id, skill:");
        skill.setId(intScanner.nextInt());
        skill.setName(stringScanner.nextLine());
        if (skill != null) {
            skillController.update(skill);
        }
    }

    public List<Skill> getAll() {
        List<Skill> skills = skillController.getAll();
        for (Skill skill : skills
        ) {
            System.out.println(skill);
        }
        return skills;
    }

    public void delete() {
        System.out.println("enter id:");
        skillController.delete(intScanner.nextInt());
    }
}

