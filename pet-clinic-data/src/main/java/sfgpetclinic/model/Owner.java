package sfgpetclinic.model;

/**
 * Created by romantorkit on 12/2/19
 */
public class Owner extends Person {
    private Pet pet;

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
