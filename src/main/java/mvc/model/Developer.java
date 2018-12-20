package mvc.model;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "developer")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "specialty")
    private String specialty;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "developer_skill",
            joinColumns = {@JoinColumn(name = "developer_id")},
            inverseJoinColumns = {@JoinColumn(name = "skill_id")}
    )
    private Set<Skill> skillSet;
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    public Developer() {
    }

    public Developer(String firstName, String lastName, String specialty, Set<Skill> skillSet, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.skillSet = skillSet;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Set<Skill> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(Set<Skill> skillSet) {
        this.skillSet = skillSet;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return id == developer.id &&
                Objects.equals(firstName, developer.firstName) &&
                Objects.equals(lastName, developer.lastName) &&
                Objects.equals(specialty, developer.specialty) &&
                Objects.equals(skillSet, developer.skillSet) &&
                Objects.equals(account, developer.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, specialty, skillSet, account);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", skillSet=" + skillSet +
                ", account=" + account +
                '}';
    }
}
