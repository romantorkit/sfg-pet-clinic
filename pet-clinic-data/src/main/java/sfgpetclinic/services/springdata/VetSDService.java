package sfgpetclinic.services.springdata;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfgpetclinic.model.Vet;
import sfgpetclinic.repositories.VetRepository;
import sfgpetclinic.services.VetService;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Profile({"default","springdata"})
public class VetSDService implements VetService {

    private final VetRepository vetRepository;

    public VetSDService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.findById(id);
    }
}
