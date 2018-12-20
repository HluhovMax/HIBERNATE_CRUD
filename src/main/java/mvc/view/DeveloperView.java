package mvc.view;

import mvc.controller.AccountController;
import mvc.controller.DeveloperController;
import mvc.controller.SkillController;
import mvc.model.Developer;
import mvc.model.Skill;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DeveloperView {
    private DeveloperController developerController =
            new DeveloperController();
    private SkillController skillController = new SkillController();
    private AccountController accountController = new AccountController();
    private Scanner stringScanner = new Scanner(System.in);
    private Scanner intScanner = new Scanner(System.in);
    private Developer developer = new Developer();

    public void save() {
        System.out.println("enter name, last name, specialty:");
        developer.setFirstName(stringScanner.nextLine());
        developer.setLastName(stringScanner.nextLine());
        developer.setSpecialty(stringScanner.nextLine());
        System.out.println("how many skills do you want to add:");
        int x = intScanner.nextInt();
        Set<Skill> skills = new HashSet<>();
        for (int i = 0; i < x; i++) {
            System.out.println("enter skill id:");
            skills.add(skillController.getById(intScanner.nextInt()));
        }
        developer.setSkillSet(skills);
        System.out.println("enter account id:");
        developer.setAccount(accountController.getById(intScanner.nextInt()));
        if (developer != null) {
            developerController.save(developer);
        }
    }

    public Developer getById() {
        System.out.println("enter id:");
        developer = developerController.getById(intScanner.nextInt());
        if (developer != null) {
            System.out.println(developer);
            return developer;
        }
        return null;
    }

    public void update() {
        System.out.println("enter id, name, last name, specialty:");
        developer.setId(intScanner.nextInt());
        developer.setFirstName(stringScanner.nextLine());
        developer.setLastName(stringScanner.nextLine());
        developer.setSpecialty(stringScanner.nextLine());
        System.out.println("how many skills do you want to add:");
        int x = intScanner.nextInt();
        Set<Skill> skills = new HashSet<>();
        for (int i = 0; i < x; i++) {
            System.out.println("enter skill id:");
            skills.add(skillController.getById(intScanner.nextInt()));
        }
        developer.setSkillSet(skills);
        System.out.println("enter account id:");
        developer.setAccount(accountController.getById(intScanner.nextInt()));
        if (developer != null) {
            developerController.update(developer);
        }
    }

    public List<Developer> getAll() {
        List<Developer> developers = developerController.getAll();
        for (Developer developer : developers
        ) {
            System.out.println(developer);
        }
        return developers;
    }

    public void delete() {
        System.out.println("enetr id:");
        developerController.delete(intScanner.nextInt());
    }
}
