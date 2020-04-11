package sfgpetclinic.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

/**
 * Created by romantorkit on 12/2/19
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Owner extends Person {
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Pet pet;
}
