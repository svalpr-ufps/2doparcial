import javax.persistence.*;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data.*;

@Entity
public class ProjectAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer project_id;
    private Integer employee_id;
    private Integer role_id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
