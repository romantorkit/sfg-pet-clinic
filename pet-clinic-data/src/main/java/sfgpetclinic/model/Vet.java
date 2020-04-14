package sfgpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class Vet extends Person {

    @ManyToMany
    @JoinTable(name = "vet_speciality",
            joinColumns = {@JoinColumn(name = "vet_id")},
            inverseJoinColumns = {@JoinColumn(name = "speciality_id")})
    private Set<Speciality> specialities;
}
