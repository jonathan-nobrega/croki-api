package croki.api.domain.clients.dto;

import croki.api.domain.address.AddressJPA;
import croki.api.domain.clients.Client;

public record ClientDetailingDTO(
        Long id,
        Boolean isActive,
        String name,
        String company,
        String email,
        String phone,
        AddressJPA address
) {
    public ClientDetailingDTO(Client client) {
        this(
                client.getId(),
                client.isActive(),
                client.getName(),
                client.getCompany(),
                client.getEmail(),
                client.getPhone(),
                client.getAddress()
        );
    }
}
