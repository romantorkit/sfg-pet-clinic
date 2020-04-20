package sfgpetclinic.services;

import sfgpetclinic.model.Owner;

/**
 * Created by romantorkit on 12/2/19
 */
public interface OwnerService extends AbstractCRUDService<Owner, Long>{

    Owner findByLastName(String lastName);

}
