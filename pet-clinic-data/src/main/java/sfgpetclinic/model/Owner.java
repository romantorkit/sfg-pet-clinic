package sfgpetclinic.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;

/**
 * Created by romantorkit on 12/2/19
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Owner extends Person {
    @OneToMany(mappedBy = "owner")
    private Pet pet;
}
