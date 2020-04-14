package sfgpetclinic.bootstarp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import sfgpetclinic.model.*;
import sfgpetclinic.properties.Vet1;
import sfgpetclinic.properties.Vet2;
import sfgpetclinic.service.*;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;

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
    private final SpecialityService specialityService;

    public DataLoader(ConfigurableApplicationContext context,
                      OwnerService ownerService,
                      VetService vetService,
                      PetService petService,
                      PetTypeService petTypeService,
                      SpecialityService specialityService) {
        this.context = context;
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
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

        loadData();
    }

    private void loadData() {
        PetType dogType = new PetType("dog");
        petTypeService.save(dogType);
        System.out.println(dogType);

        PetType catType = new PetType("cat");
        petTypeService.save(catType);
        System.out.println(catType);

        Speciality radiology = new Speciality("radiology");
        radiology = specialityService.save(radiology);
        Speciality surgery = new Speciality("surgery");
        surgery = specialityService.save(surgery);
        Speciality dentistry = new Speciality("dentistry");
        dentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Diane");
        owner1.setLastName("Kruger");
        owner1.setAddress("234 Cottman ave");
        owner1.setCity("Philadelphia");
        owner1.setTelephone("(267) 588-2297");
        ownerService.save(owner1);
        System.out.println(owner1.toString());

        Owner owner2 = new Owner();
        owner2.setFirstName("Eva");
        owner2.setLastName("Green");
        owner2.setAddress("234 Cottman ave");
        owner2.setCity("Philadelphia");
        owner2.setTelephone("(267) 588-2297");
        Pet pet2 = new Pet();
        pet2.setPetType(catType);
        pet2.setName("Cat");
        pet2.setBirthDate(LocalDate.now());
        owner2.getPets().add(pet2);
        pet2.setOwner(owner2);
        ownerService.save(owner2);
        System.out.println(owner2.toString());

        Owner owner3 = new Owner();
        owner3.setFirstName(firstName);
        owner3.setLastName(lastName);
        owner3.setAddress("234 Cottman ave");
        owner3.setCity("Philadelphia");
        owner3.setTelephone("(267) 588-2297");
        Pet pet3 = new Pet();
        pet3.setPetType(dogType);
        pet3.setBirthDate(LocalDate.of(2015, 7, 27));
        pet3.setName("Hans");
        owner3.getPets().add(pet3);
        pet3.setOwner(owner3);
        ownerService.save(owner3);
        System.out.println(owner3.toString());

        Vet vet1 = new Vet();
        vet1.setFirstName(vet1FirstName);
        vet1.setLastName(vet1LastName);
        vet1.getSpecialities().addAll(Arrays.asList(radiology, surgery));
        vetService.save(vet1);
        System.out.println(vet1.toString());

        Vet vet2 = new Vet();
        vet2.setFirstName(vet2FirstName);
        vet2.setLastName(vet2LastName);
        vet2.getSpecialities().addAll(Arrays.asList(dentistry, surgery));
        vetService.save(vet2);
        System.out.println(vet2.toString());
    }
}
