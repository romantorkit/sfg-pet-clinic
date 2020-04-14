package sfgpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true, exclude = "pet")
@EqualsAndHashCode(callSuper = true, exclude = "pet")
public class Visit extends BaseEntity{
    private String description;
    private LocalDate visitDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;
}