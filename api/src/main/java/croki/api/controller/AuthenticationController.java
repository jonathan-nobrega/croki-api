package croki.api.controller;

import croki.api.domain.user.AuthenticationDTO;
import croki.api.domain.user.UserJPA;
import croki.api.infra.security.TokenJwtDTO;
import croki.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenJwtDTO> authenticate(@RequestBody @Valid AuthenticationDTO payload) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(payload.login(), payload.password());
        var auth = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generateToken((UserJPA) auth.getPrincipal());

        return ResponseEntity.ok(new TokenJwtDTO(tokenJWT));
    }
}
