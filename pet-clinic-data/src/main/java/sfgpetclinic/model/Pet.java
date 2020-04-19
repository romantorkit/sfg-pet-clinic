package sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by romantorkit on 12/2/19
 */
@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Pet extends BaseEntity{
    private String name;
    private LocalDate birthDate;
    @ManyToOne
    @JoinColumn(name = "pet_type_id")
    private PetType petType;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Owner owner;
    @OneToMany(mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();
}
