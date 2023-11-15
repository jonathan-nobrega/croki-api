package croki.api.clients;

import croki.api.address.AddressDTO;

public record ClientDTO(
        String id,
        boolean is_active,
        String name,
        String company,
        String email,
        String phone,
        AddressDTO address
) {
}
