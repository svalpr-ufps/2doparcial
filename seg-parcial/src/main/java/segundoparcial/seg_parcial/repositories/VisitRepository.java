import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface VisitRepository extends JpaRepository<Department, Integer> {
}