package mvc.controller;

import mvc.model.Account;
import mvc.service.AccountService;

import java.util.List;

public class AccountController {
    private AccountService accountService = new AccountService();

    public void save(Account account) {
         accountService.save(account);
    }

    public Account getById(Integer id) {
        return accountService.getById(id);
    }

    public void update(Account account) {
        accountService.update(account);
    }

    public List<Account> getAll() {
        return accountService.getAll();
    }

    public void delete(Integer id) {
        accountService.delete(id);
    }
}
