package sfgpetclinic.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by romantorkit on 12/2/19
 */
@NoArgsConstructor
@EqualsAndHashCode
public class PetType {
    private String name;

    public PetType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
