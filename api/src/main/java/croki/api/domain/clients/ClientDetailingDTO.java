package croki.api.domain.clients;

import croki.api.domain.address.AddressJPA;

public record ClientDetailingDTO(
        Long id,
        boolean is_active,
        String name,
        String company,
        String email,
        String phone,
        AddressJPA address
) {
    public ClientDetailingDTO(ClientJPA client) {
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
