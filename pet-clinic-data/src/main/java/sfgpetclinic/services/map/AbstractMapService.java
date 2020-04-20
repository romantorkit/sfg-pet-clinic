package sfgpetclinic.services.map;

import sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T t) {
        if(t != null){
            if (t.isNew()) {
                t.setId(getNextId());
            }
            map.put(t.getId(), t);
            return t;
        }
        throw new NullPointerException("Object can't be null.");
    }

    void delete(T t) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(t));
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    private long getNextId(){
        if (map.size() == 0) {
            return 1L;
        }
        return Collections.max(map.keySet()) + 1;
    }
}
