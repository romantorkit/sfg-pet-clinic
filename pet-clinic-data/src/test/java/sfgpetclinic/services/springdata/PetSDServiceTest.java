package sfgpetclinic.services.springdata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sfgpetclinic.model.Pet;
import sfgpetclinic.repositories.PetRepository;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PetSDServiceTest {

    @Mock
    PetRepository petRepository;
    @InjectMocks
    PetSDService service;

    Long expectedPetId = 1L;
    Pet expectedPet;
    String expectedName = "Hans";

    @BeforeEach
    void setUp() {
        expectedPet = Pet.builder().id(expectedPetId).name(expectedName).build();
    }

    @Test
    void findAll() {
        Set<Pet> expectedSet = new HashSet<>();
        expectedSet.add(Pet.builder().id(1L).build());
        expectedSet.add(Pet.builder().id(2L).build());
        when(petRepository.findAll()).thenReturn(expectedSet);

        Set<Pet> actualSet = service.findAll();
        assertEquals(2, actualSet.size());
        verify(petRepository).findAll();
    }

    @Test
    void findById() {
        when(petRepository.findById(anyLong())).thenReturn(Optional.of(expectedPet));

        Pet actualPet = service.findById(expectedPetId);
        assertNotNull(actualPet);
        assertEquals(expectedPetId, actualPet.getId());
        verify(petRepository).findById(anyLong());
    }

    @Test
    void findById_ThrowsException() {
        when(petRepository.findById(anyLong())).thenThrow(NoSuchElementException.class);
        assertThrows(NoSuchElementException.class, () -> petRepository.findById(expectedPetId));
        verify(petRepository).findById(expectedPetId);
    }

    @Test
    void save() {
        when(petRepository.save(any())).thenReturn(expectedPet);

        Pet actualPet = service.save(Pet.builder().name(expectedName).build());
        assertEquals(expectedPetId, actualPet.getId());
        assertEquals(expectedName, actualPet.getName());
        verify(petRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(expectedPet);
        verify(petRepository).delete(expectedPet);
    }

    @Test
    void deleteById() {
        service.deleteById(expectedPetId);
        verify(petRepository).deleteById(expectedPetId);
    }
}