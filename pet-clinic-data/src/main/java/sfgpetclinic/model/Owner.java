package sfgpetclinic.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by romantorkit on 12/2/19
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Owner extends Person {
    private String address;
    private String city;
    private String telephone;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    private Set<Pet> pets = new HashSet<>();
}
