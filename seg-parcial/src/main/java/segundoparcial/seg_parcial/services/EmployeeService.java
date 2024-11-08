package segundoparcial.seg_parcial.services;
import segundoparcial.seg_parcial.entities.Employee;
import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee findEmployeeWithSalary(Integer employeeId);
}
