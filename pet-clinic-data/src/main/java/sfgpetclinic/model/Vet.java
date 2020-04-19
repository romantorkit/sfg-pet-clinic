package sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by romantorkit on 12/2/19
 */
@Entity
@Table(name = "vets")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_speciality",
            joinColumns = {@JoinColumn(name = "vet_id")},
            inverseJoinColumns = {@JoinColumn(name = "speciality_id")})
    private Set<Speciality> specialities = new HashSet<>();
}
