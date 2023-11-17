package croki.api.clients;

public record ListClientDTO(
        int id,
        boolean is_active,
        String name,
        String company,
        String email,
        String phone,
        croki.api.address.AddressJPA address
) {
        public ListClientDTO(ClientJPA client) {
                this(
                        client.getId(),
                        client.is_active(),
                        client.getName(),
                        client.getCompany(),
                        client.getEmail(),
                        client.getPhone(),
                        client.getAddress()
                );
        }
}
