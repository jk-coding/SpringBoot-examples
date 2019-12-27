package simpletext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleTextRepository extends JpaRepository<SimpleTextRecord, Long> {

}
