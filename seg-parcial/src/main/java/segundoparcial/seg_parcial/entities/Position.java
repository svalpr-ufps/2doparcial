import javax.persistence.*;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data.*;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double salary;

    @OneToMany(mappedBy = "position")
    private List<Employee> employees;

}
