package sfgpetclinic.model;

import java.util.Objects;

/**
 * Created by romantorkit on 12/2/19
 */
public class PetType extends BaseEntity{
    private String name;

    public PetType() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PetType)) return false;
        if (!super.equals(o)) return false;
        PetType petType = (PetType) o;
        return Objects.equals(name, petType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
