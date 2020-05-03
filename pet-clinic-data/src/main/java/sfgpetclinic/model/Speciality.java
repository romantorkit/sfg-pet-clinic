package sfgpetclinic.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialities")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Speciality extends BaseEntity{

    private String description;

    public Speciality() {
    }

    public Speciality(Long id, String description) {
        super(id);
        this.description = description;
    }
}
