package sfgpetclinic.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by romantorkit on 12/2/19
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Person extends BaseEntity{
    private String firstName;
    private String lastName;
}
