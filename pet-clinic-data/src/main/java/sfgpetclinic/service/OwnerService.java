package sfgpetclinic.service;

import sfgpetclinic.model.Owner;

import java.util.Set;

/**
 * Created by romantorkit on 12/2/19
 */
public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
