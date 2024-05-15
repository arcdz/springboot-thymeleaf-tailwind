package ra.trys.spring.tt.items;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemUpsertDto {

    private String name;

    private String email;

    @Override
    public String toString() {
        return "{" + "name:'" + name + '\'' + ", email:'" + email + '\'' + '}';
    }

}
