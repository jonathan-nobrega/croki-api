package croki.api.domain.clients;

import croki.api.domain.address.AddressJPA;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean is_active;
    private String name;
    private String company;
    private String email;
    private String phone;

    @Embedded
    private AddressJPA address;

    public ClientJPA(CreateClientDTO data) {
        this.name = data.name();
        this.is_active = true;
        this.company = data.company();
        this.email = data.email();
        this.phone = data.phone();
        this.address = new AddressJPA(data.address());
    }

    public void updateData(UpdateClientDTO data) {
        if (data.name() != null) this.name = data.name();
        this.is_active = data.is_active();
        if (data.company() != null) this.company = data.company();
        if (data.email() != null) this.email = data.email();
        if (data.phone() != null) this.phone = data.phone();
        if (data.address() != null) this.address.updateData(data.address());
    }
}
