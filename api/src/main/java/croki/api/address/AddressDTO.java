package croki.api.address;

public record AddressDTO(
        String line_1,
        String line_2,
        String city,
        String state,
        int zip
) {
}
