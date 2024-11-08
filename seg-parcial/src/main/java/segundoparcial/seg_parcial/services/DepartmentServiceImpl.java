package segundoparcial.seg_parcial.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import segundoparcial.seg_parcial.entities.Department;
import segundoparcial.seg_parcial.entities.Employee;
import segundoparcial.seg_parcial.repositories.DepartmentRepository;
import segundoparcial.seg_parcial.repositories.EmployeeRepository;
import segundoparcial.seg_parcial.services.DepartmentService;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Department findDepartmentById(Integer id) {
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public void addEmployeesToDepartment(Integer departmentId, List<Integer> employeeIds) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new RuntimeException("Department not found"));
        List<Employee> employees = employeeRepository.findAllById(employeeIds);
        
        employees.forEach(employee -> employee.setDepartment(department));
        employeeRepository.saveAll(employees);
    }

    @Override
    public void removeEmployeeFromDepartment(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setDepartment(null);
        employeeRepository.save(employee);
    }
}
