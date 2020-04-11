package sfgpetclinic.bootstarp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import sfgpetclinic.model.Owner;
import sfgpetclinic.model.Pet;
import sfgpetclinic.model.PetType;
import sfgpetclinic.model.Vet;
import sfgpetclinic.properties.Vet1;
import sfgpetclinic.properties.Vet2;
import sfgpetclinic.service.OwnerService;
import sfgpetclinic.service.PetService;
import sfgpetclinic.service.PetTypeService;
import sfgpetclinic.service.VetService;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Value("${user.name.first}")
    private String firstName;
    @Value("${user.name.last}")
    private String lastName;

    private String vet1FirstName;
    private String vet1LastName;

    private String vet2FirstName;
    private String vet2LastName;

    private final ConfigurableApplicationContext context;
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;

    public DataLoader(ConfigurableApplicationContext context,
                      OwnerService ownerService,
                      VetService vetService,
                      PetService petService,
                      PetTypeService petTypeService) {
        this.context = context;
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @PostConstruct
    public void init() {
        Vet1 vet1 = context.getBean(Vet1.class);
        vet1FirstName = vet1.getFirstName();
        vet1LastName = vet1.getLastName();
        Vet2 vet2 = context.getBean(Vet2.class);
        vet2FirstName = vet2.getFirstName();
        vet2LastName = vet2.getLastName();
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dogType = new PetType("dog");
        petTypeService.save(dogType);
        System.out.println(dogType);

        PetType catType = new PetType("cat");
        petTypeService.save(catType);
        System.out.println(catType);

        Owner owner1 = new Owner();
        owner1.setFirstName("Diane");
        owner1.setLastName("Kruger");
        ownerService.save(owner1);
        System.out.println(owner1.toString());

        Owner owner2 = new Owner();
        owner2.setFirstName("Eva");
        owner2.setLastName("Green");
        Pet pet2 = new Pet();
        pet2.setPetType(catType);
        pet2.setName("Cat");
        pet2.setBirthDate(LocalDate.now());
        owner2.setPet(pet2);
        ownerService.save(owner2);
        pet2.setOwner(owner2);
        petService.save(pet2);
        System.out.println(owner2.toString());

        Owner owner3 = new Owner();
        owner3.setFirstName(firstName);
        owner3.setLastName(lastName);
        Pet pet3 = new Pet();
        pet3.setPetType(dogType);
        pet3.setBirthDate(LocalDate.of(2015, 7, 27));
        pet3.setName("Hans");
        owner3.setPet(pet3);
        ownerService.save(owner3);
        pet3.setOwner(owner3);
        petService.save(pet3);
        System.out.println(owner3.toString());

        Vet vet1 = new Vet();
        vet1.setFirstName(vet1FirstName);
        vet1.setLastName(vet1LastName);
        vetService.save(vet1);
        System.out.println(vet1.toString());

        Vet vet2 = new Vet();
        vet2.setFirstName(vet2FirstName);
        vet2.setLastName(vet2LastName);
        vetService.save(vet2);
        System.out.println(vet2.toString());
    }
}
