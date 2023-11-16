package croki.api.address;

import jakarta.validation.constraints.*;

public record AddressDTO(
        @NotBlank
        String line_1,
        String line_2,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @Positive @Min(1) @Max(99950)
        int zip
) {
}
