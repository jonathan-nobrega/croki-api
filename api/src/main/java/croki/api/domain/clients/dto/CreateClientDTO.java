package croki.api.domain.clients.dto;

import croki.api.domain.address.AddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateClientDTO(
        boolean isActive,
        @NotBlank
        String name,
        String company,
        @NotBlank @Email
        String email,
        @NotBlank @Pattern(regexp = "^\\+\\d{1,4}\\s*\\(\\d+\\)\\s*\\d+(?:[-.\\s]?\\d+)*$")
        String phone,
        @Valid
        AddressDTO address
) {
}
