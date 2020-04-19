package sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sfgpetclinic.model.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
}
