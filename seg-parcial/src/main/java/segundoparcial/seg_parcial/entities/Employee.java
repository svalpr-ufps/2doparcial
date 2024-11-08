import javax.persistence.*;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String first_name;
    private String last_name;
    private Date birthdate;
    private Integer department_id;
    private Integer position_id;
    private Date entry_date;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @OneToMany(mappedBy = "employee")
    private List<Department> departments;

    @OneToMany(mappedBy = "employee")
    private List<Visit> visits;

    @OneToMany(mappedBy = "employee")
    private List<ProjectAssignment> projectAssignments;

}
