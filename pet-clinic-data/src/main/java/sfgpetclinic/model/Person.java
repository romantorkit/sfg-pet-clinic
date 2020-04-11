package sfgpetclinic.model;

import lombok.*;

/**
 * Created by romantorkit on 12/2/19
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Person extends BaseEntity{
    private String firstName;
    private String lastName;
}
