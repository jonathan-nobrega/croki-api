package croki.api.clients;

public record ListClientDTO(
        boolean is_active,
        String name,
        String company,
        String email,
        String phone,
        croki.api.address.AddressJPA address
) {
        public ListClientDTO(ClientJPA client) {
                this(
                        client.is_active(),
                        client.getName(),
                        client.getCompany(),
                        client.getEmail(),
                        client.getPhone(),
                        client.getAddress()
                );
        }
}
