import javax.persistence.*;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer chief_id;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
    
    @OneToMany(mappedBy = "department")
    private List<Visit> visits;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
