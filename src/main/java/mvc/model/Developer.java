package mvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@Entity
@Table(name = "developer")
public class  Developer {
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
    @ManyToMany
    @JoinTable(
            name = "developer_skill",
            joinColumns = {@JoinColumn(name = "developer_id")},
            inverseJoinColumns = {@JoinColumn(name = "skill_id")}
    )
    private Set<Skill> skills;
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    public Developer() {
    }
//
//    public Developer(String firstName, String lastName, String specialty, Set<Skill> skills, Account account) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.specialty = specialty;
//        this.skills = skills;
//        this.account = account;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getSpecialty() {
//        return specialty;
//    }
//
//    public void setSpecialty(String specialty) {
//        this.specialty = specialty;
//    }
//
//    public Set<Skill> getSkills() {
//        return skills;
//    }
//
//    public void setSkills(Set<Skill> skills) {
//        this.skills = skills;
//    }
//
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Developer developer = (Developer) o;
//        return id == developer.id &&
//                Objects.equals(firstName, developer.firstName) &&
//                Objects.equals(lastName, developer.lastName) &&
//                Objects.equals(specialty, developer.specialty) &&
//                Objects.equals(skills, developer.skills) &&
//                Objects.equals(account, developer.account);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, firstName, lastName, specialty, skills, account);
//    }
//
//    @Override
//    public String toString() {
//        return "Developer{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", specialty='" + specialty + '\'' +
//                ", skills=" + skills +
//                ", account=" + account +
//                '}';
//    }
}
