package segundoparcial.seg_parcial.services;
import segundoparcial.seg_parcial.entities.Department;
import segundoparcial.seg_parcial.entities.Employee;
import segundoparcial.seg_parcial.repositories.ProjectRepository;
import java.util.List;

public interface DepartmentService {
    Department findDepartmentById(Integer id);
    void addEmployeesToDepartment(Integer departmentId, List<Integer> employeeIds);
    void removeEmployeeFromDepartment(Integer employeeId);
}
