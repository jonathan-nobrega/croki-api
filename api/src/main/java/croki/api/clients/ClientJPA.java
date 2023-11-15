package croki.api.clients;

import croki.api.address.AddressJPA;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "clients")
@Entity(name = "client")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ClientJPA {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private boolean is_active;
    private String name;
    private String company;
    private String email;
    private String phone;

    @Embedded
    private AddressJPA address;

    public ClientJPA(ClientDTO data) {
        this.is_active = data.is_active();
        this.name = data.name();
        this.company = data.company();
        this.email = data.email();
        this.phone = data.phone();
        this.address = new AddressJPA(data.address());
    }
}
