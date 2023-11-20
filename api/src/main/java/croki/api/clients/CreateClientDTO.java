package croki.api.clients;

import croki.api.address.AddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateClientDTO(
        @NotNull
        boolean is_active,
        @NotBlank
        String name,
        @NotBlank
        String company,
        @NotBlank @Email
        String email,
        @NotBlank @Pattern(regexp = "^\\+\\d{1,4}\\s*\\(\\d+\\)\\s*\\d+(?:[-.\\s]?\\d+)*$")
        String phone,
        @Valid
        AddressDTO address
) {
}