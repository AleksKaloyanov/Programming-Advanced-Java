package Assignment;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String id;
    private List<Project> projects;

    public Employee(String id) {
        setId(id);
        this.projects = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public List<Project> getProjects() {
        return projects;
    }

    private void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addProject(Project project){
        this.projects.add(project);
    }
}
