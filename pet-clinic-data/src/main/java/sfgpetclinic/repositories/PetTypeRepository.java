package sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sfgpetclinic.model.PetType;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
