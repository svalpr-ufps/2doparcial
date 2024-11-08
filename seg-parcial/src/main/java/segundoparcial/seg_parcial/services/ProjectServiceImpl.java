package segundoparcial.seg_parcial.services.impl;
import segundoparcial.seg_parcial.entities.Project;
import segundoparcial.seg_parcial.entities.ProjectAssignment;
import segundoparcial.seg_parcial.entities.Employee;
import segundoparcial.seg_parcial.repositories.ProjectRepository;
import segundoparcial.seg_parcial.repositories.EmployeeRepository;
import segundoparcial.seg_parcial.repositories.ProjectAssignmentRepository;
import segundoparcial.seg_parcial.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectAssignmentRepository projectAssignmentRepository;

    @Override
    public List<Project> listProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project updateProject(Integer projectId, Project projectDetails) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));
        project.setProjectName(projectDetails.getProjectName());
        return projectRepository.save(project);
    }

    @Override
    public List<Employee> listEmployeesWithRoles(Integer projectId) {
        return projectAssignmentRepository.findByProjectId(projectId)
                                          .stream()
                                          .map(ProjectAssignment::getEmployee)
                                          .toList();
    }

    @Override
    public void addEmployeeToProject(Integer projectId, Integer employeeId, Role role) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));

        ProjectAssignment assignment = new ProjectAssignment();
        assignment.setEmployee(employee);
        assignment.setProject(project);
        assignment.setRole(role);
        
        projectAssignmentRepository.save(assignment);
    }
}
