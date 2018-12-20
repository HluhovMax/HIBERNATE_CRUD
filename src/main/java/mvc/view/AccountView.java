package mvc.view;

import mvc.controller.AccountController;
import mvc.model.Account;

import java.util.List;
import java.util.Scanner;

public class AccountView {
    private AccountController accountController =
            new AccountController();
    private Scanner stringScanner = new Scanner(System.in);
    private Scanner intScanner = new Scanner(System.in);
    private Account account = new Account();

    public void save() {
        System.out.println("enter account data:");
        account.setAccountData(stringScanner.nextLine());
        if (account != null) {
            accountController.save(account);
        }
    }

    public Account getById() {
        System.out.println("enter id:");
        account = accountController.getById(intScanner.nextInt());
        if (account != null) {
            System.out.println(account);
            return account;
        }
        return null;
    }

    public void update() {
        System.out.println("enter id, data");
        account.setId(intScanner.nextInt());
        account.setAccountData(stringScanner.nextLine());
        if (account != null) {
            accountController.update(account);
        }
    }

    public List<Account> getAll() {
        List<Account> accountList = accountController.getAll();
        for (Account account : accountList
        ) {
            System.out.println(account);
        }
        return accountList;
    }

    public void delete() {
        System.out.println("enter id:");
        accountController.delete(intScanner.nextInt());
    }
}
