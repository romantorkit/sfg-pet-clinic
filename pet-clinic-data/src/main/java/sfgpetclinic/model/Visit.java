package sfgpetclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visits")
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
    @JsonIgnore
    private Pet pet;
}
