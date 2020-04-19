package sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sfgpetclinic.model.Visit;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
