package mvc;

import mvc.model.Account;
import mvc.model.Developer;
import mvc.model.Skill;
import mvc.repository.AccountRepository;
import mvc.repository.DeveloperRepository;
import mvc.repository.SkillRepository;
import mvc.repository.impl.AccountRepoImpl;
import mvc.repository.impl.DeveloperRepoImpl;
import mvc.repository.impl.SkillRepoImpl;
import mvc.util.SessionFactoryUtil;
import mvc.view.ConsoleHelper;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ConsoleHelper.run();
        }
}
