package sfgpetclinic.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by romantorkit on 12/2/19
 */
public class Pet extends BaseEntity{
    private LocalDate birthDate;
    @ManyToOne
    @JoinColumn(name = "pet_type_id")
    private PetType petType;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Pet() {
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        if (!super.equals(o)) return false;
        Pet pet = (Pet) o;
        return Objects.equals(birthDate, pet.birthDate) &&
                Objects.equals(petType, pet.petType) &&
                Objects.equals(owner, pet.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), birthDate, petType, owner);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "birthDate=" + birthDate +
                ", petType=" + petType +
                ", owner=" + owner +
                "} " + super.toString();
    }
}
