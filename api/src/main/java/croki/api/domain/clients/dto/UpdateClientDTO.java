package croki.api.domain.clients.dto;

import croki.api.domain.address.AddressDTO;
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


