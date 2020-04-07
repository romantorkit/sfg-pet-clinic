package sfgpetclinic.service;

import java.util.Set;

public interface AbstractCRUDService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T t);

    void delete(T t);

    void deleteById(ID id);
}
