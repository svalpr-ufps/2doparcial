import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProjectAssignmentRepository extends JpaRepository<Department, Integer> {
}