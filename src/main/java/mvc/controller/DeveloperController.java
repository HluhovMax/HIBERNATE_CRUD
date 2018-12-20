package mvc.controller;

import mvc.model.Developer;
import mvc.service.DeveloperService;

import java.util.List;

public class DeveloperController {
    private DeveloperService developerService =
            new DeveloperService();

    public void save(Developer developer) {
        developerService.save(developer);
    }

    public Developer getById(Integer id) {
        return developerService.getById(id);
    }

    public void update(Developer developer) {
        developerService.update(developer);
    }

    public List<Developer> getAll() {
        return developerService.getAll();
    }

    public void delete(Integer id) {
        developerService.delete(id);
    }
}
