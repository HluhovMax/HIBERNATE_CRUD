package mvc.repository;

import mvc.model.Account;

import java.util.List;

public interface AccountRepository extends GenericRepository<Account, Integer> {
    @Override
    void save(Account account);

    @Override
    Account getById(Integer integer);

    @Override
    void update(Account account);

    @Override
    List<Account> getAll();

    @Override
    void delete(Integer integer);
}
