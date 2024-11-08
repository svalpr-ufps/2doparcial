package segundoparcial.seg_parcial.controller;
import segundoparcial.seg_parcial.entities.Project;
import segundoparcial.seg_parcial.entities.Employee;
import segundoparcial.seg_parcial.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> listProjects() {
        return projectService.listProjects();
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<Project> updateProject(@PathVariable } projectId, @RequestBody Project projectDetails) {
        Project updatedProject = projectService.updateProject(projectId, projectDetails);
        return ResponseEntity.ok(updatedProject);
    }

    @PostMapping("/{projectId}/employees/{employeeId}")
    public ResponseEntity<Void> addEmployeeToProject(@PathVariable Integer projectId, 
                                                     @PathVariable Integer employeeId, 
                                                     @RequestParam String role) {
        projectService.addEmployeeToProject(projectId, employeeId, role);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{projectId}/employees")
    public List<Employee> listEmployeesWithRoles(@PathVariable Integer projectId) {
        return projectService.listEmployeesWithRoles(projectId);
    }
}
