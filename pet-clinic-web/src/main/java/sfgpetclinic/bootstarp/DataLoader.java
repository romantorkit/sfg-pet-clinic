package sfgpetclinic.bootstarp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfgpetclinic.model.Owner;
import sfgpetclinic.model.Vet;
import sfgpetclinic.service.OwnerService;
import sfgpetclinic.service.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Diane");
        owner1.setLastName("Kruger");
        ownerService.save(owner1);
        System.out.println(owner1.toString());

        Owner owner2 = new Owner();
        owner2.setFirstName("Eva");
        owner2.setLastName("Green");
        ownerService.save(owner2);
        System.out.println(owner2.toString());

        Vet vet1 = new Vet();
        vet1.setFirstName("Monica");
        vet1.setLastName("Bellucci");
        vetService.save(vet1);
        System.out.println(vet1.toString());

        Vet vet2 = new Vet();
        vet2.setFirstName("Scarlett");
        vet2.setLastName("Johansson ");
        vetService.save(vet2);
        System.out.println(vet2.toString());
    }
}
