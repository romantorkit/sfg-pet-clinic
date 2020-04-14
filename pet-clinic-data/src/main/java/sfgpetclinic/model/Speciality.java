package sfgpetclinic.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Speciality extends BaseEntity{

    private String description;
}
