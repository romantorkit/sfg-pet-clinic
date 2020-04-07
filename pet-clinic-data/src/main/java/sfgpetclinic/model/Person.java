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
@EqualsAndHashCode
public class Person {
    private String firstName;
    private String lastName;
}
