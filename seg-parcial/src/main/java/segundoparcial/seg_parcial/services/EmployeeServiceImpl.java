package segundoparcial.seg_parcial.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import segundoparcial.seg_parcial.entities.Employee;
import segundoparcial.seg_parcial.repositories.EmployeeRepository;
import segundoparcial.seg_parcial.services.EmployeeService;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeWithSalary(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        // Suponiendo que el salario es un campo en Employee, se puede devolver directamente
        return employee;
    }
}
