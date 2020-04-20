package sfgpetclinic.services.springdata;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfgpetclinic.model.Pet;
import sfgpetclinic.services.PetService;

import java.util.Set;

@Service
@Profile({"default","springdata"})
public class PetSDService implements PetService {
    @Override
    public Set<Pet> findAll() {
        return null;
    }

    @Override
    public Pet findById(Long aLong) {
        return null;
    }

    @Override
    public Pet save(Pet pet) {
        return null;
    }

    @Override
    public void delete(Pet pet) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
