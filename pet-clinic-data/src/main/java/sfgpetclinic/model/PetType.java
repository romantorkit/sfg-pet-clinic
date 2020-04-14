package sfgpetclinic.model;

import lombok.*;

import javax.persistence.Entity;

/**
 * Created by romantorkit on 12/2/19
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PetType extends BaseEntity{
    private String typeName;
}
