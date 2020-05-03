package sfgpetclinic.services.springdata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sfgpetclinic.model.Owner;
import sfgpetclinic.repositories.OwnerRepository;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDServiceTest {

    Owner expectedOwner;
    Long expectedOwnerId = 1L;
    String expectedFirstName = "Roman";
    String expectedLastName = "Torkit";

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDService service;

    @BeforeEach
    void setUp() {
        expectedOwner = Owner.builder()
                .id(expectedOwnerId)
                .firstName(expectedFirstName)
                .lastName(expectedLastName)
                .build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(anyString())).thenReturn(expectedOwner);
        Owner actual = service.findByLastName(expectedLastName);
        assertNotNull(actual);
        assertEquals(expectedLastName, actual.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> expectedSet = new HashSet<>();
        expectedSet.add(Owner.builder().id(1L).build());
        expectedSet.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(expectedSet);

        Set<Owner> actualSet = service.findAll();
        assertNotNull(actualSet);
        assertEquals(expectedSet.size(), actualSet.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(expectedOwnerId)).thenReturn(Optional.of(expectedOwner));
        Owner actual = service.findById(expectedOwnerId);
        assertNotNull(actual);
        assertEquals(expectedOwnerId, actual.getId());
    }

    @Test
    void findById_ThrowsException() {
        when(ownerRepository.findById(anyLong())).thenThrow(NoSuchElementException.class);
        assertThrows(NoSuchElementException.class, () -> service.findById(expectedOwnerId));
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(expectedOwner);
        Owner actual = service.save(Owner.builder().firstName(expectedFirstName).lastName(expectedLastName).build());
        assertNotNull(actual);
        assertEquals(expectedOwnerId, actual.getId());
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(expectedOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(expectedOwnerId);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}