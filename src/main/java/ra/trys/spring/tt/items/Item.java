package ra.trys.spring.tt.items;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue
    @With
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, max = 25, message = "Name must be between 3 and 25 chars")
    private String name;

    @Email(message = "Email must be a well-formed email address")
    @NotEmpty(message = "Email cannot be empty")@NotNull
    private String email;

    public Item(ItemUpsertDto dto) {
        this.name = dto.getName();
        this.email = dto.getEmail();
    }

    @Override
    public String toString() {
        return "{" + "id:" + id + ", name:'" + name + '\'' + ", email:'" + email + '\'' + '}';
    }
}
