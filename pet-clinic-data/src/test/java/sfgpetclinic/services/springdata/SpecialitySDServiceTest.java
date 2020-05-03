package sfgpetclinic.services.springdata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sfgpetclinic.model.Speciality;
import sfgpetclinic.repositories.SpecialityRepository;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialitySDServiceTest {

    Speciality expectedSpeciality1;
    Speciality expectedSpeciality2;
    Set<Speciality> expectedSet;
    Long expectedId = 1L;

    @Mock
    SpecialityRepository specialityRepository;

    @InjectMocks
    SpecialitySDService specialitySDService;

    @BeforeEach
    void setUp() {
        expectedSpeciality1 = new Speciality(1L, "Speciality 1");
        expectedSpeciality2 = new Speciality(2L, "Speciality 2");
        expectedSet = new HashSet<>();
        expectedSet.add(expectedSpeciality1);
        expectedSet.add(expectedSpeciality2);
    }

    @Test
    void findAll() {
        when(specialityRepository.findAll()).thenReturn(expectedSet);

        Set<Speciality> actualSet = specialitySDService.findAll();
        verify(specialityRepository, times(1)).findAll();
        assertEquals(expectedSet.size(), actualSet.size());
    }

    @Test
    void findById() {
        when(specialityRepository.findById(expectedId)).thenReturn(Optional.of(expectedSpeciality1));

        Speciality actual = specialitySDService.findById(expectedId);
        verify(specialityRepository, times(1)).findById(expectedId);
        assertEquals(expectedId, actual.getId());
    }

    @Test
    void findById_ThrowsNoSuchElementException() {
        when(specialityRepository.findById(anyLong())).thenThrow(NoSuchElementException.class);

        assertThrows(NoSuchElementException.class, () -> specialitySDService.findById(anyLong()));
        verify(specialityRepository, times(1)).findById(anyLong());
    }

    @Test
    void save() {
        when(specialityRepository.save(any())).thenReturn(expectedSpeciality1);
        Speciality actual = specialitySDService.save(any());
        assertEquals(expectedId, actual.getId());
        verify(specialityRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        specialitySDService.delete(any());
        verify(specialityRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        specialitySDService.deleteById(anyLong());
        verify(specialityRepository, times(1)).deleteById(anyLong());
    }
}