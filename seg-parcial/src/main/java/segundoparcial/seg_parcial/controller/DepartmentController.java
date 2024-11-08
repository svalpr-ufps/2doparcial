package segundoparcial.seg_parcial.controller;
import segundoparcial.seg_parcial.entities.Department;
import segundoparcial.seg_parcial.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable Integer id) {
        return departmentService.findDepartmentById(id);
    }

    @PostMapping("/{departmentId}/employees")
    public ResponseEntity<Void> addEmployeesToDepartment(@PathVariable Integer departmentId, @RequestBody List<Integer> employeeIds) {
        departmentService.addEmployeesToDepartment(departmentId, employeeIds);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<Void> removeEmployeeFromDepartment(@PathVariable Integer employeeId) {
        departmentService.removeEmployeeFromDepartment(employeeId);
        return ResponseEntity.ok().build();
    }
}
