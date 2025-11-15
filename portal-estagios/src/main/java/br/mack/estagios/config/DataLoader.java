package br.mack.estagios.config;

import br.mack.estagios.dao.UsuarioDAO;
import br.mack.estagios.model.Usuario;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private final UsuarioDAO usuarioDAO;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public DataLoader(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @PostConstruct
    public void init() {
        if (usuarioDAO.findByLogin("admin").isEmpty()) {
            Usuario u = new Usuario();
            u.setLogin("admin");
            u.setSenha(passwordEncoder.encode("admin123")); // <<< AGORA ESTÁ CRIPTOGRAFADA!
            u.setRole(Usuario.Role.ROLE_ADMIN);
            usuarioDAO.save(u);

            System.out.println(">>> Usuário admin criado com sucesso!");
        }
    }
}