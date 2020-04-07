package sfgpetclinic.service;

import sfgpetclinic.model.Pet;

import java.util.Set;

/**
 * Created by romantorkit on 12/2/19
 */
public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
