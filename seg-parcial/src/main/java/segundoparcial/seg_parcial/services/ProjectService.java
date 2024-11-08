package segundoparcial.seg_parcial.services;
import segundoparcial.seg_parcial.entities.Project;
import segundoparcial.seg_parcial.entities.ProjectAssignment;
import segundoparcial.seg_parcial.entities.Employee;

import java.util.List;

public interface ProjectService {
    List<Project> listProjects();
    Project updateProject(Integer projectId, Project projectDetails);
    List<Employee> listEmployeesWithRoles(Integer projectId);
    void addEmployeeToProject(Integer projectId, Integer employeeId, Role role);
}
