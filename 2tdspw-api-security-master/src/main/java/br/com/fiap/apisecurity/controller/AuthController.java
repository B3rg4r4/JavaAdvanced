package br.com.fiap.apisecurity.controller;


import br.com.fiap.apisecurity.dto.AuthDTO;
import br.com.fiap.apisecurity.dto.RegisterDTO;
import br.com.fiap.apisecurity.model.User;
import br.com.fiap.apisecurity.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDTO authDTO){
        var userPwd = new UsernamePasswordAuthenticationToken(
                authDTO.username(),
                authDTO.password());
        var auth = this.authenticationManager.authenticate(userPwd);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/Register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO){
        if (userRepository.findByUsername(registerDTO.username()) != null){
            return ResponseEntity.badRequest().build();
        }
        String encryptedPwd = new BCryptPasswordEncoder()
                .encode(registerDTO.password());
        User newUser = new User(
                registerDTO.username(),
                encryptedPwd,
                registerDTO.role());
        userRepository.save(newUser);
        return ResponseEntity.ok().build();

    }

}
