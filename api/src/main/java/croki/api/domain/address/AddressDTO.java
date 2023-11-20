package croki.api.domain.address;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

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
