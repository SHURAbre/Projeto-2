package br.mack.estagios.controller;

import br.mack.estagios.config.JwtUtil;
import br.mack.estagios.model.Usuario;
import br.mack.estagios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario loginRequest) {

        Usuario usuario = usuarioService.buscarPorLogin(loginRequest.getLogin());

        if (usuario == null) {
            return ResponseEntity.status(403).body("Login inválido");
        }

        // valida senha
        if (!passwordEncoder.matches(loginRequest.getSenha(), usuario.getSenha())) {
            return ResponseEntity.status(403).body("Senha inválida");
        }

        // gera token
        String token = jwtUtil.generateToken(usuario.getLogin(), usuario.getRole().name());

        return ResponseEntity.ok(new AuthResponse(
                usuario.getId(),
                usuario.getLogin(),
                usuario.getRole().name(),
                token
        ));
    }

    record AuthResponse(Long id, String login, String role, String token) {}
}