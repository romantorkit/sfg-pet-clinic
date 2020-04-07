package sfgpetclinic.service;

import sfgpetclinic.model.Vet;

import java.util.Set;

/**
 * Created by romantorkit on 12/2/19
 */
public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
