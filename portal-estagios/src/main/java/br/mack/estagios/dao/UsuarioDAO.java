package br.mack.estagios.dao;

import org.springframework.data.repository.CrudRepository;
import br.mack.estagios.model.Usuario;
import java.util.Optional;

public interface UsuarioDAO extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);
}