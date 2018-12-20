package mvc.model;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "accountData")
    private String accountData;

    public Account() {
    }

    public Account(String accountData) {
        this.accountData = accountData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountData() {
        return accountData;
    }

    public void setAccountData(String accountData) {
        this.accountData = accountData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                Objects.equals(accountData, account.accountData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountData);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountData='" + accountData + '\'' +
                '}';
    }
}
