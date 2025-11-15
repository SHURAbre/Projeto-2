package br.mack.estagios.dao;
import org.springframework.data.repository.CrudRepository;
import br.mack.estagios.model.Estudante;
import java.util.Optional;

public interface EstudanteDAO extends CrudRepository<Estudante, Long> {
    Optional<Estudante> findByCpf(String cpf);
}