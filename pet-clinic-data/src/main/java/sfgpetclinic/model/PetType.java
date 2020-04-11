package sfgpetclinic.model;

import lombok.*;

/**
 * Created by romantorkit on 12/2/19
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PetType extends BaseEntity{
    private String typeName;
}
