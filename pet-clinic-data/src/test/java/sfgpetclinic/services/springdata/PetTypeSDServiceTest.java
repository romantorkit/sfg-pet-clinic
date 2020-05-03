package sfgpetclinic.services.springdata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sfgpetclinic.model.PetType;
import sfgpetclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PetTypeSDServiceTest {

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    PetTypeSDService service;

    PetType expectedDog;
    PetType expectedCat;
    Long expectedIdOne = 1L;
    Long expectedIdTwo = 2L;
    String expectedDogName = "dog";
    String expectedCatName = "dog";

    @BeforeEach
    void setUp() {
        expectedDog = new PetType(expectedIdOne, expectedDogName);
        expectedCat = new PetType(expectedIdTwo, expectedCatName);
    }

    @Test
    void findAll() {
        Set<PetType> expectedSet = new HashSet<>();
        expectedSet.add(expectedDog);
        expectedSet.add(expectedCat);
        when(petTypeRepository.findAll()).thenReturn(expectedSet);

        Set<PetType> actualSet = service.findAll();
        assertNotNull(actualSet);
        assertEquals(2, actualSet.size());
        verify(petTypeRepository).findAll();
    }

    @Test
    void findById() {
        when(petTypeRepository.findById(expectedIdOne)).thenReturn(Optional.of(expectedDog));
        PetType actual = service.findById(expectedIdOne);
        assertNotNull(actual);
        assertEquals(expectedIdOne, actual.getId());
        verify(petTypeRepository).findById(expectedIdOne);
    }

    @Test
    void findById_ThrowsException() {
        Long notExistingId = 3L;
        when(petTypeRepository.findById(notExistingId)).thenThrow(NoSuchElementException.class);
        assertThrows(NoSuchElementException.class, () -> service.findById(notExistingId));
        verify(petTypeRepository).findById(notExistingId);
    }

    @Test
    void save() {
        when(petTypeRepository.save(any())).thenReturn(expectedDog);
        PetType actual = service.save(new PetType(null, expectedDogName));
        assertNotNull(actual);
        assertEquals(expectedIdOne, actual.getId());
        assertEquals(expectedDogName, actual.getTypeName());
        verify(petTypeRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(expectedDog);
        verify(petTypeRepository).delete(expectedDog);
    }

    @Test
    void deleteById() {
        service.deleteById(expectedIdOne);
        verify(petTypeRepository).deleteById(expectedIdOne);
    }
}