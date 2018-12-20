package mvc.view;

import java.util.Scanner;

public class ConsoleHelper {

    public static void run() {
        System.out.println("enter entity you want work with");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "account":
                AccountView accountView = new AccountView();
                System.out.println("enter the actions you want to do");
                choice = scanner.nextLine();
                switch (choice) {
                    case "save":
                        accountView.save();
                        break;
                    case "getById":
                        accountView.getById();
                        break;
                    case "update":
                        accountView.update();
                        break;
                    case "getAll":
                        accountView.getAll();
                        break;
                    case "delete":
                        accountView.delete();
                        break;
                }
                break;
            case "developer":
                DeveloperView developerView = new DeveloperView();
                System.out.println("enter the actions you want to do");
                choice = scanner.nextLine();
                switch (choice) {
                    case "save":
                        developerView.save();
                        break;
                    case "getById":
                        developerView.getById();
                        break;
                    case "update":
                        developerView.update();
                        break;
                    case "getAll":
                        developerView.getAll();
                        break;
                    case "delete":
                        developerView.delete();
                        break;
                }
                break;
            case "skill":
                SkillView skillView = new SkillView();
                System.out.println("enter the actions you want to do");
                choice = scanner.nextLine();
                switch (choice) {
                    case "save":
                        skillView.save();
                        break;
                    case "getById":
                        skillView.getById();
                        break;
                    case "update":
                        skillView.update();
                        break;
                    case "getAll":
                        skillView.getAll();
                        break;
                    case "delete":
                        skillView.delete();
                        break;
                }
                break;
        }
    }
}
