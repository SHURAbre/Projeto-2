package br.mack.estagios.service;

import br.mack.estagios.model.Usuario;
import br.mack.estagios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario buscarPorLogin(String login) {
        return repository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + login));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = buscarPorLogin(username);
        return org.springframework.security.core.userdetails.User
                .withUsername(usuario.getLogin())
                .password(usuario.getSenha())
                .roles(usuario.getRole().name().replace("ROLE_", ""))
                .build();
    }
}