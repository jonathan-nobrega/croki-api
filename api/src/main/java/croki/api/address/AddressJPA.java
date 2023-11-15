package croki.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressJPA {

    private String line_1;
    private String line_2;
    private String city;
    private String state;
    private int zip;

    public AddressJPA(AddressDTO data) {

        this.line_1 = data.line_1();
        this.line_2 = data.line_2();
        this.city = data.city();
        this.state = data.state();
        this.zip = data.zip();
    }
}
