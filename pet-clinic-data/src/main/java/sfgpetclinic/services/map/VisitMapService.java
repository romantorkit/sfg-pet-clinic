package sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import sfgpetclinic.model.Visit;
import sfgpetclinic.services.VisitService;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null || visit.getPet().isNew() || visit.getPet().getOwner() == null
                || visit.getPet().getOwner().isNew()){
            throw new RuntimeException("Need proper visit object");
        }
        return super.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
