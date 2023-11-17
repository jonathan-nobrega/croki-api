package croki.api.clients;

import croki.api.address.AddressDTO;
import jakarta.validation.constraints.NotNull;

public record UpdateClientDTO(
        @NotNull
        Long id,
        boolean is_active,
        String name,
        String company,
        String email,
        String phone,
        AddressDTO address
        ) {
}


