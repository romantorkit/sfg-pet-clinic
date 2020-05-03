package sfgpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sfgpetclinic.model.Owner;
import sfgpetclinic.model.Pet;
import sfgpetclinic.model.PetType;

import java.util.Collections;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final long ownerId = 1L;
    final long petId = 2L;
    final String lastName = "Torkit";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());
        ownerMapService.save(Owner.builder().id(ownerId).firstName("Roman").lastName("Torkit")
                .pets(new HashSet(Collections.singleton(
                        Pet.builder().id(petId).name("Hans").petType(new PetType(1L, "Dog")).build()
                )))
                .build());
    }

    @Test
    void findAll() {
        int expected = 1;
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(expected, owners.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        long id = 2L;
        Owner expected = Owner.builder().id(id).build();
        Owner actual = ownerMapService.save(expected);
        assertEquals(id, actual.getId());
    }

    @Test
    void saveNoId() {
        Owner expected = ownerMapService.save(Owner.builder().build());
        assertNotNull(expected);
        assertNotNull(expected.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
        assertEquals(1, owner.getPets().size());
        assertEquals(petId, (owner.getPets().iterator().hasNext() ? owner.getPets().iterator().next().getId() : 0L));
    }

    @Test
    void findByLastName() {
        Owner actual = ownerMapService.findByLastName(lastName);
        assertNotNull(actual);
        assertEquals(lastName, actual.getLastName());
    }

    @Test
    void findByLastName_ThrowsNoSuchElementException() {
        String expected = "Smith";
        assertThrows(NoSuchElementException.class, () -> ownerMapService.findByLastName(expected));
    }
}