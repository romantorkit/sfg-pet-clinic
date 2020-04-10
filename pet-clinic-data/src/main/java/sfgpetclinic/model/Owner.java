package sfgpetclinic.model;

import javax.persistence.OneToMany;
import java.util.Objects;

/**
 * Created by romantorkit on 12/2/19
 */
public class Owner extends Person {
    @OneToMany(mappedBy = "owner")
    private Pet pet;

    public Owner() {
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;
        if (!super.equals(o)) return false;
        Owner owner = (Owner) o;
        return Objects.equals(pet, owner.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pet);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "pet=" + pet +
                "} " + super.toString();
    }
}
