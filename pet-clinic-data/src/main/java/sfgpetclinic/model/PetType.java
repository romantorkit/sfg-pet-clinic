package sfgpetclinic.model;

import lombok.*;

/**
 * Created by romantorkit on 12/2/19
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PetType extends BaseEntity{
    private String name;
}
