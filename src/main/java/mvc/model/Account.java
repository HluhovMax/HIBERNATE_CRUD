package mvc.model;

import lombok.*;

import java.util.Objects;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "accountData")
    private String accountData;
}
