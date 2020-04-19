package sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sfgpetclinic.model.Speciality;

@Repository
public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
