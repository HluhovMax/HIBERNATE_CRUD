package mvc.service;

import mvc.model.Account;
import mvc.repository.impl.AccountRepoImpl;

import java.util.List;

public class AccountService {
    private AccountRepoImpl accountRepo = new AccountRepoImpl();

    public void save(Account account) {
        accountRepo.save(account);
    }

    public Account getById(Integer id) {
        return accountRepo.getById(id);
    }

    public void update(Account account) {
        accountRepo.update(account);
    }

    public List<Account> getAll() {
        return accountRepo.getAll();
    }

    public void delete(Integer id) {
        accountRepo.delete(id);
    }
}
