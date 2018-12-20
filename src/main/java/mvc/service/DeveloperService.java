package mvc.service;

import mvc.model.Developer;
import mvc.repository.DeveloperRepository;
import mvc.repository.impl.DeveloperRepoImpl;

import java.util.List;

public class DeveloperService {
    private DeveloperRepository developerRepository =
            new DeveloperRepoImpl();

    public void save(Developer developer) {
        developerRepository.save(developer);
    }

    public Developer getById(Integer id) {
        return developerRepository.getById(id);
    }

    public void update(Developer developer) {
        developerRepository.update(developer);
    }

    public List<Developer> getAll() {
        return developerRepository.getAll();
    }

    public void delete(Integer id) {
        developerRepository.delete(id);
    }
}
