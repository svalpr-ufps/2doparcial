import javax.persistence.*;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data.*;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String descripcion;
    private Date start_date;
    private Date end_date;

    @OneToMany(mappedBy = "project")
    private List<ProjectAssignment> projectAssignments;

}
