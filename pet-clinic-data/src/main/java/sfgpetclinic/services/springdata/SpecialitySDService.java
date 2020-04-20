package sfgpetclinic.services.springdata;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfgpetclinic.model.Speciality;
import sfgpetclinic.repositories.SpecialityRepository;
import sfgpetclinic.services.SpecialityService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdata")
public class SpecialitySDService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialitySDService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
