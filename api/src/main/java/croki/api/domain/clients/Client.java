package croki.api.domain.clients;

import croki.api.domain.address.AddressDTO;
import croki.api.domain.address.AddressJPA;
import croki.api.domain.clients.dto.CreateClientDTO;
import croki.api.domain.clients.dto.UpdateClientDTO;
import croki.api.domain.projects.Project;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "clients")
@Entity(name = "client")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isActive;
    private String name;
    private String company;
    private String email;
    private String phone;

    @Embedded
    private AddressJPA address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Project> projects;

    public Client(CreateClientDTO data) {
        this.name = data.name();
        this.isActive = true;
        this.company = data.company();
        this.email = data.email();
        this.phone = data.phone();
        this.address = new AddressJPA(data.address());
    }

    public Client(boolean b, String randomClientName, String randomCompanyName, String mail, String s, AddressDTO addressDTO) {
    }

    public void updateData(UpdateClientDTO data) {
        if (data.name() != null) this.name = data.name();
        this.isActive = data.is_active();
        if (data.company() != null) this.company = data.company();
        if (data.email() != null) this.email = data.email();
        if (data.phone() != null) this.phone = data.phone();
        if (data.address() != null) this.address.updateData(data.address());
    }
}
