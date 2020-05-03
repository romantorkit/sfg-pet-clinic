package sfgpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by romantorkit on 12/2/19
 */
@Entity
@Table(name = "pet_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PetType extends BaseEntity{
    private String typeName;

    public PetType(Long id, String typeName) {
        super(id);
        this.typeName = typeName;
    }
}
