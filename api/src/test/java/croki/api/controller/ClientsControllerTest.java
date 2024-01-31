package croki.api.controller;

import croki.api.domain.address.Address;
import croki.api.domain.address.AddressDTO;
import croki.api.domain.clients.ClientRepository;
import croki.api.domain.clients.dto.ClientDetailingDTO;
import croki.api.domain.clients.dto.CreateClientDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ClientsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<CreateClientDTO> createClientDTOJson;

    @Autowired
    private JacksonTester<ClientDetailingDTO> clientDetailingDTOJson;

    @MockBean
    private ClientRepository clientRepository;

    @Test
    @DisplayName("POST /clients - Should bring status 400 for wrong input")
    @WithMockUser
    void createClientError() throws Exception {
        var response = mvc.perform(post("/clients"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("POST /clients - Should bring status 201 when client is created")
    @WithMockUser
    void createClientSuccess() throws Exception {
        var content = new CreateClientDTO(
                true,
                "random client name",
                "random company name",
                "test@email.com",
                "+1 (919) 123-1234",
                new AddressDTO(
                        "line 1 address example",
                        "line 2 address example",
                        "city example",
                        "state example",
                        27123
                )
        );

        var response = mvc.perform(
                        post("/clients")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(createClientDTOJson.write(content).getJson())
                )
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

    //@Test
    //@DisplayName("GET /clients - Should bring status 200 and list of clients")
    //@WithMockUser
    //void listClients() throws Exception {
    //    List<ClientDetailingDTO> mockClients = Arrays.asList(
    //            createRandomClientObject(),
    //            createRandomClientObject(),
    //            createRandomClientObject()
    //    );
    //    System.out.println(mockClients);

    //    Page<ClientDetailingDTO> mockPage = new PageImpl<>(mockClients);

    //    when(clientRepository.findAll(Mockito.any(Pageable.class)).map(ClientDetailingDTO::new)).thenReturn(mockPage);

    //    var response = mvc.perform(
    //            get("/clients")
    //    ).andReturn().getResponse();
    //    System.out.println(response);
    //}

    ClientDetailingDTO createRandomClientObject() {
        var randomId = new Random().nextLong();
        return new ClientDetailingDTO(
                randomId, true, "TestClient " + randomId,
                "Company " + randomId, randomId + "@asd.com",
                "+1 (919) 123-1234", createRandomAddressObject()
        );
    }

    Address createRandomAddressObject() {
        return new Address(
                "line" + new Random() + "address example",
                "line" + new Random() + "address example",
                "city example",
                "state example",
                27123
        );
    }

}